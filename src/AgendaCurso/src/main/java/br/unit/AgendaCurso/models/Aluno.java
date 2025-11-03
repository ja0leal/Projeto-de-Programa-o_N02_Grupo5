package br.unit.AgendaCurso.models;

public class Aluno {
    private int IdAluno;
    private String Nome;
    private String Matricula;
    private String Email;
    private String Senha;
    private int IdRole;
    private int IdCurso;
    private Agenda agenda;

    public int getIdAluno() {
        return IdAluno;
    }

    public void setIdAluno(int idAluno) {
        IdAluno = idAluno;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public void setIdRole(int idRole) {
        IdRole = idRole;
    }

    public void setIdCurso(int idCurso) {
        IdCurso = idCurso;
    }

    public void setIdAgenda(int idAgenda) {
        IdAgenda = idAgenda;
    }

    public String getNome() {
        return Nome;
    }

    public String getMatricula() {
        return Matricula;
    }

    public String getEmail() {
        return Email;
    }

    public String getSenha() {
        return Senha;
    }

    public int getIdRole() {
        return IdRole;
    }

    public int getIdCurso() {
        return IdCurso;
    }

    public int getIdAgenda() {
        return IdAgenda;
    }

    private int IdAgenda;
}
