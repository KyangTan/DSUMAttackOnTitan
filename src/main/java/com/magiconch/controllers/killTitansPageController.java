package com.magiconch.controllers;

import com.magiconch.attackontitan.App;
import com.magiconch.backend.AttributeComparator;
import com.magiconch.backend.GraphRelated.Djikstra;
import com.magiconch.backend.GraphRelated.Graph;
import com.magiconch.backend.GraphRelated.Vertex;
import com.magiconch.backend.GraphRelated.VertexType;
import com.magiconch.backend.GraphRelated.WeightMode;
import com.magiconch.backend.HashMap;
import com.magiconch.backend.LinkedList;
import com.magiconch.backend.LinkedListNode;
import com.magiconch.backend.Provider;
import com.magiconch.backend.Titan;
import com.magiconch.utility.Animator;
import com.magiconch.utility.GraphDrawer;
import com.magiconch.utility.fileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class killTitansPageController implements Initializable, ControlledScreen {

    @FXML
    private Button killButton;

    @FXML
    private TextField titansNumberTextBox;

    @FXML
    private ToggleGroup killNode;

    @FXML
    private StackPane titanCard;

    @FXML
    private Text titanInfoText;

    @FXML
    private Text titanDescText;

    @FXML
    private ImageView titanPic;

    @FXML
    private Text closeNodeDetail;

    @FXML
    private Text outputText;

    @FXML
    private Button showNodeDetails;

    @FXML
    private Button findShortestPath;

    @FXML
    private Button getPriorityKill;

    @FXML
    private Button resetButton;

    @FXML
    private AnchorPane body;

    ScreenController myController;
    private ArrayList<ArrayList<Integer>> adjMatrix = Provider.getGraphMatrix();
    private GraphDrawer draw;
    private boolean isNodeDetailsShown = false;
    private boolean isFound = false;
    private boolean isPriority = true;
    private VertexType currentSelecting = null;

    @FXML
    public void toggleNodeDetails() {
        if (!isNodeDetailsShown) {
            // find the shortest path

            findShortestPath.setDisable(true);
            showNodeDetails.setDisable(true);
            resetButton.setDisable(true);
            getPriorityKill.setDisable(true);

            // set titanCard content
            HashMap<String, String> nodeDetails = getNodeDetails();
            titanInfoText.setText(String.format("Name: %s\nHeight: %sm\nType: %s\nNumber of Walking Legs: %s\nWalking Pattern: %s\nRunnign Speed: %s\nCan climb: %s\nDanger Risk: %s",
                    nodeDetails.get("name").getValue(),
                    nodeDetails.get("height").getValue(),
                    nodeDetails.get("titanType").getValue(),
                    nodeDetails.get("walkingLegs").getValue(),
                    nodeDetails.get("walkingPattern").getValue(),
                    nodeDetails.get("runningSpeed").getValue(),
                    nodeDetails.get("isClimb").getValue(),
                    nodeDetails.get("dangerRisk").getValue()));
            titanDescText.setText(nodeDetails.get("titanDesc").getValue());
            titanPic.setImage(new Image(App.class.getResource(nodeDetails.get("titanImageUrl").getValue()).toString()));
            Animator.lineAnimation(1000, 0, titanCard);

        } else {
            findShortestPath.setDisable(false);
            showNodeDetails.setDisable(false);
            resetButton.setDisable(false);
            getPriorityKill.setDisable(false);
            Animator.lineAnimation(0, 1000, titanCard);
        }
        isNodeDetailsShown = !isNodeDetailsShown;
    }

    @FXML
    public void resetGraph() {
        String jsonString = fileReader.readFile("src\\main\\resources\\com\\magiconch\\attackontitan\\json\\map.json");
        Graph graph = fileReader.readGraphFromJSON(jsonString, WeightMode.DIFFER_BY_INDEX);
        Provider.setGraph(graph);
        adjMatrix = Provider.getGraphMatrix();

        draw.removeAllEdges();
        draw.removeAllThumb();
        draw.drawOriGraph(adjMatrix);
        draw.drawThumbnail(Provider.getGraph());
    }

    @FXML
    public void getPriorityKill() {
        if (isPriority) {
            findShortestPath.setDisable(true);
            showNodeDetails.setDisable(true);
            resetButton.setDisable(true);
            draw.removeAllEdges();
            getPriorityKill.setText("Reset");
            ArrayList<Vertex> vertices = Provider.getGraph().getVertices();
            PriorityQueue<Titan> pQueue = new PriorityQueue<>(AttributeComparator.getTitanComparator());
            int i = 0;
            for (Vertex v : vertices) {
                if (v.getType().equals(VertexType.TITAN)) {
                    ((Titan) v).setPosition(i);
                    pQueue.add((Titan) v);
                }
                i++;
            }
            LinkedList<Titan> sorted = new LinkedList<>();

            int k = pQueue.size();
            for (int j = 0; j < k; j++) {
                sorted.add(pQueue.poll());
            }
            // display Kill route
            String path = "";
            LinkedList<Integer> steps;
            i = 0;
            LinkedListNode<Titan> tempTitan = sorted.getHead();
            while (tempTitan.getNext() != null) {
                if (i == 0) {
                    steps = Djikstra.djikstra(Provider.getGraphMatrix(), 0, tempTitan.getData().getPosition());

                    LinkedListNode<Integer> temp = steps.getHead();
                    while (temp.getNext() != null) {
                        path += temp.getData().toString() + " -> ";

                        draw.drawLine(temp.getData(), temp.getNext().getData());
                        temp = temp.getNext();
                    }
                }
                steps = Djikstra.djikstra(Provider.getGraphMatrix(), tempTitan.getData().getPosition(), tempTitan.getNext().getData().getPosition());

                LinkedListNode<Integer> temp = steps.getHead();
                while (temp.getNext() != null) {
                    path += temp.getData().toString() + " -> ";

                    draw.drawLine(temp.getData(), temp.getNext().getData());
                    temp = temp.getNext();
                }

                tempTitan = tempTitan.getNext();
                i++;
            }
            path += tempTitan.getData().getPosition();
            
            String[] stop = path.split(" -> ");
            int total = 0;
            for(int l = 0 ; l < stop.length -1 ;l++){
                total += Math.abs(Integer.parseInt(stop[l+1])-Integer.parseInt(stop[l]));
            }
            outputText.setText("Total Distance by Index Difference: "+ total + "\n" + path);

        } else {
            findShortestPath.setDisable(false);
            showNodeDetails.setDisable(false);
            resetButton.setDisable(false);
            getPriorityKill.setText("Get Priority Kill");
            draw.removeAllEdges();
            draw.drawOriGraph(adjMatrix);
            outputText.setText("");

        }
        isPriority = !isPriority;
    }

    private HashMap<String, String> getNodeDetails() {
        HashMap<String, String> nodeDetails = new HashMap<>();
        Node selected = (Node) killNode.getSelectedToggle();
        String src = ((Text) selected.getParent().getChildrenUnmodifiable().get(1)).getText();
        System.out.println("Getting details of " + src);

        Graph graph = Provider.getGraph();

        Vertex v = graph.getVertices().get(Integer.parseInt(src));

        if (v.getType().equals(VertexType.TITAN)) {
            Titan casted = (Titan) v;
            nodeDetails.put("name", casted.getName());
            nodeDetails.put("height", casted.getHeight() + "");
            nodeDetails.put("titanType", casted.getType().toString());
            nodeDetails.put("walkingLegs", casted.getWalkingLegs() + "");
            nodeDetails.put("walkingPattern", casted.getWp() + "");
            nodeDetails.put("runningSpeed", casted.getRunningSpeed() + "");
            nodeDetails.put("isClimb", casted.isClimb() ? "Yes" : "No");
            nodeDetails.put("dangerRisk", casted.getDangerRisk() + "");
            nodeDetails.put("titanDesc", casted.getTitanDesc());
            nodeDetails.put("titanImageUrl", casted.getTitanImageUrl());
        }

        return nodeDetails;
    }

    @FXML
    public void checkIsTitan(ActionEvent e) {
        Node selected = (Node) killNode.getSelectedToggle();
        String src = ((Text) selected.getParent().getChildrenUnmodifiable().get(1)).getText();

        Graph graph = Provider.getGraph();

        Vertex v = graph.getVertices().get(Integer.parseInt(src));

        draw.removeAllEdges();
        draw.drawOriGraph(adjMatrix);
        if(isFound){
            findShortestPath.setText("Find shortest path");
        }
        if(outputText.getText().length() > 0){
            outputText.setText("");
        }
        
        if (v.getType().equals(VertexType.TITAN)) {
            showNodeDetails.setDisable(false);
            findShortestPath.setDisable(false);
        } else {
            showNodeDetails.setDisable(true);
            findShortestPath.setDisable(true);
        }
    }

    @FXML
    public void toggleFinder() {
        draw.removeAllEdges();
        if (isFound) {
            showNodeDetails.setDisable(false);

            //reset the graph
            findShortestPath.setText("Find shortest path");
            outputText.setText("");
            draw.drawOriGraph(adjMatrix);
        } else {
            showNodeDetails.setDisable(true);
            findShortestPath.setText("Cancel");
            // find the shortest path

            Node selected = (Node) killNode.getSelectedToggle();
            int dest = Integer.parseInt(((Text) selected.getParent().getChildrenUnmodifiable().get(1)).getText());

            LinkedList<Integer> steps = Djikstra.djikstra(Provider.getGraphMatrix(), 0, dest);

            LinkedListNode<Integer> temp = steps.getHead();
            String path = "";
            while (temp.getNext() != null) {
                path += temp.getData().toString() + " -> ";

                draw.drawLine(temp.getData(), temp.getNext().getData());
                temp = temp.getNext();
            }
            path += temp.getData();
            outputText.setText("Total Distance: " + steps.getSize() + "\n" + path);

        }
        isFound = !isFound;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // draw initial line
        draw = new GraphDrawer(body);
        draw.drawOriGraph(adjMatrix);
        draw.drawThumbnail(Provider.getGraph());

        // disable showNodeDetails
        showNodeDetails.setDisable(true);
        findShortestPath.setDisable(true);

        // set titan card closing methid
        closeNodeDetail.setOnMouseClicked((e) -> {
            toggleNodeDetails();
        });
    }

    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }

}
