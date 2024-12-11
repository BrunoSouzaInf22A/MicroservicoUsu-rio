package com.projeto.microservico.service;

import com.projeto.microservico.model.Usuario;
import com.projeto.microservico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para listar todos os usuários
    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Método para buscar um usuário por id
    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Método para salvar um novo usuário
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Método para atualizar um usuário existente
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }

    // Método para excluir um usuário
    public boolean excluirUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
