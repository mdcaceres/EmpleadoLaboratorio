package com.laboratorio.empleadoslaboratorio.service;

import com.laboratorio.empleadoslaboratorio.Dto.in.ReciboDtoIn;
import com.laboratorio.empleadoslaboratorio.Dto.out.ReciboDto;

import java.util.List;

public interface ReciboService {
    public List<ReciboDto> getAllByLegajo(Integer legajo);
    public ReciboDto create(ReciboDtoIn reciboDto);
}
