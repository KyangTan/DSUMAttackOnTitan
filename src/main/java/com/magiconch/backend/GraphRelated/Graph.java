/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend.GraphRelated;

import java.util.ArrayList;

/**
 *
 * @author WeiXin
 */
public class Graph {

    // adjacency matrix
    // each element is the weight of the edge between 2 vertices
    private ArrayList<ArrayList<Integer>> adjMatrix;
    // record the index of Vertex object
    private ArrayList<Vertex> occupiedBy;
    private int dim = 0;
    private WeightMode weightMode = WeightMode.NO_WEIGHT;

    public Graph() {
        this.adjMatrix = new ArrayList<>();
    }

    public Graph(int dim, WeightMode weightMode) {
        // to limit both column and row
        this.dim = dim;

        // to set graph weight mode
        setWeightMode(weightMode);

        // to instantiate the ArrayList and occcupiedBy
        this.adjMatrix = new ArrayList<>();
        this.occupiedBy = new ArrayList<>();
        // build row
        for (int i = 0; i < dim; i++) {
            // populate vertex
            this.occupiedBy.add(new Vertex(VertexType.UNDEFINED));

            this.adjMatrix.add(new ArrayList<>());
            for (int j = 0; j < dim; j++) {
                // init all to 0
                this.adjMatrix.get(i).add(0);
            }
        }
    }

    public void setWeightMode(WeightMode mode) {
        this.weightMode = mode;
    }

    public WeightMode getWeightMode() {
        return this.weightMode;
    }

    public void setWeight(int src, int dest) {
        // validate input
        if (src > this.dim || dest > this.dim) {
            System.out.println("Unknown source node");
        } else {
            if (null == weightMode) {
                System.out.println("This method is not applicable to custom weight");
            } else {
                switch (weightMode) {
                    // all edge weight is 1
                    case NO_WEIGHT:
                        this.adjMatrix.get(src).set(dest, 1);
                        break;
                    // all edge weight is the difference of the index of source node and destination node
                    case DIFFER_BY_INDEX:
                        this.adjMatrix.get(src).set(dest, Math.abs(dest - src));
                        break;
                    // not covered
                    default:
                        System.out.println("This method is not applicable to custom weight");
                        break;
                }
            }
        }
    }

    public void setWeight(int weight, int src, int dest) {
        if (src >= this.dim || dest >= this.dim) {
            System.out.println("Unknown source node");
        } else {
            // all edge weight is custom value (read from json)
            if (weightMode == WeightMode.CUSTOM_WEIGHT) {
                this.adjMatrix.get(src).set(dest, weight);
            } else {
                System.out.println("This method is only applicable to custom weight");
            }
        }
    }

    public void setWeight(int src, Object[] dest) {
        for (Object d : dest) {
            setWeight(src, (int) d);
        }
    }

    public void setWeight(Object[] weight, int src, Object[] dest) {
        int i = 0;
        for (Object d : dest) {
            setWeight((int) weight[i], src, (int) d);
            i++;
        }
    }

    public boolean hasEdges(int node) {
        int sum = 0;
        for (Integer i : this.adjMatrix.get(node)) {
            sum += i.intValue();
        }
        return sum != 0;
    }

    public boolean hasEdge(int src, int dest) {
        return this.adjMatrix.get(src).get(dest) > 0;
    }

    // delete edge between 2 existing node
    public void deleteEdge(int src, int dest) {
        setEdge(src, dest, 0);
    }

    // add edge between 2 existing nodes (weight = 1)
    public void setEdge(int src, int dest) {
        setEdge(src, dest, 1);
    }

    // add weighted edge between 2 existing nodes
    public void setEdge(int src, int dest, int weight) {
        if (src >= this.dim || dest >= this.dim) {
            System.out.println("Unknown source node");
        } else {
            this.adjMatrix.get(src).set(dest, weight);
        }
    }

    public void addEdge(Vertex v) {
        // update size
        this.dim++;

        // add row
        this.adjMatrix.add(new ArrayList<>());

        // add column
        for (ArrayList<Integer> col : this.adjMatrix) {
            if (col.size() < this.dim) {
                for (int i = 0; i < this.dim; i++) {
                    col.add(0);
                }
            } else {
                col.add(0);
            }
        }

        // add new Vertex
        this.occupiedBy.add(v);

    }

    public ArrayList<Integer> getEdges(int node) {
        return this.adjMatrix.get(node);
    }

    public ArrayList<ArrayList<Integer>> getAdjacencyMatrix() {
        return this.adjMatrix;
    }

    public ArrayList<Vertex> getVertices() {
        return this.occupiedBy;
    }

    //this method is to print graph
    public void printGraph() {
        if (this.dim == 0) {
            System.out.println("========Blank Graph========");
        } else {
            for (int i = 0; i <= this.dim + 1; i++) {
                switch (i) {
                    case 0:
                        System.out.printf("%5s|", " ");
                        for (int j = 0; j < this.dim; j++) {
                            System.out.printf("%3s%2d ", " ", j);
                        }   System.out.println("");
                        break;
                    case 1:
                        System.out.printf("%5s|", " ");
                        for (int j = 0; j < this.dim; j++) {
                            System.out.print("------");
                        }   System.out.println("");
                        break;
                    default:
                        System.out.printf("%-3s%2d|", " ", i - 2);
                        for (int j = 0; j < this.dim; j++) {
                            System.out.printf("%4s%d ", " ", this.adjMatrix.get(i - 2).get(j));
                        }   System.out.println("");
                        break;
                }
            }

        }

    }

}
