package com.jokerp515.gestionalumnos.dto;

import com.jokerp515.gestionalumnos.model.Materia;

public record DatosRespuestaMateria(
        Long id,
        String nombre,
        String codigo,
        Integer creditos
) {
    public DatosRespuestaMateria(Materia materia) {
        this(
                materia.getId(),
                materia.getNombre(),
                materia.getCodigo(),
                materia.getCreditos()
        );
    }
}
