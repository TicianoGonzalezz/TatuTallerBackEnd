package com.example.tatu.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tatu.entidades.ReservaClase;

@Repository
public interface ReservaClaseRepositorio extends JpaRepository<ReservaClase, Long> {

}
