package br.unit.AgendaCurso.repositories;

import br.unit.AgendaCurso.models.Diciplina;
import br.unit.AgendaCurso.models.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

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

    public List<Horario> getPorTurmaId(int id){
        String sql =
                """
                SELECT
                    * 
                FROM Horario
                WHERE IdTurma = ?
                ORDER BY HorarioInicio;
                """;
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
        return jdbcTemplate.query(sql, rowMapper, id);
    }

    public int addHorario(Horario horario){
        String sql = """
                INSERT INTO Horario(
                	HorarioInicio,
                	Sala,
                	DiaSemana,
                	IdTurma
                )
                VALUES (
                    ?,
                    ?,
                    ?,
                    ?
                )
                """;
        return jdbcTemplate.update(sql, horario.getHorarioInicio(), horario.getSala(), horario.getDiaDaSemana(),  horario.getIdTurma());
    }

    public boolean hasHorario(LocalTime horario, int diaSemana, int idTurma){
        String sql =    """
                SELECT
                    CASE
                        WHEN EXISTS (SELECT 1 FROM Horario WHERE DiaSemana = ? AND CAST(HorarioInicio AS TIME) = CAST(? AS TIME) AND IdTurma = ?)
                        THEN 1
                        ELSE 0
                    END
                AS 'Existe'
                """;
        Boolean existe = jdbcTemplate.queryForObject(sql, Boolean.class, diaSemana, horario, idTurma);
        return existe != null && existe;
    }
}
