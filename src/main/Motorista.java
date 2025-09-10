package main;

import java.util.ArrayList;
import java.util.List;

public class Motorista extends Usuario {
	// aceita corridas e transporta passageiros
	//pode ser passageiro em outras corridas	
	//funcoes e veiculo cadastrado
	//consultar historico dos usuarios, indicando o papel q desempenhou, valor da corrida e avaliacao	
	//informar caracteristicas de uma viagem especifica
	
    private List<Veiculo> veiculos;

    public Motorista(int id, String nome) {
        super(id, nome);
        this.veiculos = new ArrayList<>();
    }

    //creator p criar veiculo
    public Veiculo criarVeiculo(String placa, String modelo) {
        Veiculo v = new Veiculo(placa, modelo);
        veiculos.add(v);
        return v;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
    
    //padrao creator
    public static Motorista criarMotorista(int id, String nome) {
    	return new Motorista(id,nome);
    }
}