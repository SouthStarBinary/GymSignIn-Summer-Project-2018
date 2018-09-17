/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import persons.Client;
import persons.Member;
import persons.MemberClient;
import saves.SaveMembers;

/**
 *
 * @author jeanp
 */

public class Controller extends ControllerParent implements Initializable {

    @FXML
    Button notbutton;
    @FXML
    MenuItem test;
    @FXML
    Button fuButton;
    @FXML
    ToolBar globalToolBar;
    @FXML
    ListView<String> list;
    
    @FXML
    TextField idTextBox;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
        System.out.println(this.textTest); 
        
        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent click) {
            if (click.getClickCount() == 2) {
                try {
                    getSelectedMember(list.getSelectionModel().selectedItemProperty().getValue());
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           }
          });
        
//        list.getSelectionModel().selectedItemProperty().addListener((v, oldvalue, newvalue) -> 
//        {
//            try {
//                getSelectedMember(newvalue);
//            } catch (IOException ex) {
//                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });

        Client check = new Client("ms123","Samuel", "Lobon","Monthly", "N/A");
        super.memList.add(check);
    }
    
    
    public void handleIdTextBox () {
        System.out.println("Text was entered");
        System.out.println(this.idTextBox.getText());
        SaveMembers loads = new SaveMembers();
        ArrayList<Member> currMems = loads.load();
        Member target = findMem(currMems, this.idTextBox.getText());
        if (target == null){
            System.out.println("Member not found");
        }
        else{
            System.out.println(target.toString());
            list.getItems().add(this.idTextBox.getText());
        } 
        
        this.idTextBox.clear();
    }
    
    public void handleButtonClick () {
        System.out.println("Check check");
        notbutton.setText("Work?");
    }
    
    private Member findMem (ArrayList<Member> l, String target) { 
	for (int i = 0; i < l.size(); i++) {
	    if (l.get(i).getID().compareTo(target) == 0) {
		return l.get(i);
	    }
	}
	return null;
    } 
    
    public void getSelectedMember (String newValue) throws IOException {
        System.out.println(newValue);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateMemberFXML.fxml"));
        Pane pane = loader.load();
        UpdateMemberController nextWin = loader.getController();
        nextWin.setStage(window);
        //this.window = nextWin.window;
        Member mem = findMember(newValue);
        nextWin.setMemID(mem.getID());
        nextWin.setMemFirst(mem.getFirstName());
        nextWin.setMemLast(mem.getLastName());
        if (mem.getMembershipType().compareTo("Trainer") == 0) { 
            nextWin.setMemType(mem.getMembershipType());
        } 
        else { 
            
        }
        nextWin.setMemType(mem.getMembershipType());
        double height, width;
        height = this.window.getHeight();
        width = this.window.getWidth();
        this.window.setScene(new Scene(pane,width,height));
        
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateMemberFXML.fxml"));
//        Pane root = loader.load();
//        // Get the Controller from the FXMLLoader
//        UpdateMemberController nextWin = loader.getController();
//        nextWin.setMemID(newValue);
//        double height, width;
//        height = this.window.getHeight();
//        width = this.window.getWidth();
//        this.window.setScene(new Scene(root,width,height));
    } 
    
    
}

