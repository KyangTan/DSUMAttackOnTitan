package com.magiconch.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import com.magiconch.model.wallComponentModel;
import javafx.scene.layout.AnchorPane;

public class mariaWallPageController implements Initializable, ControlledScreen{

    @FXML
    private Button breakItButton;

    @FXML
    private TextField wallLayersTextbox;
    
    @FXML
    private Text errorMsg;
    
    @FXML
    private AnchorPane mariaScreen;

    ScreenController myController = new ScreenController();
    private int layersNo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorMsg.setVisible(false);
    }

    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; 
    }
    
    public void breakIt(ActionEvent e){
        try {
            errorMsg.setVisible(false);
            layersNo = Integer.parseInt(wallLayersTextbox.getText());
            System.out.println("Previous Page LayersNo " + layersNo);
            myController.showPopupStage(mariaScreen, "/src/main/resources/com/magiconch/attackontitan/wallLayersOverlay.fxml");
            //myController.showPopupStage(mariaScreen, "/com/magiconch/attackontitan/wallLayersOverlay.fxml");
                       
        } catch (NumberFormatException error) {
            errorMsg.setVisible(true);
        }
    }

    public int getLayersNo() {
        return layersNo;
    }

}
