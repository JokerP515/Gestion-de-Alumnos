package com.jokerp515.gestionalumnos.controller;

import com.jokerp515.gestionalumnos.dto.DatosRegistroNota;
import com.jokerp515.gestionalumnos.dto.DatosRespuestaNota;
import com.jokerp515.gestionalumnos.service.NotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;

    @PostMapping
    public ResponseEntity<DatosRespuestaNota> registrarNota(
            @Valid @RequestBody DatosRegistroNota datos
    ) {
        DatosRespuestaNota nota = notaService.registrarNota(datos);
        return new ResponseEntity<>(nota, HttpStatus.CREATED);
    }

    @GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<List<DatosRespuestaNota>> listarNotasPorAlumno(
            @PathVariable Long alumnoId
    ) {
        return ResponseEntity.ok(notaService.listarNotasPorAlumno(alumnoId));
    }

    @GetMapping("/alumno/{alumnoId}/materia/{materiaId}")
    public ResponseEntity<List<DatosRespuestaNota>> listarNotasPorAlumnoYMateria(
            @PathVariable Long alumnoId,
            @PathVariable Long materiaId
    ) {
        return ResponseEntity.ok(
                notaService.listarNotasPorAlumnoYMateria(alumnoId, materiaId)
        );
    }
}
