/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.utility;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author User
 */
public class Animator {
    public static void lineAnimation(double start, double end, Node node){
        TranslateTransition move = new TranslateTransition();
        move.setNode(node);
        move.setFromX(start);
        move.setToX(end);
        move.setCycleCount(1);
        move.setAutoReverse(false);
        move.setDuration(Duration.millis(200));
        move.play();
        
    }
}
