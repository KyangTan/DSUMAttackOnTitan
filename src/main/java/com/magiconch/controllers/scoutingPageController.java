package com.magiconch.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class scoutingPageController implements Initializable, ControlledScreen {

    @FXML
    private Text cliOutputText;

    @FXML
    private Button scoutButton;

    ScreenController myController;
    
    @FXML
    void scout(ActionEvent event) {

    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }

}
