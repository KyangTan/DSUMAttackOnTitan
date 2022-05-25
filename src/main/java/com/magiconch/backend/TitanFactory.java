/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

import java.util.Random;

/**
 *
 * @author kwany
 */
public class TitanFactory {
    public Titan generateRandomTitan(){
        Random ran = new Random();
        int randomNum = ran.nextInt(100);
        if (randomNum <60) {
            return new NormalTitan();
        }
        else if (randomNum < 90 ){
            return new AbnormalTitan();
        }
        else if (randomNum < 100){
            return new NineTitan();
        }
        else{
            return null;
        }
    }
    
    public Titan generateNormalTitan(){
        return new NormalTitan();
    }
    
    public Titan generateAbnormalTitan(){
        return new AbnormalTitan();
    }
    
    public Titan generateNineTitan(){
        return new NineTitan();
    }
    
    
}
