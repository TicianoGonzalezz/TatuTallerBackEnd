package com.example.tatu.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tatu.dto.ClaseDTO;
import com.example.tatu.excepciones.MiException;
import com.example.tatu.servicios.ClaseServicio;

@RestController
@RequestMapping("/clase")
public class ClaseControlador {

    @Autowired
    private ClaseServicio claseServicio;

    // Método para crear una nueva clase
    /**
     * Crea una nueva clase.
     *
     * @param dto Objeto DTO que contiene los datos de la clase.
     * @return ClaseDTO con los datos de la clase creada.
     */
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ClaseDTO dto) {
        try {
            ClaseDTO claseCreada = claseServicio.crear(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(claseCreada);
        } catch (Exception e) {
            e.printStackTrace(); // <-- AGREGÁ ESTA LÍNEA

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
        }
    }

    // Metodo para listar todas las clases
    /**
     * Lista todas las clases.
     *
     * @return Lista de ClaseDTO con todas las clases.
     */
    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            return ResponseEntity.ok(claseServicio.listar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
        }
    }

    // Método para buscar una clase por ID
    /**
     * Busca una clase por su ID.
     *
     * @param id ID de la clase a buscar.
     * @return ClaseDTO con los datos de la clase encontrada, o 404 si no se
     *         encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClaseDTO> buscarPorId(Long id) {
        try {
            return claseServicio.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Método para actualizar una clase existente
    /**
     * Actualiza una clase existente.
     *
     * @param dto Objeto DTO que contiene los datos actualizados de la clase.
     * @param id  ID de la clase a actualizar.
     * @return ClaseDTO con los datos actualizados de la clase, o 404 si no se
     *         encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody ClaseDTO dto, Long id) {
        try {
            ClaseDTO claseActualizada = claseServicio.actualizar(id, dto);
            return ResponseEntity.ok(claseActualizada);
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
        }
    }

    // Método para eliminar una clase por ID
    /**
     * Elimina una clase por su ID.
     *
     * @param id ID de la clase a eliminar.
     * @return Respuesta HTTP 204 No Content si se elimina correctamente, o 404 si
     *         no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(Long id) {
        try {
            claseServicio.eliminar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
        }
    }
}