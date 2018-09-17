/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.io.IOException;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import persons.Member;
import persons.Client;
import persons.Trainer;
import saves.SaveMembers;
/**
 *
 * @author jeanp
 */
public class MembersController extends ControllerParent implements Initializable{
    
    @FXML
    TableView<Member> table;
    @FXML
    TableColumn<Member, String> IDColumn;
    @FXML
    TableColumn<Member, String> firstNameColumn;
    @FXML
    TableColumn<Member, String> lastNameColumn;
    @FXML
    TableColumn<Member, String> membershipTypeColumn;
    @FXML
    TableColumn<Client, String> trainerColumn;
    @FXML
    Button newMemberButton;
    //creating a new member page
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Members view now loaded!");
        //tempMems();
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        membershipTypeColumn.setCellValueFactory(new PropertyValueFactory<>("membershipType"));
        trainerColumn.setCellValueFactory(new PropertyValueFactory<>("trainer"));
        table.setItems(getMembers());
        //table.getColumns().addAll(IDColumn, membershipTypeColumn, trainerColumn);
        
    }
     
    public void handleNewMemberButton () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewMemberFXML.fxml"));
        Pane pane = loader.load();
        NewMemberController nextWin = loader.getController();
        nextWin.setStage(window);
        //this.window = nextWin.window;
        double height, width;
        height = this.window.getHeight();
        width = this.window.getWidth();
        this.window.setScene(new Scene(pane,width,height));
    }
    
//    public ObservableList<Member> getMembers () {
//        
//        SaveMembers loads = new SaveMembers();
//        ArrayList<Member> mems = loads.load();
//        if (mems == null){
//            ObservableList<Member> noFileMems;
//            return noFileMems =FXCollections.observableArrayList();
//        }
//        ObservableList<Member> members = FXCollections.observableArrayList();
//        for (int i = 0; i < mems.size(); i++) {
//            //System.out.println(super.memList.get(i).toString());
//            members.add(mems.get(i));
//        }
//        
////        Client ccheck2);heck2 = new Client ("ms124","Monthly","N/A");
////        members.add(check2);
//        
//        return members;
//    }
    
    public void tempMems () {
        ArrayList<Member> list = new ArrayList<>();
        Client check2 = new Client ("ms125","Dennis", "Lobon", "Monthly","N/A");
        Client check3 = new Client ("ms126", "Krissie", "Lobon","Monthly","N/A");
        Trainer check4 = new Trainer ("ms127","Tessie","Lobon", "Trainer");
        list.add(check2);
        list.add(check3);
        list.add(check4);
        
        SaveMembers save = new SaveMembers();
        save.save(list);
    }

}
