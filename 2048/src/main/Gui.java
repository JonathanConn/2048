package main;

import java.awt.event.ActionEvent;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage; 


public class Gui extends Application {
    
    public static GridPane gridPane = new GridPane();   
    main mainOBJ = new main();
	
    @Override
    public void start(Stage stage) {
         
        gridPane.setMinSize(500,500); 
         
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        
        gridPane.setVgap(5); 
        gridPane.setHgap(5);       
        
        gridPane.setAlignment(Pos.CENTER); 
                        
        Button buttonLEFT = new Button("left");
        buttonLEFT.setOnAction((event) -> {
        	
        	updateGrid(mainOBJ.getBoard());
        	mainOBJ.moveEverything(direction.LEFT);
        	mainOBJ.addNum();
        });
        
        Button buttonRIGHT = new Button("right");
        buttonRIGHT.setOnAction((event) -> {
        
        	mainOBJ.moveEverything(direction.RIGHT);
        	updateGrid(mainOBJ.getBoard());
        	mainOBJ.addNum();
        });
        
        Button buttonUP = new Button("up");
        buttonUP.setOnAction((event) -> {
        	mainOBJ.moveEverything(direction.UP);
        	updateGrid(mainOBJ.getBoard());
        	mainOBJ.addNum();
        });
        Button buttonDOWN = new Button("down");
        buttonDOWN.setOnAction((event) -> {
        	mainOBJ.moveEverything(direction.DOWN);
        	updateGrid(mainOBJ.getBoard());
        	mainOBJ.addNum();
        });
        
        VBox  vbox = new VBox();
        
        ObservableList list = vbox.getChildren();
        list.addAll(gridPane,buttonLEFT,buttonRIGHT,buttonDOWN,buttonUP);
        
        Scene scene = new Scene(vbox);  
        
        stage.setTitle("2048"); 
        stage.setScene(scene); 
        stage.show(); 
    }
    
    public static void updateGrid(int[][] boardData) {       
        gridPane.getChildren().clear();
        
    	gridPane.add(new Text(Integer.toString(boardData[0][0])), 0, 0); 
        gridPane.add(new Text(Integer.toString(boardData[0][1])), 1, 0); 
        gridPane.add(new Text(Integer.toString(boardData[0][2])), 2, 0); 
        gridPane.add(new Text(Integer.toString(boardData[0][3])), 3, 0); 
        
        gridPane.add(new Text(Integer.toString(boardData[1][0])), 0, 1); 
        gridPane.add(new Text(Integer.toString(boardData[1][1])), 1, 1); 
        gridPane.add(new Text(Integer.toString(boardData[1][2])), 2, 1); 
        gridPane.add(new Text(Integer.toString(boardData[1][3])), 3, 1); 
        
        gridPane.add(new Text(Integer.toString(boardData[2][0])), 0, 2); 
        gridPane.add(new Text(Integer.toString(boardData[2][1])), 1, 2); 
        gridPane.add(new Text(Integer.toString(boardData[2][2])), 2, 2); 
        gridPane.add(new Text(Integer.toString(boardData[2][3])), 3, 2); 
       
        gridPane.add(new Text(Integer.toString(boardData[3][0])), 0, 3); 
        gridPane.add(new Text(Integer.toString(boardData[3][1])), 1, 3); 
        gridPane.add(new Text(Integer.toString(boardData[3][2])), 2, 3); 
        gridPane.add(new Text(Integer.toString(boardData[3][3])), 3, 3); 
        
    }
    
    
    public static void callStart() {
        launch();
    }
    
    
    
}