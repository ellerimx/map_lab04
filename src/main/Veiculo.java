package main;

public class Veiculo {
    private String placa;
    private String modelo;

    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return modelo + " (" + placa + ")";
    }
    
    //padrao creator
    public static Veiculo addVeiculo(String placa, String modelo) {
    	return new Veiculo(placa, modelo);
    }
}

