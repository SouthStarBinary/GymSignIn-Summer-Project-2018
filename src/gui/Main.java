/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Rectangle2D screensize = Screen.getPrimary().getVisualBounds();
//        window = primaryStage;
//        FXMLLoader root = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
//        Pane myPane = (Pane) root.load();
//        Controller controller = (Controller) root.getController();
//        controller.window = primaryStage;
//        Scene scene = new Scene(myPane, screensize.getWidth(), screensize.getHeight());
//        window.setTitle("Summer Project - 2018");
//        window.setScene(scene);
//        //window.setMaximized(true);
//        window.show();

        MainController controller = new MainController();
        controller.getAController(primaryStage);
    }

}
