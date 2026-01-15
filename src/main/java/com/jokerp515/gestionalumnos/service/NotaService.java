package com.jokerp515.gestionalumnos.service;

import com.jokerp515.gestionalumnos.model.Nota;

import java.util.List;

public interface NotaService {

    Nota registrarNota(Long alumnoId, Long materiaId, Double valor);

    List<Nota> listarNotasPorAlumno(Long alumnoId);

    List<Nota> listarNotasPorAlumnoYMateria(Long alumnoId, Long materiaId);
}