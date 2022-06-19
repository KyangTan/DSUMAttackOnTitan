package com.magiconch.controllers;

import com.magiconch.backend.GraphRelated.HamiltonianCycle;
import com.magiconch.backend.Provider;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class scoutingPageController implements Initializable, ControlledScreen {

    @FXML
    private AnchorPane body;

    @FXML
    private Text cliOutputText;

    @FXML
    private Button scoutButton;

    @FXML
    private ToggleGroup startNode;

    ScreenController myController;

    @FXML
    void scout(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // draw initial line
        ArrayList<ArrayList<Integer>> adjMatrix = Provider.getGraphMatrix();
        for (int i = 0; i < adjMatrix.size(); i++) {
            for (int j = i + 1; j < adjMatrix.size(); j++) {
                if (adjMatrix.get(i).get(j) > 0) {
                    drawLine(i, j);
                }
            }
        }

    }

    // draw line between nodes
    private void drawLine(int src, int dest) {
        double[] from = getCoord(src);
        double[] to = getCoord(dest);

        Line line = new Line(from[0], from[1], to[0], to[1]);
//        line.setStyle("-fx-stroke: #EAD6C4;-fx-stroke-width: 5px;");
        line.getStyleClass().add("edges");
        line.setId(String.format("edge%d-%d", src, dest));

        body.getChildren().add(1, line);
    }

    // get Coord on screen
    private double[] getCoord(int index) {
        double offsetX = 30;
        double offsetY = 30;

        double[] xy = new double[2];
        body.getChildren().forEach(
                (node) -> {
                    if (node.getId() != null && node.getId().equals("node" + index)) {
                        xy[0] = node.getLayoutX() + offsetX;
                        xy[1] = node.getLayoutY() + offsetY;
                    } else {
                        return;
                    }
                }
        );
        return xy;
    }

    // drawing animation
//    public void drawAnimation(String[] path) {
//        int i = 0;
//        Timeline timeline = new Timeline();
//        timeline.setCycleCount(1);
//        timeline.setAutoReverse(false);
//        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(00), new EventHandler<ActionEvent>() {
//            final int[] counter = {0};
//            @Override
//            public void handle(ActionEvent e) {
//                drawLine(Integer.parseInt(path[i]), Integer.parseInt(path[0]));
//                counter[0]++;
//            }
//        }));
//        timeline.play();
//    }
    @FXML
    public void getHamiltonianCycle() throws InterruptedException {
        Node selected = (Node) startNode.getSelectedToggle();
        String src = ((Text) selected.getParent().getChildrenUnmodifiable().get(1)).getText();

        ArrayList<String> paths = new HamiltonianCycle().hamCycle(Provider.getGraphMatrix(), Integer.parseInt(src));

        if (paths == null) {
            // show pop up
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("No cycle found");
            a.setContentText("Current starting position does not have any Hamiltonian Cycle. Please select other node to start");
            Stage stageA = (Stage) a.getDialogPane().getScene().getWindow(); // get the window of alert box and cast to stage to add icons
//                    stageA.getIcons().add(new Image(App.class.getResource("assets/company/logo2.png").toString()));
            stageA.showAndWait();
        } else {
            // start animation
            body.getChildren().removeIf((node) -> {
                return node.getId().startsWith("edge");
            });

            String[] path = paths.get(0).trim().split(" ");
            for (int i = 0; i < path.length; i++) {
                if (i == path.length - 1) {
                    drawLine(Integer.parseInt(path[i]), Integer.parseInt(path[0]));
                    continue;
                }
                drawLine(Integer.parseInt(path[i]), Integer.parseInt(path[i + 1]));
            }
        }
    }

    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }

}
