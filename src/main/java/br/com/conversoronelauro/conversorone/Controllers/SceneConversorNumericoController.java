package br.com.conversoronelauro.conversorone.Controllers;

import br.com.conversoronelauro.conversorone.ConversorNumeros.CalculadoraSistemasNumericos;
import br.com.conversoronelauro.conversorone.ConversorNumeros.SistemasNumericos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private TextField textoValor;
    @FXML
    private TextField textoResultado;

    @FXML
    void converter(ActionEvent event) throws IOException {
        //Puxar seleção das choicebox utilizando o Hashmap declarado na classe ENUM
        var sistemaDe = SistemasNumericos.MAPnome.get(choiceBoxSistemaOriginal.getValue());
        var sistemaPara = SistemasNumericos.MAPnome.get(choiceBoxSistemaPara.getValue());
        //Chama resultado e altera o textfield dinâmicamente
        String resultado = CalculadoraSistemasNumericos.calculaConversao(sistemaDe, sistemaPara, textoValor.getText());
        textoResultado.setText(resultado);

    }

    @FXML
    void inverteSelecao(ActionEvent event){
        //Inverte seleções de texto e choicebox
        String de = choiceBoxSistemaOriginal.getValue();
        String para = choiceBoxSistemaPara.getValue();
        String valor = textoValor.getText();
        String resultado = textoResultado.getText();
        textoResultado.setText(valor);
        textoValor.setText(resultado);
        choiceBoxSistemaOriginal.setValue(para);
        choiceBoxSistemaPara.setValue(de);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var sistemas = Arrays.stream(SistemasNumericos.values()).toList();

        //Popula as choicebox quando carregado
        sistemas.forEach(sistema -> choiceBoxSistemaOriginal.getItems().add(sistema.getNome()));
        choiceBoxSistemaOriginal.setValue(SistemasNumericos.DECIMAL.getNome());
        sistemas.forEach(sistema -> choiceBoxSistemaPara.getItems().add(sistema.getNome()));
        choiceBoxSistemaPara.setValue((SistemasNumericos.BINARIO.getNome()));
    }

    @FXML
    void chamaCena1(ActionEvent event) throws IOException {
        //Carrega menu principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/conversoronelauro/conversorone/scene1.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Conversor One");
        stage.show();
    }
    @FXML
    void fechaPrograma(ActionEvent event) {
        //Finaliza programa
        Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
        dialogoErro.setTitle("Message");
        dialogoErro.setHeaderText(null);
        dialogoErro.setContentText("Programa Finalizado");
        dialogoErro.showAndWait();
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
}
