package org.example.projetodeprogramao_n02_grupo5;

public class Professor {
    private int idProfessor;
    private String nome;
    private String email;

    public Professor(String email, int idProfessor, String nome) {
        this.email = email;
        this.idProfessor = idProfessor;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
