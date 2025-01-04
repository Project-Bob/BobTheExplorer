/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projectbob.bobtheexplorer.UI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
import com.gluonhq.charm.glisten.control.TextField;
import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 * FXML Controller class
 *
 * @author gztan
 */
public class GameDifficultyPageController implements Initializable {

    /**
     * Initializes the controller class.
     */

    loginController getFile = new loginController();
    String username=getFile.usernameLogin;
    CharacterCreationPageController getFileCharacterName = new CharacterCreationPageController();
    String characterName=getFileCharacterName.characterNameText;
    String characterRole=getFileCharacterName.characterRole;
    public static String levelDifficulty="";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        usernameID.setText(username);
        Image imgLogout=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/logoutButton.png"));
        ImageView imgLogoutView = new ImageView(imgLogout);
        imgLogoutView.setFitHeight(20);
        imgLogoutView.setFitWidth(40);
        logOutButton.setGraphic(imgLogoutView);
        Image infoButton=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/infoButton.png"));
        ImageView infoButtonViewLv1 = new ImageView(infoButton);
        infoButtonViewLv1.setFitHeight(40);
        infoButtonViewLv1.setFitWidth(40);
        ImageView infoButtonViewLv2 = new ImageView(infoButton);
        infoButtonViewLv2.setFitHeight(40);
        infoButtonViewLv2.setFitWidth(40);
        ImageView infoButtonViewLv3 = new ImageView(infoButton);
        infoButtonViewLv3.setFitHeight(40);
        infoButtonViewLv3.setFitWidth(40);
        lv1DetailsButton.setGraphic(infoButtonViewLv1);
        lv2DetailsButton.setGraphic(infoButtonViewLv2);
        lv3DetailsButton.setGraphic(infoButtonViewLv3);
        Image imgLv1=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/difficulty level 1.jpg"));
        ImageView imgLv1View = new ImageView(imgLv1);
        imgLv1View.setFitHeight(107);
        imgLv1View.setFitWidth(429);
        lv1Button.setGraphic(imgLv1View);
        Image imgLv2=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/difficulty level 2.jpg"));
        ImageView imgLv2View = new ImageView(imgLv2);
        imgLv2View.setFitHeight(107);
        imgLv2View.setFitWidth(429);
        lv2Button.setGraphic(imgLv2View);
        Image imgLv3=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/difficulty level 3.jpg"));
        ImageView imgLv3View = new ImageView(imgLv3);
        imgLv3View.setFitHeight(107);
        imgLv3View.setFitWidth(429);
        lv3Button.setGraphic(imgLv3View);
//        Image megatron=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/megatron.gif"));
//        testGif.setImage(megatron);
        logOutButton.setFocusTraversable(false);
        lv1DetailsButton.setFocusTraversable(false);
        lv2DetailsButton.setFocusTraversable(false);
        lv3DetailsButton.setFocusTraversable(false);
        if (MusicPlayerManager.getInstance().isPlaying()) {
            MusicPlayerManager.getInstance().playMusic(); // Ensure music continues playing
        } else {
            MusicPlayerManager.getInstance().stopMusic(); // Ensure music stays stopped
        }
    }
    @FXML
    private Button logOutButton;
    @FXML
    private Button lv1Button;
    @FXML
    private Button lv2Button;
    @FXML
    private Button lv3Button;
    @FXML
    private Button lv1DetailsButton;
    @FXML
    private Button lv2DetailsButton;
    @FXML
    private Button lv3DetailsButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button enterGameButton;
    @FXML
    private Label usernameID;
    @FXML
    private Label nameArea;
    @FXML
    private ImageView testGif;
    @FXML
    private AnchorPane threeButtons;
    @FXML
    private AnchorPane confirmation;

    public void logOut() throws IOException{
        App m=new App();
        m.changeScene("loginPage.fxml");
    }
    public void chooseLevel1(ActionEvent event) throws IOException{
        levelDifficulty="Level 1";
        popOutConfirmation();
    }
    public void chooseLevel2(ActionEvent event) throws IOException{
        levelDifficulty="Level 2";
        popOutConfirmation();
    }
    public void chooseLevel3(ActionEvent event) throws IOException{
        levelDifficulty="Level 3";
        popOutConfirmation();
    }
    public void popOutConfirmation(){
        threeButtons.setVisible(false);
        lv1Button.setFocusTraversable(false);
        lv2Button.setFocusTraversable(false);
        lv3Button.setFocusTraversable(false);
        confirmation.setVisible(true);
        nameArea.setText(characterName+" , You are good to go!");
    }
    public void cancelPage(ActionEvent event) throws IOException{
        threeButtons.setVisible(true);
        lv1Button.setFocusTraversable(true);
        lv2Button.setFocusTraversable(true);
        lv3Button.setFocusTraversable(true);
        confirmation.setVisible(false);
    }
    public void enterGame(ActionEvent event) throws IOException{
        App m=new App();
        m.changeScene("GamingDungeon.fxml");
    }
}
