package br.unit.AgendaCurso.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.unit.AgendaCurso.user.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
