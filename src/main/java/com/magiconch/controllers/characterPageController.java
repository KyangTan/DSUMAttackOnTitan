package com.magiconch.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class characterPageController implements Initializable {
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
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
