/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;




/**
 *
 * @author devv
 */
public class LaFleurMain extends Application {
    
   @Override
    public void start(Stage stage) throws Exception {
      
        Parent root20 = FXMLLoader.load(getClass().getResource("authentificat.fxml"));
        Scene scene;
       scene = new Scene(root20, 800, 600);
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        
	launch(args);
    }
}
