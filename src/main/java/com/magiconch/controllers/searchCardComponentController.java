package com.magiconch.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class searchCardComponentController {

    @FXML
    private ImageView charEyeImage;

    @FXML
    private Text charNameText;

    @FXML
    private Text charDescText;

    public void setContentInfo(String imagePath, String charName, String desc){
//        this.charImage.setImage(imagePath);
        this.charNameText.setText(charName);
        this.charDescText.setText(desc);
        
    }
    
}
