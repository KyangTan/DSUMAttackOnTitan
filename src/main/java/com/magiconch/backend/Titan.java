package com.magiconch.backend;

import com.magiconch.backend.GraphRelated.Vertex;
import com.magiconch.backend.GraphRelated.VertexType;
import java.util.Random;

/**
 *
 * @author kwany
 */
public abstract class Titan extends Vertex {

    static int normalTitanCount = 0;
    static int abnormalTitanCount = 0;
    private final VertexType vertexType = VertexType.TITAN;
    private String titanUrl;

    enum type {
        Normal,
        Abnormal,
        NineTitan
    }

    enum WalkingPattern {
        Not_Repeated,
        Repeated,
        Normal_Pattern
    }
    private String name;
    private type Titantype;
    private WalkingPattern wp;
    private boolean climb;
    private int height, walkingLegs, runningSpeed, position;
    private String titanDesc;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public type getTitantype() {
        return Titantype;
    }

    public void setTitantype(type Titantype) {
        super.setType(VertexType.TITAN);
        this.Titantype = Titantype;
    }

    public WalkingPattern getWp() {
        return wp;
    }

    public void setWp(WalkingPattern wp) {
        this.wp = wp;
        if (Titantype.equals(type.Normal)) {
            if (wp.equals(WalkingPattern.Normal_Pattern)) {
                super.increDangerRisk(1);
            } else if (wp.equals(WalkingPattern.Repeated)) {
                super.increDangerRisk(2);
            } else if (wp.equals(WalkingPattern.Not_Repeated)) {
                super.increDangerRisk(3);
            }
        }
    }

    public boolean isClimb() {
        return climb;
    }

    public void setClimb(boolean climb) {
        this.climb = climb;
        if (Titantype.equals(type.Normal)) {
            if (climb) {
                super.increDangerRisk(3);
            } else {
                super.increDangerRisk(1);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        if (Titantype.equals(type.Normal)) {
            if (height < 10) {
                super.increDangerRisk(1);
            } else if (height >= 10) {
                super.increDangerRisk(2);
            } else if (height > 20) {
                super.increDangerRisk(3);
            }
        }
    }

    public int getWalkingLegs() {
        return walkingLegs;
    }

    public void setWalkingLegs(int walkingLegs) {
        this.walkingLegs = walkingLegs;
        if (Titantype.equals(type.Normal)) {
            if (this.walkingLegs == 4) {
                super.increDangerRisk(3);
            } else if (this.walkingLegs == 2) {
                super.increDangerRisk(2);
            } else if (this.walkingLegs == 0) {
                super.increDangerRisk(1);
            }
        }
    }

    public int getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(int runningSpeed) {
        this.runningSpeed = runningSpeed;
        if (Titantype.equals(type.Normal)) {
            if (this.runningSpeed > 20) {
                super.increDangerRisk(3);
            } else if (this.runningSpeed > 10) {
                super.increDangerRisk(2);
            } else if (this.runningSpeed < 10) {
                super.increDangerRisk(1);
            }
        }
    }

    public int getDangerRisk() {
        return super.getDangerRisk();
    }

    public void setDangerRisk(int dangerRisk) {
        super.setDangerRisk(dangerRisk);
    }
    
    public String getTitanImageUrl() {
        return titanUrl;
    }

    public void setTitanImageUrl(String titanUrl) {
        this.titanUrl = titanUrl;
    }
    public String getTitanDesc() {
        return titanDesc;
    }

    public void setTitanDesc(String titanDesc) {
        this.titanDesc = titanDesc;
    }

    public WalkingPattern randomWP() {
        Random ran = new Random();
        int randomNo = ran.nextInt(3);
        switch (randomNo) {
            case 0:
                return WalkingPattern.Repeated;
            case 1:
                return WalkingPattern.Not_Repeated;
            case 2:
                return WalkingPattern.Normal_Pattern;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Titan{" + "name=" + name + ", Titantype=" + Titantype + ", wp=" + wp + ", climb=" + climb + ", height=" + height + ", walkingLegs=" + walkingLegs + ", runningSpeed=" + runningSpeed + ", dangerRisk=" + super.getDangerRisk() + ", position=" + position + ", description=" + titanDesc + '}';
    }

}
