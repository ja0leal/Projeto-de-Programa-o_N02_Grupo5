package br.unit.AgendaCurso.repositories;

import br.unit.AgendaCurso.models.Diciplina;
import br.unit.AgendaCurso.models.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public class HorarioRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TurmaRepository _turmaRepository;

    public Horario getPorId(int id){
        String sql = "SELECT * FROM Horario WHERE IdHorario = ?;";

        RowMapper<Horario> rowMapper = ((rs, rowNum) -> {
            Horario h =  new Horario(
                    rs.getInt("IdHorario"),
                    rs.getInt("IdTurma"),
                    rs.getObject("HorarioInicio", LocalTime.class),
                    rs.getString("Sala"),
                    rs.getInt("DiaSemana"),
                    _turmaRepository.getPorId(rs.getInt("IdTurma"))
            );
            return h;
        });

        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
