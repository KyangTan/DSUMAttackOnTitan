package     com.magiconch.controllers;

import com.magiconch.backend.Member;
import com.magiconch.backend.Provider;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
            successMsg.setVisible(true);
        } catch (NumberFormatException e) {
            errorMsg.setVisible(true);
        }
    }
}
