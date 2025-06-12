package com.example.tatu.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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