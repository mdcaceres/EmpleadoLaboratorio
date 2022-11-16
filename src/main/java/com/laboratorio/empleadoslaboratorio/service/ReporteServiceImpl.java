package com.laboratorio.empleadoslaboratorio.service;


import com.laboratorio.empleadoslaboratorio.Dto.in.FechaDto;
import com.laboratorio.empleadoslaboratorio.Dto.out.ReporteDto;
import com.laboratorio.empleadoslaboratorio.exception.MesException;
import com.laboratorio.empleadoslaboratorio.model.ReporteArea;
import com.laboratorio.empleadoslaboratorio.repository.ReciboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteServiceImpl implements ReporteService {
    @Autowired
    private ReciboRepository reciboRepository;

    @Override
    public List<ReporteDto> getReporteByFecha(FechaDto fecha) {

        if(fecha.getMes() <= 0 || fecha.getMes() > 12){
            throw new MesException("el mes debe estar entre el 1 y el 12");
        }
        List<ReporteArea> reporteAreas = reciboRepository.getReporteArea(fecha.getMes(), fecha.getAño());
        return reporteAreas.stream().map(r -> new ReporteDto(
                r.getNombre(),
                r.getSueldoPagado()
        )).collect(Collectors.toList());
    }
}
