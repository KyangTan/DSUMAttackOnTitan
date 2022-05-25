/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.magiconch.backend;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author kwany
 */
public class AOTBruh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ParseException, IOException, JSONException {
        LinkedList<Member> characterList = new LinkedList<>();
        LinkedListNode tempNode = new LinkedListNode();
        characterList.add(new Member("Reiner Braun", 185,95,9,7,7,10,8));
        characterList.add(new Member("Armin Arlert", 163,55,2,6,10,8,8));
        characterList.add(new Member("Annie Leonhart", 153,54,10,7,7,3,1));
        characterList.add(new Member("Bertholdt Hoover", 192,81,9,4,6,9,2));
        characterList.add(new Member("Jean Kristein", 175,65,9,8,7,5,9));
        characterList.add(new Member("Sasha Blouse", 165,55,6,3,5,6,7));
        characterList.add(new Member("Connie Springer", 158,58,6,7,3,7,5));
        characterList.add(new Member("Mikasa Ackerman", 170,68,10,9,8,6,7));
        characterList.add(new Member("Eren Yeager", 170,63,9,10,3,5,10));
        characterList.add(new Member("Historia Reiss", 145,42,4,8,7,6,5));
        characterList.add(new Member("Levi Ackerman", 160,65,12,12,7,8,8));
        characterList.add(new Member("Erwin Smith", 188,92,8,8,11,10,12));
        characterList.add(new Member("Hange Zoë", 170,60,9,9,12,7,11));
        tempNode = characterList.getHead();
//        
//        characterList.printList();
        // TODO code application logic here
        
        TitanFactory tf = new TitanFactory();
        System.out.println(tf.generateRandomTitan());
        System.out.println("");
        System.out.println(tf.generateRandomTitan());
        System.out.println("");
        System.out.println(tf.generateRandomTitan());
        System.out.println("");
        System.out.println(tf.generateNineTitan());
        System.out.println(tf.generateNineTitan());
        System.out.println(tf.generateNineTitan());
        System.out.println(tf.generateNineTitan());
        System.out.println(tf.generateNineTitan());
        System.out.println(tf.generateNineTitan());
        System.out.println(tf.generateNineTitan());
        System.out.println(tf.generateNineTitan());
        System.out.println(tf.generateNineTitan());
        System.out.println(tf.generateNineTitan());

        

        
        JSONArray jsonArray = new JSONArray();
        
        
        while (tempNode!= null) {
            try {
                JSONObject memberJSON = new JSONObject();
                JSONObject memberAttributesJSON = new JSONObject();
                
                Member mem = (Member) tempNode.element;
                memberAttributesJSON.put("Name", mem.getName());
                memberAttributesJSON.put("Height", mem.getHeight());
                memberAttributesJSON.put("Weight", mem.getWeight());
                memberAttributesJSON.put("Strength", mem.getStrength());
                memberAttributesJSON.put("Agility", mem.getAgility());
                memberAttributesJSON.put("Intelligence", mem.getIntelligence());
                memberAttributesJSON.put("Coordination", mem.getCoordination());
                memberAttributesJSON.put("Leadership", mem.getLeadership()); 
                jsonArray.put(memberAttributesJSON);
                tempNode = tempNode.next;
                
            } catch (JSONException ex) {
                Logger.getLogger(AOTBruh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        

        try (FileWriter file = new FileWriter("members")) {
            file.write(jsonArray.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + jsonArray);
        } catch(Exception e){
            System.out.println(e);

        }
    }
    
}
