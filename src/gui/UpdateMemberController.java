/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import persons.Member;

/**
 *
 * @author jeanp
 */
public class UpdateMemberController extends ControllerParent implements Initializable {
    
    @FXML
    TextField firstNameText;
    @FXML
    TextField lastNameText;
    @FXML
    TextField IDText;
    @FXML
    ChoiceBox<String> membershipType;
    @FXML
    ChoiceBox<String> trainer;
    @FXML
    Button submit; 

    String memID;
    Member mem;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        //IDText.setEditable(true);
        //System.out.println(memID);
        System.out.println(memID + "from update");
        //System.out.println(findMember(memID));
        if (mem != null) {
            firstNameText.setText(mem.getFirstName());
            lastNameText.setText(mem.getLastName());
            IDText.setText(mem.getID());
        } 
        membershipType.getItems().add("Monthly");
        membershipType.getItems().add("Yearly");
        membershipType.getItems().add("EFT");
        membershipType.getItems().add("Trainer");
    } 
    
//    UpdateMemberController (String mem) {
//        this.memID = mem;
//    }
    
    public void init () {
        
    }
    
    public void setMemID (String memID) {
       this.IDText.setText(memID);
    } 
    
    public void setMemFirst (String name) {
        this.firstNameText.setText(name);
    } 
    
    public void setMemLast (String name) {
        this.lastNameText.setText(name);
    } 
    
    public void setMemType (String s) { 
        this.membershipType.setValue(s);
    } 
    
    public void setTrainer (String s) {
        this.trainer.setValue(s);
    }
    
    public void onSubmitButtonClick () {
        System.out.println("update submit clicked");
    }
    
}
