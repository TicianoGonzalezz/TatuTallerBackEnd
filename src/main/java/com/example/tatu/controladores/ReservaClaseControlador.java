package com.example.tatu.controladores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tatu.dto.ClaseDisponibleDTO;
import com.example.tatu.dto.ReservaClaseDTO;
import com.example.tatu.dto.ReservaRequestDTO;
import com.example.tatu.excepciones.MiException;
import com.example.tatu.servicios.ReservaClaseServicio;

@RestController
@RequestMapping("/reservas")
public class ReservaClaseControlador {

    @Autowired
    private ReservaClaseServicio reservaClaseServicio;

    // Método para crear una nueva reserva de clase
    /**
     * Crea una nueva reserva de clase.
     *
     * @param reservaClaseDTO Objeto DTO que contiene los datos de la reserva.
     * @return ReservaClaseDTO con los datos de la reserva creada.
     * @throws MiException si ocurre un error durante la creación.
     */
    @PostMapping
    public ResponseEntity<?> crearReserva(@RequestBody ReservaRequestDTO req) {

        try {
            reservaClaseServicio.reservar(req);
            return ResponseEntity.ok().build();
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    // Método para listar todas las reservas de clase
    /**
     * Lista todas las reservas de clase.
     *
     * @return Lista de ReservaClaseDTO con todas las reservas.
     */
    @GetMapping
    public ResponseEntity<List<ReservaClaseDTO>> listar() {
        return ResponseEntity.ok(reservaClaseServicio.listar());
    }

    @GetMapping("/disponibles")
    public List<ClaseDisponibleDTO> clasesDisponibles(@RequestParam String fecha) {
        return reservaClaseServicio.clasesDisponiblesPorFecha(LocalDate.parse(fecha));
    }

    // 2. Reservar clase puntual o mensual
    @PostMapping("/reservas")
    public ResponseEntity<?> reservar(@RequestBody ReservaRequestDTO req) {
        try {
            reservaClaseServicio.reservar(req);
            return ResponseEntity.ok().build();
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }

    }

    // 3. Confirmar/rechazar reserva (profesor)
    @GetMapping("/confirmar/{id}")
    public ResponseEntity<String> confirmar(@PathVariable Long id) {
        reservaClaseServicio.confirmarReserva(id);
        return ResponseEntity.ok("Reserva confirmada");
    }

    @GetMapping("/rechazar/{id}")
    public ResponseEntity<String> rechazar(@PathVariable Long id) {
        reservaClaseServicio.rechazarReserva(id);
        return ResponseEntity.ok("Reserva rechazada");
    }

    // 4. Ver reservas del usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<ReservaClaseDTO> reservasPorUsuario(@PathVariable Long usuarioId) {
        return reservaClaseServicio.reservasPorUsuario(usuarioId);
    }

    // Método para buscar una reserva por ID
    /**
     * Busca una reserva de clase por su ID.
     *
     * @param id ID de la reserva a buscar.
     * @return ReservaClaseDTO con los datos de la reserva encontrada, o 404 si no
     *         se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<ReservaClaseDTO> reserva = reservaClaseServicio.buscarPorId(id);
        if (reserva.isPresent()) {
            return ResponseEntity.ok(reserva.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reserva no encontrada");
        }
    }

    // Método para actualizar una reserva de clase
    /**
     * Actualiza una reserva de clase existente.
     *
     * @param id              ID de la reserva a actualizar.
     * @param reservaClaseDTO Objeto DTO con los nuevos datos de la reserva.
     * @return ReservaClaseDTO con los datos actualizados de la reserva.
     * @throws MiException si ocurre un error durante la actualización.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody ReservaClaseDTO reservaClaseDTO) {
        try {
            ReservaClaseDTO actualizada = reservaClaseServicio.actualizar(id, reservaClaseDTO);
            return ResponseEntity.ok(actualizada);
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Método para eliminar una reserva de clase
    /**
     * Elimina una reserva de clase por su ID.
     *
     * @param id ID de la reserva a eliminar.
     * @return Respuesta vacía con código 204 si se elimina correctamente, o 404 si
     *         no se encuentra.
     * @throws MiException si ocurre un error durante la eliminación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            reservaClaseServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (MiException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
