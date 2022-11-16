package com.laboratorio.empleadoslaboratorio.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Table(name = "empleados")
public class Empleado {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer legajo;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="area_id")
    private Area area;
    private Double sueldoBruto;
    private LocalDate fechaIngreso;
}
