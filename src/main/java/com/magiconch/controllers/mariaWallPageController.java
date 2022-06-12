package com.magiconch.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class mariaWallPageController implements Initializable, ControlledScreen{

    @FXML
    private Button breakItButton;

    @FXML
    private TextField wallLayersTextbox;

    ScreenController myController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }

}
