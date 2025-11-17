package br.unit.AgendaCurso.viewModels;

import br.unit.AgendaCurso.models.Horario;
import br.unit.AgendaCurso.models.Turma;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TurmasVM {
    private int idTurma;
    private String nome;
    private String horarios;

    public TurmasVM() {
    }

    public TurmasVM(Turma turma, List<Horario> horarios) {
        idTurma = turma.getIdTurma();
        nome = turma.getNome();

        if(horarios.isEmpty()){
            this.horarios = "Nenhum horário disponível.";
        }else{
            this.horarios = "";
            for(Horario horario : horarios){
                String diaDaSemana= "";
                switch (horario.getDiaDaSemana()) {
                    case 1:
                        diaDaSemana = " Dom";
                        break;
                    case 2:
                        diaDaSemana = " Seg";
                        break;
                    case 3:
                        diaDaSemana = " Ter";
                        break;
                    case 4:
                        diaDaSemana = " Qua";
                        break;
                    case 5:
                        diaDaSemana = " Qui";
                        break;
                    case 6:
                        diaDaSemana = " Sex";
                        break;
                    case 7:
                        diaDaSemana = " Sab";
                        break;
                    default:
                        diaDaSemana = " Não encontrado";
                }


                this.horarios += horario.getHorarioInicio().toString() + diaDaSemana + " | ";
            }
        }
    }

    public int getIdTurma() {
        return idTurma;
    }

    public String getNome() {
        return nome;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }
}
