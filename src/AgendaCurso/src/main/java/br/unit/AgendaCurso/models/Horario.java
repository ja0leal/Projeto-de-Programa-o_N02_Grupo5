package br.unit.AgendaCurso.models;

import jdk.jfr.Timespan;

import java.time.LocalTime;

public class Horario {
    private int idHorario;
    private int idDiciplina;
    private LocalTime horarioInicio;
    private String sala;
    private int diaDaSemana;
    private Diciplina diciplina;

    public Horario() {
    }

    public Horario(int idHorario, int idDiciplina, LocalTime horarioInicio, String sala, int diaDaSemana, Diciplina diciplina) {
        this.idHorario = idHorario;
        this.idDiciplina = idDiciplina;
        this.horarioInicio = horarioInicio;
        this.sala = sala;
        this.diaDaSemana = diaDaSemana;
        this.diciplina = diciplina;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public int getIdDiciplina() {
        return idDiciplina;
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

    public Diciplina getDiciplina() {
        return diciplina;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public void setIdDiciplina(int idDiciplina) {
        this.idDiciplina = idDiciplina;
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

    public void setDiciplina(Diciplina diciplina) {
        this.diciplina = diciplina;
    }
}
