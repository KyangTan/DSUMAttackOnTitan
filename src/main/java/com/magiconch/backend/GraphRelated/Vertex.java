/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend.GraphRelated;

/**
 *
 * @author WeiXin
 */
public class Vertex {

    private VertexType type = VertexType.UNDEFINED;
    private int dangerRisk = 0;

    public Vertex() {
        setType(type);
    }

    public Vertex(VertexType type) {
        setType(type);
    }

    public void setType(VertexType type) {
        this.type = type;
    }

    public VertexType getType() {
        return this.type;
    }

    public void setDangerRisk(int dangerRisk) {
        this.dangerRisk = dangerRisk;
    }

    ;
    
    public int getDangerRisk() {
        return this.dangerRisk;
    }

    public void increDangerRisk(int n) {
        this.dangerRisk += n;
    }

    public void decreDangerRisk(int n) {
        if (this.dangerRisk - n < 0) {
            this.dangerRisk = 0;
        } else {
            this.dangerRisk -= n;
        }
    }
}
