/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.utility;

import com.magiconch.attackontitan.App;
import com.magiconch.backend.GraphRelated.Graph;
import com.magiconch.backend.GraphRelated.Vertex;
import com.magiconch.backend.GraphRelated.VertexType;
import com.magiconch.backend.Titan;
import java.util.ArrayList;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

/**
 *
 * @author WeiXin
 */
public class GraphDrawer {

    private AnchorPane body;

    public GraphDrawer(AnchorPane body) {
        this.body = body;
    }

    public void drawOriGraph(ArrayList<ArrayList<Integer>> adjMatrix) {
        if (!bodyChecker()) {
            return;
        }
        for (int i = 0; i < adjMatrix.size(); i++) {
            for (int j = i + 1; j < adjMatrix.size(); j++) {
                if (adjMatrix.get(i).get(j) > 0) {
                    drawLine(i, j);
                }
            }
        }
    }

    // draw line between nodes
    public void drawLine(int src, int dest) {
        if (!bodyChecker()) {
            return;
        }

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

    public void drawThumbnail(Graph graph) {
        if (!bodyChecker()) {
            return;
        }

        ArrayList<Vertex> vertices = graph.getVertices();
        int i = 0;
        for (Vertex v : vertices) {
            if (v.getType().equals(VertexType.TITAN)) {
                final int index = i;
                Titan casted = (Titan) v;

                String imageUrl = casted.getTitanImageUrl();

                ImageView thumbnail = new ImageView(new Image(App.class.getResource(imageUrl).toString()));
                // set Id
                thumbnail.setId("thumbnail" + i);

                // make aspect ratio always 1:1
                thumbnail.setPreserveRatio(true);

                // set size to 30 x 30
                thumbnail.setFitWidth(30);

                // offset
                thumbnail.setTranslateX(25);
                thumbnail.setTranslateY(25);

                // add thumbnail to titan nodes
                body.getChildren().forEach(
                        (node) -> {
                            if (node.getId() != null && node.getId().equals("node" + index)) {
                                ((StackPane) node).getChildren().add(thumbnail);
                            } else {
                                return;
                            }
                        }
                );

            }
            i++;
        }

    }

    public void removeAllEdges() {
        if (!bodyChecker()) {
            return;
        }
        body.getChildren().removeIf((node) -> {

            return node.getId() == null ? false : node.getId().startsWith("edge");
        });
    }

    public void removeAllThumb() {
        if (!bodyChecker()) {
            return;
        }
        body.getChildren().forEach((node) -> {
            try {
                ((RadioButton)((StackPane)node).getChildren().get(0)).setSelected(false);
            } catch (Exception e) {
                //
            } finally {
                if (node.getId() != null && node.getId().startsWith("node")) {
                    ((StackPane) node).getChildren().removeIf(
                            (n) -> {
                                return n.getId() == null ? false : n.getId().startsWith(("thumbnail"));
                            }
                    );
                }

            }

        });
    }

    private boolean bodyChecker() {
        if (body == null) {
            return false;
        }
        return true;
    }
}
