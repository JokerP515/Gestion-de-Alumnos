package com.jokerp515.gestionalumnos.service.impl;

import com.jokerp515.gestionalumnos.dto.DatosRegistroNota;
import com.jokerp515.gestionalumnos.dto.DatosRespuestaNota;
import com.jokerp515.gestionalumnos.exception.ResourceNotFoundException;
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
    public DatosRespuestaNota registrarNota(DatosRegistroNota datos) {

        Alumno alumno = alumnoRepository.findById(datos.alumnoId())
                .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado"));

        Materia materia = materiaRepository.findById(datos.materiaId())
                .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada"));

        Nota nota = new Nota();
        nota.setAlumno(alumno);
        nota.setMateria(materia);
        nota.setValor(datos.valor());

        Nota guardada = notaRepository.save(nota);
        return new DatosRespuestaNota(guardada);
    }

    @Override
    public List<DatosRespuestaNota> listarNotasPorAlumno(Long alumnoId) {
        return notaRepository.findByAlumnoId(alumnoId)
                .stream()
                .map(DatosRespuestaNota::new)
                .toList();
    }

    @Override
    public List<DatosRespuestaNota> listarNotasPorAlumnoYMateria(Long alumnoId, Long materiaId) {
        return notaRepository.findByAlumnoIdAndMateriaId(alumnoId, materiaId)
                .stream()
                .map(DatosRespuestaNota::new)
                .toList();
    }
}
