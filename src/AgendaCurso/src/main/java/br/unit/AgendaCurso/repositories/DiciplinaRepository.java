package br.unit.AgendaCurso.repositories;

import br.unit.AgendaCurso.models.Diciplina;
import br.unit.AgendaCurso.models.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DiciplinaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProfessoresRepository _professoresRepository;

    public Diciplina getPorId(int id){
        String sql = "SELECT * FROM Diciplina WHERE IdDiciplina = ?";

        RowMapper<Diciplina> rowMapper = ((rs, rowNum) -> {
            Diciplina d = new Diciplina(
                    rs.getInt("IdDiciplina"),
                    rs.getString("Nome")
            );
            return d;
        });

        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
