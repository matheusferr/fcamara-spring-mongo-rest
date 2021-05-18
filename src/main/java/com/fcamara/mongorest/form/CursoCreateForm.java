package com.fcamara.mongorest.form;

import com.fcamara.mongorest.model.Curso;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class CursoCreateForm {
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    private String professor;

    public String getNome() {
        return nome;
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

    public Curso toCurso() {
        Curso novoCurso = new Curso();
        novoCurso.setNome(this.nome);
        novoCurso.setProfessor(this.professor);
        novoCurso.setAlunos(new ArrayList<>());

        return novoCurso;
    }

}
