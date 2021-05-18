package com.fcamara.mongorest.service;

import com.fcamara.mongorest.form.CursoCreateForm;
import com.fcamara.mongorest.model.Curso;
import com.fcamara.mongorest.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImp implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> findById(String id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso create(CursoCreateForm form) {
        Optional<Curso> existe = cursoRepository.findByNome(form.getNome());

        if (existe.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Curso já cadastrado");

        return cursoRepository.save(form.toCurso());
    }

    @Override
    public Curso update(String id, CursoCreateForm form) {
        Optional<Curso> existe = cursoRepository.findById(id);

        if (existe.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado");


        Optional<Curso> existeNome = cursoRepository.findByNome(form.getNome());

        if (existeNome.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome já cadastrado");

        if(form.getNome() != null)
            existe.get().setNome(form.getNome());

        if (form.getProfessor() != null)
            existe.get().setProfessor(form.getProfessor());

        cursoRepository.save(existe.get());

        return existe.get();
    }

    @Override
    public void delete(String id) {
        Optional<Curso> existe = cursoRepository.findById(id);

        if (existe.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado");

        cursoRepository.delete(existe.get());

    }
}
