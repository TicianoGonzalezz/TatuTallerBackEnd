package com.example.tatu.dto;

public class ReservaClaseDTO {
    private Long id;
    private Long usuarioId;
    private Long claseId;
    private String horarioReservaDesde;
    private String estado;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getClaseId() {
        return claseId;
    }

    public void setClaseId(Long claseId) {
        this.claseId = claseId;
    }

    public String gethorarioReservaDesde() {
        return horarioReservaDesde;
    }

    public void sethorarioReservaDesde(String horarioReservaDesde) {
        this.horarioReservaDesde = horarioReservaDesde;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
