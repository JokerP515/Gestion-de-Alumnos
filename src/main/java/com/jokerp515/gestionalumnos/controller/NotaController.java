package com.jokerp515.gestionalumnos.controller;

import com.jokerp515.gestionalumnos.model.Nota;
import com.jokerp515.gestionalumnos.service.NotaService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;

    @PostMapping
    public ResponseEntity<Nota> registrarNota(
            @RequestParam @NotNull Long alumnoId,
            @RequestParam @NotNull Long materiaId,
            @RequestParam @NotNull Double valor
    ) {
        Nota nota = notaService.registrarNota(alumnoId, materiaId, valor);
        return new ResponseEntity<>(nota, HttpStatus.CREATED);
    }

    @GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<List<Nota>> listarNotasPorAlumno(
            @PathVariable Long alumnoId
    ) {
        return ResponseEntity.ok(notaService.listarNotasPorAlumno(alumnoId));
    }

    @GetMapping("/alumno/{alumnoId}/materia/{materiaId}")
    public ResponseEntity<List<Nota>> listarNotasPorAlumnoYMateria(
            @PathVariable Long alumnoId,
            @PathVariable Long materiaId
    ) {
        return ResponseEntity.ok(
                notaService.listarNotasPorAlumnoYMateria(alumnoId, materiaId)
        );
    }
}
