package com.projeto.microservico.repository;

import com.projeto.microservico.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // O JpaRepository já fornece métodos como save(), findAll(), findById(), deleteById() automaticamente
}
