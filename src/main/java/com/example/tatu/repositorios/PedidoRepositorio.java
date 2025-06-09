package com.example.tatu.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tatu.entidades.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
    
}
