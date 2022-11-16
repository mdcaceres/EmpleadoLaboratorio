package com.laboratorio.empleadoslaboratorio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteArea {
    private String nombre;
    private Double sueldoPagado;
}
