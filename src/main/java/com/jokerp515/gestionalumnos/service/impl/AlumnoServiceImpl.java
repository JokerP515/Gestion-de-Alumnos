package com.jokerp515.gestionalumnos.service.impl;

import com.jokerp515.gestionalumnos.dto.DatosActualizarAlumno;
import com.jokerp515.gestionalumnos.dto.DatosRegistroAlumno;
import com.jokerp515.gestionalumnos.dto.DatosRespuestaAlumno;
import com.jokerp515.gestionalumnos.exception.ResourceNotFoundException;
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
    public DatosRespuestaAlumno crearAlumno(DatosRegistroAlumno datos) {
        if (alumnoRepository.existsByEmail(datos.email())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }
        Alumno alumno = new Alumno(datos);
        Alumno guardado = alumnoRepository.save(alumno);
        return new DatosRespuestaAlumno(guardado);
    }

    @Override
    public List<DatosRespuestaAlumno> listarAlumnos() {
        return alumnoRepository.findAll()
                .stream()
                .map(DatosRespuestaAlumno::new)
                .toList();
    }

    @Override
    public DatosRespuestaAlumno obtenerPorId(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado"));
        return new DatosRespuestaAlumno(alumno);
    }

    private Alumno buscarAlumnoPorId(Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado"));
    }

    @Override
    public DatosRespuestaAlumno actualizarAlumno(Long id, DatosActualizarAlumno datos) {
        Alumno existente = buscarAlumnoPorId(id);
        existente.actualizarAlumno(datos);
        Alumno actualizado = alumnoRepository.save(existente);
        return new DatosRespuestaAlumno(actualizado);
    }

    @Override
    public void eliminarAlumno(Long id) {
        Alumno alumno = buscarAlumnoPorId(id);
        alumnoRepository.delete(alumno);
    }

}
