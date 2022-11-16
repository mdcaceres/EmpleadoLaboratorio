package com.laboratorio.empleadoslaboratorio.controller;

import com.laboratorio.empleadoslaboratorio.Dto.in.ReciboDtoIn;
import com.laboratorio.empleadoslaboratorio.Dto.out.ReciboDto;
import com.laboratorio.empleadoslaboratorio.service.ReciboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/recibo")
@Validated
public class ReciboController {

    @Autowired
    private ReciboService reciboService;

    @PostMapping
    public ResponseEntity<ReciboDto> createRecibo(@Valid @RequestBody ReciboDtoIn reciboDtoIn){
        return ResponseEntity.ok().body(reciboService.create(reciboDtoIn));
    }

    @GetMapping
    public ResponseEntity<List<ReciboDto>> getAllByLegajo(@RequestParam Integer legajo){
        return ResponseEntity.ok().body(reciboService.getAllByLegajo(legajo));
    }
}
