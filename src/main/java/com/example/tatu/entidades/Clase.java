package com.example.tatu.entidades;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Clase {

    @Id
    @Column(name = "id_clase")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "profesor_id") // <--- Usa @JoinColumn, NO @Column
    private Usuario profesor;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "sede_id")
    private Sede sede;
    @Column(name = "horario_desde", nullable = false)
    private LocalDateTime horarioDesde;
    @Column(name = "horario_hasta", nullable = false)
    private LocalDateTime horarioHasta;

    public Clase() {
    }

    public Clase(String descripcion, Usuario profesor, Sede sede, String nombre, LocalDateTime horarioDesde,
            LocalDateTime horarioHasta) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.sede = sede;
        this.descripcion = descripcion;
        this.horarioDesde = horarioDesde;
        this.horarioHasta = horarioHasta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getHorarioDesde() {
        return horarioDesde;
    }

    public void setHorarioDesde(LocalDateTime horarioDesde) {
        this.horarioDesde = horarioDesde;
    }

    public LocalDateTime getHorarioHasta() {
        return horarioHasta;
    }

    public void setHorarioHasta(LocalDateTime horarioHasta) {
        this.horarioHasta = horarioHasta;
    }
}
