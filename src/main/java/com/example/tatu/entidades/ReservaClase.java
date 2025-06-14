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
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class ReservaClase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;

    @Column(name = "horario_desde", nullable = false)
    private LocalTime horaDesde;

    @Column(name = "horario_hasta", nullable = false)
    private LocalTime horaHasta;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    public ReservaClase() {
    }

    public ReservaClase(Usuario usuario, Clase clase, LocalTime horarioDesde, LocalTime horarioHasta,
            EstadoReserva estado) {
        this.usuario = usuario;
        this.clase = clase;
        this.horaDesde = horarioDesde;
        this.horaHasta = horarioHasta;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public LocalTime getHorarioReservaDesde() {
        return horaDesde;
    }

    public void setHorarioReservaDesde(LocalTime horarioReservaDesde) {
        this.horaDesde = horarioReservaDesde;
    }

    public LocalTime getHorarioReservaHasta() {
        return horaHasta;
    }

    public void setHorarioReservaHasta(LocalTime horarioReservaHasta) {
        this.horaHasta = horarioReservaHasta;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

}