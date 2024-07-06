package com.unillanos.babycare.service;

import com.unillanos.babycare.model.Ninera;

import java.time.LocalDateTime;
import java.util.List;

public interface NineraService {

    List<Ninera> getAllNineras();
    Ninera createNinera(Ninera ninera);
    List<Ninera> getDisponibles();
    List<Ninera> getDisponibles(LocalDateTime fechaHora, int duracionHoras);
    void actualizarDisponibilidad(Ninera ninera, LocalDateTime fechaHora, int duracionHoras);

}
