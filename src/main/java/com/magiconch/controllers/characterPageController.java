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


    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        characterVBox.getChildren().clear();
        characters.clear();
        
        Provider.addMember(new Member("Reiner Braun", 185,95,9,7,7,10,8));
        Provider.addMember(new Member("Armin Arlert", 163,55,2,6,10,8,8));
        Provider.addMember(new Member("Annie Leonhart", 153,54,10,7,7,3,1));
        Provider.addMember(new Member("Bertholdt Hoover", 192,81,9,4,6,9,2));
        Provider.addMember(new Member("Jean Kristein", 175,65,9,8,7,5,9));
        Provider.addMember(new Member("Sasha Blouse", 165,55,6,3,5,6,7));
        Provider.addMember(new Member("Connie Springer", 158,58,6,7,3,7,5));
        Provider.addMember(new Member("Mikasa Ackerman", 170,68,10,9,8,6,7));
        Provider.addMember(new Member("Eren Yeager", 170,63,9,10,3,5,10));
        Provider.addMember(new Member("Historia Reiss", 145,42,4,8,7,6,5));
        Provider.addMember(new Member("Levi Ackerman", 160,65,12,12,7,8,8));
        Provider.addMember(new Member("Erwin Smith", 188,92,8,8,11,10,12));
        Provider.addMember(new Member("Hange Zoë", 170,60,9,9,12,7,11));  
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

                nodes[h].setOnMousePressed(evt -> {
                    //add code here when clicked
                });

                characterVBox.getChildren().add(nodes[j]);
                tempNode = tempNode.getNext();

            }
        } catch (IOException ex) {
            Logger.getLogger(wallLayersOverlayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void addNewChar(ActionEvent event) {
        myController.showPopupStage(characterScreen, "/com/magiconch/attackontitan/addNewCharacterOverlay.fxml");
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
