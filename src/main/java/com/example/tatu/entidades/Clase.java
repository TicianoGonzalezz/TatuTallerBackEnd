package com.example.tatu.entidades;

import java.time.LocalDateTime;
import java.time.LocalTime;

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

    @Column(name = "dia_semana", nullable = false)
    private Integer diaSemana;

    @Column(name = "horario_desde", nullable = false)
    private LocalTime horarioDesde;
    @Column(name = "horario_hasta", nullable = false)
    private LocalTime horarioHasta;

    @Column(nullable = false)
    private Integer capacidad = 6;

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    public void setHorarioDesde(LocalTime horarioDesde) {
        this.horarioDesde = horarioDesde;
    }

    public void setHorarioHasta(LocalTime horarioHasta) {
        this.horarioHasta = horarioHasta;
    }

    public Clase() {
    }

    public Clase(String descripcion, Usuario profesor, Sede sede, String nombre, LocalTime horarioDesde,
            LocalTime horarioHasta) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.sede = sede;
        this.descripcion = descripcion;
        this.horarioDesde = horarioDesde;
        this.horarioHasta = horarioHasta;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
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

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public LocalTime getHorarioDesde() {
        return horarioDesde;
    }

    public LocalTime getHorarioHasta() {
        return horarioHasta;
    }

}
