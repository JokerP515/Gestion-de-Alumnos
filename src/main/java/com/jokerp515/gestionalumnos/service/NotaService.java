package com.jokerp515.gestionalumnos.service;

import com.jokerp515.gestionalumnos.dto.DatosRegistroNota;
import com.jokerp515.gestionalumnos.dto.DatosRespuestaNota;

import java.util.List;

public interface NotaService {

    DatosRespuestaNota registrarNota(DatosRegistroNota datos);

    List<DatosRespuestaNota> listarNotasPorAlumno(Long alumnoId);

    List<DatosRespuestaNota> listarNotasPorAlumnoYMateria(Long alumnoId, Long materiaId);
}