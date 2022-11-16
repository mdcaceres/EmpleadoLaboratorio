package com.laboratorio.empleadoslaboratorio.service;

import com.laboratorio.empleadoslaboratorio.Dto.in.ReciboDtoIn;
import com.laboratorio.empleadoslaboratorio.Dto.out.ReciboDto;
import com.laboratorio.empleadoslaboratorio.exception.EmpleadoNotFoundException;
import com.laboratorio.empleadoslaboratorio.exception.MesException;
import com.laboratorio.empleadoslaboratorio.model.Empleado;
import com.laboratorio.empleadoslaboratorio.model.Recibo;
import com.laboratorio.empleadoslaboratorio.repository.EmpleadoRepository;
import com.laboratorio.empleadoslaboratorio.repository.ReciboRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReciboServiceImpl implements ReciboService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ReciboRepository reciboRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ReciboDto> getAllByLegajo(Integer legajo) {
        return reciboRepository.getRecibosByEmpleadoLegajo(legajo)
                .stream().map( x -> new ReciboDto(
                x.getId(),
                x.getEmpleado().getId(),
                x.getAño(),
                x.getMes(),
                x.getAntiguedad(),
                x.getSueldoBruto(),
                x.getMontoAntiguedad(),
                x.getJubilacion(),
                x.getObraSocial(),
                x.getFondoAltaComplejidad(),
                x.getTotal()))
                .collect(Collectors.toList());
    }

    @Override
    public ReciboDto create(ReciboDtoIn reciboDto) {
        if(reciboDto.getMes() <= 0 || reciboDto.getMes() > 12){
            throw new MesException("el mes debe estar entre el 1 y el 12");
        }
        //Mapeo el dto a recibo
        Recibo recibo = modelMapper.map(reciboDto,Recibo.class);

        //valido el empleaod
        Empleado empleado = empleadoRepository.findById(reciboDto.getEmpleadoId())
                .orElseThrow(() -> new EmpleadoNotFoundException("Empleado id: " + reciboDto.getEmpleadoId() + " no existe"));
        //le seteo el empleado al recibo
        recibo.setEmpleado(empleado);
        //le seteo el suelo bruto del empleado obteniendolo de los que esta en su tabla
        recibo.setSueldoBruto(empleado.getSueldoBruto());
        //Saco la cantidad de años para setear la antiguedad
        Period period = empleado.getFechaIngreso().until(LocalDate.now());
        int yearsBetween = period.getYears();
        recibo.setAntiguedad(yearsBetween);

        recibo.setMontoAntiguedad(reciboDto.getMontoAntiguedad() * yearsBetween);

        //obtengo el total de los descuentos
        Double descuentos = recibo.getJubilacion() + recibo.getObraSocial() + recibo.getFondoAltaComplejidad();
        //Saco el calculo del total;
        Double total = (recibo.getSueldoBruto() + recibo.getMontoAntiguedad()) - descuentos;
        recibo.setTotal(total);
        //Guardo en la db
        Recibo rec = reciboRepository.save(recibo);

        ReciboDto dto = new ReciboDto(
                rec.getId(),
                rec.getEmpleado().getId(),
                rec.getAño(),
                rec.getMes(),
                rec.getAntiguedad(),
                rec.getSueldoBruto(),
                rec.getMontoAntiguedad(),
                rec.getJubilacion(),
                rec.getObraSocial(),
                rec.getFondoAltaComplejidad(),
                rec.getTotal());
        return dto;
        //return modelMapper.map(rec, ReciboDto.class);
    }
}
