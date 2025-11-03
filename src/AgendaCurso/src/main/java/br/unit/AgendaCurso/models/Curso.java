package br.unit.AgendaCurso.models;

import java.util.List;

public class Curso {
    private int IdCurso;
    private String Nome;
    private List<Aluno> alunos;

    public int getIdCurso() {
        return IdCurso;
    }

    public String getNome() {
        return Nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setIdCurso(int idCurso) {
        IdCurso = idCurso;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
