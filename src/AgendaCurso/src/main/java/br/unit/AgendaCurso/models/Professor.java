package br.unit.AgendaCurso.models;

import java.util.List;

public class Professor {
    private int idProfessor;
    private String nome;
    private List<Turma> turmas;

    public Professor() {
    }

    public Professor(int idProfessor, String nome, List<Turma> turmas) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.turmas = turmas;
    }

    public int getIdProfessor() {
        return idProfessor;
    }
    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
