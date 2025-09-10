package main;

public class Main {
    public static void main(String[] args) {
    	
    	//criando adms
    	Administrador a1 = Administrador.criarAdm(4, "Magali");
    	Administrador a2= Administrador.criarAdm(2, "Jose");
    	
        //criacao de usuarios || p1 = passageiro, m1 = motorista
        Passageiro p1 = new Passageiro(1, "Bianca");
        Motorista m1 = new Motorista(2, "Jose");       
       
        //criar veiculo
        Veiculo moto = m1.criarVeiculo("ABC-001", "moto vermelha");

        //criacao de viagem pra ter o historico
        Viagens v1 = new Viagens("Shopping partage", "UEPB (cct)",p1, m1,moto, Pagamento.CARTAO, 22.10); //passageiro 1, motorissta 1,veiculo motorista 1, metodo pgto, e valor
        v1.avaliar(4.5); // avaliacao da corrida

        
        //criacao de uma nova viagem tendo o motorista 1 (m1) como passageiro 2 (p2)
        Passageiro p2 = new Passageiro(3, "Jose");
        Motorista m2 = new Motorista(4, "Magali");
        Veiculo carro = m2.criarVeiculo("TOP-000", "carro azul escuro");

        Viagens v2 = new Viagens("Parque do povo", "Garden Hotel",p2, m2, carro, Pagamento.DINHEIRO, 46.30);
        v2.avaliar(4);
        
        //add funcoes
        p1.adicionarFuncao(Funcao.PASSAGEIRO);
        m1.adicionarFuncao(Funcao.MOTORISTA);
        m1.adicionarFuncao(Funcao.ADMINISTRADOR); // jose atribuido como motorista e adm
        p2.adicionarFuncao(Funcao.PASSAGEIRO);
        m2.adicionarFuncao(Funcao.MOTORISTA);
        a1.adicionarFuncao(Funcao.ADMINISTRADOR);
        a2.adicionarFuncao(Funcao.ADMINISTRADOR);
        

        // hstorico das corridas
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
        System.out.println(m2);
        m2.getHistorico().forEach(System.out::println);
        System.out.println("\n    -> administrador dessa corrida:");
        a1.gerenciarUsuarios();
        a1.gerenciarPgto();
        a1.gerenciarSuporte();
        System.out.println("\n");
    }

    }


