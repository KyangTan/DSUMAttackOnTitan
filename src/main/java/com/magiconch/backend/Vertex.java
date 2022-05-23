/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

/**
 *
 * @author WeiXin
 */
public class Vertex {

    private VertexType type = VertexType.UNDEFINED;

    public Vertex(VertexType type) {
        setType(type);
    }

    public void setType(VertexType type) {
        this.type = type;
    }

    public VertexType getType() {
        return this.type;
    }
}
