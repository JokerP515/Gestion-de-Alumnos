package com.jokerp515.gestionalumnos.dto;

import jakarta.validation.constraints.Positive;

public record DatosActualizarMateria(
        String nombre,
        String codigo,

        @Positive(message = "Los créditos deben ser mayores a 0")
        Integer creditos
) {
}
