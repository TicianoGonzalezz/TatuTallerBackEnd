package com.example.tatu.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.tatu.servicios.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    // CREATE
    @PostMapping("/crear")
    public ResponseEntity<Object> crearUsuario(MultipartFile archivo, String nombre, String email, String password, String password2) {
        try {
            usuarioServicio.registrar(archivo, nombre, email, password, password2);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ
    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerUsuario(@PathVariable String id) {
        var usuario = usuarioServicio.buscarPorId(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Object> listarUsuarios() {
        return new ResponseEntity<>(usuarioServicio.listarUsuarios(), HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/modificar/{id}")
    public ResponseEntity<Object> modificarUsuario(
            @PathVariable String id,
            MultipartFile archivo,
            String nombre,
            String email,
            String password,
            String password2) {
        try {
            usuarioServicio.actualizar(archivo, id, nombre, email, password, password2);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable String id) {
        try {
            usuarioServicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
