/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

import java.util.ArrayList;

/**
 *
 * @author Wei Xin
 */
public class Operations {

    // Helper function to switch comparator by attribute
    public static int ComparatorSwitcher(Attribute attr, Member o1, Member o2, boolean reverse) {
        switch (attr) {
            case NAME:
                return AttributeComparator.compareByName(o1, o2, reverse);
            case HEIGHT:
                return AttributeComparator.compareByHeight(o1, o2, reverse);
            case WEIGHT:
                return AttributeComparator.compareByWeight(o1, o2, reverse);
            case LEADERSHIP:
                return AttributeComparator.compareByLeadership(o1, o2, reverse);
            case INTELLIGENCE:
                return AttributeComparator.compareByIntelligence(o1, o2, reverse);
            case AGILITY:
                return AttributeComparator.compareByAgility(o1, o2, reverse);
            case COORDINATION:
                return AttributeComparator.compareByCoordination(o1, o2, reverse);
            case STRENGTH:
                return AttributeComparator.compareByStrength(o1, o2, reverse);
            default:
                throw new RuntimeException();
        }
    }

    private static int binarySearchHigh(Member[] sorted, int starting, int ending, Attribute attr, int target) {
        //  check no result
        if (starting == -1 || ending == -1) {
            return -1;
        }
        
        // ability value only
        // searching objective: find the first occurance and last occurance of targeted value
        int mid = starting + ((ending - starting) / 2);
        int midVal = (int) sorted[mid].get(attr);
        int rightVal = (int) sorted[mid + 1].get(attr);
        int occurance = -1;

        // target at the right
        if (midVal < target) {
            occurance = binarySearchHigh(sorted, mid + 1, ending, attr, target);
        } // target at the left
        else if (midVal > target) {
            occurance = binarySearchHigh(sorted, starting, mid - 1, attr, target);
        } // check right
        else {
            if (rightVal == target) {
                occurance = binarySearchHigh(sorted, mid + 1, ending, attr, target);
            } else {
                occurance = mid;
            }
        }

        return occurance;
    }

    private static int binarySearchLow(Member[] sorted, int starting, int ending, Attribute attr, int target) {
        //  check no result
        if (starting == -1 || ending == -1) {
            return -1;
        }

        // ability value only
        // searching objective: find the first occurance and last occurance of targeted value
        int mid = starting + ((ending - starting) / 2);
        int midVal = (int) sorted[mid].get(attr);
        int leftVal = (int) sorted[mid - 1].get(attr);
        int occurance = -1;

        // target at the right
        if (midVal < target) {
            occurance = binarySearchLow(sorted, mid + 1, ending, attr, target);
        } // target at the left
        else if (midVal > target) {
            occurance = binarySearchLow(sorted, starting, mid - 1, attr, target);
        } // check right
        else {
            if (leftVal == target) {
                occurance = binarySearchLow(sorted, starting, mid - 1, attr, target);
            } else {
                occurance = mid;
            }
        }

        return occurance;
    }

// LinkedList Operations
    /**
     *
     * @param attr
     * @param members
     * @param reverse
     * @return
     */
    public static Member[] sortBy(Attribute attr, LinkedList<Member> members, boolean reverse) {
        // init array to be returned
        Member[] arr = new Member[members.getSize()];
        int k = 0;
        for (Member member : members) {
            arr[k] = member;
            k++;
        }

        // Bubble sort
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (ComparatorSwitcher(attr, arr[j], arr[j + 1], reverse) > 0) {
                    Member temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        return arr;
    }

    /**
     *
     * @param attr
     * @param members
     * @param val
     * @return null if no result
     */
    public static Member[] search(Attribute attr, LinkedList<Member> members, int val) {
        // get ascending order by attribute type
        Member[] sorted = sortBy(attr, members, false);
        int upper = binarySearchHigh(sorted, 0, sorted.length - 1, attr, val);
        int lower = binarySearchLow(sorted, 0, upper, attr, val);

        Member[] matched;
        // check got result or not
        if (upper == -1 || lower == -1) {
            matched = null;
        } else {
            matched = new Member[upper - lower + 1];
            int j = 0;
            for (int i = lower; i <= upper; i++) {
                matched[j] = sorted[i];
                j++;
            }
        }

        return matched;
    }

    /**
     *
     * @param attr
     * @param titans
     * @return
     */
//    public static Titans[] sortBy(String attr, LinkedList<Titans> titans){
//        
//    }
    /**
     *
     * @param attr
     * @param members
     * @return
     */
//    public static Member[] searchByAttribute(String attr, LinkedList<Member> members){
//    
//    }
// Graph Operations
    /**
     *
     * @param srcIndex
     * @param destIndex
     * @param inputGraph
     * @return
     */
//    public static int getDistance(int srcIndex, Graph inputGraph, int destIndex){
//        return dist;
//    }
    /**
     *
     * @param srcIndex
     * @param destIndex
     * @param inputGraph
     * @param getPath
     * @return
     */
//    public static Pair<Integer,String> getDistance(int srcIndex, int destIndex, Graph inputGraph, boolean getPath){
//        if(getPath){
//            return new Pair<Integer, String>(dist, path);
//        }
//        else{
//            return new Pair<Integer, String>(getDistance(srcIndex, destIndex),null);
//        }
//        
//    }
}
