package br.unit.AgendaCurso.models;

import java.time.LocalDateTime;

public class Evento {
    private int idEvento;
    private String titulo;
    private String descricao;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String tipo;
    private int idAgenda;
    private Agenda agenda;
    private int idTurma;
    private Turma turma;

    public Evento() {
    }

    public Evento(String titulo, String descricao, LocalDateTime inicio, LocalDateTime fim, String tipo, Agenda agenda, Turma turma) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.tipo = tipo;
        this.agenda = agenda;
        this.turma = turma;
    }

    public int getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }
    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }
    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Agenda getAgenda() { return agenda; }
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Turma getTurma() {
        return turma;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
