package com.example.tatu.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tatu.entidades.Producto;
import com.example.tatu.repositorios.ProductoRepositorio;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Transactional
    public void crearProducto(String nombre, String descripcion, Double precio) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        productoRepositorio.save(producto);
    }

    @Transactional(readOnly = true)
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Transactional
    public void modificarProducto(Long id, String nombre, String descripcion, Double precio) {
        Optional<Producto> respuesta = productoRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Producto producto = respuesta.get();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            productoRepositorio.save(producto);
        }
    }

    public Producto buscarPorId(Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }
}