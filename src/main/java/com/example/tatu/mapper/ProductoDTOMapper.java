package com.example.tatu.mapper;

import org.springframework.stereotype.Component;

import com.example.tatu.dto.ProductoDTO;
import com.example.tatu.entidades.Producto;

@Component
public class ProductoDTOMapper {
    public ProductoDTO toDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        if (producto.getImagen() != null) {
            dto.setImagenUrl("/imagenes/" + producto.getImagen().getId());
        } else {
            dto.setImagenUrl(null);
        }
        return dto;
    }

    public Producto fromDTO(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        // No se setea imagen aquí, se maneja en el servicio
        return producto;
    }
}
