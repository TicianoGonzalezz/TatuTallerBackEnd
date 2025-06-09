package com.example.tatu.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tatu.entidades.Sede;

@Repository
public interface  SedeRespositorio extends JpaRepository<Sede, Long> {
    
}
