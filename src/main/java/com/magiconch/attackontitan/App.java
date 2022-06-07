package com.magiconch.attackontitan;

import com.magiconch.backend.Attribute;
import com.magiconch.backend.BGMPlayer;
import com.magiconch.backend.LinkedList;
import com.magiconch.backend.Member;
import com.magiconch.backend.Music;
import com.magiconch.backend.Operations;
import com.magiconch.utility.fileReader;
//import com.magiconch.controllers.SceneController;
import com.magiconch.controllers.ScreenController;
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
    
    public static String brain = "controlCenter";
    public static String characterPage = "characterPage";
    public static String mariaWallPage = "mariaWallPage";
    public static String decipherPage = "decipherPage";
    public static String killTitansPage = "killTitanPage";
    public static String scoutingPage = "scoutingPage";
    public static String searchPage = "searchPage";
            
    public static String brainFile = "/src/main/resources/com/magiconch/attackontitan/navBar.fxml";
    public static String characterPageFile = "/src/main/resources/com/magiconch/attackontitan/characterPage.fxml";
    public static String mariaWallPageFile = "/src/main/resources/com/magiconch/attackontitan/mariaWallPage.fxml";
    public static String decipherPageFile = "/src/main/resources/com/magiconch/attackontitan/decipherPage.fxml";
    public static String killTitansPageFile = "/src/main/resources/com/magiconch/attackontitan/killTitansPage.fxml";
    public static String scoutingPageFile = "/src/main/resources/com/magiconch/attackontitan/scoutingPage.fxml";
    public static String searchPageFile = "/src/main/resources/com/magiconch/attackontitan/searchPage.fxml";
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        //Initialise all the fxml file
        ScreenController mainContainer = new ScreenController();
        mainContainer.loadScreen(brain, brainFile);
        mainContainer.loadScreen(characterPage, characterPageFile);
        mainContainer.loadScreen(mariaWallPage, mariaWallPageFile);
        mainContainer.loadScreen(decipherPage, decipherPageFile);
        mainContainer.loadScreen(killTitansPage, killTitansPageFile);
        mainContainer.loadScreen(scoutingPage, scoutingPageFile);
        mainContainer.loadScreen(searchPage, searchPageFile);
        
        mainContainer.setScreen(brain);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        
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
                String jsonString = fileReader.readFile("src/main/resources/com/magiconch/attackontitan/json/bgmList.json");
                LinkedList<Music> queue = fileReader.getBGMQueueFromJSON(jsonString);
                BGMPlayer.initPlayer(queue);
                BGMPlayer.startPlayer();
                new SceneController().switchToNavBar(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Scene scene = new Scene(root, 1280, 720);
        Image icon = new Image("assets/images/aot_logo.png");
        primaryStage.getIcons().add(icon);
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

//        String jsonString = fileReader.readFile("C:/Users/User/Documents/Git Netbeans/attackontitan/src/main/resources/com/magiconch/attackontitan/json/members.json");
//        LinkedList<Member> members = fileReader.getMembersFromJSON(jsonString);
//        Member[] sorted = Operations.sortBy(Attribute.STRENGTH, members, true);
//        for (Member member : sorted) {
//            System.out.printf("%s %d\n", member.getName(), member.getStrength());
//        }
//
//        Member[] matched = Operations.search(Attribute.STRENGTH, members, 1);
//        
//        if (matched == null) {
//            System.out.println("No result is found");
//        } else {
//            for (Member member : matched) {
//                System.out.printf("%s %d\n", member.getName(), member.getStrength());
//            }
//        }

        launch();
    }
}
