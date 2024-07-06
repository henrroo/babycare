package com.unillanos.babycare.service;

import com.unillanos.babycare.model.Disponibilidad;
import com.unillanos.babycare.repository.DisponibilidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DisponibilidadService {

    private final DisponibilidadRepository disponibilidadRepository;

    public List<Disponibilidad> getDisponibilidad(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        List<Disponibilidad> disponibilidadList = disponibilidadRepository.findByFechaAndHoraInicioLessThanEqualAndHoraFinGreaterThanEqual(
            fecha, horaInicio, horaFin);
        return disponibilidadList;
    }

    public Disponibilidad saveDisponibilidad(Disponibilidad disponibilidad) {
        return disponibilidadRepository.save(disponibilidad);
    }

}