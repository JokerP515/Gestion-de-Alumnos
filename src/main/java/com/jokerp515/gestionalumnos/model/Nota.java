package com.jokerp515.gestionalumnos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(
        name = "notas",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"alumno_id", "materia_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nota {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull(message = "El valor de la nota es obligatorio")
        @Min(value = 0, message = "La nota mínima es 0")
        @Max(value = 5, message = "La nota máxima es 5")
        @Column(nullable = false)
        private Double valor;

        @Column(name = "fecha_registro", nullable = false)
        private LocalDate fechaRegistro;

        @ManyToOne
        @JoinColumn(name = "alumno_id", nullable = false)
        private Alumno alumno;

        @ManyToOne
        @JoinColumn(name = "materia_id", nullable = false)
        private Materia materia;
}
