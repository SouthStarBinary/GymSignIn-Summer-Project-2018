/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import persons.Client;
import persons.Member;
import persons.Trainer;
import saves.SaveMembers;

/**
 *
 * @author jeanp
 */
public class NewMemberController extends ControllerParent implements Initializable {
    
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

    boolean resetChoice = false;
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        membershipType.getItems().add("Monthly");
        membershipType.getItems().add("Yearly");
        membershipType.getItems().add("EFT");
        membershipType.getItems().add("Trainer");
        membershipType.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> checkIfClient(newValue));
        
        trainer.getItems().add("N/A");
        trainer.setValue("N/A");
        findTrainers();
        //trainer.getItems().add("N/A");
    }
    
    public boolean checkIfClient (String newValue) {
        if (newValue == null) {
            return false;
        }
        else if (newValue.equals("Trainer")) {
            trainer.setDisable(true);
            return false;
        }        
        else {
            trainer.setDisable(false);
        }
        return true;
    }   
    
    private void resetChoices () {
        System.out.println("Gets to method");
//        if (resetChoice == false)
//            return resetChoice;
        
        membershipType.getItems().clear();
        trainer.getItems().clear();
        
        membershipType.getItems().add("Monthly");
        membershipType.getItems().add("Yearly");
        membershipType.getItems().add("EFT");
        membershipType.getItems().add("Trainer");
        membershipType.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> checkIfClient(newValue));

        trainer.setValue("N/A");
        //trainer.getItems().add("N/A");
    }
    
    public void onSubmitButtonClick () {
        SaveMembers newMem = new SaveMembers();
        ArrayList<Member> addNewMem = newMem.load();
        if (addNewMem == null){
            addNewMem = new ArrayList<>();
        }
        
        String memType = membershipType.getValue();
        System.out.println(memType);
        if (memType.equals("Trainer")) {
            Trainer newTrainer = new Trainer(
                    IDText.getText(), firstNameText.getText(), lastNameText.getText(), membershipType.getValue());
            addNewMem.add(newTrainer);
            newMem.save(addNewMem);
        }
        else {
            Client newClient = new Client(
            IDText.getText(), firstNameText.getText(), lastNameText.getText(), 
                    membershipType.getValue(), trainer.getValue());
            addNewMem.add(newClient);
            newMem.save(addNewMem);
        }
        IDText.clear(); firstNameText.clear(); lastNameText.clear();
        resetChoices();
    } 
    
    @Override
    public ArrayList<Member> findTrainers () {
        SaveMembers loads = new SaveMembers();
        ArrayList<Member> currTrainers = new ArrayList<>();
        ArrayList<Member> l = loads.load();
        int k = 0;
	for (int i = 0; i < l.size(); i++) {
	    if (l.get(i).getMembershipType().compareTo("Trainer") == 0) {
		currTrainers.add(l.get(i));
                trainer.getItems().add(currTrainers.get(k).getFirstName() + currTrainers.get(k).getLastName());
                k++;
	    } 
	}
        System.out.println(currTrainers.toString());
        
	return currTrainers;
    }
    
}
