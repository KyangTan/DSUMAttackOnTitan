package com.magiconch.controllers;

import com.magiconch.attackontitan.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class navBarController implements Initializable, ControlledScreen{
    
    @FXML
    private ToggleButton ScoutingPageToggleButton;

    @FXML
    private AnchorPane characterPage;

    @FXML
    private ToggleButton characterPageToggleButton;

    @FXML
    private ToggleButton decipherPageToggleButton;

    @FXML
    private ToggleButton killPageToggleButton;

    @FXML
    private StackPane pageContainer;

    @FXML
    private ToggleButton searchPageToggleButton;

    @FXML
    private ToggleButton wallPageToggleButton;
    
    ScreenController myController;
    
    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        characterPageToggleButton.setFocusTraversable(true);
        characterPageToggleButton.requestFocus();
        
//        try {
//            changeScene(App.class.getResource("characterPage.fxml").toString());
//        } catch (IOException ex) {
//            Logger.getLogger(navBarController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
    public void changeScene(String fxmlName) throws IOException{
        Parent fxml = null;
        fxml = FXMLLoader.load(getClass().getResource(fxmlName));
        pageContainer.getChildren().removeAll();
        pageContainer.getChildren().setAll(fxml);
    }
    
}