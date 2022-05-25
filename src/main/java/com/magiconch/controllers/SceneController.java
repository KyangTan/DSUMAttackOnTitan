/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.controllers;
import com.magiconch.attackontitan.App;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneController {

    private Scene scene;
    private static Stage primaryStage;
    private final double WIDTH;
    private final double HEIGHT;
    private final double PREF_WIDTH = 1280;
    private final double PREF_HEIGHT = 720;

    public SceneController() {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        this.WIDTH = screenBounds.getWidth();
        this.HEIGHT = screenBounds.getHeight();
    }

    public static void setPrimaryStage(Stage primaryStage) {
        SceneController.primaryStage = primaryStage;
    }

    public static Stage showPopUpStage(String fxmlFile) {
        Parent root;

        try {
            root = FXMLLoader.load(App.class.getResource(fxmlFile));
            
            Scene scene = new Scene(root);
            Stage popupStage = new Stage();

            popupStage.initOwner(SceneController.primaryStage);
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.setResizable(false);

            return popupStage;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource(fxmlFile));
       
        scene = new Scene(root, PREF_WIDTH, PREF_HEIGHT);
        SceneController.primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        SceneController.primaryStage.show();
    }
    
    private void switchScene(MouseEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource(fxmlFile));
        
        scene = new Scene(root, PREF_WIDTH, PREF_HEIGHT);
        SceneController.primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        SceneController.primaryStage.show();

    }

    public void switchToScoutingScene(ActionEvent event) throws IOException {
        switchScene(event, "characterPage.fxml");
    }

    public void switchToScoutingScene(MouseEvent event) throws IOException {
        switchScene(event, "characterPage.fxml");
    }

    public static void closeSplashStage() {
        Stage newPrimary = new Stage();
        newPrimary.initStyle(StageStyle.DECORATED);
        newPrimary.setOnHiding(e -> Platform.exit());
        newPrimary.getIcons().add(new Image(App.class.getResource("assets/company/logo2.png").toString()));
        newPrimary.setTitle("War on Titan");
        newPrimary.setResizable(false);
        newPrimary.centerOnScreen();
        SceneController.primaryStage.hide();
        primaryStage = newPrimary;
    }

}
