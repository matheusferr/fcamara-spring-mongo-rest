package com.fcamara.mongorest.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AlunoForm {
    @NotNull
    @NotEmpty
    private String nomeAluno;
    @NotNull
    @NotEmpty
    private String cursoId;

    public String getNomeAluno() {
        return this.nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getCursoId() {
        return this.cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }
}
