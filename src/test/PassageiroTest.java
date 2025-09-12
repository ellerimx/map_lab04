package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Pagamento;
import main.Passageiro;

import static org.junit.jupiter.api.Assertions.*;

public class PassageiroTest {

    private Passageiro passageiro;

    @BeforeEach
    public void setup() {
        passageiro = new Passageiro(101, "Laryssa");
    }

    @Test
    void deveCriarPassageiroComDadosValidos() {
        int id = 1;
        String nome = "Maria";

        Passageiro novoPassageiro = Passageiro.criarPassageiro(id, nome);

        assertNotNull(novoPassageiro);
        assertEquals(id, novoPassageiro.getId());
        assertEquals(nome, novoPassageiro.getNome());
    }

    @Test
    void deveLancarExcecaoAoCriarPassageiroComIdInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Passageiro.criarPassageiro(0, "Nome Invalido");
        });
    }
    
    @Test
    void deveLancarExcecaoAoCriarPassageiroComNomeInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            Passageiro.criarPassageiro(2, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Passageiro.criarPassageiro(3, "");
        });
    }

    @Test
    void deveAdicionarUmaNovaFormaDePagamento() {
        passageiro.addPgto(Pagamento.CARTAO);
        
        assertTrue(passageiro.getFormasPagamento().contains(Pagamento.CARTAO));
        assertEquals(1, passageiro.getFormasPagamento().size());
    }

    @Test
    void deveLancarExcecaoAoAdicionarPagamentoNulo() {
        assertThrows(NullPointerException.class, () -> {
            passageiro.addPgto(null);
        });
    }

    @Test
    void deveLancarExcecaoAoAdicionarPagamentoDuplicado() {
        passageiro.addPgto(Pagamento.PIX);
        
        assertThrows(IllegalArgumentException.class, () -> {
            passageiro.addPgto(Pagamento.PIX);
        });
    }
}