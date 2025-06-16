package com.example.tatu.entidades;

import java.time.LocalDate;

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

    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @Enumerated(EnumType.STRING)
    private TipoReserva tipoReserva;

    public ReservaClase() {
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public ReservaClase(Usuario usuario, Clase clase, LocalDate fecha,
            EstadoReserva estado, TipoReserva tipoReserva) {
        this.usuario = usuario;
        this.clase = clase;
        this.estado = estado;
        this.tipoReserva = tipoReserva;
        this.fechaReserva = fecha;
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

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fecha) {
        this.fechaReserva = fecha;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

}