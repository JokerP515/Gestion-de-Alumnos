package com.jokerp515.gestionalumnos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record DatosRegistroAlumno(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotBlank(message = "El apellido es obligatorio")
        String apellido,

        @Email(message = "Email no válido")
        @NotBlank(message = "El email es obligatorio")
        String email,

        @Past(message = "La fecha de nacimiento debe ser pasada")
        LocalDate fechaNacimiento
) {
}
