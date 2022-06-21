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
public class NormalTitan extends Titan{
    public NormalTitan(){
        Random ran = new Random();
        setName("Titan " + ++normalTitanCount);
        setTitantype(type.Normal);
        setWp(randomWP());
        setClimb(ran.nextBoolean());
        setHeight(ran.nextInt(10-5)+5);
        setWalkingLegs(ran.nextInt(3) * 2);
        setRunningSpeed(ran.nextInt(26));
        setTitanImageUrl("assets/images/normal.png");
        setTitanDesc("Ranging from 2 - 15 m in height, these Titans composed the vast majority of observed Titans. They all resembled humans but with varying levels of deformity. Their only common feature was their mindless nature. They mindlessly attacked nearby humans, making them easy to deceive. However, they were still dangerous due to their size, physical strength, and sheer numbers. They were often used as weapons of war, by Eldia in the past and Marley in the present.");
    }
}
