package com.jokerp515.gestionalumnos.service;

import com.jokerp515.gestionalumnos.dto.DatosActualizarMateria;
import com.jokerp515.gestionalumnos.dto.DatosRegistroMateria;
import com.jokerp515.gestionalumnos.dto.DatosRespuestaMateria;

import java.util.List;

public interface MateriaService {

    DatosRespuestaMateria crearMateria(DatosRegistroMateria datos);

    List<DatosRespuestaMateria> listarMaterias();

    DatosRespuestaMateria obtenerPorId(Long id);

    DatosRespuestaMateria actualizarMateria(Long id, DatosActualizarMateria datos);

    void eliminarMateria(Long id);
}