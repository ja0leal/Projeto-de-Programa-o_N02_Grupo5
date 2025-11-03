package br.unit.AgendaCurso.Services;

import br.unit.AgendaCurso.models.Aluno;
import br.unit.AgendaCurso.repositories.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AlunosRepository _alunosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Aluno aluno = _alunosRepository.getPorMatricula(username).orElseThrow(() -> new UsernameNotFoundException("Aluno não encontrado"));

        return new User(aluno.getMatricula(), aluno.getSenha(), List.of(new SimpleGrantedAuthority("ROLE_ALUNO")));
    }
}
