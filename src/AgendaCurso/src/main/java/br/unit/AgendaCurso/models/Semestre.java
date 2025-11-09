package br.unit.AgendaCurso.models;

import java.time.LocalDateTime;
import java.util.List;

public class Semestre {
    private int idSemestre;
    private String nome;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private List<Turma> turmas;

    public Semestre() {
    }

    public Semestre(int idSemestre, String nome, LocalDateTime dataInicio, LocalDateTime dataFim, List<Turma> turmas) {
        this.idSemestre = idSemestre;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.turmas = turmas;
    }

    public int getIdSemestre() {
        return idSemestre;
    }
    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
