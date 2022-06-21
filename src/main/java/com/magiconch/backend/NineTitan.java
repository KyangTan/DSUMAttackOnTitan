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

    static ArrayList<String> available = new ArrayList<>(Arrays.asList("Founding Titan", "Armored Titan", "Attack Titan", "Beast Titan", "Cart Titan", "Colossal Titan", "Female Titan", "Jaw Titan", "War Hammer Titan"));

    public NineTitan() {
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
                    setTitanImageUrl("assets/images/founding_titan.jpg");
                    setTitanDesc("The Founding Titan (始祖の巨人 Shiso no Kyojin?, also translated as Progenitor Titan) was one of the Nine Titans and the first of all Titans. Its Scream (叫び Sakebi?) could create and control other Titans and modify the memories and body compositions of the Subjects of Ymir, but this power had historically only been able to be used by members of the royal family. According to Marley's Titan Biology Research Society, the Founding Titan was the point where the paths connecting all Subjects of Ymir and Titans cross. Because of this, those who hail from Marley sometimes called it the 'Coordinate' (座標 Zahyō?).");
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
                    setTitanImageUrl("assets/images/armored.png");
                    setTitanDesc("The Armored Titan (鎧の巨人 Yoroi no Kyojin?) was one of the Nine Titans that possessed armored plates of skin across its body.");
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
                    setTitanImageUrl("assets/images/attack_titan.jpg");
                    setTitanDesc("The Attack Titan (進撃の巨人 Shingeki no Kyojin?, also translated as Attacking Titan) was one of the Nine Titans that could see through the memories of its past and future holders, and is said to have fought for freedom throughout the course of numerous generations.");
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
                    setTitanImageUrl("assets/images/beast_titan.jpg");
                    setTitanDesc("The Beast Titan (獣の巨人 Kemono no Kyojin?) was one of the Nine Titans. Typically, it was slightly larger than most Titans and took on an animal-like appearance.");
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
                    setTitanImageUrl("assets/images/cart_titan.jpg");
                    setTitanDesc("");
                    break;
                case "Colossal Titan":
                    setName("Colossal Titan");
                    setTitantype(Titan.type.NineTitan);
                    setWp(WalkingPattern.Not_Repeated);
                    setClimb(false);
                    setHeight(60);
                    setWalkingLegs(2);
                    setRunningSpeed(50);
                    setDangerRisk(19);
                    setTitanImageUrl("assets/images/collosal.png");
                    setTitanDesc("The Colossus Titan (超大型巨人 Chō ōgata Kyojin?) was one of the Nine Titans and the early main antagonist of the Attack on Titan series. It was notable for its incredible size and significant control over the steam emitted by its Titan body along with the user being able to successfully control its transformation's power.");
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
                    setTitanImageUrl("assets/images/female.png");
                    setTitanDesc("The Female Titan (女型の巨人 Megata no Kyojin?) was one of the Nine Titans and possessed the ability to easily mimic the attributes of the other Titans. It could also selectively harden parts of its skin and attract Pure Titans with its screams within a limited range, possibly due to its aforementioned mimicry ability.");
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
                    setTitanImageUrl("assets/images/jaw_titan.jpg");
                    setTitanDesc("The Jaw Titan (顎の巨人 Agito no Kyojin?) was one of the Nine Titans with a ferociously powerful set of jaws and claws that were able to tear through almost anything. Due to its small size, it was also known to be the fastest out of the Nine Titans. The Jaw Titan is an assault unit. Its small size makes it the swiftest of all. Its powerful claws and jaws can crush just about anything.");

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
                    setTitanImageUrl("assets/images/warHammer.png");
                    setTitanDesc("The War Hammer Titan (戦鎚の巨人 Sentsui no Kyojin?) was one of the Nine Titans, and it possessed the ability to create structures out of hardened Titan flesh. It controls Titan hardening to create weapons, or anything it needs, from underground.");
                    break;
                default:
                    throw new AssertionError();
            }
        } else {
            System.out.println("All Nine Titan has been summoned");
        }
    }

}
