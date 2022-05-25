package com.magiconch.attackontitan;

import com.magiconch.backend.Attribute;
import com.magiconch.backend.BGMPlayer;
import com.magiconch.backend.LinkedList;
import com.magiconch.backend.Member;
import com.magiconch.backend.Music;
import com.magiconch.backend.Operations;
import com.magiconch.utility.fileReader;
import com.magiconch.controllers.SceneController;
import com.magiconch.utility.CommonMethod;
import java.io.File;
import java.io.IOException;
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
                mediaPlayer.dispose();
                String jsonString = fileReader.readFile("C:/Users/User/Documents/Git Netbeans/attackontitan/src/main/resources/com/magiconch/attackontitan/json/bgmList.json");
                LinkedList<Music> queue = fileReader.getBGMQueueFromJSON(jsonString);
                BGMPlayer.initPlayer(queue);
                BGMPlayer.startPlayer();
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
//        Graph graph = fileReader.readGraphFromJSON(jsonString, WeightMode.NO_WEIGHT);
//        ArrayList<String> paths = new HamiltonianCycle().hamCycle(graph.getAdjacencyMatrix(), 0);
//        for (String s : paths) {
//            System.out.println(s);
//        }
//        for(Music music : queue){
//            System.out.println(music.getSongName());
//            System.out.println(music.getSongPath());
//        }

        String jsonString = fileReader.readFile("C:/Users/User/Documents/Git Netbeans/attackontitan/src/main/resources/com/magiconch/attackontitan/json/members.json");
        LinkedList<Member> members = fileReader.getMembersFromJSON(jsonString);
        Member[] sorted = Operations.sortBy(Attribute.STRENGTH, members, true);
        for (Member member : sorted) {
            System.out.printf("%s %d\n", member.getName(), member.getStrength());
        }

        Member[] matched = Operations.search(Attribute.STRENGTH, members, 1);
        
        if (matched == null) {
            System.out.println("No result is found");
        } else {
            for (Member member : matched) {
                System.out.printf("%s %d\n", member.getName(), member.getStrength());
            }
        }

//        launch();
    }
}
