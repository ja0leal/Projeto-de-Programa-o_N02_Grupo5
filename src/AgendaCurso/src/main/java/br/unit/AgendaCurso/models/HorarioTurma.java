package br.unit.AgendaCurso.models;

import java.time.LocalTime;
import java.time.DayOfWeek;

public class HorarioTurma {
    private int idHorarioTurma;
    private DayOfWeek diaDaSemana;;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private int idTurma;
    private Turma turma;

    public HorarioTurma() {
    }

    public HorarioTurma(int idHorarioTurma, DayOfWeek diaDaSemana, LocalTime horaInicio, LocalTime horaFim, int idTurma, Turma turma) {
        this.idHorarioTurma = idHorarioTurma;
        this.diaDaSemana = diaDaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.idTurma = idTurma;
        this.turma = turma;
    }

    public int getIdHorarioTurma() {
        return idHorarioTurma;
    }
    public void setIdHorarioTurma(int idHorarioTurma) {
        this.idHorarioTurma = idHorarioTurma;
    }

    public DayOfWeek getDiaDaSemana() {
        return diaDaSemana;
    }
    public void setDiaDaSemana(DayOfWeek diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }
    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public int getIdTurma() {
        return idTurma;
    }
    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public Turma getTurma() {
        return turma;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
