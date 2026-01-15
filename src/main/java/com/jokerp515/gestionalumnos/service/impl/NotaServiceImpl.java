package com.jokerp515.gestionalumnos.service.impl;

import com.jokerp515.gestionalumnos.model.Alumno;
import com.jokerp515.gestionalumnos.model.Materia;
import com.jokerp515.gestionalumnos.model.Nota;
import com.jokerp515.gestionalumnos.repository.AlumnoRepository;
import com.jokerp515.gestionalumnos.repository.MateriaRepository;
import com.jokerp515.gestionalumnos.repository.NotaRepository;
import com.jokerp515.gestionalumnos.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;
    private final AlumnoRepository alumnoRepository;
    private final MateriaRepository materiaRepository;

    @Override
    public Nota registrarNota(Long alumnoId, Long materiaId, Double valor) {

        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));

        Materia materia = materiaRepository.findById(materiaId)
                .orElseThrow(() -> new IllegalArgumentException("Materia no encontrada"));

        Nota nota = new Nota();
        nota.setAlumno(alumno);
        nota.setMateria(materia);
        nota.setValor(valor);

        return notaRepository.save(nota);
    }

    @Override
    public List<Nota> listarNotasPorAlumno(Long alumnoId) {
        return notaRepository.findByAlumnoId(alumnoId);
    }

    @Override
    public List<Nota> listarNotasPorAlumnoYMateria(Long alumnoId, Long materiaId) {
        return notaRepository.findByAlumnoIdAndMateriaId(alumnoId, materiaId);
    }
}
