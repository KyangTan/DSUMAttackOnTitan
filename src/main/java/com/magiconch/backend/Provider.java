package com.magiconch.backend;

import java.util.ArrayList;
import java.util.List;
import com.magiconch.backend.GraphRelated.Graph;

/**
 *
 * @author Ming
 */
public class Provider {

    private static LinkedList<Member> memberList = new LinkedList<>();
    private static int currentI = 0;

    // graph
    private static ArrayList<ArrayList<Integer>> adjMatrix;
    private static Graph graph;

    public static LinkedList<Member> getMemberList() {
        return memberList;
    }

    public static void setMemberList(LinkedList<Member> memberList) {
        Provider.memberList = memberList;
    }

    public static int getCurrentI() {
        return currentI;
    }

    public static void setCurrentI(int currentI) {
        Provider.currentI = currentI;
    }

    public static void addMember(Member member) {
        memberList.add(member);
    }

    public static void removeMember(Member member) {
        memberList.removeElement(member);
    }

    public static void setMember(Member oldM, Member newM) {
        memberList.replace(oldM, newM);
    }

    public static void setGraph(Graph graph) {
        Provider.graph = graph;
        setGraphMatrix(graph.getAdjacencyMatrix());
    }

    public static Graph getGraph() {
        return Provider.graph;
    }

    public static void setGraphMatrix(ArrayList<ArrayList<Integer>> adjMatrix) {
        Provider.adjMatrix = adjMatrix;
    }

    public static ArrayList<ArrayList<Integer>> getGraphMatrix() {
        if (Provider.adjMatrix == null) {
            System.out.println("No graph stored in provider");
            return null;
        }
        return Provider.adjMatrix;
    }

}
