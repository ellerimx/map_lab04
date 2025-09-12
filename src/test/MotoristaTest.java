package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Motorista;
import main.Veiculo;

import static org.junit.jupiter.api.Assertions.*;

public class MotoristaTest {

    private Motorista motorista;

    @BeforeEach
    public void setup() {
        motorista = new Motorista(101, "Laryssa");
    }
    
    @Test
    void deveCriarMotoristaComDadosValidos() {
        int id = 1;
        String nome = "Maria";

        Motorista novoMotorista = Motorista.criarMotorista(id, nome);

        assertNotNull(novoMotorista);
        assertEquals(id, novoMotorista.getId());
        assertEquals(nome, novoMotorista.getNome());
    }

    @Test
    void deveCriarVeiculoEAdicionarAListaDoMotorista() {
        Veiculo veiculo = motorista.criarVeiculo("XYZ-001", "Corolla Preto");
        
        assertNotNull(veiculo);
        assertEquals("XYZ-001", veiculo.getPlaca());
        assertTrue(motorista.getVeiculos().contains(veiculo));
        assertEquals(1, motorista.getVeiculos().size());
    }
    
    @Test
    void deveLancarExcecaoAoCriarVeiculoComPlacaNulaOuVazia() {
        assertThrows(IllegalArgumentException.class, () -> {
            motorista.criarVeiculo(null, "Modelo");
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            motorista.criarVeiculo("", "Modelo");
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            motorista.criarVeiculo("   ", "Modelo");
        });
    }
    
    @Test
    void deveLancarExcecaoAoCriarVeiculoComModeloNuloOuVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            motorista.criarVeiculo("XYZ-001", null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            motorista.criarVeiculo("XYZ-001", "");
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            motorista.criarVeiculo("XYZ-001", "   ");
        });
    }

    @Test
    void deveLancarExcecaoAoTentarAdicionarVeiculoComPlacaDuplicada() {
        motorista.criarVeiculo("XYZ-001", "Uno Vermelho");

        assertThrows(IllegalArgumentException.class, () -> {
            motorista.criarVeiculo("XYZ-001", "Onix Branco");
        });
    }
}