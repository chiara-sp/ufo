package it.polito.tdp.ufo;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.ufo.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxForma;

    @FXML
    private Button btnConta;
    
    @FXML
    private TextField txtMessaggio;

    @FXML
    void handleConta(ActionEvent event) {

    	String forma = boxForma.getValue();
    	int count = model.getCountByForma(forma);
    	txtMessaggio.setText("Gli UFO della forma "+forma+" sono: "+count);
    }
    public void setModel(Model m) {
    	this.model = m ;
    	boxForma.getItems().addAll(model.getFormeUFO());
    	//boxForma.getItems().addAll(this.model.getFormeUFO()) ;
    }

    @FXML
    void initialize() {
        assert boxForma != null : "fx:id=\"boxForma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnConta != null : "fx:id=\"btnConta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMessaggio != null : "fx:id=\"txtMessaggio\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
