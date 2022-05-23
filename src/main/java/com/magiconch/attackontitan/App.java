package com.magiconch.attackontitan;

import com.magiconch.backend.Graph;
import com.magiconch.backend.HamiltonianCycle;
import com.magiconch.backend.Vertex;
import com.magiconch.backend.VertexType;
import com.magiconch.backend.WeightMode;
import com.magiconch.utility.fileReader;
import com.magiconch.controllers.SceneController;
import com.magiconch.utility.CommonMethod;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class App extends Application {

    private final CommonMethod method = new CommonMethod();

    @Override
    public void start(Stage primaryStage) throws IOException {
        // set Primary Stage
        SceneController.setPrimaryStage(primaryStage);

        //Instantiating Media class  
        String vidPath = "src/main/resources/com/magiconch/attackontitan/assets/videos/opening.mp4";
        Media media = new Media(new File(vidPath).toURI().toString());

        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //Instantiating MediaView class   
        MediaView mediaView = new MediaView(mediaPlayer);

        //by setting this property to true, the Video will be played   
        mediaPlayer.setAutoPlay(true);

        // static waiting screen
        ImageView img = new ImageView(new Image(method.getPathToResources("assets/images/opening.png")));

        //setting group and scene   
        Group root = new Group();
        root.getChildren().add(mediaView);
        mediaPlayer.setOnEndOfMedia(() -> {
            // switch to static
            root.getChildren().add(img);
        });

        root.setOnMouseClicked(e -> {
            try {
                mediaPlayer.stop();
                new SceneController().switchToScoutingScene(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Attack on Titan");
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        String jsonString = fileReader.readFile("C:\\Users\\User\\Documents\\Git Netbeans\\attackontitan\\src\\main\\resources\\com\\magiconch\\attackontitan\\assets\\images\\simplemap.json");
        Graph graph = fileReader.readGraphFromJSON(jsonString, WeightMode.NO_WEIGHT);
        ArrayList<String> paths = new HamiltonianCycle().hamCycle(graph.getAdjacencyMatrix(), 0);
        for (String s : paths) {
            System.out.println(s);
        }

//        launch();
    }
}
