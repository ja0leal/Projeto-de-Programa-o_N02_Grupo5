package br.unit.AgendaCurso.models;

public class Professor {
    private int idProfessor;
    private String nome;

    public Professor() {
    }

    public Professor(String nome) {
        this.nome = nome;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
