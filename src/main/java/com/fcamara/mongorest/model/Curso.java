package com.fcamara.mongorest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.naming.directory.InvalidAttributesException;
import java.util.Collections;
import java.util.List;

@Document
public class Curso {
    @Id
    private String id;
    private String nome;
    private String professor;
    private List<String> alunos;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public List<String> getAlunos() {
        return Collections.unmodifiableList(this.alunos);
    }

    public void setAlunos(List<String> alunos) {
        this.alunos = alunos;
    }

    public void addAluno(String aluno) {
        if (this.alunos.contains(aluno))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno já cadastrado");

        this.alunos.add(aluno);
    }

    public void removeAluno(String aluno) {
        if (!this.alunos.contains(aluno))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno não encontrado");

        this.alunos.remove(aluno);
    }
}
