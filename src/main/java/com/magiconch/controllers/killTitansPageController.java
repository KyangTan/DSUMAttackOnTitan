package com.magiconch.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class killTitansPageController implements Initializable, ControlledScreen{

    @FXML
    private Button killButton;

    @FXML
    private TextField titansNumberTextBox;

    ScreenController myController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }

}
