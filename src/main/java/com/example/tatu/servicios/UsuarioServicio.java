package com.example.tatu.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.example.tatu.dto.UsuarioDTO;
import com.example.tatu.mapper.*;
import com.example.tatu.entidades.Imagen;
import com.example.tatu.entidades.Usuario;
import com.example.tatu.enumeraciones.Rol;
import com.example.tatu.excepciones.MiException;
import com.example.tatu.repositorios.UsuarioRepositorio;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ImagenServicio imagenServicio;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioDTOMapper usuarioDTOMapper;

    public UsuarioDTO registrar(UsuarioDTO usuarioDTO, MultipartFile archivo, String password, String password2)
            throws MiException {
        validar(usuarioDTO.getNombre(), usuarioDTO.getEmail(), password, password2);

        Usuario usuario = usuarioDTOMapper.fromDTO(usuarioDTO);
        usuario.setPassword(passwordEncoder.encode(password));
        usuario.setRol(Rol.ALUMNO);

        Imagen imagen = imagenServicio.guardar(archivo);
        usuario.setImagen(imagen);

        usuarioRepositorio.save(usuario);
        return usuarioDTOMapper.toDTO(usuario);
    }

    public UsuarioDTO buscarPorIdDTO(Long id) {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            return usuarioDTOMapper.toDTO(respuesta.get());
        } else {
            return null; // O lanzar una excepción si prefieres
        }
    }

    public List<UsuarioDTO> listarUsuariosDTO() {
        return usuarioRepositorio.findAll().stream()
                .map(usuarioDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void eliminar(Long id) throws MiException {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            usuarioRepositorio.delete(respuesta.get());
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
    public UsuarioDTO actualizar(Long id, UsuarioDTO usuarioDTO, MultipartFile archivo, String password,
            String password2) throws MiException {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();

            if (usuarioDTO.getNombre() != null && !usuarioDTO.getNombre().isEmpty()) {
                usuario.setNombre(usuarioDTO.getNombre());
            }
            if (usuarioDTO.getEmail() != null && !usuarioDTO.getEmail().isEmpty()) {
                usuario.setEmail(usuarioDTO.getEmail());
            }
            if (password != null && !password.isEmpty()) {
                if (!password.equals(password2)) {
                    throw new MiException("Las contraseñas ingresadas deben ser iguales");
                }
                usuario.setPassword(passwordEncoder.encode(password));
            }
            if (archivo != null && !archivo.isEmpty()) {
                Imagen imagen = imagenServicio.guardar(archivo);
                usuario.setImagen(imagen);
            }

            usuarioRepositorio.save(usuario);
            return usuarioDTOMapper.toDTO(usuario);
        } else {
            throw new MiException("Usuario no encontrado");
        }
    }

    public UsuarioDTO login(String email, String password) throws MiException {
        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if (usuario == null) {
            throw new MiException("Usuario no encontrado");
        }
        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new MiException("Contraseña incorrecta");
        }
        return usuarioDTOMapper.toDTO(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if (usuario != null) {
            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            permisos.add(p);
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                    .currentRequestAttributes();
            HttpSession session = attributes.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario); // Guardamos el usuario en la sesión
            return new User(usuario.getEmail(), usuario.getPassword(), permisos);

        } else {
            return null; // Si el usuario no existe, retornamos null
        }
    }

}