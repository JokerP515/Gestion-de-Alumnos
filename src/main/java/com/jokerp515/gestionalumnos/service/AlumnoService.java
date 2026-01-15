package com.jokerp515.gestionalumnos.service;

import com.jokerp515.gestionalumnos.model.Alumno;

import java.util.List;

public interface AlumnoService {

    Alumno crearAlumno(Alumno alumno);

    List<Alumno> listarAlumnos();

    Alumno obtenerPorId(Long id);

    Alumno actualizarAlumno(Long id, Alumno alumno);

    void eliminarAlumno(Long id);

}
