/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

/**
 *
 * @author WeiXin
 */
public class Pair<E,T>{
    
    private E val1 = null;
    private T val2 = null;
    private boolean hasSecondVal = false;
    
    Pair(E val1, T val2){
        if(val2!=null){
            this.hasSecondVal = true;
        }
        this.val1 = val1;
        this.val2 = val2;
    }
    
    public E getVal1(){
        return val1;
    }
    
    public T getVal2(){
        return val2;
    }
    
    public void setVal1(E newVal1){
        this.val1 = newVal1;
    }
    
    public void setVal2(T newVal2){
        this.val2 = newVal2;
    }
    
    public boolean hasSecondVal(){
        return this.hasSecondVal;
    }
    
}
