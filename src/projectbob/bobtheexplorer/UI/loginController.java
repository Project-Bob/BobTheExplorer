/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projectbob.bobtheexplorer.UI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
import com.gluonhq.charm.glisten.control.TextField;

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
    public void userLogin(ActionEvent event) throws IOException{
        checkLogin();
    }
    public void checkLogin() throws IOException{
        if(username.getText().toString().equals("hihihi") && password.getText().toString().equals("123")){
            wrongID.setText("Success!");
            usernameLogin=username.getText();
            goToCreatePage();
            //CharacterCreationPageController getFile = new CharacterCreationPageController();
            //getFile.getID();

        }
        else if(username.getText().isEmpty()&& password.getText().isEmpty()){
            wrongID.setText("Please fill up all data");
        }
        else{
            wrongID.setText("Wrong username or password !!!");
        }
    }
    public void userRegister(ActionEvent event) throws IOException{
        checkRegister();
    }
    public void checkRegister() throws IOException{
        Main m=new Main();
        m.changeScene("RegisterPage.fxml");
    }
    public void goToCreatePage() throws IOException{
        Main m=new Main();
        m.changeScene("CharacterCreationPage.fxml");
    }

}
