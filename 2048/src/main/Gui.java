package main;

import java.awt.Insets;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class Gui extends Application {
    
    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
// 
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
        
        StackPane root = new StackPane();
//    root.getChildren().add(btn);

        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("2048");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void callStart() {
        launch();
    }
    
}