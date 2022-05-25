/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

/**
 *
 * @author User
 */
public class AttributeComparator {

    public static int compareByName(Member o1, Member o2, boolean reverse) {
        if (!reverse) {
            return o1.getName().compareTo(o2.getName());
        }
        return o2.getName().compareTo(o1.getName());
    }

    public static int compareByWeight(Member o1, Member o2, boolean reverse) {
        if (!reverse) {
            return Integer.valueOf(o1.getWeight()).compareTo(o2.getWeight());
        }
        return Integer.valueOf(o2.getWeight()).compareTo(o1.getWeight());
    }

    public static int compareByHeight(Member o1, Member o2, boolean reverse) {
        if (!reverse) {
            return Integer.valueOf(o1.getHeight()).compareTo(o2.getHeight());
        }
        return Integer.valueOf(o2.getHeight()).compareTo(o1.getHeight());
    }

    public static int compareByLeadership(Member o1, Member o2, boolean reverse) {
        if (!reverse) {
            return Integer.valueOf(o1.getLeadership()).compareTo(o2.getLeadership());
        }
        return Integer.valueOf(o2.getLeadership()).compareTo(o1.getLeadership());
    }

    public static int compareByIntelligence(Member o1, Member o2, boolean reverse) {
        if (!reverse) {
            return Integer.valueOf(o1.getIntelligence()).compareTo(o2.getIntelligence());
        }
        return Integer.valueOf(o2.getIntelligence()).compareTo(o1.getIntelligence());
    }

    public static int compareByAgility(Member o1, Member o2, boolean reverse) {
        if (!reverse) {
            return Integer.valueOf(o1.getAgility()).compareTo(o2.getAgility());
        }
        return Integer.valueOf(o2.getAgility()).compareTo(o1.getAgility());
    }

    public static int compareByStrength(Member o1, Member o2, boolean reverse) {
        if (!reverse) {
            return Integer.valueOf(o1.getStrength()).compareTo(o2.getStrength());
        }
        return Integer.valueOf(o2.getStrength()).compareTo(o1.getStrength());
    }

    public static int compareByCoordination(Member o1, Member o2, boolean reverse) {
        if (!reverse) {
            return Integer.valueOf(o1.getCoordination()).compareTo(o2.getCoordination());
        }
        return Integer.valueOf(o2.getCoordination()).compareTo(o1.getCoordination());
    }

}
