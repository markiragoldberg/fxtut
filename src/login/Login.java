/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author mark
 */
public class Login extends Application {
    
    // Entry point for JavaFX application
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome!");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setId("welcome-text");
        grid.add(sceneTitle, 0, 0, 2, 1);
        
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
        
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
//        grid.setGridLinesVisible(true);
        
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        final Text actionTarget = new Text();
        actionTarget.setId("actiontarget");
        grid.add(actionTarget, 1, 6);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
           
            @Override
            public void handle(ActionEvent e) {
                String output = login(userTextField.getText(), pwBox.getText());
                actionTarget.setText(output);
            }
        });
        
        Scene scene = new Scene(grid, 325, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add
                (Login.class.getResource("Login.css").toExternalForm());
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static String login(String login, String pw) {
        if(login.isEmpty()) {
            return "Please enter your user name.";
        }
        else if(pw.isEmpty()) {
            return "Please enter your password.";
        }
        else if(!pw.equals("friend")) {
            return "Error: the password is friend.";
        }
        else {
            return "Successfully logged in as " + login + ".";
        }
    }
    
}
