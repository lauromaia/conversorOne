package br.com.conversoronelauro.conversorone.ConversorMoeda.Controllers;

import br.com.conversoronelauro.conversorone.ConversorMoeda.CalculadoraMoedas;
import br.com.conversoronelauro.conversorone.ConversorMoeda.Moedas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Scene2Controller implements Initializable {

    @FXML
    private ChoiceBox<String> moedaConversao;

    @FXML
    private ChoiceBox<String> moedaOriginal;

    @FXML
    private Text textoCifra;

    @FXML
    private TextField textValor;

    @FXML
    private Button botaoConverter;
    @FXML
    void getMoedaOriginal(ActionEvent event) {
        String selecionada = moedaOriginal.getValue();
        var moeda = Moedas.MAPnome.get(selecionada);
        textoCifra.setText(moeda.getCifra());
    }

    @FXML
    public void converter(ActionEvent event) throws IOException {
        var moedaIni = Moedas.MAPnome.get(moedaOriginal.getValue());
        var moedaCon = Moedas.MAPnome.get(moedaConversao.getValue());
        String valor = textValor.getText();

        System.out.println(CalculadoraMoedas.calculaConversao(moedaIni.toString(), moedaCon.toString(), valor));
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Definindo valores e os valores default para a choicebox, a partir do ENUM das moedas
        var moedas = Arrays.stream(Moedas.values()).toList();


        moedas.forEach(moeda -> moedaOriginal.getItems().add(moeda.getNome()));
        moedaOriginal.setValue(Moedas.BRL.nome);

        moedas.forEach(moeda -> moedaConversao.getItems().add(moeda.getNome()));
        moedaConversao.setValue(Moedas.USD.nome);


        //Chama o método que altera o texto da cifra do valor original para a seleção da moeda, assim facilitando
        // a visualização da conversão que será feita

        moedaOriginal.setOnAction(this::getMoedaOriginal);


    }
}