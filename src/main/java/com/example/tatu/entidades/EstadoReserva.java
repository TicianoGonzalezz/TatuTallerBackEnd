package com.example.tatu.entidades;

public class EstadoReserva {
    public enum Estado {
        PENDIENTE,
        CONFIRMADA,
        CANCELADA
    }

    private Estado estado;

    public EstadoReserva(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "EstadoReserva{" +
                "estado=" + estado +
                '}';
    }
}
    
