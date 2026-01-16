package com.jokerp515.gestionalumnos.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroNota(
        @NotNull(message = "El ID del alumno es obligatorio")
        Long alumnoId,

        @NotNull(message = "El ID de la materia es obligatorio")
        Long materiaId,

        @NotNull(message = "El valor de la nota es obligatorio")
        @Min(value = 0, message = "La nota mínima es 0")
        @Max(value = 5, message = "La nota máxima es 5")
        Double valor
) {
}
