package br.unit.AgendaCurso.repositories;

import br.unit.AgendaCurso.models.Diciplina;
import br.unit.AgendaCurso.models.Horario;
import br.unit.AgendaCurso.models.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

@Repository
public class HorarioRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TurmaRepository _turmaRepository;

    public Horario getPorId(int id) {
        String sql = "SELECT * FROM Horario WHERE IdHorario = ?;";
        RowMapper<Horario> rowMapper = ((rs, rowNum) -> {
            Horario h = new Horario(
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

    public List<Horario> getPorTurmaId(int id) {
        String sql =
                """
                        SELECT
                            * 
                        FROM Horario
                        WHERE IdTurma = ?
                        ORDER BY HorarioInicio;
                        """;
        RowMapper<Horario> rowMapper = ((rs, rowNum) -> {
            Horario h = new Horario(
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

    public List<Horario> getProximosPorTurmas(List<Turma> turmas) {
        if(turmas.isEmpty()){
            return Collections.emptyList();
        }
        String queryCondition = " (";
        for (Turma turma : turmas) {
            String condition = " IdTurma = " + turma.getIdTurma() + " OR ";
            queryCondition = queryCondition + condition;
        }

        queryCondition = queryCondition.substring(0, queryCondition.length() - 3);
        queryCondition = queryCondition + ") AND";

        String query = """
                        SELECT
                        	*
                        FROM Horario
                        WHERE
                """ + queryCondition;

        String sql = query +
                """
                        	DiaSemana > DATEPART(weekday, SYSDATETIME()) OR (DiaSemana = DATEPART(weekday, SYSDATETIME()) AND HorarioInicio > CAST(SYSDATETIME() AS TIME))
                        ORDER BY
                            DiaSemana,
                            HorarioInicio;
                        """;

        RowMapper<Horario> rowMapper = ((rs, rowNum) -> {
            Horario h = new Horario(
                    rs.getInt("IdHorario"),
                    rs.getInt("IdTurma"),
                    rs.getObject("HorarioInicio", LocalTime.class),
                    rs.getString("Sala"),
                    rs.getInt("DiaSemana"),
                    _turmaRepository.getPorId(rs.getInt("IdTurma"))
            );
            return h;
        });
        return jdbcTemplate.query(sql, rowMapper);
    }

    public int addHorario(Horario horario) {
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
        return jdbcTemplate.update(sql, horario.getHorarioInicio(), horario.getSala(), horario.getDiaDaSemana(), horario.getIdTurma());
    }

    public boolean hasHorario(LocalTime horario, int diaSemana, int idTurma) {
        String sql = """
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

    public boolean hasHorarioAluno(LocalTime horario, int diaSemana, int idAluno) {
        String sql = """
                SELECT
                    CASE
                        WHEN EXISTS (
                                SELECT
                                    *
                                FROM Horario h
                                LEFT JOIN AlunoTurma at
                                    on at.IdTurma = h.IdTurma
                                WHERE
                                    at.IdAluno = ? AND
                                    CAST(h.HorarioInicio AS TIME) = CAST(? AS TIME) AND
                                    h.DiaSemana = ?)
                        THEN 1
                        ELSE 0
                    END
                AS 'Existe'
               \s""";
        Boolean existe = jdbcTemplate.queryForObject(sql, Boolean.class, idAluno, horario, diaSemana);
        return existe != null && existe;
    }
}
