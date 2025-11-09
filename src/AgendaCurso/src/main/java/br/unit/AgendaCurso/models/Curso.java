package br.unit.AgendaCurso.models;
import java.util.List;

public class Curso {
    private int idAluno;
    private String nome;
    private List<Aluno> Alunos;
    private List<Disciplina> disciplinas;

    public Curso() {
    }

    public Curso(List<Disciplina> disciplinas, List<Aluno> alunos, String nome, int idAluno) {
        this.disciplinas = disciplinas;
        Alunos = alunos;
        this.nome = nome;
        this.idAluno = idAluno;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public String getNome() {
        return nome;
    }

    public List<Aluno> getAlunos() {
        return Alunos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAlunos(List<Aluno> alunos) {
        Alunos = alunos;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
