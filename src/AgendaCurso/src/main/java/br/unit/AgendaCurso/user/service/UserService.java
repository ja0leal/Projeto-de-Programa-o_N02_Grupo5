package br.unit.AgendaCurso.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import br.unit.AgendaCurso.user.model.Role;
import br.unit.AgendaCurso.user.model.User;
import br.unit.AgendaCurso.user.repository.RoleRepository;
import br.unit.AgendaCurso.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,  RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerStudent(String name, String email, String password) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists!");
        }

        String hashedPassword = passwordEncoder.encode(password);

        Role studentRole = roleRepository
                .findByName("ROLE_STUDENT")
                .orElseThrow(
                        () -> new RuntimeException("Cargo -> Role_Student não encontrado!")
                );

        User newUser =  new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(hashedPassword);
        newUser.getRoles().add(studentRole);

        return userRepository.save(newUser);
    }
}