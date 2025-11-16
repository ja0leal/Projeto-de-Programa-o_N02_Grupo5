package br.unit.AgendaCurso.models;

public class Aluno {
    private int idAluno;
    private String nome;
    private String matricula;
    private String email;
    private String senha;
    private String role;
    private int idCurso;
    private Agenda agenda;
    private Curso curso;

    public Aluno() {
    }

    public Aluno(String nome, String matricula, String email, String senha, String role, int idCurso) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.idCurso = idCurso;
    }

    public Aluno(int idAluno, String nome, String matricula, String email, String senha, String role, int idCurso, Agenda agenda, Curso curso) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.idCurso = idCurso;
        this.agenda = agenda;
        this.curso = curso;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getRole() {
        return role;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
