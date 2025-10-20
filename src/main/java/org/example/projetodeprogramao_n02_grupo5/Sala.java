package org.example.projetodeprogramao_n02_grupo5;

public class Sala {
    private int idSala;
    private String nome;
    private String localizacao;
    private int capacidade;

    public Sala(int capacidade, int idSala, String localizacao, String nome) {
        this.capacidade = capacidade;
        this.idSala = idSala;
        this.localizacao = localizacao;
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getIdSala() {
        return idSala;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
