/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author kwany
 */
public class LinkedList<E> implements Iterable<E> {

    private LinkedListNode<E> head;
    private LinkedListNode<E> tail;
    private int size;
    private boolean isCircular = false;

    /**
     * @param args the command line arguments
     */
    public void add(E e) {
        LinkedListNode<E> newNode = new LinkedListNode<>(e);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    public void removeElement(E e) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        LinkedListNode<E> current = head;
        E temp = null;
        while (current != null) {
            if (head.element.equals(e)) {
                head = head.next;
            }
            if (current.next.element.equals(e)) {
                temp = current.next.element;
                current.next.element = null;
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
        System.out.println("Deleted: " + temp);
        size--;
    }

    public void printList() {
        LinkedListNode<E> current = head;
        for (int i = 1; i <= getSize(); i++) {
            System.out.println("Member " + (i));
            System.out.print(current.element.toString() + " \n\n");
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean contains(E e) {
        LinkedListNode<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void replace(E e, E newE) {
        LinkedListNode<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                current.element = newE;
                break;
            }
            current = current.next;
        }
    }

    public LinkedListNode<E> getHead() {
        return head;
    }

    public void setHead(LinkedListNode<E> head) {
        this.head = head;
    }

    public LinkedListNode<E> getTail() {
        return tail;
    }

    public void setTail(LinkedListNode<E> tail) {
        this.tail = tail;
    }

    public void makeCircular() {
        this.tail.next = this.head;
        isCircular = true;
    }

    public void disableCircular() {
        this.tail.next = null;
        isCircular = false;
    }
    
    public E[] toArray(){
        LinkedListNode<E> current = this.head;
        E[] ret = (E[]) new Object[size];
        int i = 0;
        while(current.getNext() != null){
            ret[i] = current.getData();
        }
        
        return ret;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            LinkedListNode<E> current = (LinkedListNode<E>) head;
            private LinkedListNode<E> prev;

            @Override
            public boolean hasNext() {
                if (isCircular) {

                    return prev == null ? true : !prev.equals(tail) ? true : false;
                }
                return current != null;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E dR = current.getData();
                    prev = current;
                    current = current.next;
                    return dR;
                }
                return null;
            }
        };
    }

}
