package com.magiconch.controllers;

import com.magiconch.attackontitan.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
        
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/com/magiconch/attackontitan/characterPage.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(navBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        pageContainer.getChildren().removeAll();
        pageContainer.getChildren().setAll(fxml);
        
//        try {
//            changeScene(App.class.getResource("characterPage.fxml").toString());
//        } catch (IOException ex) {
//            Logger.getLogger(navBarController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
    @FXML
    private void goToCharacterPage(ActionEvent event) throws IOException{
        myController.loadScreen("characterPage", "/com/magiconch/attackontitan/characterPage.fxml");
        
        swapScreen("/com/magiconch/attackontitan/characterPage.fxml");
        
    }
    
    @FXML
    private void goToSearchPage(ActionEvent event) throws IOException{
//        myController.setScreen("searchPage");
        swapScreen("/com/magiconch/attackontitan/searchPage.fxml");
    }
    
        @FXML
    private void goToKillTitansPage(ActionEvent event) throws IOException{
//        myController.setScreen("killTitanPage");
        swapScreen("/com/magiconch/attackontitan/killTitansPage.fxml");
    }
    
    @FXML
    private void goToDecipherPage(ActionEvent event) throws IOException{
//        myController.setScreen("decipherPage");
        swapScreen("/com/magiconch/attackontitan/decipherPage.fxml");
    }
    
    @FXML
    private void goToScoutingPage(ActionEvent event) throws IOException{
//        myController.setScreen("scoutingPage");
        swapScreen("/com/magiconch/attackontitan/scoutingPage.fxml");
    }
    
    @FXML
    private void goToMariaWallPage(ActionEvent event) throws IOException{
//        myController.setScreen("mariaWallPage");
        swapScreen("/com/magiconch/attackontitan/mariaWallPageOne.fxml");
    }
    
    
    public void swapScreen(String fxmlfile)throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource(fxmlfile));
        pageContainer.getChildren().removeAll();
        pageContainer.getChildren().setAll(fxml);
    }
    
//    public void changeScene(String fxmlName) throws IOException{
//        Parent fxml = null;
//        fxml = FXMLLoader.load(getClass().getResource(fxmlName));
//        pageContainer.getChildren().removeAll();
//        pageContainer.getChildren().setAll(fxml);
//    }
    
}