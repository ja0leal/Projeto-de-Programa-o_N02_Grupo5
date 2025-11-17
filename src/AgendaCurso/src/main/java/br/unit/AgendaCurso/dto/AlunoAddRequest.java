package br.unit.AgendaCurso.dto;

public class AlunoAddRequest {
    private String nome;
    private String senha;
    private String role;

    public AlunoAddRequest() {
    }

    public AlunoAddRequest(String nome, String senha, String role) {
        this.nome = nome;
        this.senha = senha;
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getRole() {
        return role;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
