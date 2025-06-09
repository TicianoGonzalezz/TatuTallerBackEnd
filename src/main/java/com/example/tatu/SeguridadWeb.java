package com.example.tatu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SeguridadWeb {


    @Configuration
public class SecurityConfig {

    // CON ESTE METODO HAGO QUE NO SEA NECESARIO INICIAR SESION PARA ACCEDER A LA PAGINA PRINCIPAL!!!!!!!
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }
}
//:)
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeHttpRequests((authorize) -> authorize
    //             .requestMatchers("/admin/**").hasRole("ADMIN") // Acceso solo para ADMIN
    //             .requestMatchers("/css/**", "/js/**", "/img/**").permitAll() // Recursos estáticos
    //             .requestMatchers("/login", "/registro","/registrar").permitAll()          // Acceso libre a login/registro
    //             .anyRequest().authenticated()                                // Lo demás requiere login
    //         )
    //         .formLogin((form) -> form
    //             .loginPage("/login")                     // Página de login personalizada
    //             .loginProcessingUrl("/logincheck")       // Acción que procesa el formulario
    //             .usernameParameter("email")              // Input name del usuario
    //             .passwordParameter("password")           // Input name de la contraseña
    //             .defaultSuccessUrl("/inicio", true)      // Redirige al inicio si login exitoso
    //             .permitAll()
    //         )
    //         .logout((logout) -> logout
    //             .logoutUrl("/logout")                    // URL de logout
    //             .logoutSuccessUrl("/login")              // Redirige al login al cerrar sesión
    //             .permitAll()
    //         )
    //         .csrf(csrf -> csrf.disable());

    //     return http.build();
    // }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

