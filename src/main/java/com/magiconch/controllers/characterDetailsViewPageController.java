package com.magiconch.controllers;

import com.magiconch.backend.LinkedListNode;
import com.magiconch.backend.Member;
import com.magiconch.backend.Provider;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class characterDetailsViewPageController implements Initializable, ControlledScreen{

    @FXML
    private Button backButton;

    @FXML
    private Text charDescText;

    @FXML
    private ImageView charFullImage;

    @FXML
    private Text charInfoText;

    @FXML
    private Text charNameText;

    @FXML
    private Text counterButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button previousButton;
    
    ScreenController characterDetailsViewPageController = new ScreenController();
    
    LinkedListNode<Member> tempNode = new LinkedListNode<>();
    int index = Provider.getCurrentI();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println("after: " + index);
        tempNode = Provider.getMemberList().getHead();
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();
        }
//        System.out.println(tempNode.getData().toString());
        setContent();
    }
    
    public void setContent(){
        charNameText.setText(tempNode.getData().getName());
        setAttr();
        charDescText.setText(tempNode.getData().getName() + " was a former member of the Survey Corps. He was the main protagonist of Attack on Titan. He lived in Shiganshina District with his parents until the fall of Wall Maria, where he impotently witnessed his mother being eaten by a Titan. This event would lead to Eren's intense hatred towards the Titans as he swore to wipe all of them off the face of the Earth.\n");
    }
    
    public void setAttr(){
        String attr = "Height: " + tempNode.getData().getHeight() + 
                    "\nWeight: " + tempNode.getData().getWeight() +
                    "\nStrength: " + tempNode.getData().getStrength() +
                    "\nAgility: " + tempNode.getData().getAgility() +
                    "\nIntelligence: " + tempNode.getData().getIntelligence() +
                    "\nCoordination: " + tempNode.getData().getCoordination() +
                    "\nLeadership: " + tempNode.getData().getLeadership();
        charInfoText.setText(attr);
        counterButton.setText((index+1)+"/"+Provider.getMemberList().getSize());
    }
    
    @FXML
    public void back(ActionEvent event) {
        //Cancel button to back to login page
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void nextChar(ActionEvent event) {
        characterDetailsViewPageController.setScreen("Page " + (index+1));
    }
    
    @FXML
    public void prevChar(ActionEvent event) {
        characterDetailsViewPageController.setScreen("Page " + (index-1));
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        characterDetailsViewPageController = screenPage;
    }
}
