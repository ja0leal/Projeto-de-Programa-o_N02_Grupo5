package br.unit.AgendaCurso.models;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int idTurma;
    private String nome;
    private int idDiciplina;
    private int idProfessor;
    private Diciplina diciplina;
    private Professor professor;

    public Turma() {
    }

    public Turma(int idTurma, String nome, int idDiciplina, int idProfessor, Diciplina diciplina, Professor professor) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.idDiciplina = idDiciplina;
        this.idProfessor = idProfessor;
        this.diciplina = diciplina;
        this.professor = professor;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public String getNome() {
        return nome;
    }

    public int getIdDiciplina() {
        return idDiciplina;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public Diciplina getDiciplina() {
        return diciplina;
    }

    public Professor getProfessor() {
        return professor;
    }
}
