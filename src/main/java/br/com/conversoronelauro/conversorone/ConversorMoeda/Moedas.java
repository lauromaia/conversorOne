package br.com.conversoronelauro.conversorone.ConversorMoeda;

import java.util.HashMap;

public enum Moedas {
    BRL("Real", "R$"), USD("Dólar", "US$"), ARS("Peso Argentino", "$"),
    CLP("Peso Chileno", "CLP$"), GBP("Libras Esterlinas", "£");

    public final String nome;
    public final String cifra;
    public static final HashMap<String, Moedas> MAPcifras = new HashMap<String, Moedas>();
    public static final HashMap<String, Moedas> MAPnome = new HashMap<String, Moedas>();
    Moedas(String label, String cifrao){
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
