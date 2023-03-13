package br.com.conversoronelauro.conversorone.ConversorNumeros;

import java.util.HashMap;

public enum SistemasNumericos {
    DECIMAL("Decimal"), HEXADECIMAL("Hexadecimal"), OCTAL("Octal"), BINARIO("Binário");

    public static final HashMap<String, SistemasNumericos> MAPnome = new HashMap<String, SistemasNumericos>();
    private String nome;

    SistemasNumericos(String label) {
        this.nome = label;
    }

    public String getNome() {
        return this.nome;
    }

    static {
        for (SistemasNumericos field : SistemasNumericos.values()) {
            MAPnome.put(field.getNome(), field);
        }
    }
}

