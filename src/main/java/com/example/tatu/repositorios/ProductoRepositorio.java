package com.example.tatu.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tatu.entidades.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
