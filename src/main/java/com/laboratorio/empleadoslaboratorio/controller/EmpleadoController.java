package com.laboratorio.empleadoslaboratorio.controller;

import com.laboratorio.empleadoslaboratorio.Dto.in.EmpleadoDtoIn;
import com.laboratorio.empleadoslaboratorio.Dto.out.EmpleadoCreatedDto;
import com.laboratorio.empleadoslaboratorio.Dto.out.EmpleadoDto;
import com.laboratorio.empleadoslaboratorio.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<EmpleadoDto>> getEmpleados(){
        return ResponseEntity.ok().body(empleadoService.getAll());
    }

    @PostMapping
    public ResponseEntity<EmpleadoCreatedDto> createEmpleado(@RequestBody EmpleadoDtoIn empleado){
        return ResponseEntity.ok().body(empleadoService.create(empleado));
    }

}
