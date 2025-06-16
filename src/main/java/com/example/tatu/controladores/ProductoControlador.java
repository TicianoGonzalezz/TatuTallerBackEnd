package com.example.tatu.controladores;

import com.example.tatu.dto.ProductoDTO;
import com.example.tatu.servicios.ProductoServicio;
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
@RequestMapping("/producto")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

 

    // CREATE
    @PostMapping(value = "/crear", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> crearProducto(
            @RequestPart("producto") String productoJson,
            @RequestPart(value = "archivo", required = false) MultipartFile archivo) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ProductoDTO productoDTO = mapper.readValue(productoJson, ProductoDTO.class);
            ProductoDTO creado = productoServicio.crear(productoDTO, archivo);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
        }
    }

    // GET ALL
    @GetMapping("/listar")
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        List<ProductoDTO> productos = productoServicio.listarProductosDTO();
        return ResponseEntity.ok(productos);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable Long id) {
        ProductoDTO producto = productoServicio.buscarPorIdDTO(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
    }

    // UPDATE
    @PutMapping(value = "/actualizar/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> actualizarProducto(
            @PathVariable Long id,
            @RequestPart("producto") String productoJson,
            @RequestPart(value = "archivo", required = false) MultipartFile archivo) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ProductoDTO productoDTO = mapper.readValue(productoJson, ProductoDTO.class);
            ProductoDTO actualizado = productoServicio.actualizar(id, productoDTO, archivo);
            return ResponseEntity.ok(actualizado);
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno");
        }
    }

    // DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        try {
            productoServicio.eliminar(id);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
