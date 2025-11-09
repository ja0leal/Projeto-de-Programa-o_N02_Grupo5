package br.unit.AgendaCurso.models;

import java.util.List;

public class Turma {
    private int idTurma;
    private int codigoTurma;
    private int idDisciplina;
    private Disciplina disciplina;
    private int idSemestre;
    private Semestre semestre;
    private int idProfessor;
    private Professor professor;
    private int idLocal;
    private Local local;
    private List<HorarioTurma> horarios;
    private List<Aluno> alunos;

    public Turma() {
    }

    public Turma(int idTurma, int codigoTurma, int idDisciplina, Disciplina disciplina, int idSemestre, Semestre semestre, int idProfessor, Professor professor, int idLocal, Local local, List<HorarioTurma> horarios, List<Aluno> alunos) {
        this.idTurma = idTurma;
        this.codigoTurma = codigoTurma;
        this.idDisciplina = idDisciplina;
        this.disciplina = disciplina;
        this.idSemestre = idSemestre;
        this.semestre = semestre;
        this.idProfessor = idProfessor;
        this.professor = professor;
        this.idLocal = idLocal;
        this.local = local;
        this.horarios = horarios;
        this.alunos = alunos;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public int getIdSemestre() {
        return idSemestre;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public Local getLocal() {
        return local;
    }

    public List<HorarioTurma> getHorarios() {
        return horarios;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public void setHorarios(List<HorarioTurma> horarios) {
        this.horarios = horarios;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
