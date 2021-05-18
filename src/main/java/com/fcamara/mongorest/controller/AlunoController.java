package com.fcamara.mongorest.controller;

import com.fcamara.mongorest.form.AlunoForm;
import com.fcamara.mongorest.model.Curso;
import com.fcamara.mongorest.service.AlunoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping
public class AlunoController {
    @Autowired
    private AlunoServiceImp alunoServiceImp;

    @PostMapping("/alunos")
    public ResponseEntity<Curso> create(@RequestBody @Valid AlunoForm form, UriComponentsBuilder uriBuilder) {
        Curso novoCurso = alunoServiceImp.create(form);
        URI uri = uriBuilder.path("/curso/{id}").buildAndExpand(novoCurso.getId()).toUri();

        return ResponseEntity.created(uri).body(novoCurso);
    }

    @DeleteMapping("/aluno/{idCurso}")
    public ResponseEntity<?> update(@PathVariable String idCurso, @RequestBody @Valid AlunoForm form) {
        alunoServiceImp.delete(idCurso, form);

        return ResponseEntity.ok().body("Aluno removido com sucesso");
    }

}
