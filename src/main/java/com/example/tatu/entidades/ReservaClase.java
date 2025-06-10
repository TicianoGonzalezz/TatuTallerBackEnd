package com.example.tatu.entidades;

import java.time.LocalDateTime;

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

    private LocalDateTime horarioReservaDesde;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    public ReservaClase() {}
    public ReservaClase(Usuario usuario, Clase clase, LocalDateTime horarioReservaDesde, EstadoReserva estado) {
        this.usuario = usuario;
        this.clase = clase;
        this.horarioReservaDesde = horarioReservaDesde;
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
        this.clase = clase;}
    public LocalDateTime getHorarioReservaDesde() {
        return horarioReservaDesde;
    }
    public void setHorarioReservaDesde(LocalDateTime horarioReservaDesde) {
        this.horarioReservaDesde = horarioReservaDesde;
    }
    public EstadoReserva getEstado() {
        return estado;}
    public void setEstado(EstadoReserva estado) {
        this.estado = estado;}
        


}