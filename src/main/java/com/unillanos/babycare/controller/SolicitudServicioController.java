package com.unillanos.babycare.controller;

import com.unillanos.babycare.model.SolicitudServicio;
import com.unillanos.babycare.service.SolicitudServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor
public class SolicitudServicioController {

    private final SolicitudServicioService solicitudServicioService;

    @GetMapping
    public List<SolicitudServicio> getAllSolicitudes() {
        return solicitudServicioService.getAllSolicitudes();
    }

    @PostMapping
    public SolicitudServicio createSolicitud(@RequestBody SolicitudServicio solicitud) {
        return solicitudServicioService.createSolicitud(solicitud);
    }

    @PostMapping("/{solicitudId}/assign/{nineraId}")
    public SolicitudServicio assignNinera(@PathVariable Long solicitudId, @PathVariable Long nineraId) {
        return solicitudServicioService.assignNinera(solicitudId, nineraId);
    }

}
