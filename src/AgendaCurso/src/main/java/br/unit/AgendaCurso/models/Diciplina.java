package br.unit.AgendaCurso.models;

public class Diciplina {
    private int idDiciplina;
    private String nome;
    private int idProfessor;
    private Professor professor;

    public Diciplina() {
    }

    public Diciplina(int idDiciplina, String nome, int idProfessor, Professor professor) {
        this.idDiciplina = idDiciplina;
        this.nome = nome;
        this.idProfessor = idProfessor;
        this.professor = professor;
    }

    public int getIdDiciplina() {
        return idDiciplina;
    }

    public String getNome() {
        return nome;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setIdDiciplina(int idDiciplina) {
        this.idDiciplina = idDiciplina;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
