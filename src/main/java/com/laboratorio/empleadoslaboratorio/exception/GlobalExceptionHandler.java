package com.laboratorio.empleadoslaboratorio.exception;


import com.laboratorio.empleadoslaboratorio.Dto.out.ResponseDTO;
import com.laboratorio.empleadoslaboratorio.Dto.out.ResponseListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseListDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ResponseDTO> responses = e.getAllErrors().stream()
                .map(error -> new ResponseDTO(error.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseListDTO(responses));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.status(400).body(new ResponseDTO("Invalid type for parameter: " + e.getName()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Invalid type of field"));
    }

    @ExceptionHandler(EmpleadoNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleUserNotFoundException(EmpleadoNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(e.getMessage()));
    }

    @ExceptionHandler(AreaNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleAreaNotFoundException(AreaNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseDTO> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(e.getMessage()));
    }

    @ExceptionHandler(MesException.class)
    public ResponseEntity<ResponseDTO> MesException(MesException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(e.getMessage()));
    }
}
