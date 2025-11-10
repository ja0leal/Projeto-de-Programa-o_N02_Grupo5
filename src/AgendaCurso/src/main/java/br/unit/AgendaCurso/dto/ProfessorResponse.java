package br.unit.AgendaCurso.dto;

public class ProfessorResponse {
    private String nome;
    private int idProfessor;

    public ProfessorResponse() {
    }

    public ProfessorResponse(String nome, int idProfessor) {
        this.nome = nome;
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
}
