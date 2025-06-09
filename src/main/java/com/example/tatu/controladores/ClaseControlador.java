package com.example.tatu.controladores;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tatu.entidades.Clase;
import com.example.tatu.entidades.Sede;
import com.example.tatu.entidades.Usuario;
import com.example.tatu.servicios.ClaseServicio;
import com.example.tatu.servicios.SedeServicio;
import com.example.tatu.servicios.UsuarioServicio;

@RestController
@RequestMapping("/clase")
public class ClaseControlador {

    @Autowired
    private ClaseServicio claseServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private SedeServicio sedeServicio;

    // CREATE
    @PostMapping("/crear")
    public ResponseEntity<Void> crearClase(
            @RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
            @RequestParam String profesorId,
            @RequestParam Long sedeId) {
        try {
            Usuario profesor = usuarioServicio.buscarPorId(profesorId);
            Sede sede = sedeServicio.buscarPorId(sedeId);
            if (profesor == null || sede == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
           
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ (listar todas)
    @GetMapping("/listar")
    public ResponseEntity<List<Clase>> listarClases() {
        return new ResponseEntity<>(claseServicio.listarClases(), HttpStatus.OK);
    }

    // READ (por id)
    @GetMapping("/{id}")
    public ResponseEntity<Clase> obtenerClase(@PathVariable Long id) {
        Clase clase = claseServicio.buscarPorId(id);
        if (clase != null) {
            return new ResponseEntity<>(clase, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE
    @PutMapping("/modificar/{id}")
    public ResponseEntity<Void> modificarClase(
            @PathVariable Long id,
            @RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
            @RequestParam String profesorId,
            @RequestParam Long sedeId) {
        try {
            Usuario profesor = usuarioServicio.buscarPorId(profesorId);
            Sede sede = sedeServicio.buscarPorId(sedeId);
            if (profesor == null || sede == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            claseServicio.modificarClase(id, nombre, descripcion, fecha, profesor, sede);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarClase(@PathVariable Long id) {
        try {
            claseServicio.eliminarClase(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // BUSQUEDAS AVANZADAS
    @GetMapping("/por-profesor/{profesorId}")
    public ResponseEntity<List<Clase>> buscarPorProfesor(@PathVariable Long profesorId) {
        Usuario profesor = usuarioServicio.buscarPorId(profesorId.toString());
        if (profesor == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(claseServicio.buscarPorProfesor(profesor), HttpStatus.OK);
    }

    @GetMapping("/por-sede/{sedeId}")
    public ResponseEntity<List<Clase>> buscarPorSede(@PathVariable Long sedeId) {
        Sede sede = sedeServicio.buscarPorId(sedeId);
        if (sede == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(claseServicio.buscarPorSede(sede), HttpStatus.OK);
    }

    @GetMapping("/por-nombre")
    public ResponseEntity<List<Clase>> buscarPorNombre(@RequestParam String nombre) {
        return new ResponseEntity<>(claseServicio.buscarPorNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/por-fecha")
    public ResponseEntity<List<Clase>> buscarPorFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha) {
        return new ResponseEntity<>(claseServicio.buscarPorFecha(fecha), HttpStatus.OK);
    }

    @GetMapping("/por-fecha-entre")
    public ResponseEntity<List<Clase>> buscarPorFechaEntre(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
        return new ResponseEntity<>(claseServicio.buscarPorFechaEntre(fechaInicio, fechaFin), HttpStatus.OK);
    }
}