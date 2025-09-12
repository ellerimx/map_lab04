package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Funcao;
import main.Usuario;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    public void setup() {
        usuario = new Usuario(1, "Laryssa");
    }

    @Test
    void deveCriarUsuarioComSucesso() {
        int id = 2;
        String nome = "Ana";
        
        Usuario novoUsuario = new Usuario(id, nome);
        
        assertNotNull(novoUsuario);
        assertEquals(id, novoUsuario.getId());
        assertEquals(nome, novoUsuario.getNome());
    }

    @Test
    void deveLancarExcecaoQuandoIdForNegativoOuZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(0, "Nome Invalido");
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(-10, "Nome Invalido");
        });
    }

    @Test
    void deveLancarExcecaoQuandoNomeForNuloOuVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(3, null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(4, "");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(5, "   ");
        });
    }

    @Test
    void deveAdicionarFuncaoComSucesso() {
        usuario.adicionarFuncao(Funcao.PASSAGEIRO);
        
        assertTrue(usuario.getFuncao().contains(Funcao.PASSAGEIRO));
        assertEquals(1, usuario.getFuncao().size());
    }

    @Test
    void naoDeveAdicionarFuncaoDuplicada() {
        usuario.adicionarFuncao(Funcao.PASSAGEIRO);
        
        usuario.adicionarFuncao(Funcao.PASSAGEIRO);
        
        assertEquals(1, usuario.getFuncao().size());
    }

}