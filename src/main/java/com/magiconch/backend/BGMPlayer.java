/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

import javafx.scene.media.MediaPlayer;

/**
 *
 * @author WeiXin
 */
public class BGMPlayer {
    
    private static LinkedList<Music> queue;
    private static LinkedListNode<Music> current;
    public static MediaPlayer player;
    private static Runnable r;
    private static boolean paused = false;
    BGMPlayer() {
    }
    
    public static void initPlayer(LinkedList<Music> queue) {
        BGMPlayer.queue = queue;
        BGMPlayer.current = BGMPlayer.queue.getHead();
        BGMPlayer.r = () -> {
            current = current.next;
            BGMPlayer.player = new MediaPlayer(current.getData().getMediaObject());
            BGMPlayer.player.setOnEndOfMedia(r);
            player.play();
            
        };
    }
    
    public static void startPlayer() {
        if (BGMPlayer.player == null) {
            BGMPlayer.player = new MediaPlayer(current.getData().getMediaObject());
            BGMPlayer.player.setOnEndOfMedia(r);
        }
        BGMPlayer.player.setOnReady(() -> {
            BGMPlayer.player.play();
        });
        
        BGMPlayer.player.setOnError(() -> {
            BGMPlayer.player.getError().printStackTrace();
        });     
    }
    
    public static boolean togglePlayer() {
        if(BGMPlayer.player == null){
            startPlayer();
        }
        if (paused) {
            BGMPlayer.player.play();
            paused = false;
        }else{
            BGMPlayer.player.pause();
            paused = true;
        }
        
        return paused;
    }
    
}
