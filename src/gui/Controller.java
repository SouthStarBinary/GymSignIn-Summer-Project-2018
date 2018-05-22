/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import persons.MemberClient;

/**
 *
 * @author jeanp
 */

public class Controller implements Initializable {

    Stage window;
    @FXML
    Button notbutton;
    @FXML
    MenuItem test;
    @FXML
    Button fuButton;
    @FXML
    ToolBar globalToolBar;
    
    @FXML
    TextField idTextBox;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
         globalToolBar = new ToolBar();
        globalToolBar.getItems().add(fuButton);
        //MemberClient.main();
    }
    
    public void setStage (Stage window) {
        this.window = window;
    }
    
    public void handleIdTextBox () {
        System.out.println("Text was entered");
        System.out.println(this.idTextBox.getText());
        this.idTextBox.clear();
    }
    
    public void handleButtonClick () {
        System.out.println("Check check");
        notbutton.setText("Work?");
    }
    
    @FXML
    public void handleFuButtonClick() throws IOException {
        System.out.println("being clicked");
        AnchorPane myPane = null;
        //myPane = FXMLLoader.load(getClass().getResource("fuFXML.fxml"));
        //Scene scene = new Scene(myPane);
        FXMLLoader root = new FXMLLoader(getClass().getResource("fuFXML.fxml"));
        Pane pane = (Pane) root.load();
        //FuController nextWin = (FuController) root.getController();
        //nextWin.setStage(window);
        //this.window = nextWin.window;
        double height, width;
        height = this.window.getHeight();
        width = this.window.getWidth();
        this.window.setScene(new Scene(pane,width,height));
        //this.window.setMaximized(true);
        this.window.show();
        
        
    }
    
    public void handleMenuItemClick() {
        System.out.println("MenuItem was clicked");
    }

}

