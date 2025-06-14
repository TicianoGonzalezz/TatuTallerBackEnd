package com.example.tatu.mapper;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.example.tatu.dto.ClaseDTO;
import com.example.tatu.entidades.Clase;

@Component
public class ClaseDTOMapper {

    // Metodo para convertir de Clase a ClaseDTO
    public ClaseDTO toDTO(Clase clase) {
        if (clase == null) {
            return null;
        }
        ClaseDTO dto = new ClaseDTO();
        dto.setId(clase.getId());
        dto.setNombre(clase.getNombre());
        dto.setDescripcion(clase.getDescripcion());
        dto.setHoraDesde(clase.getHorarioDesde().toString());
        dto.setHoraHasta(clase.getHorarioHasta().toString());
        dto.setDiaSemana(clase.getDiaSemana());
        dto.setSedeId(clase.getSede().getId());
        dto.setProfesorId(clase.getProfesor().getId());
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
        clase.setHorarioDesde(LocalTime.parse(dto.getHoraDesde()));
        clase.setHorarioHasta(LocalTime.parse(dto.getHoraHasta()));
        // Aquí se debería buscar el profesor y la sede por sus IDs
        // clase.setProfesor(usuarioRepositorio.findById(dto.getProfesorId()).orElse(null));
        // clase.setSede(sedeRepositorio.findById(dto.getSedeId()).orElse(null));
        // Por ahora, se deja como null para evitar problemas de dependencia circular
        clase.setProfesor(null);
        clase.setSede(null);
        return clase;
    }

}
