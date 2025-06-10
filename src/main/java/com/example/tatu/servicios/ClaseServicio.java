package com.example.tatu.servicios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tatu.entidades.Clase;
import com.example.tatu.entidades.Sede;
import com.example.tatu.entidades.Usuario;
import com.example.tatu.repositorios.ClaseRepositorio;

@Service
public class ClaseServicio {

    @Autowired
    private ClaseRepositorio claseRepositorio;

    @Transactional
    public void crear(String nombre, String descripcion, Usuario profesor, Sede sede,
                      String horarioDesde, String horarioHasta) {
        Clase clase = new Clase(descripcion, profesor, sede, nombre, LocalDateTime.parse(horarioDesde), LocalDateTime.parse(horarioHasta));
        claseRepositorio.save(clase);
    }

    @Transactional(readOnly = true)
    public List<Clase> listarClases() {
        return claseRepositorio.findAll();
    }

    @Transactional
    public void modificarClase(Long id, String nombre, String descripcion, LocalDateTime fecha, Usuario profesor, Sede sede) {
        Optional<Clase> respuesta = claseRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Clase clase = respuesta.get();
            clase.setNombre(nombre);
            clase.setDescripcion(descripcion);
        }
    }

    public void eliminarClase(Long id) {
        Optional<Clase> respuesta = claseRepositorio.findById(id);
        if (respuesta.isPresent()) {
            claseRepositorio.delete(respuesta.get());
        }
    }

   
    public Clase buscarPorId(Long id) {
        return claseRepositorio.findById(id).orElse(null);
    }
}