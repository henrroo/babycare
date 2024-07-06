package com.unillanos.babycare.config;

import com.unillanos.babycare.model.Ninera;
import com.unillanos.babycare.repository.NineraRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final NineraRepository nineraRepository;

    @Override
    public void run(String... args) {
        Ninera ninera1 = new Ninera();
        ninera1.setNombre("Maria Perez");
        ninera1.setDisponible(true);
        ninera1.setDisponibilidadDesde(LocalDateTime.now().minusHours(52));
        ninera1.setDisponibilidadHasta(LocalDateTime.now().plusHours(5));
        nineraRepository.save(ninera1);

        Ninera ninera2 = new Ninera();
        ninera2.setNombre("Ana Gomez");
        ninera2.setDisponible(true);
        ninera2.setDisponibilidadDesde(LocalDateTime.now().minusHours(1));
        ninera2.setDisponibilidadHasta(LocalDateTime.now().plusHours(3));
        nineraRepository.save(ninera2);

        Ninera ninera3 = new Ninera();
        ninera3.setNombre("Laura Diaz");
        ninera3.setDisponible(false);
        ninera3.setDisponibilidadDesde(LocalDateTime.now().minusHours(4));
        ninera3.setDisponibilidadHasta(LocalDateTime.now().plusHours(2));
        nineraRepository.save(ninera3);

        log.info("Datos de niñeras precargados.");
    }
}
