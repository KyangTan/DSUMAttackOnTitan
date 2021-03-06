package com.magiconch.controllers;

import static com.magiconch.backend.CipherClass.myDecrypt;
import static com.magiconch.backend.MarleyClass.marleyToParadis;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class deMychiperToParadisController implements Initializable, ControlledScreen{

    @FXML
    private Button backButton;

    @FXML
    private TextField marleyOutputTextBox;

    @FXML
    private TextField paradisSentenceTextbox;

    @FXML
    private Button toParadisButton;
    
    ScreenController myController = new ScreenController();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
    
    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    void back(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toParadisSentence(ActionEvent event) {
        marleyOutputTextBox.setText(marleyToParadis(myDecrypt(paradisSentenceTextbox.getText())));
    }

}
