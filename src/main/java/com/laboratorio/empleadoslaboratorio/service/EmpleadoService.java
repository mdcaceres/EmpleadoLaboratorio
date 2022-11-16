package com.laboratorio.empleadoslaboratorio.service;

import com.laboratorio.empleadoslaboratorio.Dto.in.EmpleadoDtoIn;
import com.laboratorio.empleadoslaboratorio.Dto.out.EmpleadoCreatedDto;
import com.laboratorio.empleadoslaboratorio.Dto.out.EmpleadoDto;

import java.util.List;

public interface EmpleadoService {
    public List<EmpleadoDto> getAll();
    public EmpleadoDto getById(Long id);
    public EmpleadoCreatedDto create(EmpleadoDtoIn empleadoDto);
}
