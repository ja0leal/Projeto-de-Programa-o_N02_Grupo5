package br.unit.AgendaCurso.viewModels;

import br.unit.AgendaCurso.models.Horario;

import java.time.LocalTime;

public class HorarioLinha {
    private LocalTime horaInicio;
    private String horarioVisual;
    private Horario domingo;
    private Horario segunda;
    private Horario terca;
    private Horario quarta;
    private Horario quinta;
    private Horario sexta;
    private Horario sabado;

    public HorarioLinha() {
    }

    public HorarioLinha(LocalTime horaInicio, String horarioVisual, Horario domingo, Horario segunda, Horario terca, Horario quarta, Horario quinta, Horario sexta, Horario sabado) {
        this.horaInicio = horaInicio;
        this.horarioVisual = horarioVisual;
        this.domingo = domingo;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public String getHorarioVisual() {
        return horarioVisual;
    }

    public Horario getDomingo() {
        return domingo;
    }

    public Horario getSegunda() {
        return segunda;
    }

    public Horario getTerca() {
        return terca;
    }

    public Horario getQuarta() {
        return quarta;
    }

    public Horario getQuinta() {
        return quinta;
    }

    public Horario getSexta() {
        return sexta;
    }

    public Horario getSabado() {
        return sabado;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHorarioVisual(String horarioVisual) {
        this.horarioVisual = horarioVisual;
    }

    public void setDomingo(Horario domingo) {
        this.domingo = domingo;
    }

    public void setSegunda(Horario segunda) {
        this.segunda = segunda;
    }

    public void setTerca(Horario terca) {
        this.terca = terca;
    }

    public void setQuarta(Horario quarta) {
        this.quarta = quarta;
    }

    public void setQuinta(Horario quinta) {
        this.quinta = quinta;
    }

    public void setSexta(Horario sexta) {
        this.sexta = sexta;
    }

    public void setSabado(Horario sabado) {
        this.sabado = sabado;
    }
}
