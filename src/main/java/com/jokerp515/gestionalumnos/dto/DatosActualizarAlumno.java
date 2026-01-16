package com.jokerp515.gestionalumnos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record DatosActualizarAlumno(
        String nombre,
        String apellido,

        @Email(message = "Email no válido")
        String email,

        @Past(message = "La fecha de nacimiento debe ser pasada")
        LocalDate fechaNacimiento
) {
}
