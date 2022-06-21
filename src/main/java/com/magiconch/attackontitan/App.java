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
import java.io.InputStream;
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
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class App extends Application {

    private final CommonMethod method = new CommonMethod();
    
    public static String brain = "controlCenter";

            
    public static String brainFile = "/com/magiconch/attackontitan/navBar.fxml";

    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
//        String resourceName = "/com/magiconch/attackontitan/json/members.json";
//        InputStream is = App.class.getResourceAsStream(resourceName);
//        if (is == null) {
//            throw new NullPointerException("Cannot find resource file " + resourceName);
//        }
//
//        JSONTokener tokener = new JSONTokener(is);
//        JSONArray WholeThing = new JSONArray(tokener);
//        for (int i = 0; i < WholeThing.length(); i++) {
//            JSONObject object = WholeThing.getJSONObject(i);
//            Provider.addMember(new Member(object.getString("Name"), object.getInt("Height"),object.getInt("Weight"),object.getInt("Strength"),object.getInt("Agility"),object.getInt("Intelligence"),object.getInt("Coordination"),object.getInt("Leadership")));
//        }

        
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
        //set graph
        String jsonString = fileReader.readFile("src\\main\\resources\\com\\magiconch\\attackontitan\\json\\map.json");
        Graph graph = fileReader.readGraphFromJSON(jsonString, WeightMode.DIFFER_BY_INDEX);
        Provider.setGraph(graph);
        
        // add characters
        LinkedList<Member> members = fileReader.getMembersFromJSON(fileReader.readFile("src\\main\\resources\\com\\magiconch\\attackontitan\\json\\members.json"));
        Provider.setMemberList(members);
//        graph.printGraph();
//        Djikstra.djikstra(graph.getAdjacencyMatrix(), 0, 14);
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
