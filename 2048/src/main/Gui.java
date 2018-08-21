package main;

import javafx.application.Application; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage; 


public class Gui extends Application {
    
    @Override
    public void start(Stage stage) {
    	
        Text title = new Text("2048");       
      
        GridPane gridPane = new GridPane();    
         
        gridPane.setMinSize(500,500); 
         
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        
        gridPane.setVgap(5); 
        gridPane.setHgap(5);       
        
        gridPane.setAlignment(Pos.CENTER); 
         
        gridPane.add(title, 0, 0); 
        
        Scene scene = new Scene(gridPane);  
        
        stage.setTitle("2048"); 
        stage.setScene(scene); 
        stage.show(); 
    }
    
    public static void callStart() {
        launch();
    }
    
}