/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.controllers;

import com.magiconch.backend.BGMPlayer;
import com.magiconch.backend.LinkedList;
import com.magiconch.backend.Music;
import com.magiconch.utility.fileReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 *
 * @author WeiXin
 */
public class characterController implements Initializable {

    @FXML
    private ImageView tempPlayButton;

    @FXML
    public void playBGM() {
        System.out.println("hi");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        String jsonString = fileReader.readFile("C:/Users/User/Documents/Git Netbeans/attackontitan/src/main/resources/com/magiconch/attackontitan/json/bgmList.json");
//        LinkedList<Music> queue = fileReader.getBGMQueueFromJSON(jsonString);
//        BGMPlayer.initPlayer(queue);
//        BGMPlayer.startPlayer();
    }

}
