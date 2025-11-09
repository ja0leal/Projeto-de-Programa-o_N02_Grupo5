package br.unit.AgendaCurso.models;

import java.util.List;

public class Disciplina {
    private int idDisciplina;
    private String nome;
    private int cargaHoraria;
    private List<Turma> turmas;
    private List<Curso> curso;

    public Disciplina() {
    }

    public Disciplina(int idDisciplina, String nome, int cargaHoraria, List<Turma> turmas, List<Curso> curso) {
        this.idDisciplina = idDisciplina;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.turmas = turmas;
        this.curso = curso;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }
}
