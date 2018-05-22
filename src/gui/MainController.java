/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static java.awt.SystemColor.window;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author jeanp
 */
public class MainController {
    
    Stage window;
    
    public void getAController (Stage currentStage) throws IOException {
        
        if (currentStage.getScene() == null) {
            Rectangle2D screensize = Screen.getPrimary().getVisualBounds();
            window = new Stage();
            //window = currentStage;
            FXMLLoader root = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Pane myPane = (Pane) root.load();
            Controller controller = (Controller) root.getController();
            controller.setStage(window);
            //controller.window = currentStage;
            Scene scene = new Scene(myPane, screensize.getWidth(), screensize.getHeight());
            window.setTitle("Summer Project - 2018");
            window.setScene(scene);
            //window.setMaximized(true);
            window.show();
        }
    }
}
