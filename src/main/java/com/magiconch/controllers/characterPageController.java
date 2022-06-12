package com.magiconch.controllers;

import com.magiconch.backend.BGMPlayer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class characterPageController implements Initializable, ControlledScreen {
    @FXML
    private ImageView SettingButton;

    @FXML
    private ImageView addCharacterIconButton;

    @FXML
    private Text addCharacterTextButton;

    @FXML
    private ToggleButton bgmToggleButton;
    
    @FXML
    private VBox characterVBox;
    
    ScreenController myController;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }
    
    @FXML
    public void toggleBGM(ActionEvent event) throws IOException{
        BGMPlayer.togglePlayer();
    }
}
