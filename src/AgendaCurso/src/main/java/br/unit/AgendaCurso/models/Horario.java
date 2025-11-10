package br.unit.AgendaCurso.models;

import java.time.LocalTime;

public class Horario {
    private int idHorario;
    private int idTurma;
    private LocalTime horarioInicio;
    private String sala;
    private int diaDaSemana;
    private Turma turma;

    public Horario() {
    }

    public Horario(int idHorario, int idTurma, LocalTime horarioInicio, String sala, int diaDaSemana, Turma turma) {
        this.idHorario = idHorario;
        this.idTurma = idTurma;
        this.horarioInicio = horarioInicio;
        this.sala = sala;
        this.diaDaSemana = diaDaSemana;
        this.turma = turma;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public String getSala() {
        return sala;
    }

    public int getDiaDaSemana() {
        return diaDaSemana;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setDiaDaSemana(int diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
