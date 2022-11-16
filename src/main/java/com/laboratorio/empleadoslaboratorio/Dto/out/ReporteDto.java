package com.laboratorio.empleadoslaboratorio.Dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDto {
    private String nombre;
    private Double sueldoPagado;
}
