package com.example.tatu.repositorios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tatu.entidades.Clase;
import com.example.tatu.entidades.ReservaClase;

@Repository
public interface ReservaClaseRepositorio extends JpaRepository<ReservaClase, Long> {
    int countByClaseAndFecha(Clase clase, LocalDate fecha);

    List<ReservaClase> findByUsuarioId(Long usuarioId);
}
