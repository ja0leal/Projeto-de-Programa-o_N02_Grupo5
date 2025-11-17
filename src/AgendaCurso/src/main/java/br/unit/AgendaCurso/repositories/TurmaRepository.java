package br.unit.AgendaCurso.repositories;

import br.unit.AgendaCurso.models.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TurmaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProfessoresRepository _professoresRepository;

    @Autowired
    private DiciplinaRepository _diciplinaRepository;

    public Turma getPorId(int id) {
        String sql = "SELECT * FROM Turma WHERE IdTurma = ?";
        RowMapper<Turma> rowMapper = ((rs, rowNum) -> {
            return new Turma(
                    rs.getInt("IdTurma"),
                    rs.getString("Nome"),
                    rs.getInt("IdDiciplina"),
                    rs.getInt("IdProfessor"),
                    _diciplinaRepository.getPorId(rs.getInt("IdDiciplina")),
                    _professoresRepository.getPorId(rs.getInt("IdProfessor"))
            );
        });
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<Turma> getTodos() {
        String sql = "SELECT * FROM Turma";
        RowMapper<Turma> rowMapper = (rs, rowNum) -> {
            return new Turma(
                    rs.getInt("IdTurma"),
                    rs.getString("Nome"),
                    rs.getInt("IdDiciplina"),
                    rs.getInt("IdProfessor"),
                    _diciplinaRepository.getPorId(rs.getInt("IdDiciplina")),
                    _professoresRepository.getPorId(rs.getInt("IdProfessor"))
            );
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<Turma> getPorAlunoId(int id) {
        String sql =
                "SELECT " +
                        " IdTurma " +
                        "FROM AlunoTurma " +
                        "WHERE IdAluno = ?";

        RowMapper<Turma> rowMapper = (rs, rowNum) -> {
            return getPorId(rs.getInt("IdTurma"));
        };

        return jdbcTemplate.query(sql, rowMapper, id);
    }

    public List<Turma> getPorProfessorId(int id) {
        String sql = """
                SELECT
                    *
                FROM Turma
                WHERE IdProfessor = ?
                """;

        RowMapper<Turma> rowMapper = (rs, rowNum) -> {
            return new Turma(
                    rs.getInt("IdTurma"),
                    rs.getString("Nome"),
                    rs.getInt("IdDiciplina"),
                    rs.getInt("IdProfessor"),
                    _diciplinaRepository.getPorId(rs.getInt("IdDiciplina")),
                    _professoresRepository.getPorId(rs.getInt("IdProfessor"))
            );
        };

        return jdbcTemplate.query(sql, rowMapper, id);
    }

    public int addTurma(Turma turma) {
        String sql = "INSERT INTO dbo.Turma (Nome, IdDiciplina, IdProfessor) VALUES (?, ?, ?)";

        return jdbcTemplate.update(sql, turma.getNome(), turma.getIdDiciplina(), turma.getIdProfessor());
    }

    public void removerAlunoTurma(int idAluno, int idTurma) {
        String sql =
                """
                         DELETE FROM AlunoTurma WHERE IdAluno = ? and IdTurma = ?
                        """;

        jdbcTemplate.update(sql, idAluno, idTurma);
    }
}
