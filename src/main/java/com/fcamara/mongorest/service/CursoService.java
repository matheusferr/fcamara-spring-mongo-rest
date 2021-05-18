package com.fcamara.mongorest.service;

import com.fcamara.mongorest.form.CursoCreateForm;
import com.fcamara.mongorest.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> findAll();
    Optional<Curso> findById(String id);
    Curso create(CursoCreateForm form);
    Curso update(String id, CursoCreateForm form);
    void delete(String id);
}
