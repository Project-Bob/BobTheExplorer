package projectbob.bobtheexplorer.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreBoardController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO
        rules.setVisible(false);
        Image imgLogout=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/logoutButton.png"));
        ImageView imgLogoutView = new ImageView(imgLogout);
        imgLogoutView.setFitHeight(20);
        imgLogoutView.setFitWidth(40);
        logOutButton.setGraphic(imgLogoutView);
        logOutButton.setFocusTraversable(false);
    }

    @FXML
    private Button logOutButton;
    @FXML
    private javafx.scene.control.MenuItem buttonRulesRegulation;
    @FXML
    private javafx.scene.control.MenuItem buttonScoreBoard;
    @FXML
    private MenuItem buttonExit;
    @FXML
    private AnchorPane rules;
    @FXML
    private Button buttonBackToLoginPage;

    public void logOut() throws IOException {
        Main m=new Main();
        m.changeScene("loginPage.fxml");
    }

    public void actionRulesRegulation(ActionEvent actionEvent)throws IOException{
        rules.setVisible(true);
    }

    public void actionScoreBoard(ActionEvent actionEvent)throws IOException{
        Main m = new Main();
        m.changeScene("ScoreBoard.fxml");
    }

    public void actionExit(ActionEvent actionEvent)throws IOException{
        System.exit(0);
    }

    public void cancelRules(ActionEvent actionEvent)throws IOException{
        rules.setVisible(false);
    }

}