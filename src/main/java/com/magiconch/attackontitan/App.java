package com.magiconch.attackontitan;

import com.magiconch.backend.Attribute;
import com.magiconch.backend.BGMPlayer;
import com.magiconch.backend.GraphRelated.Djikstra;
import com.magiconch.backend.GraphRelated.Graph;
import com.magiconch.backend.GraphRelated.WeightMode;
import com.magiconch.backend.LinkedList;
import com.magiconch.backend.Member;
import com.magiconch.backend.Music;
import com.magiconch.backend.Operations;
import com.magiconch.backend.Provider;
import com.magiconch.controllers.SceneController;
import com.magiconch.utility.fileReader;
//import com.magiconch.controllers.SceneController;
import com.magiconch.controllers.ScreenController;
import com.magiconch.utility.CommonMethod;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class App extends Application {

    private final CommonMethod method = new CommonMethod();
    
    public static String brain = "controlCenter";

            
    public static String brainFile = "/com/magiconch/attackontitan/navBar.fxml";

    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        //Add character
        Provider.addMember(new Member("Reiner Braun", 185,95,9,7,7,10,8));
        Provider.addMember(new Member("Armin Arlert", 163,55,2,6,10,8,8));
        Provider.addMember(new Member("Annie Leonhart", 153,54,10,7,7,3,1));
        Provider.addMember(new Member("Bertholdt Hoover", 192,81,9,4,6,9,2));
        Provider.addMember(new Member("Jean Kristein", 175,65,9,8,7,5,9));
        Provider.addMember(new Member("Sasha Blouse", 165,55,6,3,5,6,7));
        Provider.addMember(new Member("Connie Springer", 158,58,6,7,3,7,5));
        Provider.addMember(new Member("Mikasa Ackerman", 170,68,10,9,8,6,7));
        Provider.addMember(new Member("Eren Yeager", 170,63,9,10,3,5,10));
        Provider.addMember(new Member("Historia Reiss", 145,42,4,8,7,6,5));
        Provider.addMember(new Member("Levi Ackerman", 160,65,12,12,7,8,8));
        Provider.addMember(new Member("Erwin Smith", 188,92,8,8,11,10,12));
        Provider.addMember(new Member("Hange Zoë", 170,60,9,9,12,7,11));  
        
        //Initialise all the fxml file
        ScreenController mainContainer = new ScreenController();
        System.out.println(mainContainer.loadScreen(brain, brainFile));

        
        mainContainer.setScreen(brain);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        
        // set Primary Stage
//        SceneController.setPrimaryStage(primaryStage);

        //Instantiating Media class  
        String vidPath = "src\\main\\resources\\com\\magiconch\\attackontitan\\assets\\videos\\opening.mp4";
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
//        Group root = new Group();
        root.getChildren().add(mediaView);
        mediaPlayer.setOnEndOfMedia(() -> {
            // switch to static
            root.getChildren().add(img);
        });

        mediaView.setOnMouseClicked(e->{
            mediaPlayer.stop();
            mediaPlayer.dispose();
            String jsonString = fileReader.readFile("src\\main\\resources\\com\\magiconch\\attackontitan\\json\\bgmList.json");
            LinkedList<Music> queue = fileReader.getBGMQueueFromJSON(jsonString);
            BGMPlayer.initPlayer(queue);
            BGMPlayer.startPlayer();
//            root.setOnMouseClicked();
            mainContainer.setScreen(brain);
            System.out.println("\n\n\n removing");
            root.getChildren().remove(mediaView);
        });
//        root.setOnMouseClicked(e -> {
//            mediaPlayer.stop();
//            mediaPlayer.dispose();
//            String jsonString = fileReader.readFile("C:\\Users\\kwany\\Documents\\NetBeansProjects\\attackontitan\\src\\main\\resources\\com\\magiconch\\attackontitan\\json\\bgmList.json");
//            LinkedList<Music> queue = fileReader.getBGMQueueFromJSON(jsonString);
//            BGMPlayer.initPlayer(queue);
//            BGMPlayer.startPlayer();
////            root.setOnMouseClicked();
//            mainContainer.setScreen(brain);
//            System.out.println("\n\n\n removing");
//            root.removeEventHandler(MouseEvent.MOUSE_CLICKED, root.getOnMouseClicked());
//        });
        
        
        
        Scene scene = new Scene(root, 1280, 720);
        Image icon = new Image(new File("assets/images/aot_logo.png").toURI().toString());
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Attack on Titan");
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        String jsonString = fileReader.readFile("src\\main\\resources\\com\\magiconch\\attackontitan\\json\\map.json");
        Graph graph = fileReader.readGraphFromJSON(jsonString, WeightMode.DIFFER_BY_INDEX);
//        graph.printGraph();
//        Djikstra.dijkstra(graph.getAdjacencyMatrix(), 2);
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
