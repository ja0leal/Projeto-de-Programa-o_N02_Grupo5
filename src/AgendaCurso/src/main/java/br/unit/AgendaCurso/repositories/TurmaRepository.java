package br.unit.AgendaCurso.repositories;

import br.unit.AgendaCurso.models.Diciplina;
import br.unit.AgendaCurso.models.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TurmaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProfessoresRepository _professoresRepository;

    @Autowired
    private DiciplinaRepository _diciplinaRepository;

    public Turma getPorId(int id){
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
}
