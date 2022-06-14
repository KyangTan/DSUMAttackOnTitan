/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class wallComponentControllers {

    @FXML
    private TextField textfield;

    @FXML
    private Text wallText;
    
    public void setContentInfo(String wallText, String textFieldId){
        this.wallText.setText(wallText);
        this.textfield.setId(textFieldId);
        this.textfield.setPromptText(wallText);
    }
    
    

}
