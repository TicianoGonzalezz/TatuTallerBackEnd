package com.example.tatu.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sede")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Long id;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "telefono")
    private String telefono;

    public Sede() {}

    public Sede( String direccion, String telefono) {
       
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
