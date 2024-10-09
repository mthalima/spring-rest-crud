package com.codandospring.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails joao = User.builder()
                .username("joao")
                .password("{noop}123456")
                .roles("FUNCIONARIO")
                .build();

        UserDetails maria = User.builder()
                .username("maria")
                .password("{noop}123456")
                .roles("FUNCIONARIO", "GERENTE")
                .build();

        UserDetails pedro = User.builder()
                .username("pedro")
                .password("{noop}123456")
                .roles("FUNCIONARIO")
                .build();

        UserDetails andrea = User.builder()
                .username("andrea")
                .password("{noop}123456")
                .roles("FUNCIONARIO", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(joao, maria, pedro, andrea);
    }


    //DEFINE AS LIMITAÇÕES DE A CORDO COM AS PERMISSÕES DE CADA CADASTRO
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("FUNCIONARIO")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );

        //USA AUTENTICACAO BASICA HTTP
        http.httpBasic(Customizer.withDefaults());

        //DISAPLE CROSS SITE REQUEST FORGERY - CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
