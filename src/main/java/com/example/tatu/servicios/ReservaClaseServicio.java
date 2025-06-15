package com.example.tatu.servicios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.example.tatu.dto.ClaseDisponibleDTO;
import com.example.tatu.dto.ReservaClaseDTO;
import com.example.tatu.dto.ReservaRequestDTO;
import com.example.tatu.entidades.Clase;
import com.example.tatu.entidades.EstadoReserva;
import com.example.tatu.entidades.ReservaClase;
import com.example.tatu.entidades.TipoReserva;
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
        @Autowired
        private EmailServicio emailServicio;

        public void reservar(ReservaRequestDTO dto) throws MiException {
                Usuario usuario = usuarioRepositorio.findById(dto.getUsuarioId())
                                .orElseThrow(() -> new MiException("Usuario no encontrado"));
                Clase clase = claseRepositorio.findById(dto.getClaseId())
                                .orElseThrow(() -> new MiException("Clase no encontrada"));

                if ("PUNTUAL".equalsIgnoreCase(dto.getTipoReserva())) {
                        LocalDate fecha = LocalDate.parse(dto.getFecha());
                        if (reservaClaseRepositorio.countByClaseAndFechaReserva(clase, fecha) >= clase.getCapacidad())
                                throw new MiException("Sin cupo disponible");
                        ReservaClase reserva = new ReservaClase();
                        reserva.setUsuario(usuario);
                        reserva.setClase(clase);
                        reserva.setEstado(EstadoReserva.PENDIENTE);
                        reserva.setFechaReserva(fecha);
                        reservaClaseRepositorio.save(reserva);
                        emailServicio.enviarMailConfirmacionProfesor(reserva);
                } else if ("MENSUAL".equalsIgnoreCase(dto.getTipoReserva())) {
                        LocalDate fecha = LocalDate.parse(dto.getFecha());
                        YearMonth ym = YearMonth.of(fecha.getYear(), fecha.getMonth());
                        LocalDate f = ym.atDay(1);
                        List<ReservaClase> reservas = new ArrayList<>();
                        while (f.getMonth() == ym.getMonth()) {
                                if (f.getDayOfWeek().getValue() == clase.getDiaSemana()) {
                                        if (reservaClaseRepositorio.countByClaseAndFechaReserva(clase, fecha) < clase
                                                        .getCapacidad()) {
                                                ReservaClase reserva = new ReservaClase();
                                                reserva.setUsuario(usuario);
                                                reserva.setClase(clase);
                                                reserva.setFechaReserva(f);
                                                reserva.setEstado(EstadoReserva.PENDIENTE);
                                                reservaClaseRepositorio.save(reserva);
                                                reservas.add(reserva);
                                        }
                                }
                                f = f.plusDays(1);
                        }
                        emailServicio.enviarMailConfirmacionPorLote(reservas);

                }

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

        // Método para listar clases disponibles
        /**
         * Lista las clases con cupo disponible en la fecha seleccionada
         * 
         * @param fecha
         * @return Lista de ClaseDisponibleDTO
         */
        public List<ClaseDisponibleDTO> clasesDisponiblesPorFecha(LocalDate fecha) {
                int diaSemana = fecha.getDayOfWeek().getValue();
                List<Clase> clases = claseRepositorio.findByDiaSemana(diaSemana);
                List<ClaseDisponibleDTO> disponibles = new ArrayList<>();
                for (Clase clase : clases) {
                        int reservas = reservaClaseRepositorio.countByClaseAndFechaReserva(clase, fecha);
                        int cupoDisponible = clase.getCapacidad() - reservas;
                        if (cupoDisponible > 0) {
                                ClaseDisponibleDTO dto = new ClaseDisponibleDTO();
                                dto.setIdClase(clase.getId());
                                dto.setNombre(clase.getNombre());
                                dto.setProfesor(clase.getProfesor().getNombre());
                                dto.setHoraDesde(clase.getHorarioDesde());
                                dto.setHoraHasta(clase.getHorarioHasta());
                                dto.setCupoDisponible(cupoDisponible);
                                disponibles.add(dto);
                        }

                }
                return disponibles;
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
                // Falta definir los atributos a poder modificar
                // reserva.setEstado(EstadoReserva.valueOf(dto.getEstado()));

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

        public void confirmarReserva(Long reservaId) {
                ReservaClase reserva = reservaClaseRepositorio.findById(reservaId).orElseThrow();
                reserva.setEstado(EstadoReserva.CONFIRMADA);
                reservaClaseRepositorio.save(reserva);
                emailServicio.enviarMailRespuestaUsuario(reserva, true);
        }

        public void rechazarReserva(Long reservaId) {
                ReservaClase reserva = reservaClaseRepositorio.findById(reservaId).orElseThrow();
                reserva.setEstado(EstadoReserva.CANCELADA);
                reservaClaseRepositorio.save(reserva);
                emailServicio.enviarMailRespuestaUsuario(reserva, false);
        }

        // 4. Ver reservas del usuario
        public List<ReservaClaseDTO> reservasPorUsuario(Long usuarioId) {
                List<ReservaClase> reservas = reservaClaseRepositorio.findByUsuarioId(usuarioId);
                List<ReservaClaseDTO> dtos = new ArrayList<>();
                for (ReservaClase r : reservas) {
                        ReservaClaseDTO dto = new ReservaClaseDTO();
                        dto.setId(r.getId());
                        dto.setProfesor(r.getClase().getProfesor().getNombre());
                        dto.setNombreClase(r.getClase().getNombre());
                        dto.setHoraDesde(r.getClase().getHorarioDesde().toString());
                        dto.setHoraHasta(r.getClase().getHorarioHasta().toString());
                        dto.setEstado(r.getEstado().name());
                        dto.setNombreClase(r.getClase().getNombre());
                        dto.setTipoReserva(r.getTipoReserva().toString());
                        dtos.add(dto);

                }
                return dtos;
        }

}
