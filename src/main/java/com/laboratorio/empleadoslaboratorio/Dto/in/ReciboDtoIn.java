package com.laboratorio.empleadoslaboratorio.Dto.in;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
public class ReciboDtoIn {
    @NotNull(message = "El id del empleado no debe ser nulo")
    private Long empleadoId;
    private Integer año;
    @NotNull() @Min(value = 1) @Max(value = 12)
    private Integer mes;
    private Double montoAntiguedad;
    private Double jubilacion;
    private Double obraSocial;
    private Double fondoAltaComplejidad;
}
