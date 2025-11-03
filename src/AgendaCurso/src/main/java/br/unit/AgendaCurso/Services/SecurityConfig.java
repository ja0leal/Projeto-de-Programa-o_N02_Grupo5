package br.unit.AgendaCurso.Services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // ATENÇÃO: Depreciado e inseguro, usar APENAS para debug.
        return NoOpPasswordEncoder.getInstance();
    }

    // 2. A "Configuração da Segurança" (PEÇA FALTANTE 2)
    //    Habilita a tela de login padrão.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        // Protege todas as rotas
                        .anyRequest().authenticated()
                )
                // Habilita a TELA PADRÃO do Spring Security
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
