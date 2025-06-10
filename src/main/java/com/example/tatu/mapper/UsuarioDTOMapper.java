package com.example.tatu.mapper;

import com.example.tatu.dto.UsuarioDTO;
import com.example.tatu.entidades.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDTOMapper {
    public UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setRol(usuario.getRol() != null ? usuario.getRol().name() : null);
        return dto;
    }

    public Usuario fromDTO(UsuarioDTO dto) {
        if (dto == null) return null;
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        // No se setea password ni rol aquí por seguridad, agrégalo si lo necesitas
        // usuario.setRol(Rol.valueOf(dto.getRol()));
        // Si necesitas setear la imagen, deberías buscarla por id en el servicio correspondiente
        return usuario;
    }
}