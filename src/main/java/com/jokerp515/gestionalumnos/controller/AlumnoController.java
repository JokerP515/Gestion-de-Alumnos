package com.jokerp515.gestionalumnos.controller;

import com.jokerp515.gestionalumnos.dto.DatosActualizarAlumno;
import com.jokerp515.gestionalumnos.dto.DatosRegistroAlumno;
import com.jokerp515.gestionalumnos.dto.DatosRespuestaAlumno;
import com.jokerp515.gestionalumnos.service.AlumnoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @PostMapping
    public ResponseEntity<DatosRespuestaAlumno> crearAlumno(@Valid @RequestBody DatosRegistroAlumno datos) {
        DatosRespuestaAlumno creado = alumnoService.crearAlumno(datos);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DatosRespuestaAlumno>> listarAlumnos() {
        return ResponseEntity.ok(alumnoService.listarAlumnos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaAlumno> obtenerAlumno(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaAlumno> actualizarAlumno(
            @PathVariable Long id,
            @Valid @RequestBody DatosActualizarAlumno datos
    ) {
        return ResponseEntity.ok(alumnoService.actualizarAlumno(id, datos));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarAlumno(@PathVariable Long id) {
        alumnoService.eliminarAlumno(id);
    }
}
