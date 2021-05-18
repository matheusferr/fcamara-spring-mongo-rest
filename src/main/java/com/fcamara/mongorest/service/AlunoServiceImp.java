package com.fcamara.mongorest.service;

import com.fcamara.mongorest.form.AlunoForm;
import com.fcamara.mongorest.model.Curso;
import com.fcamara.mongorest.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class AlunoServiceImp implements AlunoService{
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso create(AlunoForm form){
        Optional<Curso> existe = cursoRepository.findById(form.getCursoId());

        if (existe.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Curso não encontrado");

        existe.get().addAluno(form.getNomeAluno());

        return cursoRepository.save(existe.get());
    }

    @Override
    public void delete(String cursoId, AlunoForm form){
        Optional<Curso> existe = cursoRepository.findById(cursoId);

        if (existe.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Curso não encontrado");

        existe.get().removeAluno(form.getNomeAluno());

        cursoRepository.save(existe.get());
    }
}
