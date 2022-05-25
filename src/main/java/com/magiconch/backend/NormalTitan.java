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
    }
}
