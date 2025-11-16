package br.unit.AgendaCurso.dto;

public class TurmaResponse {
    private int  id;
    private String nome;
    private int idDiciplina;
    private int idProfessor;

    public TurmaResponse() {
    }

    public TurmaResponse(int id, String nome, int idDiciplina, int idProfessor) {
        this.id = id;
        this.nome = nome;
        this.idDiciplina = idDiciplina;
        this.idProfessor = idProfessor;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public int getIdDiciplina() {
        return idDiciplina;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdDiciplina(int idDiciplina) {
        this.idDiciplina = idDiciplina;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
}
