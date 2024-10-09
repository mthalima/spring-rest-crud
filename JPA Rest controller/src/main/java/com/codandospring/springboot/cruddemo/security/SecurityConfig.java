package com.codandospring.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
                .roles("FUNCIONARIO", "CEO")
                .build();

        return new InMemoryUserDetailsManager(joao, maria, pedro, andrea);
    }

}
