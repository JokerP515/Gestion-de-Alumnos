package com.jokerp515.gestionalumnos.dto;

import com.jokerp515.gestionalumnos.model.Alumno;

import java.time.LocalDate;

public record DatosRespuestaAlumno(
        Long id,
        String nombre,
        String apellido,
        String email,
        LocalDate fechaNacimiento
) {
    public DatosRespuestaAlumno(Alumno alumno) {
        this(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getEmail(),
                alumno.getFechaNacimiento()
        );
    }
}
