package com.unillanos.babycare.service;

import com.unillanos.babycare.model.Disponibilidad;
import com.unillanos.babycare.repository.DisponibilidadRepository;
import jakarta.transaction.Transactional;
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
        return disponibilidadRepository.findDisponibilidades(fecha, horaInicio, horaFin);
    }

    public Disponibilidad saveDisponibilidad(Disponibilidad disponibilidad) {
        return disponibilidadRepository.save(disponibilidad);
    }

    @Transactional
    public void reservarNinera(Long idDisponibilidad) {
        Disponibilidad disponibilidad = disponibilidadRepository.findById(idDisponibilidad)
                .orElseThrow(() -> new RuntimeException("Disponibilidad no encontrada"));
        disponibilidadRepository.delete(disponibilidad);
    }

}