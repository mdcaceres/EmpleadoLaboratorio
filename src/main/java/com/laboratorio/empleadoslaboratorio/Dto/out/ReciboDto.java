package com.laboratorio.empleadoslaboratorio.Dto.out;

import com.laboratorio.empleadoslaboratorio.model.Empleado;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReciboDto {
    private Long id;
    private Long empleadoId;
    private Integer año;
    private Integer mes;
    private Integer antiguedad;
    private Double salarioBruto;
    private Double montoAntiguedad;
    private Double jubilacion;
    private Double obraSocial;
    private Double fondoAltaComplejidad;
    private Double total;
}
