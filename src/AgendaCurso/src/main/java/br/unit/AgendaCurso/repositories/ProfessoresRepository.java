package br.unit.AgendaCurso.repositories;

import br.unit.AgendaCurso.models.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessoresRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Professor getPorId(int id){
        String sql = "select * from professores where idProfessor = ?";

        RowMapper<Professor> rowMapper = ((rs, rowNum) -> {
            Professor p = new Professor();
            p.setIdProfessor(rs.getInt("idProfessor"));
            p.setNome(rs.getString("nome"));
            return p;
        });
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<Professor> getTodos(){
        String sql = "SELECT * FROM Professores";

        RowMapper rowMapper = (rs, rowNum) ->{
            Professor p = new Professor();
            p.setIdProfessor(rs.getInt("idProfessor"));
            p.setNome(rs.getString("nome"));
            return p;
        };

        return jdbcTemplate.query(sql, rowMapper);
    }

    public int addProfessor(Professor professor){
        String sql = "INSERT INTO Professores (nome) VALUES (?)";

        return jdbcTemplate.update(sql, professor.getNome());
    }

    public int deleteProfessor(int id){
        String sql =
                """
                DELETE FROM Professores \s
                WHERE idProfessor = ?;
               \s""";

        return jdbcTemplate.update(sql, id);
    }
}
