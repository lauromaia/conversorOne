package br.com.conversoronelauro.conversorone.ConversorMoeda;

import java.util.HashMap;

public enum Moedas {
    REAL("Real", "R$"), DOLAR("Dólar", "US$"), PESO_ARG("Peso Argentino", "$"),
    PESO_CHILENO("Peso Chileno", "CLP$"), LIBRA("Libras Esterlinas", "£");

    public final String nome;
    public final String cifra;
    public static final HashMap<String, Moedas> MAPcifras = new HashMap<String, Moedas>();
    public static final HashMap<String, Moedas> MAPnome = new HashMap<String, Moedas>();
    private Moedas(String label, String cifrao){
        this.nome = label;
        this.cifra = cifrao;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCifra(){
        return this.cifra;
    }

    static {
        for(Moedas field: Moedas.values()){
            MAPcifras.put(field.getCifra(), field);
        }
    }
    static {
        for(Moedas field: Moedas.values()){
            MAPnome.put(field.getNome(), field);
        }
    }





}
