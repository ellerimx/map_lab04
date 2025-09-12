package main;

public class Main {
    public static void main(String[] args) {
    	
    	Administrador a1 = Administrador.criarAdm(4, "Magali");
    	Administrador a2= Administrador.criarAdm(2, "Jose");
    	
        Passageiro p1 = Passageiro.criarPassageiro(1, "Bianca");
        Motorista m1 = Motorista.criarMotorista(2, "Jose");       
       
        Veiculo moto = m1.criarVeiculo("ABC-001", "moto vermelha");

        Viagens v1 = Viagens.criarViagem("Shopping partage", "UEPB (cct)", "12h37",p1, m1,moto, Pagamento.CARTAO, 22.10);
        v1.avaliar(4.5); 

        
        Passageiro p2 = Passageiro.criarPassageiro(3, "Jose");
        Motorista m2 = Motorista.criarMotorista(4, "Magali");
        Veiculo carro = m2.criarVeiculo("TOP-000", "carro azul escuro");

        Viagens v2 = Viagens.criarViagem("Parque do povo", "Garden Hotel","09h43",p2, m2, carro, Pagamento.DINHEIRO, 46.30);
        v2.avaliar(4);
        
        p1.adicionarFuncao(Funcao.PASSAGEIRO);
        m1.adicionarFuncao(Funcao.MOTORISTA);
        m1.adicionarFuncao(Funcao.ADMINISTRADOR); 
        p2.adicionarFuncao(Funcao.PASSAGEIRO);
        m2.adicionarFuncao(Funcao.MOTORISTA);
        a1.adicionarFuncao(Funcao.ADMINISTRADOR);
        a2.adicionarFuncao(Funcao.ADMINISTRADOR);
        

        System.out.println("#### Histórico de Bianca ####\n");
        System.out.println(p1);
        p1.getHistorico().forEach(System.out::println);        
        
        
        System.out.println("\n    -> administrador dessa corrida:");
        a1.gerenciarUsuarios();
        a1.gerenciarPgto();
        a1.gerenciarSuporte();        
        System.out.println("\n");

        System.out.println("\n#### Histórico do Jose como motorista ####");
        System.out.println(m1);
        m1.getHistorico().forEach(System.out::println);
        System.out.println("\n    -> administrador dessa corrida:");
        a2.gerenciarUsuarios();
        a2.gerenciarPgto();
        a2.gerenciarSuporte();
        System.out.println("\n");

        System.out.println("#### Histórico do Jose como passageiro ####");
        System.out.println(p2);
        m2.getHistorico().forEach(System.out::println);
        System.out.println("\n    -> administrador dessa corrida:");
        a1.gerenciarUsuarios();
        a1.gerenciarPgto();
        a1.gerenciarSuporte();
        System.out.println("\n");
    }

}