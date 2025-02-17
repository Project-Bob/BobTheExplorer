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

import projectbob.bobtheexplorer.Main;
import java.sql.SQLException;

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
        if (MusicPlayerManager.getInstance().isPlaying()) {
            MusicPlayerManager.getInstance().playMusic(); // Ensure music continues playing
        } else {
            MusicPlayerManager.getInstance().stopMusic(); // Ensure music stays stopped
        }
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
    public void userRegister(ActionEvent event) throws IOException, SQLException{
        checkRegister();
    }
    public void checkRegister() throws IOException, SQLException{
        if(newUsername.getText().isEmpty()&& newPassword.getText().isEmpty()){
            registrationStatus.setText("Please fill up all data");
        }
        else if(newPassword.getText().equals(confirmPassword.getText()) && !(newUsername.getText().isEmpty())){
            Main.db.addScoreRecord(newUsername.getText(), newPassword.getText(), 0);
            registrationStatus.setText("Success!");
        }
        else if (!(newPassword.getText().equals(confirmPassword.getText()))){
            registrationStatus.setText("Passwords do not tally");
        }
    }
    public void returnBack(ActionEvent event) throws IOException{
        returnBack();
    }
    public void returnBack() throws IOException{
        projectbob.bobtheexplorer.UI.App m=new projectbob.bobtheexplorer.UI.App();
        m.changeScene("loginPage.fxml");
    }

}
