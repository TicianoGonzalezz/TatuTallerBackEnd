package com.example.tatu.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.tatu.dto.ClaseDTO;
import com.example.tatu.entidades.Clase;
import com.example.tatu.entidades.Sede;
import com.example.tatu.entidades.Usuario;
import com.example.tatu.repositorios.SedeRespositorio;
import com.example.tatu.repositorios.UsuarioRepositorio;
import java.time.LocalTime;

@Component
public class ClaseDTOMapper {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private SedeRespositorio sedeRepositorio;

    public ClaseDTO toDTO(Clase clase) {
        if (clase == null) {
            return null;
        }
        ClaseDTO dto = new ClaseDTO();
        dto.setId(clase.getId());
        dto.setNombre(clase.getNombre());
        dto.setDescripcion(clase.getDescripcion());
        dto.setHoraDesde(clase.getHorarioDesde() != null ? clase.getHorarioDesde().toString() : null);
        dto.setHoraHasta(clase.getHorarioHasta() != null ? clase.getHorarioHasta().toString() : null);
        dto.setDiaSemana(clase.getDiaSemana());
        dto.setSedeId(clase.getSede() != null ? clase.getSede().getId() : null);
        dto.setProfesorId(clase.getProfesor() != null ? clase.getProfesor().getId() : null);
        return dto;
    }

    public Clase fromDTO(ClaseDTO dto) {
        if (dto == null) {
            return null;
        }
        Clase clase = new Clase();
        clase.setId(dto.getId());
        clase.setNombre(dto.getNombre());
        clase.setDescripcion(dto.getDescripcion());
        clase.setDiaSemana(dto.getDiaSemana());
        clase.setHorarioDesde(dto.getHoraDesde() != null ? LocalTime.parse(dto.getHoraDesde()) : null);
        clase.setHorarioHasta(dto.getHoraHasta() != null ? LocalTime.parse(dto.getHoraHasta()) : null);

        // Buscar y setear profesor
        if (dto.getProfesorId() != null) {
            Usuario profesor = usuarioRepositorio.findById(dto.getProfesorId()).orElse(null);
            clase.setProfesor(profesor);
        } else {
            clase.setProfesor(null);
        }

        // Buscar y setear sede
        if (dto.getSedeId() != null) {
            Sede sede = sedeRepositorio.findById(dto.getSedeId()).orElse(null);
            clase.setSede(sede);
        } else {
            clase.setSede(null);
        }

        return clase;
    }
}