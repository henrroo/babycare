package com.unillanos.babycare.controller;

import com.unillanos.babycare.model.Ninera;
import com.unillanos.babycare.service.NineraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nineras")
@RequiredArgsConstructor
public class NineraController {

    private final NineraService nineraService;

    @GetMapping
    public List<Ninera> getAllNineras() {
        return nineraService.getAllNineras();
    }

    @PostMapping
    public Ninera createNinera(@RequestBody Ninera ninera) {
        return nineraService.saveNinera(ninera);
    }

}