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
public class AbnormalTitan extends Titan {

    public AbnormalTitan() {
        Random ran = new Random();
        setName("Abnormal Titan " + ++abnormalTitanCount);
        setTitantype(Titan.type.Abnormal);
        setWp(randomWP());
        setClimb(ran.nextBoolean());
        setHeight(ran.nextInt(10 - 5) + 5);
        setWalkingLegs(ran.nextInt(3) * 2);
        setRunningSpeed(ran.nextInt(26));
        setDangerRisk(15);
        setTitanImageUrl("assets/images/abnormal.png");
        setTitanDesc("Pure Titans that displayed abnormal behavior or intelligence were classed as Abnormal. Abnormals often ignored nearby humans and charge to more important locations where they could do more damage. The Colossus Titans found inside the Walls were unusually large, similar to the actual Colossus Titan, and had hardening abilities.");

    }
}
