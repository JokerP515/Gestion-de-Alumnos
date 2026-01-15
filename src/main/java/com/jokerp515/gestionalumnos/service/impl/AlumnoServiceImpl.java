package com.jokerp515.gestionalumnos.service.impl;

import com.jokerp515.gestionalumnos.model.Alumno;
import com.jokerp515.gestionalumnos.repository.AlumnoRepository;
import com.jokerp515.gestionalumnos.service.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Override
    public Alumno crearAlumno(Alumno alumno) {
        if (alumnoRepository.existsByEmail(alumno.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }
        return alumnoRepository.save(alumno);
    }

    @Override
    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno obtenerPorId(Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
    }

    @Override
    public Alumno actualizarAlumno(Long id, Alumno alumno) {
        Alumno existente = obtenerPorId(id);

        existente.setNombre(alumno.getNombre());
        existente.setApellido(alumno.getApellido());
        existente.setEmail(alumno.getEmail());
        existente.setFechaNacimiento(alumno.getFechaNacimiento());

        return alumnoRepository.save(existente);
    }

    @Override
    public void eliminarAlumno(Long id) {
        Alumno alumno = obtenerPorId(id);
        alumnoRepository.delete(alumno);
    }

}
