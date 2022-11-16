package com.laboratorio.empleadoslaboratorio.Dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {
    private Long id;
    private Integer legajo;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Integer antiguedad;
    private AreaDto area;
    private Double sueldoBruto;
}
