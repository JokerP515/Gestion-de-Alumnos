package com.jokerp515.gestionalumnos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DatosRegistroMateria(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotBlank(message = "El código es obligatorio")
        String codigo,

        @NotNull(message = "Los créditos son obligatorios")
        @Positive(message = "Los créditos deben ser mayores a 0")
        Integer creditos
) {
}
