package com.magiconch.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class messageOverlayController {

    @FXML
    private Text messageText;

    @FXML
    private Button returnButton;
    
    messageOverlayController(String msg){
        messageText.setText(msg);
    }
    
    @FXML
    void returnHome(ActionEvent event) {
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
    }

}
