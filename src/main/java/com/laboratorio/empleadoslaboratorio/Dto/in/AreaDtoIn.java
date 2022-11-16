package com.laboratorio.empleadoslaboratorio.Dto.in;

import com.laboratorio.empleadoslaboratorio.Dto.out.EmpleadoDto;
import lombok.Data;

@Data
public class AreaDtoIn {
    private Long id;
    private String nombre;
    private EmpleadoDto empleado;
}
