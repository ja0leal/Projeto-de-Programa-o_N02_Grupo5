package br.unit.AgendaCurso.models;
import java.util.List;

public class Agenda {
    private int idAluno;
    private Aluno aluno;
    private List<Evento> eventos;

    public Agenda() {
    }

    public Agenda(Aluno aluno, List<Evento> eventos) {
        this.aluno = aluno;
        this.eventos = eventos;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
