package org.example.projetodeprogramao_n02_grupo5;

public class Turma {
    private int idTurma;
    private int idCurso;
    private String nomeTurma;
    private int capacidadeMaxima;

    public Turma(int capacidadeMaxima, int idCurso, int idTurma, String nomeTurma) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.idCurso = idCurso;
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
}
