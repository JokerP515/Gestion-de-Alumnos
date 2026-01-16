package com.jokerp515.gestionalumnos.dto;

import com.jokerp515.gestionalumnos.model.Nota;

import java.time.LocalDate;

public record DatosRespuestaNota(
        Long id,
        Double valor,
        LocalDate fechaRegistro,
        DatosRespuestaAlumno alumno,
        DatosRespuestaMateria materia
) {
    public DatosRespuestaNota(Nota nota) {
        this(
                nota.getId(),
                nota.getValor(),
                nota.getFechaRegistro(),
                new DatosRespuestaAlumno(nota.getAlumno()),
                new DatosRespuestaMateria(nota.getMateria())
        );
    }
}
