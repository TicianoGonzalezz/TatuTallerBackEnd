package com.example.tatu.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tatu.entidades.Clase;
import com.example.tatu.entidades.Sede;
import com.example.tatu.entidades.Usuario;

@Repository
public interface ClaseRepositorio extends JpaRepository<Clase, Long> {
    // List<Clase> findByProfesor(Usuario profesor);
    // List<Clase> findBySede(Sede sede);
    // List<Clase> findByNombreContainingIgnoreCase(String nombre);
    // List<Clase> findByFecha(LocalDateTime fecha);
    // List<Clase> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
