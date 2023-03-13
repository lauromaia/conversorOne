package br.com.conversoronelauro.conversorone.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Scene1Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String pathNextScene;
    @FXML
    private AnchorPane scenePane;

    @FXML
    private ChoiceBox<String> choiceBoxConversor;
    private String[] listaConversores = {"Conversor de Moedas", "Conversor de Sistemas Numéricos"};



    public void proximaScene(ActionEvent event) throws IOException {
        if(choiceBoxConversor.getValue() == "Conversor de Moedas") {
            pathNextScene = "/br/com/conversoronelauro/conversorone/scene2.fxml";
        } else if(choiceBoxConversor.getValue() == "Conversor de Sistemas Numéricos") {
                pathNextScene = "/br/com/conversoronelauro/conversorone/sceneConversorNumerico.fxml";
            }
            FXMLLoader loaderConversorMoedas = new FXMLLoader(getClass().getResource(pathNextScene));
            root = loaderConversorMoedas.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Conversor de Moedas");
            stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxConversor.getItems().addAll(listaConversores);
    }

    @FXML
    void fechaPrograma(ActionEvent event) {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

}
