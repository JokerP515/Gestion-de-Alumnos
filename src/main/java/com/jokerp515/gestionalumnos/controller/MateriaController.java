package com.jokerp515.gestionalumnos.controller;

import com.jokerp515.gestionalumnos.dto.DatosActualizarMateria;
import com.jokerp515.gestionalumnos.dto.DatosRegistroMateria;
import com.jokerp515.gestionalumnos.dto.DatosRespuestaMateria;
import com.jokerp515.gestionalumnos.service.MateriaService;
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
@RequestMapping("/api/materias")
@RequiredArgsConstructor
public class MateriaController {

    private final MateriaService materiaService;

    @PostMapping
    public ResponseEntity<DatosRespuestaMateria> crearMateria(@Valid @RequestBody DatosRegistroMateria datos) {
        DatosRespuestaMateria creada = materiaService.crearMateria(datos);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DatosRespuestaMateria>> listarMaterias() {
        return ResponseEntity.ok(materiaService.listarMaterias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaMateria> obtenerMateria(@PathVariable Long id) {
        return ResponseEntity.ok(materiaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaMateria> actualizarMateria(
            @PathVariable Long id,
            @Valid @RequestBody DatosActualizarMateria datos
    ) {
        return ResponseEntity.ok(materiaService.actualizarMateria(id, datos));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarMateria(@PathVariable Long id) {
        materiaService.eliminarMateria(id);
    }
}
