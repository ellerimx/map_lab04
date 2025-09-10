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
        return "Viagem: \n" +
                "{ Origem = " + origem +", destino = " + destino+ ", horario = " + horario + ", passageiro =" + passageiro.getNome() +
                ", \nmotorista = " + motorista.getNome() + ", veiculo =" + veiculo +", valor = R$" + valor +
                ", forma de pagamento = " + pagamento +", avaliacao = " + avaliacao + " }";
    }
}


