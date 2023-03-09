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

        int responseCode = con.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK) { //Checa se a requisição foi bem sucedida antes de continuar com a lógica
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            String resultado = jsonObject.getBigDecimal("result").
                    setScale(2, RoundingMode.HALF_UP)
                    .toPlainString();
            return resultado;
        }
        else {
            return "Requisição falhou!";
        }




    }
}
