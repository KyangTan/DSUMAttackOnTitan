package com.magiconch.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class WallMaria {
    private final List<List<Integer>> wallStructure = new ArrayList<>();
    private int[][] arrayWallStructure;
    private int[] weakestPart;
    private int height = 0;
    private int width = 0;

    public List<List<Integer>> getWallStructure() {
        return wallStructure;
    }
    
    public void loadWall(int height, int width){
//        System.out.print("    Height of Wall: ");
//        height = sc.nextInt();
//        System.out.print("    Width of Wall: ");
//        width = sc.nextInt();
        arrayWallStructure = new int[height][width];
        this.height = height;
        this.width = width;
//        for(int i =0; i<width; i++){
//            if(i == 0){
//                System.out.printf("\n    %1s  ", Integer.toString(i));
//            } else if(i == width-1){
//                System.out.printf("  %2s", Integer.toString(i));
//            } else {
//                System.out.printf(" %2s ", Integer.toString(i));
//            }
//        }
//        System.out.println();
//        
//        for(int i =0; i<width; i++){
//            if(i==0){
//                System.out.print("    ___");
//            } else
//            System.out.print("____");
//        }
//        System.out.println();
//        
//        for(int i = 0; i < height; i++ ){
//            List<Integer> layer = new ArrayList<>();
//            for(int j = 0; j<width; j++){
//                //1 for edge, 0 for wall brick
//                int rand;
//                if(j == 0 || j == width-1){
//                    rand = 1;
//                } else {
//                    rand = r.nextInt(2);
//                }
//                
//                // Store in array for later use if necessary
//                arrayWallStructure[i][j] = rand;
//                
//                // Store in List<Integer> in layer i
//                if(rand == 1 && (j!=0 && j!= width-1)){
//                    layer.add(j);
//                }
//                
//                if(rand == 0){
//                    System.out.print("____");
//                } else if(rand == 1 && j == 0){
//                    System.out.print("    |__");
//                } else if(rand == 1 && j == width-1){
//                    System.out.print("___|");
//                } else {
//                    System.out.print("__|_");
//                }
//            }
//            wallStructure.add(layer);
//            System.out.println();
//        }
    }
    
    public void insertEdges(String integers){
        String [] strings = integers.split(" ");
        List<Integer> layer = new ArrayList<>();
        for(int i = 0; i< strings.length;i++){
            layer.add(Integer.parseInt(strings[i]));
        }
        wallStructure.add(layer);
    }
    
    public void printWall(){
        System.out.println();
        for(int i = 0; i<height; i++){
            System.out.println("    Brick edges of layer " + (i + 1) + " : "+ wallStructure.get(i).toString());
        }
    }
    public ArrayList<Integer> weakestPart(){
        int maxE = 0;
        ArrayList<Integer> weakestPartArray = new ArrayList<>();
        weakestPart = new int[width];
        
        for(int i = 0; i<height; i++){
            for(Object index : wallStructure.get(i).toArray()){
                weakestPart[(Integer)index] ++;
            }
        }
        
        for(int i = 1; i<weakestPart.length-1; i++){
            if(weakestPart[i]>maxE){
                maxE = weakestPart[i];
            }
        }
        
        for(int i = 1; i<weakestPart.length-1; i++){
            if(weakestPart[i]==maxE){
                weakestPartArray.add(i);
            }
        }
        return weakestPartArray;
    }
}
