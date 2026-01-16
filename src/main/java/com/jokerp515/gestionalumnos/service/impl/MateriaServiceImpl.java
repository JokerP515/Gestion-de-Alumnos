package com.jokerp515.gestionalumnos.service.impl;

import com.jokerp515.gestionalumnos.dto.DatosActualizarMateria;
import com.jokerp515.gestionalumnos.dto.DatosRegistroMateria;
import com.jokerp515.gestionalumnos.dto.DatosRespuestaMateria;
import com.jokerp515.gestionalumnos.exception.ResourceNotFoundException;
import com.jokerp515.gestionalumnos.model.Materia;
import com.jokerp515.gestionalumnos.repository.MateriaRepository;
import com.jokerp515.gestionalumnos.service.MateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;

    @Override
    public DatosRespuestaMateria crearMateria(DatosRegistroMateria datos) {
        if (materiaRepository.existsByCodigo(datos.codigo())) {
            throw new IllegalArgumentException("El código de la materia ya existe");
        }
        Materia materia = new Materia(datos);
        Materia guardada = materiaRepository.save(materia);
        return new DatosRespuestaMateria(guardada);
    }

    @Override
    public List<DatosRespuestaMateria> listarMaterias() {
        return materiaRepository.findAll()
                .stream()
                .map(DatosRespuestaMateria::new)
                .toList();
    }

    @Override
    public DatosRespuestaMateria obtenerPorId(Long id) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada"));
        return new DatosRespuestaMateria(materia);
    }

    private Materia buscarMateriaPorId(Long id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada"));
    }

    @Override
    public DatosRespuestaMateria actualizarMateria(Long id, DatosActualizarMateria datos) {
        Materia existente = buscarMateriaPorId(id);
        existente.actualizarMateria(datos);
        Materia actualizada = materiaRepository.save(existente);
        return new DatosRespuestaMateria(actualizada);
    }

    @Override
    public void eliminarMateria(Long id) {
        Materia materia = buscarMateriaPorId(id);
        materiaRepository.delete(materia);
    }
}
