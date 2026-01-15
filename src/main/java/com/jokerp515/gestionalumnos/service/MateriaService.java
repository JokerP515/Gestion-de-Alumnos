package com.jokerp515.gestionalumnos.service;

import com.jokerp515.gestionalumnos.model.Materia;

import java.util.List;

public interface MateriaService {

    Materia crearMateria(Materia materia);

    List<Materia> listarMaterias();

    Materia obtenerPorId(Long id);

    Materia actualizarMateria(Long id, Materia materia);

    void eliminarMateria(Long id);
}