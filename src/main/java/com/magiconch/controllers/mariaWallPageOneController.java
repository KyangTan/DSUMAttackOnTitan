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
    
    int height;
    int width;
    List<wallComponentModel> wallLayers = new ArrayList<>();

    @FXML
    void input(ActionEvent event) {
        try {
            wallLayersVbox.getChildren().clear();
            wallLayers.clear();
            height = Integer.parseInt(wallHeightTextBox.getText());
            width = Integer.parseInt(wallWidthTextBox.getText());
        } catch (NumberFormatException e) {
            errorMsg.setVisible(true);
        }
        
        WallMaria wm = new WallMaria();
//        wm.loadWall();
        
        try {
            for (int j = 0; j < height; j++) {
                wallLayers.add(new wallComponentModel("Layer "+(j+1), ""+(j+1)));
                }
            Node[] nodes = new Node[height];

            for (int j = 0; j < nodes.length; j++) {
                FXMLLoader contentLoader = new FXMLLoader();
                contentLoader.setLocation(getClass().getResource("/com/magiconch/attackontitan/wallComponent.fxml"));
                nodes[j] = contentLoader.load();
                System.out.println("bruj");
                final int h = j;

                wallComponentControllers con = contentLoader.getController();
                con.setContentInfo(wallLayers.get(j).getLayerText(),wallLayers.get(j).getTextField());               

    //                nodes[h].setOnMouseEntered(evt -> {
    //                    //add effect
    //                    nodes[h].setStyle("-fx-background-color: #b4baca");
    //                });
    //                nodes[h].setOnMouseExited(evt -> {
    //                    //add effect
    //                    nodes[h].setStyle("-fx-background-color: transparent");
    //                });
    //                nodes[h].setOnMousePressed(evt -> {
    //                    //add effect
    //                });

                wallLayersVbox.getChildren().add(nodes[j]);

            }
        } catch (IOException ex) {
            Logger.getLogger(wallLayersOverlayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorMsg.setVisible(false);
    }
    
    @FXML
    void breakIt(ActionEvent event) {
        getTexts();
    }
    
    @FXML 
    void getTexts(){
        ObservableList<Node> childsVB = wallLayersVbox.getChildren();
        for (int i = 0; i < height; i++) {
            AnchorPane ap = (AnchorPane)childsVB.get(i);
            TextField tf = (TextField)ap.getChildren().get(2);
//            System.out.println(tf.getText());
            weakestAnsText.setText(tf.getText());
            //Later save in array to pass to another class
        }
    }

}