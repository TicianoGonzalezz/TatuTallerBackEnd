package com.example.tatu.servicios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tatu.dto.ReservaClaseDTO;
import com.example.tatu.entidades.Clase;
import com.example.tatu.entidades.EstadoReserva;
import com.example.tatu.entidades.ReservaClase;
import com.example.tatu.entidades.Usuario;
import com.example.tatu.excepciones.MiException;
import com.example.tatu.mapper.ReservaClaseDTOMapper;
import com.example.tatu.repositorios.ClaseRepositorio;
import com.example.tatu.repositorios.ReservaClaseRepositorio;
import com.example.tatu.repositorios.UsuarioRepositorio;

@Service
public class ReservaClaseServicio {

    @Autowired
    private ReservaClaseRepositorio reservaClaseRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private ClaseRepositorio claseRepositorio;
    @Autowired
    private ReservaClaseDTOMapper reservaClaseDTOMapper;

    // Método para crear una reserva de clase
    /**
     * Crea una nueva reserva de clase.
     *
     * @param dto Objeto DTO que contiene los datos de la reserva.
     * @return ReservaClaseDTO con los datos de la reserva creada.
     * @throws MiException si el usuario o la clase no se encuentran.
     */
    public ReservaClaseDTO crear(ReservaClaseDTO dto) throws MiException {
        Usuario usuario = usuarioRepositorio.findById(dto.getUsuarioId())
                .orElseThrow(() -> new MiException("Usuario no encontrado"));
        Clase clase = claseRepositorio.findById(dto.getClaseId())
                .orElseThrow(() -> new MiException("Clase no encontrada"));
        ReservaClase reserva = new ReservaClase(
                usuario,
                clase,
                LocalDateTime.parse(dto.gethorarioReservaDesde()),
                EstadoReserva.valueOf(dto.getEstado()));
        ReservaClase guardada = reservaClaseRepositorio.save(reserva);
        return reservaClaseDTOMapper.toDTO(guardada);

    }

    // Método para listar todas las reservas de clase
    /**
     * Lista todas las reservas de clase.
     *
     * @return Lista de ReservaClaseDTO con todas las reservas.
     */
    public List<ReservaClaseDTO> listar() {
        List<ReservaClase> reservas = reservaClaseRepositorio.findAll();
        return reservas.stream().map(reservaClaseDTOMapper::toDTO).collect(Collectors.toList());
    }

    // Método para buscar una reserva de clase por ID
    /**
     * Busca una reserva de clase por su ID.
     *
     * @param id ID de la reserva a buscar.
     * @return Optional con ReservaClaseDTO si se encuentra, vacío si no.
     */
    public Optional<ReservaClaseDTO> buscarPorId(Long id) {
        return reservaClaseRepositorio.findById(id)
                .map(reservaClaseDTOMapper::toDTO);
    }

    // Método para actualizar una reserva de clase
    /**
     * Actualiza una reserva de clase existente.
     *
     * @param id  ID de la reserva a actualizar.
     * @param dto Objeto DTO con los nuevos datos de la reserva.
     * @return ReservaClaseDTO con los datos actualizados de la reserva.
     * @throws MiException si la reserva o la clase no se encuentran.
     */
    public ReservaClaseDTO actualizar(Long id, ReservaClaseDTO dto) throws MiException {
        ReservaClase reserva = reservaClaseRepositorio.findById(id)
                .orElseThrow(() -> new MiException("Reserva no encontrada"));
        Clase clase = claseRepositorio.findById(dto.getClaseId())
                .orElseThrow(() -> new MiException("Clase no encontrada"));

        reserva.setClase(clase);
        reserva.setHorarioReservaDesde(LocalDateTime.parse(dto.gethorarioReservaDesde()));
        reserva.setEstado(EstadoReserva.valueOf(dto.getEstado()));

        ReservaClase actualizada = reservaClaseRepositorio.save(reserva);
        return reservaClaseDTOMapper.toDTO(actualizada);
    }

    // Método para eliminar una reserva de clase por ID
    /**
     * Elimina una reserva de clase por su ID.
     *
     * @param id ID de la reserva a eliminar.
     * @throws MiException si la reserva no se encuentra.
     */
    public void eliminar(Long id) throws MiException {
        ReservaClase reserva = reservaClaseRepositorio.findById(id)
                .orElseThrow(() -> new MiException("Reserva no encontrada"));
        reservaClaseRepositorio.delete(reserva);
    }

}
