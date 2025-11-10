package br.unit.AgendaCurso.viewModels;

import br.unit.AgendaCurso.models.Horario;

import java.time.LocalTime;

public class HorarioLinha {
    private LocalTime horaInicio;
    private String horarioVisual;
    private boolean visivel;
    private boolean intervalo;
    private Horario domingo;
    private Horario segunda;
    private Horario terca;
    private Horario quarta;
    private Horario quinta;
    private Horario sexta;
    private Horario sabado;

    public HorarioLinha() {
    }

    public HorarioLinha(LocalTime horaInicio, String horarioVisual, boolean visivel, Horario domingo, Horario segunda, Horario terca, Horario quarta, Horario quinta, Horario sexta, Horario sabado) {
        this.horaInicio = horaInicio;
        this.horarioVisual = horarioVisual;
        this.visivel = visivel;
        this.domingo = domingo;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
    }

    public HorarioLinha(LocalTime horaInicio, String horarioVisual, boolean visivel, boolean intervalo, Horario domingo, Horario segunda, Horario terca, Horario quarta, Horario quinta, Horario sexta, Horario sabado) {
        this.horaInicio = horaInicio;
        this.horarioVisual = horarioVisual;
        this.visivel = visivel;
        this.intervalo = intervalo;
        this.domingo = domingo;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
    }

    public boolean isIntervalo() {
        return intervalo;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public String getHorarioVisual() {
        return horarioVisual;
    }

    public boolean isVisivel() {
        return visivel;
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

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public void setIntervalo(boolean intervalo) {
        this.intervalo = intervalo;
    }
}
