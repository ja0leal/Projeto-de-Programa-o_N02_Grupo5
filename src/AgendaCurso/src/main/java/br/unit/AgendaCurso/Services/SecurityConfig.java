package br.unit.AgendaCurso.Services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        // 1. Permita acesso anônimo ao seu endpoint da API.
                        //    Regras específicas devem vir antes de regras gerais.
                        .requestMatchers("/Professores/add").permitAll()

                        // 2. Agora, exija autenticação para todas as OUTRAS requisições.
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())

                // 3. Desabilite o CSRF (isto corrige o erro 403).
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
