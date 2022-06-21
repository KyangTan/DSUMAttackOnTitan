package com.magiconch.controllers;

import com.magiconch.backend.LinkedListNode;
import com.magiconch.backend.Member;
import com.magiconch.backend.Provider;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
//<<<<<<< HEAD
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.apache.commons.lang3.math.NumberUtils; 
//=======
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
//>>>>>>> origin/main

public class searchPageController implements Initializable, ControlledScreen {

    @FXML
    private TableColumn<Member, Integer> charAgiCol;

    @FXML
    private TableColumn<Member, Integer> charCoorCol;

    @FXML
    private TableColumn<Member, Integer>charHeightCol;

    @FXML
    private TableColumn<Member, Integer> charIntCol;

    @FXML
    private TableColumn<Member, Integer>charLeadCol;

    @FXML
    private TableColumn<Member, String> charNameCol;

    @FXML
    private TableColumn<Member, Integer> charStrCol;

    @FXML
    private TableColumn<Member, Integer> charWeightCol;
    
    @FXML
    private TableView<Member> charTable;

    @FXML
    private TextField searchTextField;

    
//    @FXML
//    private AnchorPane scrollAPane;
    
//    @FXML
//    private ScrollPane scroll;
    
    ObservableList<Member> memberModelObservableList = FXCollections.observableArrayList();
    
    ScreenController myController;

