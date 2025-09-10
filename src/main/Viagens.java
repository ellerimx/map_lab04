package main;

import java.time.LocalDateTime;

public class Viagens {
    private String origem;
    private String destino;
    private LocalDateTime horario;
    private Passageiro passageiro;
    private Motorista motorista;
    private Veiculo veiculo;
    private Pagamento pagamento;
    private double valor;
    private double avaliacao;
    //private Administrador adm;

    public Viagens(String origem, String destino,Passageiro passageiro, Motorista motorista,Veiculo veiculo, 
    		Pagamento pagamento, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.horario = LocalDateTime.now();
        this.passageiro = passageiro;
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.pagamento = pagamento;
        this.valor = valor;

        // add viagem no historico dos usuarios de acordo com suas funcoes
        passageiro.adicionarViagem(this, Funcao.PASSAGEIRO);
        motorista.adicionarViagem(this, Funcao.PASSAGEIRO);
       // administrador.adicionarViagem(this, Funcao.ADMINISTRADOR);
    }

    public void avaliar(double d) { 
    	this.avaliacao = d; 
    	}

    @Override
    public String toString() {
        return "\nHistorico de viagem: \n" +
                "- Origem = " + origem +"\n- Destino = " + destino+ "\n- Horario = " + horario + "\n- Passageiro = " + passageiro.getNome() +
                "\n- Motorista = " + motorista.getNome() + "\n- Veiculo = " + veiculo +"\n- Valor = R$" + valor +
                "\n- Forma de pagamento = " + pagamento +"\n- Avaliacao da corrida = " + avaliacao + "\n";
    }
}


