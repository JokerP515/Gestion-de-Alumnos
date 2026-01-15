package com.jokerp515.gestionalumnos.repository;

import com.jokerp515.gestionalumnos.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    List<Nota> findByAlumnoId(Long alumnoId);

    List<Nota> findByAlumnoIdAndMateriaId(Long alumnoId, Long materiaId);
}
