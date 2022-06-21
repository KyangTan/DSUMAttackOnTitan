/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

/**
 *
 * @author kwany
 */
public class Member {
//***************************************************************************
    private String name, desc, imgUrl;
    private int height,weight,strength,agility,intelligence,coordination,leadership;
//***************************************************************************
    enum statusEnum{
        idle,
        moving,
        battling,
        escaping,
    }
    private int position, killcount;
    private statusEnum status = statusEnum.idle; 
//***************************************************************************
    
    //Empty constructor
    public Member() {
    }
    
    //Character initializer constructor
    public Member(String name, int height, int weight, int strength, int agility, int intelligence, int coordination, int leadership, String desc, String imgUrl) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.coordination = coordination;
        this.leadership = leadership;
        this.desc = desc;
        this.imgUrl = imgUrl;
    }


    
    public Member(String name, int height, int weight, int strength, int agility, int intelligence, int coordination, int leadership, int position, int killcount) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.coordination = coordination;
        this.leadership = leadership;
        this.position = position;
        this.killcount = killcount;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCoordination() {
        return coordination;
    }

    public void setCoordination(int coordination) {
        this.coordination = coordination;
    }

    public int getLeadership() {
        return leadership;
    }

    public void setLeadership(int leadership) {
        this.leadership = leadership;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getKillcount() {
        return killcount;
    }

    public void setKillcount(int killcount) {
        this.killcount = killcount;
    }
    
    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getImageUrl() {
        return this.imgUrl;
    }
    
    public void setImageUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }

    public statusEnum getStatus() {
        return status;
    }

    public void setStatus(statusEnum status) {
        this.status = status;
    }
    
    public Object get(Attribute attr){
        switch (attr){
            case NAME:
                return getName();
            case WEIGHT:
                return getWeight();
            case HEIGHT:
                return getHeight();
            case STRENGTH:
                return getStrength();
            case LEADERSHIP:
                return getLeadership();
            case AGILITY:
                return getAgility();
            case COORDINATION:
                return getCoordination();
            case INTELLIGENCE:
                return getIntelligence();
            default:
                return null;
        
        } 
    }
    
    public void set(Attribute attr, Object entry){
        switch (attr){
            case NAME:
                setName((String) entry);
                break;
            case WEIGHT:
                setWeight((int) entry);
                break;
            case HEIGHT:
                setHeight((int) entry);
                break;
            case STRENGTH:
                setStrength((int) entry);
                break;
            case LEADERSHIP:
                setLeadership((int) entry);
                break;
            case AGILITY:
                setAgility((int) entry);
                break;
            case COORDINATION:
                setCoordination((int) entry);
                break;
            case INTELLIGENCE:
                setIntelligence((int) entry);
                break;
            default:
                break;
        
        } 
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nHeight: " + getHeight() + "\nWeight: " + getWeight() + "\nStrength: " + getStrength() + "\nAgility: " + getAgility() + "\nIntelligence: " + getIntelligence() + "\nCoordination: " + getCoordination() + "\nLeadership: " + getLeadership() ;
    }


    
}
