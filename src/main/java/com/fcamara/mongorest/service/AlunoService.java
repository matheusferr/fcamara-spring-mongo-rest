package com.fcamara.mongorest.service;

import com.fcamara.mongorest.form.AlunoForm;
import com.fcamara.mongorest.model.Curso;
import org.springframework.stereotype.Service;

@Service
public interface AlunoService {
    Curso create(AlunoForm form);
    void delete(String cursoId, AlunoForm form);
}