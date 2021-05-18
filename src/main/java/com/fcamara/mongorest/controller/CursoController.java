package com.fcamara.mongorest.controller;

import com.fcamara.mongorest.form.CursoCreateForm;
import com.fcamara.mongorest.model.Curso;
import com.fcamara.mongorest.service.CursoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CursoController {

    @Autowired
    private CursoServiceImp cursoServiceImp;

    @GetMapping("/cursos")
    public List<Curso> index() {
        return cursoServiceImp.findAll();
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<Curso> search(@PathVariable String id) {
        Optional<Curso> curso = cursoServiceImp.findById(id);

        return curso.map(ResponseEntity::ok).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado")
        );
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> create(@RequestBody @Valid CursoCreateForm form, UriComponentsBuilder uriBuilder) {
        Curso novoCurso = cursoServiceImp.create(form);
        URI uri = uriBuilder.path("/curso/{id}").buildAndExpand(novoCurso.getId()).toUri();

        return ResponseEntity.created(uri).body(novoCurso);
    }

    @PutMapping("/curso/{id}")
    public ResponseEntity<Curso> update(@PathVariable String id, @RequestBody @Valid CursoCreateForm form) {
        Curso cursoAtualizado = cursoServiceImp.update(id, form);

        return ResponseEntity.ok(cursoAtualizado);
    }

    @DeleteMapping("/curso/{id}")
    public ResponseEntity<?> destroy(@PathVariable String id) {
        cursoServiceImp.delete(id);

        return ResponseEntity.ok().body("Curso removido com sucesso");
    }
}
