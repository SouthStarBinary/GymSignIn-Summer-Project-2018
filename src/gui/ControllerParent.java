/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import persons.*;
import saves.SaveMembers;

/**
 *
 * @author jeanp
 */
public abstract class ControllerParent {
    Stage window;
    ArrayList<Member> memList = new ArrayList<>();
    String textTest;
    
    public void setStage (Stage window) {
        this.window = window;
    }
    
    public void setTest (String text) {
        this.textTest = text;
    }
    
    public void handleHomeButton() throws IOException {
        System.out.println("being clicked2");
        //AnchorPane myPane = null;
        //myPane = FXMLLoader.load(getClass().getResource("fuFXML.fxml"));
        //Scene scene = new Scene(myPane);
        FXMLLoader root = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Pane pane = (Pane) root.load();
        Controller nextWin = (Controller) root.getController();
        nextWin.setStage(window);
        //this.window = nextWin.window;
        double height, width;
        height = this.window.getHeight();
        width = this.window.getWidth();
        this.window.setScene(new Scene(pane,width,height));
        //this.window.setMaximized(true);
        this.window.show();
    }
    
    public void handleFuButtonClick() throws IOException {
        
        System.out.println("being clicked");
        //AnchorPane myPane = null;
        //myPane = FXMLLoader.load(getClass().getResource("fuFXML.fxml"));
        //Scene scene = new Scene(myPane);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fuFXML.fxml"));
        Pane pane = loader.load();
        FuController nextWin = loader.getController();
        nextWin.setStage(window);
        //this.window = nextWin.window;
        double height, width;
        height = this.window.getHeight();
        width = this.window.getWidth();
        this.window.setScene(new Scene(pane,width,height));
        
        //this.window.setMaximized(true);
        //this.window.show();
        
//        MainController mcontroller = new MainController();
//        Rectangle2D screensize = Screen.getPrimary().getVisualBounds();
//        //window = primaryStage;
//        window = new Stage();
//        FXMLLoader root = new FXMLLoader(getClass().getResource("fuFXML.fxml"));
//        Pane myPane = (Pane) root.load();
//        //Controller controller = (Controller) root.getController();
//        //controller.window = primaryStage;
//        Scene Fu = new Scene(myPane, screensize.getWidth(), screensize.getHeight());
//        window.setTitle("Summer Project - 2018");
//        window.setScene(Fu);
//        //mcontroller.window = this.window;
//        //MainController mcontroller = new MainController();
//        mcontroller.getAController(window);
    }
    
    public void handleMemberButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MembersFXML.fxml"));
        Pane pane = loader.load();
        MembersController nextWin = loader.getController();
        nextWin.setStage(window);
        //this.window = nextWin.window;
        double height, width;
        height = this.window.getHeight();
        width = this.window.getWidth();
        this.window.setScene(new Scene(pane,width,height));
    }
    
    public void handleMenuItemClick() {
        System.out.println("MenuItem was clicked");
    } 
    
    public ObservableList<Member> getMembers () {
        
        SaveMembers loads = new SaveMembers();
        ArrayList<Member> mems = loads.load();
        if (mems == null){
            ObservableList<Member> noFileMems;
            return noFileMems =FXCollections.observableArrayList();
        }
        ObservableList<Member> members = FXCollections.observableArrayList();
        for (int i = 0; i < mems.size(); i++) {
            //System.out.println(super.memList.get(i).toString());
            members.add(mems.get(i));
        }
        
//        Client ccheck2);heck2 = new Client ("ms124","Monthly","N/A");
//        members.add(check2);
        
        return members;
    } 
    
    public ArrayList<Member> findTrainers () { 
        SaveMembers loads = new SaveMembers();
        ArrayList<Member> currTrainers = new ArrayList<>();
        ArrayList<Member> l = loads.load();
        int k = 0;
	for (int i = 0; i < l.size(); i++) {
	    if (l.get(i).getMembershipType().compareTo("Trainer") == 0) {
		currTrainers.add(l.get(i));
                //trainer.getItems().add(currTrainers.get(k).getFirstName() + currTrainers.get(k).getLastName());
                k++;
	    } 
	}
        System.out.println(currTrainers.toString());
        
	return currTrainers;
    }
    
    public Member findMember (String ID) { 
        SaveMembers loads = new SaveMembers();
        ArrayList<Member> currTrainers = new ArrayList<>();
        ArrayList<Member> l = loads.load();
	for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).getID() + "from the for loop");
	    if (l.get(i).getID().compareTo(ID) == 0) {
                System.out.println("returning" + l.get(i).getID());
                return l.get(i);
	    } 
	}        
	return null;
    }
    
}
