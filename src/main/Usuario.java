package main;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	// subclasses: motorista, passageiro e adm
	//papeis multiplos = pd ser motorista, adm e/ou passageiro
	
    private int id;
    private String nome;
    private List<Viagens> historico;
    private List<Funcao> funcoes;

    public Usuario(int id, String nome) {
        // validações básicas de construção
        if (id <= 0) throw new IllegalArgumentException("ID do usuário deve ser positivo.");
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome do usuário é obrigatório.");
        this.id = id;
        this.nome = nome;
        this.historico = new ArrayList<>();
        this.funcoes = new ArrayList<>();
    }

    public void adicionarViagem(Viagens v, Funcao funcao) {
        // validação
        if (v == null) throw new NullPointerException("Viagem não pode ser nula.");
        if (funcao == null) throw new IllegalArgumentException("Função na viagem é obrigatória.");
        historico.add(v);
    }

    public void adicionarFuncao(Funcao f) {
        if (f == null) throw new IllegalArgumentException("Função não pode ser nula.");
        if (!funcoes.contains(f)) {
            funcoes.add(f);
        }
    }
    
    public int getId() { return this.id; }

    public String getNome() { return nome; }

    public List<Viagens> getHistorico() { return historico; }

    public List<Funcao> getFuncao(){ return funcoes; }

    public String getFuncoes() {
        if(funcoes.isEmpty()) {
            return "nenhuma";
        }
        List<String> nomeFuncao = new ArrayList<>();
        for(Funcao f : funcoes) {
            nomeFuncao.add(f.toString());
        }
        return String.join(",", nomeFuncao);
    }

    @Override
    public String toString() {
        return "USUARIO: "+nome +" || FUNCAO: " +getFuncoes();
    }
}

