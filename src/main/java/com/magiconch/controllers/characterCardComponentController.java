package com.magiconch.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class characterCardComponentController {

    @FXML
    private ImageView charImage;

    @FXML
    private Text charNameText;
    
    @FXML
    private Button charButton;

    private int charId;
    
    public void setContentInfo(String imagePath, String charName, int id){
//        this.charImage.setImage(imagePath);
        this.charNameText.setText(charName);
        this.charId = id;
    }

}
