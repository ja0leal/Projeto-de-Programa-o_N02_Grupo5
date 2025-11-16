package br.unit.AgendaCurso.dto;

public class HorarioResponse {
    private int idHorario;

    public HorarioResponse() {
    }

    public HorarioResponse(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }
}
