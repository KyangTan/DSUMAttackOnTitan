/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author kuckn
 * @param <K> as String
 * @param <V> as String
 */
public class HashMap<K, V>{
    // for better re-sizing is taken as 2^5
    private static final int SIZE = 32;
    
    private final Entry table[] = new Entry[SIZE];
    
    /**
     * To store the Map data in key and value pair.
     * Used linked list approach to avoid the collisions
     */
    
    class Entry <K, V>{
        final K key;
        V value;
        Entry next;
        
        Entry(K k, V v){
            key = k;
            value = v;
        }
        
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }
    }
    
    ///////////////////// Start of HashMap Useful Functions ////////////////////
    
    /**
     * Returns the entry mapped to key in HashMap
     * @param k
     * @return the Entry Bucket
     * Note: use .getValue() to get value of the key
     */
    public Entry get(K k){
        /**
        * Returns a hash code for this string. The hash code for a
        * {@code String} object is computed as
        * <blockquote><pre>
        * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
        * </pre></blockquote>
        * using {@code int} arithmetic, where {@code s[i]} is the
        * <i>i</i>th character of the string, {@code n} is the length of
        * the string, and {@code ^} indicates exponentiation.
        * (The hash value of the empty string is zero.)
        *
        * @return  a hash code value for this object.
        */
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];
        
        // Bucket is identified by hashCode and traversed the bucket
        // till element is not found
        while(e != null){
            if(e.key.equals(k)){
                return e;
            }
            e = e.next;
        }
        return null;
    }
    
    public void put(K k, V v){
        if (k == null){
            System.out.println("##Error inserting " + k + ". Null value");
            return;
        }
        
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];
        
        if(e != null){
            // If we will insert duplicate key-value pair,
            // Old value will be replaced by new one.
            if(e.key.equals(k)){
                e.value = v;
            } else {
                // Collision: insert new element at the end of list
                // in the same bucket
                while(e.next != null) {
                    e = e.next;
                }
                Entry entryInOldBucket = new Entry(k, v);
                e.next = entryInOldBucket;
            }
        } else {
            // create new bucket for new element in the map.
            Entry entryInNewBucket = new Entry(k, v);
            table[hash] = entryInNewBucket;
        }
    }
    
    public boolean remove(K deleteKey){
        int hash = deleteKey.hashCode() % SIZE ;
        Entry e = table[hash];
        
        if(e == null){
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = e;
            
            while(current != null){
                if(current.key.equals(deleteKey)) {
                    if(previous == null) {
                        table[hash] = e.next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }
    
    public boolean containsKey(K key){
        return get(key) != null;
    } 
    
    /////////////////////// End of HashMap Useful Functions ////////////////////
}