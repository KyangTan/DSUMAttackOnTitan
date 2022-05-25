/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

import java.util.NoSuchElementException;

/**
 *
 * @author kwany
 */
public class LinkedListNode<E> {

    E element;
    LinkedListNode<E> next;

    public LinkedListNode(E element) {
        this.element = element;
        this.next = next;
    }

    public LinkedListNode() {
        this(null);
    }

    public E getData() {
        return element;
    }

    public LinkedListNode<E> getNext() {
        return next;
    }

}
