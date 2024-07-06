package com.unillanos.babycare.controller;

import com.unillanos.babycare.model.Ninera;
import com.unillanos.babycare.service.NineraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/nineras")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class NineraController {

    private final NineraService nineraService;

    @GetMapping
    public List<Ninera> getAllNineras() {
        return nineraService.getAllNineras();
    }

    @PostMapping
    public Ninera createNinera(@RequestBody Ninera ninera) {
        return nineraService.createNinera(ninera);
    }

    @GetMapping("/disponibles")
    public List<Ninera> getDisponibles() {
        return nineraService.getDisponibles();
    }

    @GetMapping("/disponibles/{fechaHora}/{duracionHoras}")
    public List<Ninera> getDisponibles(
            @PathVariable String fechaHora,
            @PathVariable int duracionHoras) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(fechaHora, formatter);
        return nineraService.getDisponibles(dateTime, duracionHoras);
    }
}
