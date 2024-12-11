
import com.projeto.microservico.controller.UsuarioController;
import com.projeto.microservico.model.Usuario;
import com.projeto.microservico.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Test; 
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) 
public class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;  

    @InjectMocks
    private UsuarioController usuarioController; 

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        // Criando um objeto de usuário para os testes
        usuario = new Usuario("João", "joao@example.com", "senha123");
    }

    // Teste para o método GET /api/usuarios/{id}
    @Test
    public void testBuscarUsuarioPorId_Sucesso() {
        when(usuarioService.buscarUsuarioPorId(1L)).thenReturn(Optional.of(usuario));

        ResponseEntity<Usuario> response = usuarioController.buscarUsuarioPorId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
        verify(usuarioService, times(1)).buscarUsuarioPorId(1L);  // Verifica se o método foi chamado
    }

    @Test
    public void testBuscarUsuarioPorId_NotFound() {
        when(usuarioService.buscarUsuarioPorId(1L)).thenReturn(Optional.empty());

        ResponseEntity<Usuario> response = usuarioController.buscarUsuarioPorId(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(usuarioService, times(1)).buscarUsuarioPorId(1L);  // Verifica se o método foi chamado
    }

    // Teste para o método PUT /api/usuarios/{id}
    @Test
    public void testAtualizarUsuario_Sucesso() {
        when(usuarioService.atualizarUsuario(1L, usuario)).thenReturn(usuario);

        ResponseEntity<Usuario> response = usuarioController.atualizarUsuario(1L, usuario);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
        verify(usuarioService, times(1)).atualizarUsuario(1L, usuario);
    }

    @Test
    public void testAtualizarUsuario_NotFound() {
        when(usuarioService.atualizarUsuario(1L, usuario)).thenReturn(null);

        ResponseEntity<Usuario> response = usuarioController.atualizarUsuario(1L, usuario);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(usuarioService, times(1)).atualizarUsuario(1L, usuario);
    }

    // Teste para o método DELETE /api/usuarios/{id}
    @Test
    public void testExcluirUsuario_Sucesso() {
        when(usuarioService.excluirUsuario(1L)).thenReturn(true);

        ResponseEntity<Void> response = usuarioController.excluirUsuario(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(usuarioService, times(1)).excluirUsuario(1L);
    }

    @Test
    public void testExcluirUsuario_NotFound() {
        when(usuarioService.excluirUsuario(1L)).thenReturn(false);

        ResponseEntity<Void> response = usuarioController.excluirUsuario(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(usuarioService, times(1)).excluirUsuario(1L);
    }
}
