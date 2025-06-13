package com.example.tatu.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tatu.dto.ClaseDTO;
import com.example.tatu.entidades.Clase;
import com.example.tatu.excepciones.MiException;
import com.example.tatu.mapper.ClaseDTOMapper;
import com.example.tatu.repositorios.ClaseRepositorio;

@Service
public class ClaseServicio {

    @Autowired
    private ClaseRepositorio claseRepositorio;
    @Autowired
    private ClaseDTOMapper claseDTOMapper;

    // Método para crear una nueva clase
    /**
     * Crea una nueva clase.
     *
     * @param dto Objeto DTO que contiene los datos de la clase.
     * @return ClaseDTO con los datos de la clase creada.
     */
    public ClaseDTO crear(ClaseDTO dto) {
        Clase clase = claseDTOMapper.fromDTO(dto);
        Clase guardada = claseRepositorio.save(clase);
        return claseDTOMapper.toDTO(guardada);
    }

    // Método para actualizar una clase existente
    /**
     * Actualiza una clase existente.
     *
     * @param dto Objeto DTO que contiene los datos actualizados de la clase.
     * @return ClaseDTO con los datos de la clase actualizada.
     */
    public List<ClaseDTO> listar() {
        List<Clase> clases = claseRepositorio.findAll();
        return clases.stream()
                .map(claseDTOMapper::toDTO)
                .toList();
    }

    // Método para buscar una clase por ID
    /**
     * Busca una clase por su ID.
     *
     * @param id ID de la clase a buscar.
     * @return ClaseDTO con los datos de la clase encontrada, o un Optional vacío si
     *         no se encuentra.
     */
    public Optional<ClaseDTO> buscarPorId(Long id) {
        return claseRepositorio.findById(id)
                .map(claseDTOMapper::toDTO);
    }

    // Método para actualizar una clase por ID
    /**
     * Actualiza una clase existente por su ID.
     *
     * @param id  ID de la clase a actualizar.
     * @param dto Objeto DTO con los nuevos datos de la clase.
     * @return ClaseDTO con los datos actualizados de la clase.
     * @throws MiException si la clase no se encuentra.
     */
    public ClaseDTO actualizar(Long id, ClaseDTO dto) throws MiException {
        Clase clase = claseRepositorio.findById(id)
                .orElseThrow(() -> new MiException("Clase no encontrada con ID: " + id));
        clase.setNombre(dto.getNombre());
        clase.setDescripcion(dto.getDescripcion());
        Clase actualizada = claseRepositorio.save(clase);
        return claseDTOMapper.toDTO(actualizada);
    }

    // Método para eliminar una clase por ID
    /**
     * Elimina una clase por su ID.
     *
     * @param id ID de la clase a eliminar.
     * @throws MiException si la clase no se encuentra.
     */
    public void eliminar(Long id) throws MiException {
        Clase clase = claseRepositorio.findById(id)
                .orElseThrow(() -> new MiException("Clase no encontrada con ID: " + id));
        claseRepositorio.delete(clase);
    }
}