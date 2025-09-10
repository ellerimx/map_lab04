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
        this.id = id;
        this.nome = nome;
        this.historico = new ArrayList<>();
        this.funcoes = new ArrayList<>();
    }

    public void adicionarViagem(Viagens v,Funcao funcao) {
        historico.add(v);
    }
    
    public void adicionarFuncao(Funcao f) {
        if (!funcoes.contains(f)) {
            funcoes.add(f);
        }
    }
    
    public String getNome() {
    	return nome;
    }

    public List<Viagens> getHistorico() {
        return historico;
    }

    public List<Funcao> getFuncao(){
    	return funcoes;
    }
    
    public String getFuncoes() {
    	if(funcoes.isEmpty()) {
    		return "nenhuma";
    	}
    	List<String> nomeFuncao = new ArrayList<>();
    	for(Funcao f : funcoes) {
    		nomeFuncao.add(f.toString());
    	}
    	return String.join("," , nomeFuncao);
    }

    @Override
    public String toString() {
        return "USUARIO: "+nome +" || FUNCAO: " +getFuncoes();
    }
}

