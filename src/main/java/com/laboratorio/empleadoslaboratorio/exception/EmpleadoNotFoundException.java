package com.laboratorio.empleadoslaboratorio.exception;

public class EmpleadoNotFoundException extends RuntimeException{
  public EmpleadoNotFoundException(String message) {
    super(message);
  }
}
