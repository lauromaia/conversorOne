package br.com.conversoronelauro.conversorone.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene3Controller{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Text textoResultado;


    @FXML
    void voltaSceneAnterior(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/conversoronelauro/conversorone/scene2.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Calculadora de Moedas");
        stage.show();
    }
    @FXML
    void fechaPrograma(ActionEvent event) {
        Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
        dialogoErro.setTitle("Message");
        dialogoErro.setHeaderText(null);
        dialogoErro.setContentText("Programa Finalizado");
        dialogoErro.showAndWait();
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
    public void mostraTextoResultado(String texto){
        textoResultado.setText(texto);
    }

}
