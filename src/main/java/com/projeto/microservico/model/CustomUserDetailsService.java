package com.projeto.microservico.model;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Aqui você pode buscar o usuário de um banco de dados ou de outra fonte
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Exemplo de retorno de um usuário com username e senha fixos.
        if ("admin".equals(username)) {
            return User.withUsername("admin")
                       .password("{noop}admin123")  
                       .roles("USER", "ADMIN")
                       .build();
        }
        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}
