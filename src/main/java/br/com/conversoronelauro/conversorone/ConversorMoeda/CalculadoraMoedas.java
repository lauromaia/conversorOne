package br.com.conversoronelauro.conversorone.ConversorMoeda;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;

public class CalculadoraMoedas {
    public static String calculaConversao(String moedaInicial, String moedaFinal, String valor) throws IOException {

        //Key da API para a consulta da conversão
        final String apiKey = "X9ON1vcQK09L01N0evFgQetQXwbXM6jQ";

        //URL do endpoint da API
        final String apiURL = "https://api.apilayer.com/exchangerates_data/convert?to="
        + moedaFinal + "&from=" + moedaInicial + "&amount=" + valor;

        //Requisição
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("apikey", apiKey);

        //Checa se a requisição foi bem sucedida antes de continuar com a lógica
        int responseCode = con.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK) {
            //Leitura da requisição
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            //Parse do JSON e retorno do valor obtido
            JSONObject jsonObject = new JSONObject(response.toString());
            String valorResultado = jsonObject.getBigDecimal("result").
                    setScale(2, RoundingMode.HALF_UP)
                    .toPlainString();

            //Formatação do resultado e do valor original para a resposta
            var moedaResultado = Moedas.valueOf(moedaFinal);
            var moedaOriginal = Moedas.valueOf(moedaInicial);
            String inicial = moedaOriginal.getCifra() + valor;
            String resultado = moedaResultado.getCifra() + valorResultado;

            return inicial + " equivale a: " + resultado;
        }
        else {
            return "Requisição falhou!";
        }




    }
}
