package com.unillanos.babycare.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SolicitudServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cliente;
    private LocalDateTime fechaHora;
    private int duracionHoras;
    
    @ManyToOne
    @JoinColumn(name = "ninera_id")
    private Ninera ninera;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public Ninera getNinera() {
        return ninera;
    }

    public void setNinera(Ninera ninera) {
        this.ninera = ninera;
    }
}
