package com.magiconch.controllers;

import static com.magiconch.backend.CipherClass.myDecrypt;
import static com.magiconch.backend.CipherClass.myEncrypt;
import static com.magiconch.backend.MarleyClass.marleyToParadis;
import com.magiconch.backend.ParadisClass;
import static com.magiconch.backend.ParadisClass.caesarEncrypt;
import static com.magiconch.backend.ParadisClass.paradisConverter;
import static com.magiconch.backend.ParadisClass.paradisInverter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class dechiperToMarleyController implements Initializable, ControlledScreen{

    @FXML
    private Button backButton;

    @FXML
    private Pane continueCaesarPane;

    @FXML
    private Pane continueMychiperPane;
    
    @FXML
    private Pane paradisInputPane;
    
    @FXML
    private VBox fourInputVBox;
    
    @FXML
    private TextField paradisSentenceTextBox;
    
    @FXML
    private TextField caesarIndexTextBox;

    @FXML
    private TextField startIndex;
    
    @FXML
    private TextField endIndex;
    
    @FXML
    private Text errorMsg;

    @FXML
    private Button toMarleyButton;

    @FXML
    private Button continueMychiperButton;

    @FXML
    private Button discontinueMychiperButton;

    @FXML
    private Button continueCaesarButton;

    @FXML
    private Button discontinueCaesarButton;
    
    @FXML
    private TextField marleyOutputTextBox;
    
    ScreenController myController = new ScreenController();
    String paradis = "";
    boolean caesarPressedOnce = false;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorMsg.setText("Important note!!! Do not insert caesar cipher that breaks this sequence: &num{");
        paradisInputPane.setVisible(true);
        toMarleyButton.setVisible(true);
        fourInputVBox.setVisible(false);
        continueCaesarPane.setVisible(false);
        continueMychiperPane.setVisible(false);
        
    }
    
    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    void back(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toMarleySentence(ActionEvent event) {
        paradis = paradisConverter(paradisInverter(paradisSentenceTextBox.getText()));
        marleyOutputTextBox.setText(paradis);
        
        paradisInputPane.setVisible(true);
        toMarleyButton.setVisible(false);
        fourInputVBox.setVisible(false);
        continueCaesarPane.setVisible(true);
        continueMychiperPane.setVisible(false);
    }
    
    void caesar(){
        try {
            int caesarI = Integer.parseInt(caesarIndexTextBox.getText());
            int startI = Integer.parseInt(startIndex.getText());
            int endI = Integer.parseInt(endIndex.getText());
            paradis = caesarEncrypt(paradis, caesarI, startI, endI);
        } catch (NumberFormatException e) {
            errorMsg.setText("Please input the following type: String Int Int Int");
        }
    }
    
    //After continue caesar
    @FXML
    void continueCaesar(ActionEvent event) {
        if (!caesarPressedOnce) {
            paradisInputPane.setVisible(false);
            toMarleyButton.setVisible(false);
            fourInputVBox.setVisible(true);
            continueCaesarPane.setVisible(true);
            continueMychiperPane.setVisible(false);
            
            caesarPressedOnce = true;
        }else{
            caesar();
            marleyOutputTextBox.setText(paradis);
        }
    }

    @FXML
    void discontinueCaeser(ActionEvent event) {
        marleyToParadis(paradis);
        marleyOutputTextBox.setText(paradis);
        
        paradisInputPane.setVisible(false);
        toMarleyButton.setVisible(false);
        fourInputVBox.setVisible(true);
        continueCaesarPane.setVisible(false);
        continueMychiperPane.setVisible(true);
    }
    
    void mychiper(){
        paradis = myEncrypt(paradis);
    }
    
    //Want continue Mychiper
    @FXML
    void continueMychiper(ActionEvent event) {
        mychiper();
        marleyOutputTextBox.setText(paradis);

        paradisInputPane.setVisible(true);
        toMarleyButton.setVisible(true);
        fourInputVBox.setVisible(false);
        continueCaesarPane.setVisible(false);
        continueMychiperPane.setVisible(false);
            
        caesarPressedOnce = false;
    }

    @FXML
    void discontinueMychiper(ActionEvent event) {
        marleyOutputTextBox.setText(paradis);

        paradisInputPane.setVisible(true);
        toMarleyButton.setVisible(true);
        fourInputVBox.setVisible(false);
        continueCaesarPane.setVisible(false);
        continueMychiperPane.setVisible(false);
            
        caesarPressedOnce = false;
        
        System.out.println("Proof: "+marleyToParadis(myDecrypt(paradis)));
    }

}
