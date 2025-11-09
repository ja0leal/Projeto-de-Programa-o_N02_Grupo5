package br.unit.AgendaCurso.repositories;

import br.unit.AgendaCurso.models.Aluno;
import br.unit.AgendaCurso.models.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

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

    public int addAluno(Aluno aluno) {
        String sql = "" +
                "INSERT INTO Aluno (Nome, Matricula, Email, Senha, Role, IdCurso) " +
                "VALUES (?, ?, ?, ?, ?, ?) ";
        return jdbcTemplate.update(sql, aluno.getNome(), aluno.getMatricula(), aluno.getEmail(), passwordEncoder.encode(aluno.getSenha()), aluno.getRole(), aluno.getIdCurso());
    }
}
