package com.jokerp515.gestionalumnos.service;

import com.jokerp515.gestionalumnos.dto.DatosActualizarAlumno;
import com.jokerp515.gestionalumnos.dto.DatosRegistroAlumno;
import com.jokerp515.gestionalumnos.dto.DatosRespuestaAlumno;

import java.util.List;

public interface AlumnoService {

    DatosRespuestaAlumno crearAlumno(DatosRegistroAlumno datos);

    List<DatosRespuestaAlumno> listarAlumnos();

    DatosRespuestaAlumno obtenerPorId(Long id);

    DatosRespuestaAlumno actualizarAlumno(Long id, DatosActualizarAlumno datos);

    void eliminarAlumno(Long id);

}
