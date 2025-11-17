package br.unit.AgendaCurso.viewModels;

import br.unit.AgendaCurso.models.Horario;

public class ProximosHorarios {
    private String horarioInicio;
    private String sala;
    private String diaDaSemana;

    public ProximosHorarios(Horario horario) {
        horarioInicio = horario.getHorarioInicio().toString();
        sala = horario.getSala();
        switch (horario.getDiaDaSemana()) {
            case 1:
                diaDaSemana = "Domingo";
                break;
            case 2:
                diaDaSemana = "Segunda";
                break;
            case 3:
                diaDaSemana = "Terca";
                break;
            case 4:
                diaDaSemana = "Quarta";
                break;
            case 5:
                diaDaSemana = "Quinta";
                break;
            case 6:
                diaDaSemana = "Sexta";
                break;
            case 7:
                diaDaSemana = "Sabado";
                break;
            default:
                diaDaSemana = "Não encontrado";
        }
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public String getSala() {
        return sala;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }
}
