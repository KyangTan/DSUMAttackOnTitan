package com.magiconch.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author Ming
 */
public class decipherPageController implements Initializable{
    @FXML
    private TextField InputTextbox;

    @FXML
    private Text outputText;

    @FXML
    private Button translateButton;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