    LinkedListNode<Member> tempNode = new LinkedListNode<>();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        tempNode = Provider.getMemberList().getHead();
//        for (int i = 0; i < Provider.getMemberList().getSize(); i++) {
//            memberModelObservableList.add(tempNode.getData());
//            tempNode = tempNode.getNext();
//        }
        int boxHeight = Provider.getMemberList().getSize()*95 +20;
//        scrollAPane.setPrefHeight(boxHeight);
//        searchCardVBox.setPrefHeight(boxHeight);
Node[] nodes = new Node[Provider.getMemberList().getSize()];
for (int j = 0; j < nodes.length; j++) {
//                FXMLLoader contentLoader = new FXMLLoader();
//                contentLoader.setLocation(getClass().getResource("/com/magiconch/attackontitan/searchCardComponent.fxml"));
//                nodes[j] = contentLoader.load();
//                final int h = j;
//
//                characterCardComponentController charController = contentLoader.getController();
//                charController.setContentInfo("", tempNode.getData().getName(), j);               
//                searchCardComponentController sccController = contentLoader.getController();
//
//                
//                nodes[h].setOnMousePressed(evt -> {
//                    //add code here when clicked
//                });
//
////                characterVBox.getChildren().add(nodes[j]);
//                tempNode = tempNode.getNext();
//
memberModelObservableList.add(new Member(tempNode.getData().getName(), tempNode.getData().getHeight(), tempNode.getData().getWeight(), tempNode.getData().getStrength(), tempNode.getData().getAgility(), tempNode.getData().getIntelligence(), tempNode.getData().getCoordination(), tempNode.getData().getLeadership(), tempNode.getData().getDesc(), tempNode.getData().getImageUrl()));
tempNode = tempNode.getNext();
}
charCoorCol.setCellValueFactory(new PropertyValueFactory<>("Coordination"));
charCoorCol.setResizable(false);
charHeightCol.setCellValueFactory(new PropertyValueFactory<>("Height"));
charHeightCol.setResizable(false);
charIntCol.setCellValueFactory(new PropertyValueFactory<>("Intelligence"));
charIntCol.setResizable(false);
charLeadCol.setCellValueFactory(new PropertyValueFactory<>("Leadership"));
charLeadCol.setResizable(false);
charNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
charNameCol.setResizable(false);
charStrCol.setCellValueFactory(new PropertyValueFactory<>("Strength"));
charStrCol.setResizable(false);
charWeightCol.setCellValueFactory(new PropertyValueFactory<>("Weight"));
charWeightCol.setResizable(false);
charAgiCol.setCellValueFactory(new PropertyValueFactory<>("Agility"));
charAgiCol.setResizable(false);

search();

charTable.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
//                    if (!charTable.getSelectionModel().equals(null)) {
//                        charNameCol.setText(charTable.getSelectionModel().getSelectedItem().getName());
//                        charCoorCol.setText(Integer.toString(charTable.getSelectionModel().getSelectedItem().getCoordination()));
//                        charHeightCol.setText(Integer.toString(charTable.getSelectionModel().getSelectedItem().getHeight()));
//                        charIntCol.setText(Integer.toString(charTable.getSelectionModel().getSelectedItem().getIntelligence()));
//                        charLeadCol.setText(Integer.toString(charTable.getSelectionModel().getSelectedItem().getLeadership()));
//                        charStrCol.setText(Integer.toString(charTable.getSelectionModel().getSelectedItem().getStrength()));
//                        charWeightCol.setText(Integer.toString(charTable.getSelectionModel().getSelectedItem().getWeight()));   
//                        charAgiCol.setText(Integer.toString(charTable.getSelectionModel().getSelectedItem().getAgility()));   
//                    }
                }
            });


    }

    @Override
    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent; //To change body of generated methods, choose Tools | Templates.
    }

    
    public void search() {
//        String searchKeyword = searchTextField.getText();
//        
//        if (searchKeyword.startsWith("Agi")) {
//            
//        }
//        else if(searchKeyword.startsWith("Str")){
//        
//        }
//        else if(searchKeyword.startsWith("Hei")){
//            
//        }
//        else if(searchKeyword.startsWith("Int")){
//            
//        }
//        else if(searchKeyword.startsWith("Coo")){
//            
//        }
//        else if(searchKeyword.startsWith("Lea")){
//            
//        }
//        else if(searchKeyword.startsWith("Wei")){
//            
//        }
//        else if(searchKeyword.startsWith("Nam")){
//            
//        }
//        else{}
//    
        // Initialise filtered list
        FilteredList<Member> filteredData = new FilteredList<>(memberModelObservableList, b -> true);

        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(memberSearchModel -> {

                // If no values input, no change to the list
                if (newValue.isEmpty() || newValue.isEmpty() || newValue == null) {
                    return true;
                }

//                double unsimilarity = 0;
                String searchKeyword = newValue.toLowerCase();
//                System.out.println("Seach keyword is: " + searchKeyword);
//                System.out.println("The coursename is: " +courseSearchModel.getCourseName().toLowerCase());
//                char[] courseNameCheckerArray = courseSearchModel.getCourseName().toLowerCase().toCharArray();
//                if (searchKeyword.length() <= courseSearchModel.getCourseName().toLowerCase().length() ) {
//                    for (int k = 0; k < searchKeyword.length(); k++) {
//                        if (searchKeyword.charAt(k) != courseNameCheckerArray[k]) {
////                            System.out.println(searchKeyword.charAt(k)+ " is different with " + courseNameCheckerArray[k]);
//                            unsimilarity++;
//                        }
//                    }
//                }
//                else{
//                    unsimilarity = searchKeyword.length();
//                }
                
//                unsimilarity = (unsimilarity / searchKeyword.length())*100.00;
//                System.out.println("Unsimilarity%: " + unsimilarity);
                if (memberSearchModel.getName().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true; // Found a match in course name
                } else if (Integer.toString(memberSearchModel.getAgility()).indexOf(searchKeyword) > -1) {
                    return true; // Found a match in course name
//                } else if (memberSearchModel.getOccName().toLowerCase().indexOf(searchKeyword) > -1) {
//                    return true; // Found a match in occ
                } else {
                    return false;
                }
//                if (courseSearchModel.getCourseName().toLowerCase().indexOf(searchKeyword) > -1 || unsimilarity <=30) {
//                    return true; // Found a match in course name
//                } else if (courseSearchModel.getCourseID().toLowerCase().indexOf(searchKeyword) > -1) {
//                    return true; // Found a match in course name
//                } else if (courseSearchModel.getOccName().toLowerCase().indexOf(searchKeyword) > -1) {
//                    return true; // Found a match in occ
//                } else {
//                    return false;
//                }
            });
        });

        SortedList<Member> sortedData = new SortedList<>(filteredData);

        //Bind sorted result with Table View
        sortedData.comparatorProperty().bind(charTable.comparatorProperty());
        charTable.setItems(sortedData);
    }
}
