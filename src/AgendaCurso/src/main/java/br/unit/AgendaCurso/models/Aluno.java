package br.unit.AgendaCurso.models;

public class Aluno {
    private String matricula;
    private String nome;
    private int idade;
    private String dataNascimento;
    private String email;
    private String CPF;

    public Aluno() {
    }

    public Aluno(String matricula, String nome, int idade, String dataNascimento, String email, String CPF) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.CPF = CPF;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
