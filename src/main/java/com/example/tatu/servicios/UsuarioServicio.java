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
        String rol = usuarioDTO.getRol();
        if (rol == null) {
            usuarioDTO.setRol("ALUMNO");
            rol = "ALUMNO";
        }

        validarUsuarioRegistro(usuarioDTO.getNombre(), usuarioDTO.getEmail(), password, password2);
        Usuario usuario = usuarioDTOMapper.fromDTO(usuarioDTO);
        usuario.setRol(Rol.valueOf(rol.toUpperCase()));
        usuario.setPassword(passwordEncoder.encode(password));
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

    private void validarUsuarioRegistro(String nombre, String email, String password, String password2)
            throws MiException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new MiException("El nombre es obligatorio");
        }
        if (nombre.length() < 3) {
            throw new MiException("El nombre debe tener al menos 3 caracteres");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new MiException("El email es obligatorio");
        }
        if (!(email.endsWith("@gmail.com") || email.endsWith("@hotmail.com"))) {
            throw new MiException("El email debe ser @gmail.com o @hotmail.com");
        }
        if (usuarioRepositorio.findByEmail(email) != null) {
            throw new MiException("Ya existe un usuario con ese email");
        }
        if (password == null || password.isEmpty()) {
            throw new MiException("La contraseña es obligatoria");
        }
        validarContrasena(password);
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

            // VALIDAR TODO ANTES DE MODIFICAR
            if (usuarioDTO.getNombre() != null && usuarioDTO.getNombre().isEmpty()
                    && usuario.getNombre().length() < 4) {
                throw new MiException("El nombre no puede estar vacío y debe tener al menos 4 letras");
            }
            if (usuarioDTO.getEmail() != null && usuarioDTO.getEmail().isEmpty()) {
                throw new MiException("El email no puede estar vacío");
            }
            if (usuarioDTO.getEmail() != null && !usuarioDTO.getEmail().equals(respuesta.get().getEmail())) {
                Usuario usuarioExistente = usuarioRepositorio.findByEmail(usuarioDTO.getEmail());
                if (usuarioExistente != null && !usuarioExistente.getId().equals(id)) {
                    throw new MiException("Ya existe un usuario con ese email");
                }
            }
            if (password != null && !password.isEmpty()) {
                validarContrasena(password);
                if (!password.equals(password2)) {
                    throw new MiException("Las contraseñas ingresadas deben ser iguales");
                }
            }

            // SI TODO ES VÁLIDO, RECIÉN AHÍ MODIFICÁS
            if (usuarioDTO.getNombre() != null && !usuarioDTO.getNombre().isEmpty()) {
                usuario.setNombre(usuarioDTO.getNombre());
            }
            if (usuarioDTO.getEmail() != null && !usuarioDTO.getEmail().isEmpty()) {
                usuario.setEmail(usuarioDTO.getEmail());
            }
            if (password != null && !password.isEmpty()) {
                usuario.setPassword(passwordEncoder.encode(password));
            }
            if (archivo != null && !archivo.isEmpty()) {
                Imagen imagen = imagenServicio.guardar(archivo);
                usuario.setImagen(imagen);
            }
            if (usuarioDTO.getRol() != null) {
                try {
                    usuario.setRol(Rol.valueOf(usuarioDTO.getRol().toUpperCase()));
                } catch (IllegalArgumentException e) {
                    throw new MiException("Rol inválido");
                }
            }

            usuarioRepositorio.save(usuario);
            return usuarioDTOMapper.toDTO(usuario);
        } else {
            throw new MiException("Usuario no encontrado");
        }
    }

    public boolean validarContrasena(String contrasena) throws MiException {
        if (contrasena == null || contrasena.isEmpty()) {
            throw new MiException("La contraseña no puede estar vacía");
        }
        if (contrasena.length() < 8) {
            throw new MiException("La contraseña debe tener al menos 8 caracteres");
        }
        if (!contrasena.matches(".*[A-Za-z].*")) {
            throw new MiException("La contraseña debe contener al menos una letra");
        }
        if (!contrasena.matches(".*\\d.*")) {
            throw new MiException("La contraseña debe contener al menos un número");
        }
        if (!contrasena.matches(".*[@$!%*#?&].*")) {
            throw new MiException("La contraseña debe contener al menos un carácter especial (@$!%*#?&)");
        }
        return true;
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

    public UsuarioDTO loginGoogle(String email, String nombre) {
        Usuario usuario = usuarioRepositorio.findByEmail(email);
        if (usuario == null) {
            Usuario nuevo = new Usuario();
            nuevo.setEmail(email);
            nuevo.setNombre(nombre);
            nuevo.setRol(Rol.ALUMNO); 
            nuevo.setPassword(passwordEncoder.encode("google_login_" + email));
            usuario = usuarioRepositorio.save(nuevo);
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