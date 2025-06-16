package com.example.tatu.servicios;

import com.example.tatu.dto.ProductoDTO;
import com.example.tatu.entidades.Imagen;
import com.example.tatu.entidades.Producto;
import com.example.tatu.excepciones.MiException;
import com.example.tatu.mapper.ProductoDTOMapper;
import com.example.tatu.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private ImagenServicio imagenServicio;

    @Autowired
    private ProductoDTOMapper productoDTOMapper;

    // CREATE
    public ProductoDTO crear(ProductoDTO productoDTO, MultipartFile archivo) throws MiException {
        Producto producto = productoDTOMapper.fromDTO(productoDTO);
        if (archivo != null && !archivo.isEmpty()) {
            Imagen imagen = imagenServicio.guardar(archivo);
            producto.setImagen(imagen);
        }
        Producto guardado = productoRepositorio.save(producto);
        return productoDTOMapper.toDTO(guardado);
    }

    // GET BY ID
    public ProductoDTO buscarPorIdDTO(Long id) {
        Optional<Producto> respuesta = productoRepositorio.findById(id);
        return respuesta.map(productoDTOMapper::toDTO).orElse(null);
    }

    // GET ALL
    public List<ProductoDTO> listarProductosDTO() {
        return productoRepositorio.findAll().stream()
                .map(productoDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    // UPDATE
    public ProductoDTO actualizar(Long id, ProductoDTO productoDTO, MultipartFile archivo) throws MiException {
        Optional<Producto> respuesta = productoRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Producto producto = respuesta.get();
            if (productoDTO.getNombre() != null) producto.setNombre(productoDTO.getNombre());
            if (productoDTO.getDescripcion() != null) producto.setDescripcion(productoDTO.getDescripcion());
            if (productoDTO.getPrecio() != null) producto.setPrecio(productoDTO.getPrecio());
            if (productoDTO.getStock() != null) producto.setStock(productoDTO.getStock());
            if (archivo != null && !archivo.isEmpty()) {
                Imagen imagen = imagenServicio.guardar(archivo);
                producto.setImagen(imagen);
            }
            Producto actualizado = productoRepositorio.save(producto);
            return productoDTOMapper.toDTO(actualizado);
        } else {
            throw new MiException("Producto no encontrado");
        }
    }

    // DELETE
    public void eliminar(Long id) throws MiException {
        Optional<Producto> respuesta = productoRepositorio.findById(id);
        if (respuesta.isPresent()) {
            productoRepositorio.delete(respuesta.get());
        } else {
            throw new MiException("Producto no encontrado");
        }
    }
}