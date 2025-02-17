/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projectbob.bobtheexplorer.UI;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.ActionEvent;
import com.gluonhq.charm.glisten.control.TextField;

import projectbob.bobtheexplorer.Main;
import java.util.HashMap;
import java.sql.SQLException;
import org.apache.commons.codec.digest.DigestUtils;
import projectbob.bobtheexplorer.UI.MusicPlayerManager;
/**
 * FXML Controller class
 *
 * @author gztan
 */
public class loginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static String usernameLogin="";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rules.setVisible(false);
        MusicPlayerManager.getInstance().playMusic();
    }
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongID;
    @FXML
    private ImageView LoginBackground;
    @FXML
    private MenuItem buttonRulesRegulation;
    @FXML
    private MenuItem buttonScoreBoard;
    @FXML
    private MenuItem buttonMusicOn;
    @FXML
    private MenuItem buttonMusicOff;
    @FXML
    private MenuItem buttonExit;
    @FXML
    private AnchorPane rules;
    @FXML
    private Button buttonBackToLoginPage;

    public void userLogin(ActionEvent event) throws IOException, SQLException {
        checkLogin();
    }
    public void checkLogin() throws IOException, SQLException{
        HashMap q = Main.db.findPlayer(username.getText().toString());

        if(username.getText().isEmpty()&& password.getText().isEmpty()){
            wrongID.setText("Please fill up all data");
        } else if (q.get(username.getText().toString()) == null) wrongID.setText("Wrong username or password !!!");
        else if(q.get(username.getText().toString()).equals(DigestUtils.md5Hex(password.getText().toString()))){
            wrongID.setText("Success!");
            usernameLogin=username.getText();
            goToCreatePage();
            //CharacterCreationPageController getFile = new CharacterCreationPageController();
            //getFile.getID();
        }
        else{
            wrongID.setText("Wrong username or password !!!");
        }
    }
    public void userRegister(ActionEvent event) throws IOException{
        checkRegister();
    }
    public void checkRegister() throws IOException{
        App m=new App();
        m.changeScene("RegisterPage.fxml");
    }
    public void goToCreatePage() throws IOException{
        App m=new App();
        m.changeScene("CharacterCreationPage.fxml");
    }

    public void actionRulesRegulation(ActionEvent actionEvent)throws IOException{
        rules.setVisible(true);
    }

    public void actionScoreBoard(ActionEvent actionEvent)throws IOException{
        App m = new App();
        m.changeScene("ScoreBoard.fxml");
    }

    public void actionExit(ActionEvent actionEvent)throws IOException{
        System.exit(0);
    }

    public void cancelRules(ActionEvent actionEvent)throws IOException{
        rules.setVisible(false);
    }

    public void actionMusicOn(ActionEvent actionEvent) {
        MusicPlayerManager.getInstance().playMusic();
    }

    public void actionMusicOff(ActionEvent actionEvent) {
        MusicPlayerManager.getInstance().stopMusic();
    }

}
