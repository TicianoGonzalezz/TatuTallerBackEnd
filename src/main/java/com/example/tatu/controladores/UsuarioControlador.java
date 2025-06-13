package com.example.tatu.controladores;

import com.example.tatu.dto.UsuarioDTO;
import com.example.tatu.servicios.UsuarioServicio;
import com.example.tatu.excepciones.MiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    // get de prueba para verificar que el controlador está funcionando
    @GetMapping("/prueba")
    public ResponseEntity<String> prueba() {
        return ResponseEntity.ok("Controlador de Usuario funcionando correctamente");
    }

    // CREATE
    @PostMapping(value = "/crear", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> crearUsuario(
            @RequestPart("usuario") String usuarioJson,
            @RequestPart(value = "archivo", required = false) MultipartFile archivo,
            @RequestParam String password,
            @RequestParam String password2) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            UsuarioDTO usuarioDTO = mapper.readValue(usuarioJson, UsuarioDTO.class);
            UsuarioDTO creado = usuarioServicio.registrar(usuarioDTO, archivo, password, password2);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
        }
    }

    // get ALL
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioServicio.listarUsuariosDTO();
        return ResponseEntity.ok(usuarios);
    }

    // get BY ID
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
            return ResponseEntity.ok(usuario);
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
        }
    }

}
