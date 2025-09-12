package main;

public class Viagens {
    private String origem;
    private String destino;
    private String horario;
    private Passageiro passageiro;
    private Motorista motorista;
    private Veiculo veiculo;
    private Pagamento pagamento;
    private double valor;
    private double avaliacao;
    //private Administrador adm;

    public Viagens(String origem, String destino, String horario, Passageiro passageiro, Motorista motorista,Veiculo veiculo, 
    		Pagamento pagamento, double valor) {

        if (origem == null || origem.isBlank()) throw new IllegalArgumentException("Origem é obrigatória.");
        if (destino == null || destino.isBlank()) throw new IllegalArgumentException("Destino é obrigatório.");
        if (origem.equalsIgnoreCase(destino)) throw new IllegalArgumentException("Origem e destino devem ser diferentes.");
        if (passageiro == null) throw new NullPointerException("Passageiro não pode ser nulo.");
        if (motorista == null) throw new NullPointerException("Motorista não pode ser nulo.");
        if (veiculo == null) throw new NullPointerException("Veículo não pode ser nulo.");
        if (pagamento == null) throw new NullPointerException("Forma de pagamento não pode ser nula.");
        if (valor < 0) throw new IllegalArgumentException("Valor da corrida não pode ser negativo.");

        // regra simples: motorista precisa ter ao menos 1 veículo cadastrado
        if (motorista.getVeiculos() == null || motorista.getVeiculos().isEmpty()) {
            throw new IllegalStateException("Motorista não possui veículo cadastrado.");
        }

        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
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
        if (d < 0.0 || d > 5.0) throw new IllegalArgumentException("Avaliação deve estar entre 0 e 5.");
    	this.avaliacao = d; 
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    @Override
    public String toString() {
        return "\nHistorico de viagem: \n" +
                "- Origem = " + origem +"\n- Destino = " + destino+ "\n- Horario = " + horario + "\n- Passageiro = " + passageiro.getNome() +
                "\n- Motorista = " + motorista.getNome() + "\n- Veiculo = " + veiculo +"\n- Valor = R$" + valor +
                "\n- Forma de pagamento = " + pagamento +"\n- Avaliacao da corrida = " + avaliacao + "\n";
    }
    
    //padrao creator
    public static Viagens criarViagem(String origem, String destino, String horario, Passageiro passageiro, Motorista motorista,
    		Veiculo veiculo, Pagamento pagamento, double valor) {
    	return new Viagens(origem, destino, horario, passageiro, motorista, veiculo, pagamento, valor);
    	
    }
}


