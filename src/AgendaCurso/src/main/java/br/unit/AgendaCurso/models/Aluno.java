package br.unit.AgendaCurso.models;

import java.util.List;

public class Aluno {
    private int idAluno;
    private int idCurso;
    private String nome;
    private String matricula;
    private String senha;
    private String role;
    private String email;
    private Curso curso;
    private Agenda agenda;
    private List<Turma> turmas;


    public Aluno() {
    }

    public Aluno(int idAluno, String nome, String matricula, String senha, String email, String role, Curso curso) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
        this.email = email;
        this.role = role;
        this.curso = curso;
    }

    public int getIdAluno() {
        return idAluno;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) { this.role = role; }

    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Agenda getAgenda() {
        return agenda;
    }
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
