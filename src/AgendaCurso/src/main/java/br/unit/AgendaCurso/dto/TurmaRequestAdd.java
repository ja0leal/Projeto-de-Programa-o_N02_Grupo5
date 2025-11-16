package br.unit.AgendaCurso.dto;

public class TurmaRequestAdd {
    private String nome;
    private String idDiciplina;
    private String idProfessor;

    public TurmaRequestAdd() {
    }

    public TurmaRequestAdd(String nome, String idDiciplina, String idProfessor) {
        this.nome = nome;
        this.idDiciplina = idDiciplina;
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public String getIdDiciplina() {
        return idDiciplina;
    }

    public String getIdProfessor() {
        return idProfessor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdDiciplina(String idDiciplina) {
        this.idDiciplina = idDiciplina;
    }

    public void setIdProfessor(String idProfessor) {
        this.idProfessor = idProfessor;
    }
}
