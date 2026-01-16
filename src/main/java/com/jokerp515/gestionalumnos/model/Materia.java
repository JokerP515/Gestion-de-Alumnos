package com.jokerp515.gestionalumnos.model;

import com.jokerp515.gestionalumnos.dto.DatosActualizarMateria;
import com.jokerp515.gestionalumnos.dto.DatosRegistroMateria;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "materias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El código es obligatorio")
    @Column(nullable = false, unique = true)
    private String codigo;

    @NotNull(message = "Los créditos son obligatorios")
    @Positive(message = "Los créditos deben ser mayores a 0")
    @Column(nullable = false)
    private Integer creditos;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nota> notas;

    public Materia(DatosRegistroMateria datos) {
        this.nombre = datos.nombre();
        this.codigo = datos.codigo();
        this.creditos = datos.creditos();
    }

    public void actualizarMateria(DatosActualizarMateria datos) {
        this.nombre = (datos.nombre() == null) ? this.nombre : datos.nombre();
        this.codigo = (datos.codigo() == null) ? this.codigo : datos.codigo();
        this.creditos = (datos.creditos() == null) ? this.creditos : datos.creditos();
    }

}
