package com.jokerp515.gestionalumnos.service.impl;

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
    public Materia crearMateria(Materia materia) {
        if (materiaRepository.existsByCodigo(materia.getCodigo())) {
            throw new IllegalArgumentException("El código de la materia ya existe");
        }
        return materiaRepository.save(materia);
    }

    @Override
    public List<Materia> listarMaterias() {
        return materiaRepository.findAll();
    }

    @Override
    public Materia obtenerPorId(Long id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada"));
    }

    @Override
    public Materia actualizarMateria(Long id, Materia materia) {
        Materia existente = obtenerPorId(id);

        existente.setNombre(materia.getNombre());
        existente.setCodigo(materia.getCodigo());
        existente.setCreditos(materia.getCreditos());

        return materiaRepository.save(existente);
    }

    @Override
    public void eliminarMateria(Long id) {
        Materia materia = obtenerPorId(id);
        materiaRepository.delete(materia);
    }
}
