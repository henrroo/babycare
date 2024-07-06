package com.unillanos.babycare.controller;

import com.unillanos.babycare.model.Disponibilidad;
import com.unillanos.babycare.service.DisponibilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/disponibilidad")
@RequiredArgsConstructor
public class DisponibilidadController {

    private final DisponibilidadService disponibilidadService;

    @GetMapping
    public List<Disponibilidad> getDisponibilidad(
        @RequestParam LocalDate fecha,
        @RequestParam LocalTime horaInicio,
        @RequestParam LocalTime horaFin) {
        return disponibilidadService.getDisponibilidad(fecha, horaInicio, horaFin);
    }

    @PostMapping
    public Disponibilidad createDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
        return disponibilidadService.saveDisponibilidad(disponibilidad);
    }

}