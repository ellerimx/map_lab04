package main;

public class Veiculo {

    private String placa;
    private String modelo;

    public Veiculo(String placa, String modelo) {
        if (placa == null || placa.isBlank()) throw new IllegalArgumentException("Placa do veículo é obrigatória.");
        if (modelo == null || modelo.isBlank()) throw new IllegalArgumentException("Modelo do veículo é obrigatório.");
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }


    @Override
    public String toString() {
        return modelo + " (" + placa + ")";
    }
    
    //padrao creator
    public static Veiculo addVeiculo(String placa, String modelo) {
        if (placa == null || placa.isBlank()) throw new IllegalArgumentException("Placa do veículo é obrigatória.");
        if (modelo == null || modelo.isBlank()) throw new IllegalArgumentException("Modelo do veículo é obrigatório.");
    	return new Veiculo(placa, modelo);
    }
}

