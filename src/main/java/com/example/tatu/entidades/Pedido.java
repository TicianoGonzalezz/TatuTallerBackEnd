package com.example.tatu.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import com.example.tatu.entidades.EstadoPedido;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    public Pedido() {
        this.fecha = LocalDateTime.now();
        this.estado = EstadoPedido.PENDIENTE;
    }
    public Pedido(Usuario usuario) {
        this.fecha = LocalDateTime.now();
        this.usuario = usuario;
        this.estado = EstadoPedido.PENDIENTE;   
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;}
    public LocalDateTime getFecha() {
        return fecha;}
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;}
    public Usuario getUsuario() {
        return usuario;}
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;}
    public EstadoPedido getEstado() {
        return estado;}
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;}
        



}
