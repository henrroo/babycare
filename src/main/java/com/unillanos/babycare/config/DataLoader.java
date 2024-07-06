package com.unillanos.babycare.config;

import com.unillanos.babycare.model.Disponibilidad;
import com.unillanos.babycare.model.Ninera;
import com.unillanos.babycare.repository.DisponibilidadRepository;
import com.unillanos.babycare.repository.NineraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final NineraRepository nineraRepository;
    private final DisponibilidadRepository disponibilidadRepository;

    @Autowired
    public DataLoader(NineraRepository nineraRepository, DisponibilidadRepository disponibilidadRepository) {
        this.nineraRepository = nineraRepository;
        this.disponibilidadRepository = disponibilidadRepository;
    }

    @Override
    public void run(String... args) {
        Ninera ana = new Ninera();
        ana.setNombre("Ana");
        ana.setApellido("Garcia");
        ana.setTelefono("1234567890");
        ana.setEmail("ana.garcia@email.com");
        nineraRepository.save(ana);

        Ninera maria = new Ninera();
        maria.setNombre("Maria");
        maria.setApellido("Lopez");
        maria.setTelefono("0987654321");
        maria.setEmail("maria.lopez@email.com");
        nineraRepository.save(maria);

        Ninera laura = new Ninera();
        laura.setNombre("Laura");
        laura.setApellido("Martinez");
        laura.setTelefono("5678901234");
        laura.setEmail("laura.martinez@email.com");
        nineraRepository.save(laura);

        disponibilidadRepository.save(new Disponibilidad(1L, ana, LocalDate.parse("2024-07-05"), LocalTime.parse("09:00"), LocalTime.parse("17:00")));
        disponibilidadRepository.save(new Disponibilidad(2L, ana, LocalDate.parse("2024-07-06"), LocalTime.parse("10:00"), LocalTime.parse("18:00")));
        disponibilidadRepository.save(new Disponibilidad(3L, maria, LocalDate.parse("2024-07-05"), LocalTime.parse("08:00"), LocalTime.parse("16:00")));
        disponibilidadRepository.save(new Disponibilidad(4L, maria, LocalDate.parse("2024-07-07"), LocalTime.parse("09:00"), LocalTime.parse("17:00")));
        disponibilidadRepository.save(new Disponibilidad(5L, laura, LocalDate.parse("2024-07-06"), LocalTime.parse("11:00"), LocalTime.parse("19:00")));
        disponibilidadRepository.save(new Disponibilidad(6L, laura, LocalDate.parse("2024-07-07"), LocalTime.parse("10:00"), LocalTime.parse("18:00")));
        disponibilidadRepository.save(new Disponibilidad(7L, laura, LocalDate.parse("2024-07-08"), LocalTime.parse("08:00"), LocalTime.parse("16:00")));
        disponibilidadRepository.save(new Disponibilidad(8L, laura, LocalDate.parse("2024-07-09"), LocalTime.parse("09:00"), LocalTime.parse("17:00")));
        disponibilidadRepository.save(new Disponibilidad(9L, laura, LocalDate.parse("2024-07-10"), LocalTime.parse("10:00"), LocalTime.parse("18:00")));
    }

}