package br.com.conversoronelauro.conversorone.ConversorMoeda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;

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
    void getMoedaOriginal(MouseEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var moedas = Arrays.stream(Moedas.values()).toList();
        moedas.forEach(moeda -> moedaOriginal.getItems().add(moeda.getLabel()));
        moedas.forEach(moeda -> moedaConversao.getItems().add(moeda.getLabel()));


    }
}