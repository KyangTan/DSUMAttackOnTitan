package     com.magiconch.controllers;

import com.magiconch.backend.LinkedListNode;
import com.magiconch.backend.Member;
import com.magiconch.backend.Provider;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class addNewCharacterController implements Initializable{

    @FXML
    private TextField abilityTextField;

    @FXML
    private Button addCharButton;
    
    @FXML
    private Button backButton;

    @FXML
    private TextField animeRatingTextField;

    @FXML
    private TextField coordinationTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField intelligenceTextField;

    @FXML
    private TextField leadershipTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField strengthTextField;

    @FXML
    private TextField weightTextField;
    
    @FXML
    private Text successMsg;
    
    @FXML
    private Text errorMsg;
    
    
    String name;
    int height;
    int weight;
    int strength;
    int ability;
    int intelligence;
    int coordination;
    int leadership;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorMsg.setVisible(false);
        successMsg.setVisible(false);
    }

    @FXML
    void back(ActionEvent event) {
        //Cancel button to back to login page
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void addChar(ActionEvent event) {
        errorMsg.setVisible(false);
        successMsg.setVisible(false);
        try {
            name = nameTextField.getText();
            height = Integer.parseInt(heightTextField.getText());
            weight = Integer.parseInt(weightTextField.getText());
            strength = Integer.parseInt(strengthTextField.getText());
            ability = Integer.parseInt(abilityTextField.getText());
            intelligence = Integer.parseInt(intelligenceTextField.getText());
            coordination = Integer.parseInt(coordinationTextField.getText());
            leadership = Integer.parseInt(leadershipTextField.getText());

            Provider.addMember(new Member(name,height,weight,strength,ability,intelligence,coordination,leadership));
            
            LinkedListNode tempNode = new LinkedListNode();
            tempNode = Provider.getMemberList().getHead();
            
            JSONArray jsonArray = new JSONArray();
            
        
            while (tempNode!= null) {
                try {
                    JSONObject memberJSON = new JSONObject();
                    JSONObject memberAttributesJSON = new JSONObject();

                    Member mem = (Member) tempNode.getData();
                    memberAttributesJSON.put("Name", mem.getName());
                    memberAttributesJSON.put("Height", mem.getHeight());
                    memberAttributesJSON.put("Weight", mem.getWeight());
                    memberAttributesJSON.put("Strength", mem.getStrength());
                    memberAttributesJSON.put("Agility", mem.getAgility());
                    memberAttributesJSON.put("Intelligence", mem.getIntelligence());
                    memberAttributesJSON.put("Coordination", mem.getCoordination());
                    memberAttributesJSON.put("Leadership", mem.getLeadership()); 
                    jsonArray.put(memberAttributesJSON);
                    tempNode = tempNode.getNext();

                } catch (JSONException ex) {
//                    Logger.getLogger(AOTBruh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        
//            File dir = new File("/com/magiconch/attackontitan/json");
//            File dir = new File("src\\main\\resources\\com\\magiconch\\attackontitan\\json\\members.json");
            File dir = new File(("C:\\Users\\kwany\\Documents\\NetBeansProjects\\attackontitan\\src\\main\\resources\\com\\magiconch\\attackontitan\\json"));
            File actualFile = new File(dir,"members.json" );
        try (FileWriter file = new FileWriter(actualFile)) {
            file.write(jsonArray.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + jsonArray);
        } catch(Exception e){
            System.out.println(e);

        }
            
            successMsg.setVisible(true);
        } catch (NumberFormatException e) {
            errorMsg.setVisible(true);
        }
    }
}
