package main;

import java.util.ArrayList;
import java.util.List;

	//solicitar corridas
	//passageiro == cliente
	//passageiro pode ser motorista em outras corridas
	//funcoes e forma de pgto

public class Passageiro extends Usuario {
    private List<Pagamento> formasPagamento;

    public Passageiro(int id, String nome) {
        super(id, nome);
        this.formasPagamento = new ArrayList<>();
    }

    public void addPgto(Pagamento p) {
    	formasPagamento.add(p);
    }
    
    public List<Pagamento> getFormasPagamento() {
        return formasPagamento;
    }
    
    //padrao creator
    public static Passageiro criarPassageiro(int id, String nome) {
    	return new Passageiro(id, nome);
    }
}

