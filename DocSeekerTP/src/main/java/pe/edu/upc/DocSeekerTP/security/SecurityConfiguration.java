package pe.edu.upc.DocSeekerTP.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
/*
http://localhost:8080/swagger-ui/index.html
*/
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            // -- login
            "/api/users/login/**",
            "/api/users/register/**"
};
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration
                                                        authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable();
        http.cors(withDefaults());
        http.authorizeHttpRequests( (auth) ->auth
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/api/Doctor/**").hasAnyAuthority("ROLE_PATIENT")
                .antMatchers("/api/Register/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/api/users/**").permitAll()
                .anyRequest().authenticated()
        );
        http.sessionManagement( (session)-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}


