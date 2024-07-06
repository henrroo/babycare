package com.unillanos.babycare.service;

import com.unillanos.babycare.model.SolicitudServicio;

import java.util.List;

public interface SolicitudServicioService {
    List<SolicitudServicio> getAllSolicitudes();

    SolicitudServicio createSolicitud(SolicitudServicio solicitud);

    SolicitudServicio assignNinera(Long solicitudId, Long nineraId);

}
