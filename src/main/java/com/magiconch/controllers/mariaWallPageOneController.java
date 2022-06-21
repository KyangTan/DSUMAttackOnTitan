/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.controllers;

import com.magiconch.backend.WallMaria;
import com.magiconch.model.wallComponentModel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class mariaWallPageOneController implements Initializable {

    @FXML
    private Button breakItButton;

    @FXML
    private Button inputButton;

    @FXML
    private TextField wallHeightTextBox;
    
    @FXML
    private TextField wallWidthTextBox;

    @FXML
    private AnchorPane mariaScreen;

    @FXML
    private VBox wallLayersVbox;
    
    @FXML
    private Text errorMsg;
    
    @FXML
    private Text weakestAnsText;
    
    @FXML
    private ScrollPane scroll;

    @FXML
    private AnchorPane scrollAPane;
    
    @FXML
    private Button randomWallButton;
    
    @FXML
    private Text wallText;
    
    int height;
    int width;
    List<wallComponentModel> wallLayers = new ArrayList<>();
    WallMaria wall = new WallMaria();
    
    int whichButtonClicked = -1;


    @FXML
    void input(ActionEvent event) {
        whichButtonClicked = 1;
        getWidthHeight();
        
        wall.loadWall(height, width);
        
        
        scrollAPane.setPrefHeight(height*50);
        wallLayersVbox.setPrefHeight(height*50);
        
        try {
            for (int j = 0; j < height; j++) {
                wallLayers.add(new wallComponentModel("Layer "+(j+1), ""+(j+1)));
                }
            Node[] nodes = new Node[height];

            for (int j = 0; j < nodes.length; j++) {
                FXMLLoader contentLoader = new FXMLLoader();
                contentLoader.setLocation(getClass().getResource("/com/magiconch/attackontitan/wallComponent.fxml"));
                nodes[j] = contentLoader.load();
                final int h = j;

                wallComponentControllers con = contentLoader.getController();
                con.setContentInfo(wallLayers.get(j).getLayerText(),wallLayers.get(j).getTextField());               

                wallLayersVbox.getChildren().add(nodes[j]);

            }
        } catch (IOException ex) {
            Logger.getLogger(wallLayersOverlayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorMsg.setVisible(false);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }
    
    @FXML
    void breakIt(ActionEvent event) {
        if (whichButtonClicked == 1) {
            getTexts();
        }else{
            
        }
        wall.printWall();
        System.out.println("the weakest part of the wall is at position: " + wall.weakestPart());
        weakestAnsText.setText("the weakest part of the wall is at position: " + wall.weakestPart());
        whichButtonClicked = -1;
    }
    
    @FXML 
    void getTexts(){
        System.out.println("Get text here");
        ObservableList<Node> childsVB = wallLayersVbox.getChildren();
        for (int i = 0; i < height; i++) {
            AnchorPane ap = (AnchorPane)childsVB.get(i);
            TextField tf = (TextField)ap.getChildren().get(2);
            System.out.println(tf.getText());
            wall.insertEdges(tf.getText());
            weakestAnsText.setText(tf.getText());
            //Later save in array to pass to another class
        }
        System.out.println("End");
        wall.printWall();
    }
    
    @FXML
    void randomWall(){
        wall.cleanWall();
        whichButtonClicked = 2;
        getWidthHeight();
        
        wall.loadWall(height, width);
        wallText.setText(wall.randomWallOut());
    }
    
    void getWidthHeight(){
        try {
            wallLayersVbox.getChildren().clear();
            wallLayers.clear();
            height = Integer.parseInt(wallHeightTextBox.getText());
            width = Integer.parseInt(wallWidthTextBox.getText());
        } catch (NumberFormatException e) {
            errorMsg.setVisible(true);
        }
    }

}