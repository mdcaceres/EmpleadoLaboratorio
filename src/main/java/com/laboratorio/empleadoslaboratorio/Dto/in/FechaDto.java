package com.laboratorio.empleadoslaboratorio.Dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FechaDto {
    @NotNull(message = "El año no debe ser nulo")
    Integer año;
    @NotNull(message = "El mes no debe ser nulo")
    @Min(value = 1)
    @Max(value = 12)
    Integer mes;
}
