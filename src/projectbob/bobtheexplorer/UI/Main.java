/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectbob.bobtheexplorer.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import java.io.IOException;

/**
 *
 * @author gztan
 */
public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }
    private static Stage stg;
    @Override
    public void start(Stage primaryStage)throws Exception{
        stg=primaryStage;
        Parent root=FXMLLoader.load(getClass().getResource("GamingDungeon.fxml"));
        primaryStage.setTitle("Bob The Explorer");
        ///button=new Button();
        //button.setText("Click me");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.sizeToScene();
        Image icon=new Image("FB profile pic.jpg");
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root,500,500));
        primaryStage.show();
    }
    public void changeScene(String fxml) throws IOException{
        Parent pane=FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
    
}
