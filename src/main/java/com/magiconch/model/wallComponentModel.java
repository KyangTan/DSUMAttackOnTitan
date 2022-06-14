/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.model;
/**
 *
 * @author Ming
 */
public class wallComponentModel {
    
    private String layerText;
    private String textField;

    public wallComponentModel(String layerText, String textField) {
        this.layerText = layerText;
        this.textField = textField;
    }

    public String getLayerText() {
        return layerText;
    }

    public String getTextField() {
        return textField;
    }

}
