package main;
	

public class Administrador extends Usuario {
	//gerencia usuarios, pagamento e suporte
	//pode ser passageiro e/ou motorista
	

    public Administrador(int id, String nome) {
        super(id, nome);
    }

    //funcoes do adm
    public void gerenciarUsuarios() {
        System.out.println("Administrador: "+getNome() + ", está gerenciando os usuarios...");
    }
    
    public void gerenciarPgto() {
        System.out.println("Administrador: "+getNome() + ", está gerenciando os pagamentos...");
    }
    
    public void gerenciarSuporte() {
        System.out.println("Administrador: "+getNome() + ", está gerenciando o suporte...");
    }
    
    //padrao creator
    public static Administrador criarAdm(int id, String nome){
    	return new Administrador(id, nome);
    	
    }

}

