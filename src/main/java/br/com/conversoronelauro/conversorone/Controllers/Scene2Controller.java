package br.com.conversoronelauro.conversorone.Controllers;

import br.com.conversoronelauro.conversorone.ConversorMoeda.CalculadoraMoedas;
import br.com.conversoronelauro.conversorone.ConversorMoeda.Moedas;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Scene2Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> moedaConversao;

    @FXML
    private ChoiceBox<String> moedaOriginal;

    @FXML
    private Text textoCifra;

    @FXML
    private TextField textValor;

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
        //Verifica se foi colocado um valor correto para conversão, se não, chama cena de erro.
        if(valor.isEmpty()){
            chamaCenaError(event);
        }else {
            //Chama resultado na classe encapsulada com as informações preenchidas
            String textoResultado = CalculadoraMoedas.calculaConversao(moedaIni.toString(), moedaCon.toString(), valor);

            //Cria uma instância da próxima cena para passar o resultado obtido e chama a cena
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/conversoronelauro/conversorone/scene3.fxml"));
            root = loader.load();

            Scene3Controller scene3Controller = loader.getController();
            scene3Controller.mostraTextoResultado(textoResultado);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Conversor de Moedas");
            stage.show();
        }
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


    private void chamaCenaError(ActionEvent event){
        Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
        dialogoErro.setTitle("Erro");
        dialogoErro.setHeaderText("Deve inserir um valor válido!");
        dialogoErro.showAndWait();
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