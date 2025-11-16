package br.unit.AgendaCurso.dto;

public class HorarioRequestAdd {
    private String sala;
    private int dia;
    private String horario;
    private int idTurma;

    public HorarioRequestAdd() {
    }

    public HorarioRequestAdd(String sala, int dia, String horario, int idTurma) {
        this.sala = sala;
        this.dia = dia;
        this.horario = horario;
        this.idTurma = idTurma;
    }

    public String getSala() {
        return sala;
    }

    public int getDia() {
        return dia;
    }

    public String getHorario() {
        return horario;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }
}