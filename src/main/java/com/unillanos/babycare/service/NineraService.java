package com.unillanos.babycare.service;

import com.unillanos.babycare.model.Ninera;
import com.unillanos.babycare.repository.NineraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NineraService {

    private final NineraRepository nineraRepository;

    public List<Ninera> getAllNineras() {
        return nineraRepository.findAll();
    }

    public Ninera saveNinera(Ninera ninera) {
        return nineraRepository.save(ninera);
    }

}