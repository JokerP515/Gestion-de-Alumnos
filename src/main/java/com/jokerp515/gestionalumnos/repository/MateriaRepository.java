package com.jokerp515.gestionalumnos.repository;

import com.jokerp515.gestionalumnos.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

    boolean existsByCodigo(String codigo);
}
