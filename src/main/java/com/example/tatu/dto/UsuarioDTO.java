package com.example.tatu.dto;

public class UsuarioDTO {
     private Long id;
    private String nombre;
    private String email;
    private String rol;


    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRol() {
        return rol;}
    public void setRol(String rol) {
        this.rol = rol;
    }

}
