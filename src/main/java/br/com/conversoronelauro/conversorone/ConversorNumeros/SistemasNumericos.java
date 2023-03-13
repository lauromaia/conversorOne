package br.com.conversoronelauro.conversorone.ConversorNumeros;

public enum SistemasNumericos {
    DECIMAL("Decimal"), HEXADECIMAL("Hexadecimal"), OCTAL("Octal"), BINARIO("Binário");

    private String label;

    SistemasNumericos(String label) {
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
