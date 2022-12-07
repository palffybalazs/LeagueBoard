package com.board.main.configuration;

import com.board.main.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig {

        private final CustomUserDetailsService customUserDetailsService;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/**")
                    .permitAll()
                    .antMatchers(HttpMethod.DELETE)
                    .hasRole("ADMIN")
                    .antMatchers("/teams/**")
                    .hasAnyRole( "ADMIN")
                    .antMatchers("teams/find/**")
                    .hasAnyRole("ADMIN")
                    .anyRequest()
                    .authenticated()
                    .and()
                    .httpBasic()
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http.headers().frameOptions().disable(); // needed to be able to run h2-console
            return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationManager authManager(HttpSecurity http) throws Exception {
            AuthenticationManagerBuilder authenticationManagerBuilder =
                    http.getSharedObject(AuthenticationManagerBuilder.class);

            authenticationManagerBuilder
                    .userDetailsService(customUserDetailsService)
                    .passwordEncoder(passwordEncoder());
            return authenticationManagerBuilder.build();
        }
}
