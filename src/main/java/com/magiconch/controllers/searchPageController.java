package com.magiconch.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class searchPageController implements Initializable, ControlledScreen {

    @FXML
    private TableColumn<?, ?> charAbiCol;

    @FXML
    private TableColumn<?, ?> charCoorCol;

    @FXML
    private TableColumn<?, ?> charHeightCol;

    @FXML
    private TableColumn<?, ?> charIntCol;

    @FXML
    private TableColumn<?, ?> charLeadCol;

    @FXML
    private TableColumn<?, ?> charNameCol;

    @FXML
    private TableColumn<?, ?> charStrCol;

    @FXML
    private TableView<?> charTable;

    @FXML
    private TableColumn<?, ?> charWeightCol;

    @FXML
    private TextField searchTextField;

    
    ScreenController myController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }

}
