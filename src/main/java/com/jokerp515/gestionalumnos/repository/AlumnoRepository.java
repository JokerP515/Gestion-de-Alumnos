package com.jokerp515.gestionalumnos.repository;

import com.jokerp515.gestionalumnos.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    Optional<String> findByEmail(String email);

    boolean existsByEmail(String email);
}
