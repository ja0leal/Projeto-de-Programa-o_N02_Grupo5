package br.unit.AgendaCurso.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DiciplinaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
