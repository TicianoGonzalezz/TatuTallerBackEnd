package com.example.tatu.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tatu.entidades.Sede;
import com.example.tatu.repositorios.SedeRespositorio;

@Service
public class SedeServicio {

    @Autowired
    private SedeRespositorio sedeRepositorio;

    public Sede buscarPorId(Long id) {
        return sedeRepositorio.findById(id).orElse(null);
    }

    public List<Sede> listarSedes() {
        return sedeRepositorio.findAll();
    }
}
