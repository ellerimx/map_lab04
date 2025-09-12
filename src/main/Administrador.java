package main;

public class Administrador extends Usuario {
    // gerencia usuarios, pagamento e suporte
    // pode ser passageiro e/ou motorista

    public Administrador(int id, String nome) {
        super(id, nome);
        // nenhuma regra extra específica além das de Usuario
    }

    // funcoes do adm
    public void gerenciarUsuarios() {
        if (getNome() == null) throw new IllegalStateException("Administrador sem nome definido.");
        System.out.println("Administrador: " + getNome() + ", está gerenciando os usuarios...");
    }

    public void gerenciarPgto() {
        if (getNome() == null) throw new IllegalStateException("Administrador sem nome definido.");
        System.out.println("Administrador: " + getNome() + ", está gerenciando os pagamentos...");
    }

    public void gerenciarSuporte() {
        if (getNome() == null) throw new IllegalStateException("Administrador sem nome definido.");
        System.out.println("Administrador: " + getNome() + ", está gerenciando o suporte...");
    }

    // padrao creator
    public static Administrador criarAdm(int id, String nome){
        // validação
        if (id <= 0) throw new IllegalArgumentException("ID do administrador deve ser positivo.");
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome do administrador é obrigatório.");
        return new Administrador(id, nome);
    }
}



