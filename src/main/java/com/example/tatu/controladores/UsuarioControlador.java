package com.example.tatu.controladores;

import com.example.tatu.JwtUtil;
import com.example.tatu.dto.UsuarioDTO;
import com.example.tatu.enumeraciones.Rol;
import com.example.tatu.servicios.UsuarioServicio;
import com.example.tatu.excepciones.MiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    // CREATE
    @PostMapping(value = "/crearUsuarioDesdeUnAdministrador", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> crearUsuarioDesdeAdministrador(
            @RequestPart("usuario") String usuarioJson,
            @RequestPart(value = "archivo", required = false) MultipartFile archivo,
            @RequestPart("password") String password,
            @RequestPart("password2") String password2) {
        try {
            // Obtener el usuario autenticado
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
            }

            // Si quieres validar el rol ADMIN:
            boolean isAdmin = authentication.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
            if (!isAdmin) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos de administrador");
            }

            ObjectMapper mapper = new ObjectMapper();
            UsuarioDTO usuarioDTO = mapper.readValue(usuarioJson, UsuarioDTO.class);

            UsuarioDTO creado = usuarioServicio.registrar(usuarioDTO, archivo, password, password2);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // CREATE
    @PostMapping(value = "/crearUsuarioDesdeAfuera", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> crearUsuarioDesdeAfuera(
            @RequestPart("usuario") String usuarioJson,
            @RequestPart(value = "archivo", required = false) MultipartFile archivo,
            @RequestParam String password,
            @RequestParam String password2) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            UsuarioDTO usuarioDTO = mapper.readValue(usuarioJson, UsuarioDTO.class);
            usuarioDTO.setRol("ALUMNO");
            UsuarioDTO creado = usuarioServicio.registrar(usuarioDTO, archivo, password, password2);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
        }
    }

    // READ ALL
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioServicio.listarUsuariosDTO();
        return ResponseEntity.ok(usuarios);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioServicio.buscarPorIdDTO(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    // UPDATE
    @PutMapping(value = "/actualizar/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> actualizarUsuario(
            @PathVariable Long id,
            @RequestPart("usuario") String usuarioJson,
            @RequestPart(value = "archivo", required = false) MultipartFile archivo,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String password2) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            UsuarioDTO usuarioDTO = mapper.readValue(usuarioJson, UsuarioDTO.class);
            UsuarioDTO actualizado = usuarioServicio.actualizar(id, usuarioDTO, archivo, password, password2);
            return ResponseEntity.ok(actualizado);
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
        }
    }

    // DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        try {
            usuarioServicio.eliminar(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // LOGIN    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        try {
            UsuarioDTO usuario = usuarioServicio.login(email, password);
            String token = JwtUtil.generateToken(email);
            return ResponseEntity.ok().body(Map.of("token", token, "usuario", usuario));
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
        }
    }

}
