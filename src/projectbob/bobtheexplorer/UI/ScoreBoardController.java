package projectbob.bobtheexplorer.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import projectbob.bobtheexplorer.Main;
import java.util.LinkedHashMap;
import java.sql.SQLException;

public class ScoreBoardController implements Initializable {

    @FXML
    private Label player1;
    @FXML
    private Label player2;
    @FXML
    private Label player3;
    @FXML
    private Label player4;
    @FXML
    private Label player5;
    @FXML
    private Label player6;
    @FXML
    private Label player7;
    @FXML
    private Label player8;
    @FXML
    private Label score1;
    @FXML
    private Label score2;
    @FXML
    private Label score3;
    @FXML
    private Label score4;
    @FXML
    private Label score5;
    @FXML
    private Label score6;
    @FXML
    private Label score7;
    @FXML
    private Label score8;
    
    private Label players(int n) {
        switch (n) {
            case 0: return player1;
            case 1: return player2;
            case 2: return player3;
            case 3: return player4;
            case 4: return player5;
            case 5: return player6;
            case 6: return player7;
            case 7: return player8;

            default: return null;
        }
    }
    
    private Label scores(int n) {
        switch (n) {
            case 0: return score1;
            case 1: return score2;
            case 2: return score3;
            case 3: return score4;
            case 4: return score5;
            case 5: return score6;
            case 6: return score7;
            case 7: return score8;

            default: return null;
        }
    }
    
    private int i = 0;

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
        if (MusicPlayerManager.getInstance().isPlaying()) {
            MusicPlayerManager.getInstance().playMusic(); // Ensure music continues playing
        } else {
            MusicPlayerManager.getInstance().stopMusic(); // Ensure music stays stopped
        }

        // Set scoreboard
        try {
            LinkedHashMap<String, Integer> scoreboard = Main.db.findScore();
            
            scoreboard.forEach((username, score) -> {
                if (i > 7) return;
                System.out.println(username + score.toString());
                players(i).setText(username);
                scores(i).setText(score.toString());
                i++;
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    private MenuItem buttonMusicOn;
    @FXML
    private MenuItem buttonMusicOff;
    @FXML
    private AnchorPane rules;
    @FXML
    private Button buttonBackToLoginPage;

    public void logOut() throws IOException {
        App m=new App();
        m.changeScene("loginPage.fxml");
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