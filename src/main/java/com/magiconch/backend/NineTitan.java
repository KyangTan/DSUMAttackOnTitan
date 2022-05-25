/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author kwany
 */
public class NineTitan extends Titan {
    static ArrayList<String> available = new ArrayList<>(Arrays.asList("Founding Titan", "Armored Titan", "Attack Titan", "Beast Titan", "Cart Titan","Colossus Titan", "Female Titan","Jaw Titan","War Hammer Titan"));
    
    public NineTitan(){
        if (!available.isEmpty()) {
            Random ran = new Random();
            int number = ran.nextInt(available.size());
            String chosen = available.get(number);
            available.remove(number);
            switch (chosen) {
                case "Founding Titan":
                    setName("Founding Titan");
                    setTitantype(Titan.type.NineTitan);
                    setWp(WalkingPattern.Not_Repeated);
                    setClimb(false);
                    setHeight(13);
                    setWalkingLegs(2);
                    setRunningSpeed(100);
                    setDangerRisk(19);
                    break;
                case "Armored Titan":
                    setName("Armored Titan");
                    setTitantype(Titan.type.NineTitan);
                    setWp(WalkingPattern.Not_Repeated);
                    setClimb(false);
                    setHeight(15);
                    setWalkingLegs(2);
                    setRunningSpeed(100);
                    setDangerRisk(19);
                    break;
                case "Attack Titan":
                    setName("Attack Titan");
                    setTitantype(Titan.type.NineTitan);
                    setWp(WalkingPattern.Not_Repeated);
                    setClimb(false);
                    setHeight(15);
                    setWalkingLegs(2);
                    setRunningSpeed(100);
                    setDangerRisk(19);
                    break;
                case "Beast Titan":
                    setName("Beast Titan");
                    setTitantype(Titan.type.NineTitan);
                    setWp(WalkingPattern.Not_Repeated);
                    setClimb(true);
                    setHeight(17);
                    setWalkingLegs(2);
                    setRunningSpeed(20);
                    setDangerRisk(19);
                    break;
                case "Cart Titan":
                    setName("Cart Titan");
                    setTitantype(Titan.type.NineTitan);
                    setWp(WalkingPattern.Not_Repeated);
                    setClimb(true);
                    setHeight(4);
                    setWalkingLegs(4);
                    setRunningSpeed(140);
                    setDangerRisk(19);
                    break;
                case "Colossus Titan":
                    setName("Colossus Titan");
                    setTitantype(Titan.type.NineTitan);
                    setWp(WalkingPattern.Not_Repeated);
                    setClimb(false);
                    setHeight(60);
                    setWalkingLegs(2);
                    setRunningSpeed(50);
                    setDangerRisk(19);
                    break;
                case "Female Titan":
                    setName("Female Titan");
                    setTitantype(Titan.type.NineTitan);
                    setWp(WalkingPattern.Not_Repeated);
                    setClimb(false);
                    setHeight(13);
                    setWalkingLegs(2);
                    setRunningSpeed(100);
                    setDangerRisk(19);
                    break;
                case "Jaw Titan":
                    setName("Jaw Titan");
                    setTitantype(Titan.type.NineTitan);
                    setWp(WalkingPattern.Not_Repeated);
                    setClimb(false);
                    setHeight(5);
                    setWalkingLegs(4);
                    setRunningSpeed(100);
                    setDangerRisk(19);
                    break;
                case "War Hammer Titan":
                    setName("War Hammer Titan");
                    setTitantype(Titan.type.NineTitan);
                    setWp(WalkingPattern.Not_Repeated);
                    setClimb(false);
                    setHeight(15);
                    setWalkingLegs(2);
                    setRunningSpeed(100);
                    setDangerRisk(19);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        else{
            System.out.println("All Nine Titan has been summoned");
        }
    }
    
    
}
