package main;

public class Main {
    public static void main(String[] args) {
    	
    	//criando adms
    	Administrador a1 = Administrador.criarAdm(4, "Magali");
    	
        //criacao de usuarios || p1 = passageiro, m1 = motorista
        Passageiro p1 = new Passageiro(1, "Bianca");
        Motorista m1 = new Motorista(2, "Jose");

    }
}


