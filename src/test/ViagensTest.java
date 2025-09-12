package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.Viagens;
import main.Passageiro;
import main.Motorista;
import main.Veiculo;
import main.Pagamento;

public class ViagensTest {

    private Passageiro passageiro;
    private Motorista motorista;
    private Veiculo veiculo;
    private Pagamento pagamento;

    @BeforeEach
    public void setup() {
        passageiro = new Passageiro(1, "Laryssa");
        motorista = new Motorista(2, "Ana");
        veiculo = motorista.criarVeiculo("XYZ-001", "Corolla Preto");
        pagamento = Pagamento.CARTAO;
    }

    @Test
    void deveCriarViagemComTodosOsDadosValidos() {
        Viagens viagem = new Viagens("Origem A", "Destino B","14h", passageiro, motorista, veiculo, pagamento, 20.43);

        assertNotNull(viagem);
        assertNotNull(passageiro.getHistorico());
        assertNotNull(motorista.getHistorico());
        assertEquals(1, passageiro.getHistorico().size());
        assertEquals(1, motorista.getHistorico().size());
    }

    @Test
    void deveLancarExcecaoQuandoOrigemForNulaOuVazia() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Viagens(null, "Destino B", "06h", passageiro, motorista, veiculo, pagamento, 20.43);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Viagens("", "Destino B", "09h",passageiro, motorista, veiculo, pagamento, 20.43);
        });
    }

    @Test
    void deveLancarExcecaoQuandoDestinoForNuloOuVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Viagens("Origem A", null,"04h", passageiro, motorista, veiculo, pagamento, 20.43);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Viagens("Origem A", "","09h50", passageiro, motorista, veiculo, pagamento, 20.43);
        });
    }

    @Test
    void deveLancarExcecaoQuandoOrigemForIgualADestino() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Viagens("Local", "Local", "17h30",passageiro, motorista, veiculo, pagamento, 20.43);
        });
    }

    @Test
    void deveLancarExcecaoQuandoPassageiroForNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Viagens("Origem A", "Destino B", "17h30",null, motorista, veiculo, pagamento, 20.43);
        });
    }

    @Test
    void deveLancarExcecaoQuandoMotoristaForNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Viagens("Origem A", "Destino B","17h30", passageiro, null, veiculo, pagamento, 20.43);
        });
    }
    
    @Test
    void deveLancarExcecaoQuandoVeiculoForNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Viagens("Origem A", "Destino B", "17h30",passageiro, motorista, null, pagamento, 20.43);
        });
    }

    @Test
    void deveLancarExcecaoQuandoPagamentoForNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Viagens("Origem A", "Destino B","17h30", passageiro, motorista, veiculo, null, 20.43);
        });
    }

    @Test
    void deveLancarExcecaoQuandoValorForNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Viagens("Origem A", "Destino B", "17h30",passageiro, motorista, veiculo, pagamento, -12.90);
        });
    }

    @Test
    void deveLancarExcecaoQuandoMotoristaNaoTiverVeiculoCadastrado() {
        Motorista motoristaSemVeiculo = new Motorista(3, "Beatriz");
        
        assertThrows(IllegalStateException.class, () -> {
            new Viagens("Origem A", "Destino B", "17h30",passageiro, motoristaSemVeiculo, veiculo, pagamento, 25.50);
        });
    }
    

    @Test
    void deveAvaliarViagemComSucesso() {
        Viagens viagem = new Viagens("Origem A", "Destino B", "17h30", passageiro, motorista, veiculo, pagamento, 25.50);
        double avaliacao = 4.5;
        viagem.avaliar(avaliacao);

        assertTrue(viagem.toString().contains("Avaliacao da corrida = " + avaliacao));
    }

    @Test
    void deveLancarExcecaoAoAvaliarComNotaInvalida() {
        Viagens viagem = new Viagens("Origem A", "Destino B", "17h30",passageiro, motorista, veiculo, pagamento, 25.50);

        assertThrows(IllegalArgumentException.class, () -> {
            viagem.avaliar(6.0);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            viagem.avaliar(-1.0);
        });
    }
}