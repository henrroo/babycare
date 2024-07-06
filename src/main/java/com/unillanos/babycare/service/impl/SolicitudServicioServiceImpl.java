package com.unillanos.babycare.service.impl;

import com.unillanos.babycare.model.Ninera;
import com.unillanos.babycare.model.SolicitudServicio;
import com.unillanos.babycare.repository.NineraRepository;
import com.unillanos.babycare.repository.SolicitudServicioRepository;
import com.unillanos.babycare.service.SolicitudServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServicioServiceImpl implements SolicitudServicioService {

    private final SolicitudServicioRepository solicitudServicioRepository;
    private final NineraRepository nineraRepository;

    @Override
    public List<SolicitudServicio> getAllSolicitudes() {
        return solicitudServicioRepository.findAll();
    }

    @Override
    public SolicitudServicio createSolicitud(SolicitudServicio solicitud) {
        return solicitudServicioRepository.save(solicitud);
    }

    @Override
    public SolicitudServicio assignNinera(Long solicitudId, Long nineraId) {
        SolicitudServicio solicitud = solicitudServicioRepository.findById(solicitudId).orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        Ninera ninera = nineraRepository.findById(nineraId).orElseThrow(() -> new RuntimeException("Niñera no encontrada"));
        solicitud.setNinera(ninera);
        return solicitudServicioRepository.save(solicitud);
    }

}
