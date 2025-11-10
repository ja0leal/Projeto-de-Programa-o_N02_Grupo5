package br.unit.AgendaCurso.models;

public class Diciplina {
    private int idDiciplina;
    private String nome;

    public Diciplina() {
    }

    public Diciplina(int idDiciplina, String nome) {
        this.idDiciplina = idDiciplina;
        this.nome = nome;
    }

    public int getIdDiciplina() {
        return idDiciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setIdDiciplina(int idDiciplina) {
        this.idDiciplina = idDiciplina;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
