/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package testing123;
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
public class RegisterPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private Button returnButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField newUsername;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Label registrationStatus;
    public void userRegister(ActionEvent event) throws IOException{
        checkRegister();
    }
    public void checkRegister() throws IOException{
        if(newUsername.getText().toString().equals("baibaibai") && newPassword.getText().toString().equals("123")){
            registrationStatus.setText("Success!");
        }
        else if(newUsername.getText().isEmpty()&& newPassword.getText().isEmpty()){
            registrationStatus.setText("Please fill up all data");
        }
        else{
            registrationStatus.setText("Wrong username or password !!!");
        }
    }
     public void returnBack(ActionEvent event) throws IOException{
        returnBack();
    }
     public void returnBack() throws IOException{
         Main m=new Main();
         m.changeScene("loginPage.fxml");
     
     }
    
}
