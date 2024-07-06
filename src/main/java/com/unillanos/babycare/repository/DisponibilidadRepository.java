package com.unillanos.babycare.repository;

import com.unillanos.babycare.model.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Long> {
    @Query("SELECT d FROM Disponibilidad d WHERE d.fecha = ?1 AND d.horaInicio >= ?2 AND d.horaFin <= ?3")
    List<Disponibilidad> findByFechaAndHoraInicioLessThanEqualAndHoraFinGreaterThanEqual(
            LocalDate fecha, LocalTime horaInicio, LocalTime horaFin);
}