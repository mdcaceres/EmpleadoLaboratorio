package com.laboratorio.empleadoslaboratorio.service;

import com.laboratorio.empleadoslaboratorio.Dto.in.FechaDto;
import com.laboratorio.empleadoslaboratorio.Dto.out.ReporteDto;

import java.util.List;

public interface ReporteService {
    public List<ReporteDto> getReporteByFecha(FechaDto fecha);
}
