package com.laboratorio.empleadoslaboratorio.Dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseListDTO {
    private List<ResponseDTO> responses;
}
