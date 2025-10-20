package org.example.projetodeprogramao_n02_grupo5;

public class Curso {
    private int idCurso;
    private String nome;
    private String descricao;
    private int cargaHorariaTotal;

    public Curso(int cargaHorariaTotal, String descricao, int idCurso, String nome) {
        this.cargaHorariaTotal = cargaHorariaTotal;
        this.descricao = descricao;
        this.idCurso = idCurso;
        this.nome = nome;
    }

    public int getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setCargaHorariaTotal(int cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
