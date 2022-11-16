package com.laboratorio.empleadoslaboratorio.repository;

import com.laboratorio.empleadoslaboratorio.model.Recibo;
import com.laboratorio.empleadoslaboratorio.model.ReporteArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReciboRepository extends JpaRepository<Recibo,Long> {
    public List<Recibo> getRecibosByEmpleadoLegajo(Integer legajo);

    @Query("select new com.laboratorio.empleadoslaboratorio.model.ReporteArea(a.nombre , sum(r.total)) from Recibo r " +
            "join Empleado e on e.id = r.empleado.id " +
            "join Area a on a.id = e.area.id " +
            "where r.mes = :mes and r.año = :año " +
            "group by a.nombre")
    public List<ReporteArea> getReporteArea(@Param("mes") Integer mes, @Param("año") Integer año);
}
