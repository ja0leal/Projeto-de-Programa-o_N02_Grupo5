package br.unit.AgendaCurso.repositories;

import br.unit.AgendaCurso.models.Aluno;
import br.unit.AgendaCurso.models.Diciplina;
import br.unit.AgendaCurso.models.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public class AlunosRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Aluno> getPorMatricula(String matricula) {
        String sql = "SELECT * FROM Aluno WHERE Matricula = ?";
        RowMapper<Aluno> rowMapper = ((rs, rowNum) -> {
            Aluno a = new Aluno();
            a.setIdAluno(rs.getInt("IdAluno"));
            a.setNome(rs.getString("Nome"));
            a.setMatricula(rs.getString("Matricula"));
            a.setEmail(rs.getString("Email"));
            a.setSenha(rs.getString("Senha"));
            a.setRole(rs.getString("Role"));
            a.setIdCurso(rs.getInt("IdCurso"));
            return a;
        });
        try {
            Aluno aluno = jdbcTemplate.queryForObject(sql, rowMapper, matricula);
            return Optional.of(aluno); // Retorna o aluno se for encontrado
        } catch (EmptyResultDataAccessException e) {
            // 3. Se a exceção ocorrer (nenhum aluno encontrado), retorne vazio
            return Optional.empty();
        }
    }

    public List<Aluno> getPorTurmaId(int idTurma) {
        String sql = """
                SELECT
                	a.*
                FROM AlunoTurma at
                LEFT JOIN Aluno a
                	on a.IdAluno = at.IdAluno
                WHERE IdTurma = ?
                """;

        RowMapper<Aluno> rowMapper = ((rs, rowNum) -> {
            Aluno a = new Aluno();
            a.setIdAluno(rs.getInt("IdAluno"));
            a.setNome(rs.getString("Nome"));
            a.setMatricula(rs.getString("Matricula"));
            a.setEmail(rs.getString("Email"));
            a.setSenha(rs.getString("Senha"));
            a.setRole(rs.getString("Role"));
            a.setIdCurso(rs.getInt("IdCurso"));
            return a;
        });

        return jdbcTemplate.query(sql, rowMapper,  idTurma);
    }

    public List<Aluno> getTodos() {
        String sql = """
                SELECT
                	*
                FROM Aluno
                """;

        RowMapper<Aluno> rowMapper = ((rs, rowNum) -> {
            Aluno a = new Aluno();
            a.setIdAluno(rs.getInt("IdAluno"));
            a.setNome(rs.getString("Nome"));
            a.setMatricula(rs.getString("Matricula"));
            a.setEmail(rs.getString("Email"));
            a.setSenha(rs.getString("Senha"));
            a.setRole(rs.getString("Role"));
            a.setIdCurso(rs.getInt("IdCurso"));
            return a;
        });

        return jdbcTemplate.query(sql, rowMapper);
    }

    public String maxMatricula() {
        String sql = """
                SELECT MAX(a.matricula) FROM Aluno a
                """;
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    public int addAluno(Aluno aluno) {
        String sql = "" +
                "INSERT INTO Aluno (Nome, Matricula, Email, Senha, Role, IdCurso) " +
                "VALUES (?, ?, ?, ?, ?, ?) ";
        return jdbcTemplate.update(sql, aluno.getNome(), aluno.getMatricula(), "exemplo@email.com", passwordEncoder.encode(aluno.getSenha()), aluno.getRole(), 1);
    }
}
