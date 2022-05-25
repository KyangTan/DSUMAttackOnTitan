/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.utility;

import com.magiconch.backend.GraphRelated.Graph;
import com.magiconch.backend.LinkedList;
import com.magiconch.backend.Member;
import com.magiconch.backend.Music;
import com.magiconch.backend.GraphRelated.WeightMode;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author WeiXin
 */
public class fileReader {

    public static String readFile(String path) {
        try {
            Scanner in = new Scanner(new File(path));
            String fileIn = "";
            while (in.hasNextLine()) {
                fileIn += in.nextLine();
            }
            return fileIn;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static Graph readGraphFromJSON(String jsonString, WeightMode weightMode) {
        JSONObject json = new JSONObject(jsonString);
        int dim = json.length();

        Graph graph = new Graph(dim, weightMode);

        for (int i = 0; i < dim; i++) {
            Object[] edges = json.getJSONObject(Integer.toString(i)).getJSONArray("edge").toList().toArray();
            graph.setWeight(i, edges);

            // custom weight mode only
            if (WeightMode.CUSTOM_WEIGHT == weightMode) {
                Object[] weights = json.getJSONObject(Integer.toString(i)).getJSONArray("weight").toList().toArray();
                graph.setWeight(weights, i, edges);
            }
        }

        return graph;
    }

    public static LinkedList<Music> getBGMQueueFromJSON(String jsonString) {
        JSONObject json = new JSONObject(jsonString);
        LinkedList<Music> queue = new LinkedList<>();
        for (String key : json.keySet()) {
            queue.add(new Music(key, json.get(key).toString()));
        }
        queue.makeCircular();
        return queue;
    }

    public static LinkedList<Member> getMembersFromJSON(String jsonString) {
        JSONArray json = new JSONArray(jsonString);
        LinkedList<Member> characterList = new LinkedList<>();
        
        for (Object obj : json) {
            JSONObject jObj = (JSONObject) obj;
            characterList.add(new Member(jObj.get("Name").toString(), 
                    Integer.parseInt(jObj.get("Height").toString()), 
                    Integer.parseInt(jObj.get("Weight").toString()), 
                    Integer.parseInt(jObj.get("Strength").toString()), 
                    Integer.parseInt(jObj.get("Agility").toString()), 
                    Integer.parseInt(jObj.get("Intelligence").toString()), 
                    Integer.parseInt(jObj.get("Coordination").toString()), 
                    Integer.parseInt(jObj.get("Leadership").toString())));
        }
        
        return characterList;
    }

}
