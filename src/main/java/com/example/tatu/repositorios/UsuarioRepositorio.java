package com.example.tatu.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tatu.entidades.Usuario;
import com.example.tatu.enumeraciones.Rol;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

    Usuario findByNombre(String nombre);

    Usuario findByEmailAndPassword(String email, String password);
}
