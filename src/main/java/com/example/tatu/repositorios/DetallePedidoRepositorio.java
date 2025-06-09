package com.example.tatu.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tatu.entidades.DetallePedido;

@Repository
public interface  DetallePedidoRepositorio extends JpaRepository<DetallePedido, Long>  {
    
}
