package br.com.conversoronelauro.conversorone.Controllers;

import br.com.conversoronelauro.conversorone.ConversorNumeros.SistemasNumericos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class SceneConversorNumericoController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private ChoiceBox<String> choiceBoxSistemaOriginal;

    @FXML
    private ChoiceBox<String> choiceBoxSistemaPara;

    @FXML
    private TextField textValor;

    @FXML
    private TextField textoResultado;

    @FXML
    void converter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/conversoronelauro/conversorone/scene1.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Erro");
        stage.show();
    }

    @FXML
    void inverteSelecao(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var sistemas = Arrays.stream(SistemasNumericos.values()).toList();

        //Popula as choicebox quando carregado
        sistemas.forEach(sistema -> choiceBoxSistemaOriginal.getItems().add(sistema.getLabel()));
        sistemas.forEach(sistema -> choiceBoxSistemaPara.getItems().add(sistema.getLabel()));


    }

    @FXML
    void chamaCena1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/conversoronelauro/conversorone/scene1.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Erro");
        stage.show();
    }
}
