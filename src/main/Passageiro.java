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
        // validação
        if (p == null) throw new NullPointerException("Forma de pagamento não pode ser nula.");
        // evitando duplicidade
        if (formasPagamento.contains(p)) {
            throw new IllegalArgumentException("Esta forma de pagamento já está cadastrada para o passageiro.");
        }
        formasPagamento.add(p);
    }
    
    public List<Pagamento> getFormasPagamento() {
        return formasPagamento;
    }
    
    //padrao creator
    public static Passageiro criarPassageiro(int id, String nome) {
        if (id <= 0) throw new IllegalArgumentException("ID do passageiro deve ser positivo.");
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome do passageiro é obrigatório.");
        return new Passageiro(id, nome);
    }
}


