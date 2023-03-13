package br.com.conversoronelauro.conversorone.ConversorNumeros;

import static br.com.conversoronelauro.conversorone.ConversorNumeros.SistemasNumericos.DECIMAL;

public class CalculadoraSistemasNumericos {
    public static String calculaConversao(SistemasNumericos sistemaDe, SistemasNumericos sistemaPara, String valor){
        //Verifica se é uma conversão de decimal
        if(sistemaDe == DECIMAL){
            return calculaDeDecimal(sistemaPara, valor);
        }

        //Caso não seja uma conversão de decimal, precisa-se converter para decimal antes de fazer outra conversão
        String valorConvertidoParaDecimal = calculaParaDecimal(sistemaDe, valor);

        //Verfica se é uma conversão para decimal, ou se calcula o próximo valor
        if(sistemaPara == DECIMAL){
            return valorConvertidoParaDecimal;
        }
        else{
            return calculaDeDecimal(sistemaPara, valorConvertidoParaDecimal);
        }
    }
    //Converte valores para decimal
    public static String calculaParaDecimal(SistemasNumericos sistemaDe, String valor){
        switch (sistemaDe.toString()){
            case("BINARIO"):
                int valorResultado = Integer.parseInt(valor, 2);
                return Integer.toString(valorResultado);
            case("OCTAL"):
                valorResultado = Integer.parseInt(valor, 8);
                return Integer.toString(valorResultado);
            case("HEXADECIMAL"):
                valorResultado = Integer.parseInt(valor, 16);
                return Integer.toString(valorResultado);
        }
        return "Conversão incorreta";
    }
    //Converte valores de decimal
    public static String calculaDeDecimal(SistemasNumericos sistemaPara, String valor){
        int valorInt = Integer.parseInt(valor);
        switch (sistemaPara.toString()){
            case("BINARIO"):
                return Integer.toBinaryString(valorInt);
            case("OCTAL"):
                return Integer.toOctalString(valorInt);
            case("HEXADECIMAL"):
                return Integer.toHexString(valorInt);
        }
        return "Conversão incorreta";
    }
}
