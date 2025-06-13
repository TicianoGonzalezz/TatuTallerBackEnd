package com.example.tatu.mapper;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.tatu.dto.ReservaClaseDTO;
import com.example.tatu.entidades.EstadoReserva;
import com.example.tatu.entidades.ReservaClase;
import com.example.tatu.repositorios.ClaseRepositorio;
import com.example.tatu.repositorios.UsuarioRepositorio;

@Component
public class ReservaClaseDTOMapper {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private ClaseRepositorio claseRepositorio;

    public ReservaClaseDTO toDTO(ReservaClase reserva) {
        if (reserva == null) {
            return null;
        }
        ReservaClaseDTO dto = new ReservaClaseDTO();
        dto.setId(reserva.getId());
        dto.setUsuarioId(reserva.getUsuario().getId());
        dto.setClaseId(reserva.getClase().getId());
        dto.sethorarioReservaDesde(reserva.getHorarioReservaDesde().toString());
        dto.setEstado(reserva.getEstado().name());
        return dto;
    }

    public ReservaClase fromDTO(ReservaClaseDTO dto) {
        if (dto == null) {
            return null;
        }
        ReservaClase reserva = new ReservaClase();
        reserva.setId(dto.getId());
        reserva.setUsuario(usuarioRepositorio.findById(dto.getUsuarioId()).orElse(null));
        reserva.setClase(claseRepositorio.findById(dto.getClaseId()).orElse(null));
        reserva.setHorarioReservaDesde(LocalDateTime.parse(dto.gethorarioReservaDesde()));
        reserva.setEstado(EstadoReserva.valueOf(dto.getEstado()));
        return reserva;
    }

}
