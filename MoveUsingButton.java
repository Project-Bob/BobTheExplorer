/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing123;

/**
 *
 * @author gztan
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
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
public class MoveUsingButton extends Application {
    Button button;
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
        BorderPane root=new BorderPane();
        HBox hbox=new HBox();
        hbox.setAlignment(Pos.CENTER);
        Pane pane = new Pane();
        Button left= new Button("Left");
        Button right= new Button("Right");
        Text text= new Text(160,140,"Hi");
        left.setOnAction(e -> text.setX(text.getX() -3));
        right.setOnAction(e -> text.setX(text.getX() +3));
        pane.getChildren().add(text);
        hbox.getChildren().addAll(left, right);
        root.setBottom(hbox);
        root.setCenter(pane);
        Scene scene=new Scene(root, 400,300,Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TESTING");
        primaryStage.show();
        
    }
}
