package com.magiconch.controllers;

import com.magiconch.backend.Provider;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class decipherPageController implements Initializable, ControlledScreen{
    
    @FXML
    private AnchorPane dechiperPane;

    @FXML
    private Button marleyToParadisButton;

    @FXML
    private Button paradisToMarleyButton;

    @FXML
    void toMarleyPage(ActionEvent event) {
        myController.showPopupStage(dechiperPane, "/com/magiconch/attackontitan/dechiperToMarley.fxml");
    }

    @FXML
    void toParadisPage(ActionEvent event) {
        myController.showPopupStage(dechiperPane, "/com/magiconch/attackontitan/dechiperToParadis.fxml");
    }
    
    @FXML
    void mychiperToParadisPage(ActionEvent event) {
        myController.showPopupStage(dechiperPane, "/com/magiconch/attackontitan/deMychiperToParadis.fxml");
    }
    
    ScreenController myController = new ScreenController();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
    
    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }

}
