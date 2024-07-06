package com.unillanos.babycare.service.impl;

import com.unillanos.babycare.model.Ninera;
import com.unillanos.babycare.repository.NineraRepository;
import com.unillanos.babycare.service.NineraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NineraServiceImpl implements NineraService {

    private final NineraRepository nineraRepository;

    @Override
    public List<Ninera> getAllNineras() {
        return nineraRepository.findAll();
    }

    @Override
    public Ninera createNinera(Ninera ninera) {
        return nineraRepository.save(ninera);
    }

    @Override
    public List<Ninera> getDisponibles() {
        return nineraRepository.findAll().stream()
                .filter(Ninera::isDisponible)
                .toList();
    }

    @Override
    public List<Ninera> getDisponibles(LocalDateTime fechaHora, int duracionHoras) {
        return nineraRepository.findAll().stream()
                .filter(ninera -> ninera.isDisponible() &&
                        ninera.getDisponibilidadDesde().isBefore(fechaHora) &&
                        ninera.getDisponibilidadHasta().isAfter(fechaHora.plusHours(duracionHoras)))
                .toList();
    }

    @Override
    public void actualizarDisponibilidad(Ninera ninera, LocalDateTime fechaHora, int duracionHoras) {
        ninera.setDisponibilidadDesde(fechaHora.plusHours(duracionHoras));
        ninera.setDisponible(false);
        nineraRepository.save(ninera);
    }

}