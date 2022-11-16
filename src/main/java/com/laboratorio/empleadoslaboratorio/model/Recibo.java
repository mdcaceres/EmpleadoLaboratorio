package com.laboratorio.empleadoslaboratorio.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Table(name = "recibos")
public class Recibo {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
    private Integer año;
    private Integer mes;
    private Integer antiguedad;
    private Double sueldoBruto;
    private Double montoAntiguedad;
    private Double jubilacion;
    private Double obraSocial;
    private Double fondoAltaComplejidad;
    private Double total;
}
