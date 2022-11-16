package com.laboratorio.empleadoslaboratorio.repository;

import com.laboratorio.empleadoslaboratorio.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
}
