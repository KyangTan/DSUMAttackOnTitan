/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.utility;

import com.magiconch.backend.Graph;
import com.magiconch.backend.WeightMode;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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

}
