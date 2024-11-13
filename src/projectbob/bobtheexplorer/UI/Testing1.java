/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testing123;

/**
 *
 * @author gztan
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

public class Testing1 extends Application {
    Button button;
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
        
        primaryStage.setTitle("Bob The Explorer");
        ///button=new Button();
        //button.setText("Click me");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        Image icon=new Image("FB profile pic.jpg");
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        //StackPane layout=new StackPane();
        //layout.getChildren().add(button);
        BorderPane root=new BorderPane();
        Scene scene=new Scene(root);
        
        
        TextField username=new TextField();
        username.setPromptText("Enter username...");
        TextField password=new TextField();
        password.setPromptText("Enter password...");
        Button login=new Button("Login");
        Button register=new Button("Register");
        VBox vbox=new VBox();
        HBox hbox=new HBox();
        hbox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(login, register);
        vbox.getChildren().addAll(username, password, hbox);
        vbox.setPadding(new Insets(30, 30, 40, 30));
        vbox.setSpacing(10);
        hbox.setSpacing(5);
        root.setStyle("-fx-background-color: LIGHTBLUE;");
        login.setStyle("-fx-background-color: #e1edaf;");
        register.setStyle("-fx-background-color: #e1edaf;");
        root.setCenter(vbox);
        Text text=new Text(35,80, "Welcome to Bob The Explorer");
        text.setFont(Font.font("Verdana", 20));
        text.setTextAlignment(TextAlignment.RIGHT);
        text.setY(80);
        root.getChildren().add(text);
       
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
