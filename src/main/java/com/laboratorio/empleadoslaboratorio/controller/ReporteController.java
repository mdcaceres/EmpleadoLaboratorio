package com.laboratorio.empleadoslaboratorio.controller;

import com.laboratorio.empleadoslaboratorio.Dto.in.FechaDto;
import com.laboratorio.empleadoslaboratorio.Dto.out.ReporteDto;
import com.laboratorio.empleadoslaboratorio.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reporte")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;

    @PostMapping
    public ResponseEntity<List<ReporteDto>> getReportes(@Valid @RequestBody FechaDto fechaDto){
        return ResponseEntity.ok().body(reporteService.getReporteByFecha(fechaDto));
    }
}
