package com.example.tatu.controladores;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tatu.entidades.Clase;
import com.example.tatu.entidades.Sede;
import com.example.tatu.entidades.Usuario;
import com.example.tatu.servicios.ClaseServicio;
import com.example.tatu.servicios.SedeServicio;
import com.example.tatu.servicios.UsuarioServicio;

@RestController
@RequestMapping("/clase")
public class ClaseControlador {

    @Autowired
    private ClaseServicio claseServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private SedeServicio sedeServicio;


    

   


    
}