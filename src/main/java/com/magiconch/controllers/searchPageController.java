package com.magiconch.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class searchPageController implements Initializable, ControlledScreen {

    @FXML
    private ImageView searchButton;

    @FXML
    private VBox searchCardVBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private ImageView sortingButton;
    
    ScreenController myController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }

}
