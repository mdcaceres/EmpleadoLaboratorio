package com.laboratorio.empleadoslaboratorio.service;


import com.laboratorio.empleadoslaboratorio.Dto.in.EmpleadoDtoIn;
import com.laboratorio.empleadoslaboratorio.Dto.out.AreaDto;
import com.laboratorio.empleadoslaboratorio.Dto.out.EmpleadoDto;
import com.laboratorio.empleadoslaboratorio.Dto.out.EmpleadoCreatedDto;
import com.laboratorio.empleadoslaboratorio.exception.AreaNotFoundException;
import com.laboratorio.empleadoslaboratorio.exception.EmpleadoNotFoundException;
import com.laboratorio.empleadoslaboratorio.model.Empleado;
import com.laboratorio.empleadoslaboratorio.repository.AreaRepository;
import com.laboratorio.empleadoslaboratorio.repository.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private AreaRepository areaRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<EmpleadoDto> getAll() {
        List<Empleado> empleados = empleadoRepository.findAll();
        List<EmpleadoDto> empleadoDtos = empleados.stream().map(x -> {
            Period period = x.getFechaIngreso().until(LocalDate.now());
            int yearsBetween = period.getYears();
            return new EmpleadoDto(
                    x.getId(),
                    x.getLegajo(),
                    x.getNombre(),
                    x.getApellido(),
                    x.getFechaNacimiento(),
                    yearsBetween,
                    new AreaDto(x.getArea().getId(), x.getArea().getNombre()),
                    x.getSueldoBruto()
            );
        }).collect(Collectors.toList());
        return empleadoDtos;
    }

    @Override
    public EmpleadoDto getById(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoNotFoundException("Empleado id: " + id + " no existe"));
        return modelMapper.map(empleado,EmpleadoDto.class);
    }

    @Override
    public EmpleadoCreatedDto create(EmpleadoDtoIn empleadoIn) {
        Empleado empleado = new Empleado();
        empleado.setLegajo(empleadoIn.getLegajo());
        empleado.setNombre(empleadoIn.getNombre());
        empleado.setApellido(empleadoIn.getApellido());
        empleado.setArea(areaRepository.findById(Long.valueOf(empleadoIn.getAreaId())).orElseThrow(() -> new AreaNotFoundException("No existe el area")));
        empleado.setFechaIngreso(empleadoIn.getFechaIngreso());
        empleado.setFechaNacimiento(empleadoIn.getFechaNacimiento());
        empleado.setSueldoBruto(empleadoIn.getSueldoBruto());

        Empleado empleado1 = empleadoRepository.save(empleado);
        EmpleadoCreatedDto empleadoDto = new EmpleadoCreatedDto();
        empleadoDto.setId(empleado1.getId());
        empleadoDto.setNombre(empleado1.getNombre());
        empleadoDto.setLegajo(empleado1.getLegajo());
        empleadoDto.setApellido(empleado1.getApellido());
        empleadoDto.setFechaNacimiento(empleado1.getFechaNacimiento());
        empleadoDto.setSueldoBruto(empleado1.getSueldoBruto());
        return empleadoDto;
    }
}
