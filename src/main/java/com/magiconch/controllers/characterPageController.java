package com.magiconch.controllers;

import com.magiconch.backend.BGMPlayer;
import com.magiconch.backend.LinkedList;
import com.magiconch.backend.LinkedListNode;
import com.magiconch.backend.Member;
import com.magiconch.backend.Provider;
import com.magiconch.model.wallComponentModel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class characterPageController implements Initializable, ControlledScreen {
    
    @FXML
    private AnchorPane characterScreen;
    
    @FXML
    private AnchorPane scollAPane;
    
    @FXML
    private ToggleButton bgmToggleButton;
    
    @FXML
    private Button addNewCharButton;

    @FXML
    private VBox characterVBox;
    
    @FXML
    private ScrollPane scroll;
    
    ScreenController myController = new ScreenController();
    private static List<Member> characters = new ArrayList<>();
    LinkedListNode<Member> tempNode = new LinkedListNode<>();
    ScreenController displayScreenController = new ScreenController();

    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        renderCharacterBoxes();
    }
    
    @FXML
    void addNewChar(ActionEvent event) throws IOException {
        myController.showPopupStage(characterScreen, "/com/magiconch/attackontitan/addNewCharacterOverlay.fxml");
        renderCharacterBoxes();
    }
    
    public void renderCharacterBoxes(){
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        characterVBox.getChildren().clear();
        characters.clear();
        
        
        tempNode = Provider.getMemberList().getHead();
        
        int boxHeight = Provider.getMemberList().getSize()*95 +20;
        scollAPane.setPrefHeight(boxHeight);
        characterVBox.setPrefHeight(boxHeight);
        try {
            Node[] nodes = new Node[Provider.getMemberList().getSize()];

            for (int j = 0; j < nodes.length; j++) {
                FXMLLoader contentLoader = new FXMLLoader();
                contentLoader.setLocation(getClass().getResource("/com/magiconch/attackontitan/characterCard.fxml"));
                nodes[j] = contentLoader.load();
                final int h = j;
                characterCardComponentController charController = contentLoader.getController();
                charController.setContentInfo("", tempNode.getData().getName(), j);               
                    Provider.setCurrentI(h);
                    final String name = "Page " + Provider.getCurrentI();
                    System.out.println("added :" + Provider.getCurrentI());
                    displayScreenController.loadScreen(name, "/com/magiconch/attackontitan/characterDetailsViewPage.fxml");
                
//                System.out.println(displayScreenController.getScreen(name) + " \n\n\n\n\nasdfsadfasdfasdfsa");
                nodes[h].setOnMousePressed(evt -> {
                    //add code here when clicked
                    myController.showPopupStage(characterScreen, name, displayScreenController);
                });

                characterVBox.getChildren().add(nodes[j]);
                tempNode = tempNode.getNext();

            }
        } catch (IOException ex) {
            Logger.getLogger(wallLayersOverlayController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
