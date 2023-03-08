package br.com.conversoronelauro.conversorone.ConversorMoeda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Scene2Controller implements Initializable {

    public void converterMoeda(ActionEvent event, String moedaOriginal, String moedaConversao, double valor) throws IOException {

    }

    @FXML
    private ChoiceBox<String> moedaConversao;

    @FXML
    private ChoiceBox<String> moedaOriginal;

    @FXML
    void getMoedaConversao(MouseEvent event) {

    }

    @FXML
    void getMoedaOriginal(ActionEvent event) {
        String selecionada = moedaOriginal.getValue();
        System.out.println(selecionada);
        var moeda = Moedas.MAPnome.get(selecionada);
        textoCifra.setText(moeda.getCifra());

    }
    @FXML
    private Text textoCifra;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Definindo valores e os valores default para a choicebox, a partir do ENUM das moedas
        var moedas = Arrays.stream(Moedas.values()).toList();


        moedas.forEach(moeda -> moedaOriginal.getItems().add(moeda.getNome()));
        moedaOriginal.setValue(Moedas.REAL.nome);

        moedas.forEach(moeda -> moedaConversao.getItems().add(moeda.getNome()));
        moedaConversao.setValue(Moedas.DOLAR.nome);


        //Chama o método que altera o texto da cifra do valor original para a seleção da moeda, assim facilitando
        // a visualização da conversão que será feita

        moedaOriginal.setOnAction(this::getMoedaOriginal);


    }
}