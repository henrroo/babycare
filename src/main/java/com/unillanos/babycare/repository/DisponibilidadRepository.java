package com.unillanos.babycare.repository;

import com.unillanos.babycare.model.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Long> {

    @Query("SELECT d FROM Disponibilidad d WHERE d.fecha = :fecha AND (d.horaInicio < :horaFin AND d.horaFin > :horaInicio)")
    List<Disponibilidad> findDisponibilidades(@Param("fecha") LocalDate fecha, @Param("horaInicio") LocalTime horaInicio, @Param("horaFin") LocalTime horaFin);

}
