package com.magiconch.backend.GraphRelated;

import java.util.ArrayList;

public class HamiltonianCycle {

    private boolean hasCycle = false;
    private ArrayList<String> paths = new ArrayList<>();

    // check duplicate
    private boolean checkDuplicate(ArrayList<Integer> path, int v, int pos) {
        for (int i = 0; i < pos; i++) {
            if (path.get(i) == v) {
                return true;
            }
        }

        return false;
    }

    // Function to check if a vertex v
    // can be added at index pos in
    // the Hamiltonian Cycle
    private boolean isSafe(int v, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> path, int pos) {
        // check adjacency of the previous vertex with new certex
        // check duplication of vertex in the path array
        if (graph.get(path.get(pos - 1)).get(v) == 0 || checkDuplicate(path, v, pos)) {
            return false;
        }
        return true;
    }

    // Recursive function to find all
    // hamiltonian cycles
    private void FindHamCycle(ArrayList<ArrayList<Integer>> graph, int pos, ArrayList<Integer> path, boolean[] visited) {
        // If all vertices are included
        // in Hamiltonian Cycle
        if (pos == graph.size()) {

            // If there is an edge
            // from the last vertex to
            // the source vertex
            if (graph.get(path.get(path.size() - 1)).get(path.get(0)) != 0) {

                // Include source vertex
                // into the path and
                // print the path
                path.add(0);
                String concat = "";
                for (int i = 0; i < path.size(); i++) {
                    concat += path.get(i) + " ";
                }
                paths.add(concat);
                concat = "";

                // Remove the source
                // vertex added
                path.remove(path.size() - 1);

                // Update the hasCycle
                // as true
                hasCycle = true;
            }
            return;
        }

        // Try different vertices
        // as the next vertex
        for (int v = 0; v < graph.size(); v++) {

            // Check if this vertex can
            // be added to Cycle
            if (isSafe(v, graph, path, pos) && !visited[v]) {

                path.add(v);
                visited[v] = true;

                // Recur to construct
                // rest of the path
                FindHamCycle(graph, pos + 1, path, visited);

                // Remove current vertex
                // from path and process
                // other vertices
                visited[v] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    // Function to find all possible
    // hamiltonian cycles
    public ArrayList<String> hamCycle(ArrayList<ArrayList<Integer>> graph, int src) {
        // Initially value of boolean
        // flag is false
        hasCycle = false;

        // Store the resultant path
        ArrayList<Integer> path = new ArrayList<>();
        path.add(src);

        // Keeps the track of the
        // visited vertices
        boolean[] visited = new boolean[graph.size()];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        visited[0] = true;

        // Function call to find all
        // hamiltonian cycles
        FindHamCycle(graph, 1, path, visited);
        if (!hasCycle) {
            // If no Hamiltonian Cycle
            // is possible for the
            // given graph
            System.out.println("No Hamiltonian Cycle possible");
            
            return null;
        }
        
        return paths;
    }

}
