package br.com.conversoronelauro.conversorone.ConversorMoeda;

public enum Moedas {
    REAL("Real"), DOLAR("Dólar"), PESO_ARG("Peso Argentino"), PESO_CHILENO("Peso Chileno"), LIBRA("Libras Esterlinas");

    public final String label;

    private Moedas(String label){
        this.label = label;
    }
    public String getLabel(){
        return this.label;
    }


}
