package br.unit.AgendaCurso.models;

import java.util.List;

public class Local {
    private int idLocal;
    private String nome;
    private String descricao;
    private List<Turma> turmas;

    public Local() {
    }

    public Local(int idLocal, String nome, String descricao, List<Turma> turmas) {
        this.idLocal = idLocal;
        this.nome = nome;
        this.descricao = descricao;
        this.turmas = turmas;
    }

    public int getIdLocal() {
        return idLocal;
    }
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
