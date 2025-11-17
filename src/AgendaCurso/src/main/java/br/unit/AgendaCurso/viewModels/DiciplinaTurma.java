package br.unit.AgendaCurso.viewModels;

import br.unit.AgendaCurso.models.Diciplina;
import br.unit.AgendaCurso.models.Horario;
import br.unit.AgendaCurso.models.Turma;

import java.util.List;

public class DiciplinaTurma {
    private int idDiciplina;
    private String nome;
    private List<TurmasVM> turmas;

    public DiciplinaTurma() {
    }

    public DiciplinaTurma(Diciplina diciplina, List<TurmasVM> turmas) {
        idDiciplina = diciplina.getIdDiciplina();
        nome = diciplina.getNome();
        this.turmas = turmas;
    }

    public int getIdDiciplina() {
        return idDiciplina;
    }

    public String getNome() {
        return nome;
    }

    public List<TurmasVM> getTurmas() {
        return turmas;
    }

    public void setIdDiciplina(int idDiciplina) {
        this.idDiciplina = idDiciplina;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTurmas(List<TurmasVM> turmas) {
        this.turmas = turmas;
    }
}
