package com.magiconch.controllers;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class wallLayersOverlayController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private VBox wallLayersVbox;

    @FXML
    private Text weakestAnsText;
    
    List<wallComponentModel> wallLayers = new ArrayList<>();
    int layersNo = 0;

    private boolean showing = false;
    private int number =0;
    
    public wallLayersOverlayController(int number) {
        this.number = number;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        //Get layersNo inputed in las fxml
        System.out.println("Starting new page");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/src/main/resources/com/magiconch/attackontitan/mariaWallPage.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(wallLayersOverlayController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mariaWallPageController controller = loader.getController();
        layersNo = number;
        System.out.println("After Page LayersNo " + layersNo);

        
        //Dynamically import fxml file to import 
        try {
            for (int j = 0; j < layersNo; j++) {
                wallLayers.add(new wallComponentModel("Layer "+j, ""+j));
            }
            Node[] nodes = new Node[layersNo];

            for (int j = 0; j < nodes.length; j++) {
                FXMLLoader contentLoader = new FXMLLoader();
                contentLoader.setLocation(getClass().getResource("/src/main/resources/com/magiconch/attackontitan/wallComponent.fxml"));
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
    
    public void back(ActionEvent event) {
        //Cancel button to back to login page
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
    
    public void popOut(AnchorPane screen, String resource){
     if (showing) {
            return;
        }
        else if (!showing){
            try {
                BoxBlur boxBlur = new BoxBlur();
                boxBlur.setWidth(10);
                boxBlur.setHeight(10);
                boxBlur.setIterations(3);
                screen.setEffect(boxBlur);
//                setShowing(true);
showing = true;
                System.out.println(showing);
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(resource));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                
                stage.setScene(new Scene(root));
                stage.setAlwaysOnTop(true);
                stage.showAndWait();
                //setShowing(false);
                showing = false;
                if (!showing) {
                    screen.setEffect(null);
                }
                
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
