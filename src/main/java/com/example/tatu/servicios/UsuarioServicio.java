package com.example.tatu.servicios;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.example.tatu.entidades.Imagen;
import com.example.tatu.entidades.Usuario;
import com.example.tatu.enumeraciones.Rol;
import com.example.tatu.excepciones.MiException;
import com.example.tatu.repositorios.UsuarioRepositorio;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServicio implements UserDetailsService{ 

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ImagenServicio imagenServicio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void registrar(MultipartFile archivo,String nombre, String email, String password, String password2) throws MiException {
   
        validar(nombre, email, password, password2);
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.ALUMNO);
        Imagen imagen= imagenServicio.guardar(archivo);
        usuario.setImagen(imagen);

        usuarioRepositorio.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }   
    public void eliminar(String id) throws MiException {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            usuarioRepositorio.delete(usuario);
        } else {
            throw new MiException("Usuario no encontrado");
        }
    }

    private void validar(String nombre, String email, String password, String password2) throws MiException {
        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
        if (email == null || email.isEmpty()) {
            throw new MiException("el email no puede ser nulo o estar vacío");
        }
        if (password == null || password.isEmpty() || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }
        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }
    }

    @Transactional
    public void actualizar(MultipartFile archivo, String id, String nombre, String email, String password, String password2) throws MiException {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if(respuesta.isPresent()){
            Usuario usuario = respuesta.get();

            if (nombre != null && !nombre.isEmpty()) {
                usuario.setNombre(nombre);
            }
            if (email != null && !email.isEmpty()) {
                usuario.setEmail(email);
            }
            if (password != null && !password.isEmpty()) {
                if (!password.equals(password2)) {
                    throw new MiException("Las contraseñas ingresadas deben ser iguales");
                }
                usuario.setPassword(new BCryptPasswordEncoder().encode(password));
            }
            // Imagen y otros campos...
            usuarioRepositorio.save(usuario);
        }
    }


    public Usuario buscarPorId(String id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if (usuario != null) {
            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            permisos.add(p);
            ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attributes.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario); // Guardamos el usuario en la sesión
           return new User(usuario.getEmail(), usuario.getPassword(), permisos);

        }else {
            return null; // Si el usuario no existe, retornamos null
        }
    }

}