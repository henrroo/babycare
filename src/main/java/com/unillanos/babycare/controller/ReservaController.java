package com.unillanos.babycare.controller;

import com.unillanos.babycare.dto.ReservaDTO;
import com.unillanos.babycare.service.DisponibilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final DisponibilidadService disponibilidadService;

    @PostMapping
    public ResponseEntity<?> reservarNinera(@RequestBody ReservaDTO reservaDTO) {
        try {
            disponibilidadService.reservarNinera(reservaDTO.getIdDisponibilidad());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No se pudo realizar la reserva: " + e.getMessage());
        }
    }

}