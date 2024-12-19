package projectbob.bobtheexplorer.UI;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import projectbob.bobtheexplorer.UI.Monster_Slime;

import java.util.Random;

public class BattleStatusPageController implements Initializable {

    loginController getFile = new loginController();
    CharacterCreationPageController getDetails = new CharacterCreationPageController();
    GameDifficultyPageController pass = new GameDifficultyPageController();
    GamingDungeonController getInfo = new GamingDungeonController();
    Monster_Slime monster;
    String characterName = getInfo.characterName;
    String characterRoleShow = getInfo.characterRoleShow;
    String characterAttackShow = getInfo.characterAttackShow;
    String characterHealthShow = getInfo.characterHealthShow;
    String characterSpeedShow = getInfo.characterSpeedShow;
    int HeroHP = Integer.parseInt(getInfo.characterHealthShow);
    int HeroAP = Integer.parseInt(getInfo.characterAttackShow);
    int HeroSpeed = Integer.parseInt(getInfo.characterSpeedShow);

    @FXML
    private Button logOutButton;
    @FXML
    private ImageView Hero_PIC;
    @FXML
    private Label Name_Hero;
    @FXML
    private Label Role_Hero;
    @FXML
    private Label HP_Hero;
    @FXML
    private Label AP_Hero;
    @FXML
    private Label Speed_Hero;
    @FXML
    private ImageView Monster_PIC;
    @FXML
    private Label Name_Monster;
    @FXML
    private Label HP_Monster;
    @FXML
    private Label AP_Monster;
    @FXML
    private Label Speed_Monster;
    @FXML
    private Label Instruction;
    @FXML
    private Button Attack;
    @FXML
    private Button Inventory;
    @FXML
    private Button Run;
    @FXML
    private AnchorPane BattlePage;

    private void BackToDungeon() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("GamingDungeon.fxml"));
        BattlePage.getChildren().setAll(pane);
    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // LogOut Button
        Image img = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/logoutButton.png"));
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(20);
        imgView.setFitWidth(40);
        logOutButton.setGraphic(imgView);
        logOutButton.setFocusTraversable(false);

        //Hero Info
        Image Picture_Hero = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/warriorToRight.png"));
        Hero_PIC.setImage(Picture_Hero);
        Name_Hero.setText(characterName);
        HeroStatus hero = new HeroStatus(HeroHP, HeroAP, HeroSpeed);
        HP_Hero.setText("HP: " + hero.getHP_Hero() + " / " + hero.getMaxHP_Hero());
        Role_Hero.setText("Role: " + characterRoleShow);
        AP_Hero.setText("Attack Power: " + hero.getAP_Hero());
        Speed_Hero.setText("Speed: " + hero.getSpeed_Hero());

        //Monster Info
        Image Picture_Monster = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/megatron.gif"));
        Monster_PIC.setImage(Picture_Monster);
        Name_Monster.setText(GamingDungeonController.monster_Detect);
        monster = Monster_Slime.createSlime(getInfo.difficultyLevel);
        HP_Monster.setText("HP: " + monster.getHp());
        AP_Monster.setText("Attack Power: " + monster.getAp());
        Speed_Monster.setText("Speed: " + monster.getSpeed());

        Instruction.setText("Please choose your next step!!!");
        Instruction.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 16));
        Instruction.setTextFill(Color.DARKBLUE);
        Instruction.setWrapText(true);
        Instruction.setStyle("-fx-border-color: black; -fx-background-color: light yellow; -fx-padding: 15px;");

    }

    HeroStatus hero = new HeroStatus(HeroHP, HeroAP, HeroSpeed);
    public void Attack_Hero() throws IOException{
        if (HeroSpeed >= monster.getSpeed()) {
            monster.takeDamage(HeroAP);
            Instruction.setText(GamingDungeonController.monster_Detect + " take " + HeroAP + " damage. ");
            if (monster.getHp() > 0) {
                hero.takeDamage(monster.getAp());
                Instruction.setText(GamingDungeonController.monster_Detect + " take " + HeroAP + " damage. Hero takes " + monster.getAp() + " damage. " );
            }
        }
        else {
            hero.takeDamage(monster.getAp());
            Instruction.setText(characterName + " take " + monster.getAp() + " damage. ");
            if (HeroHP > 0) {
                Instruction.setText(GamingDungeonController.monster_Detect + " take " + HeroAP + " damage. Hero takes " + monster.getAp() + " damage. " );
                monster.takeDamage(HeroAP);
            }
        }

        //display the status of hero
        HP_Hero.setText("HP: " + hero.getHP_Hero() + " / " + hero.getMaxHP_Hero());
        AP_Hero.setText("Attack Power: " + hero.getAP_Hero());
        Speed_Hero.setText("Speed: " + hero.getSpeed_Hero());

        //display the status of monster
        HP_Monster.setText("HP: " + monster.getHp());
        AP_Monster.setText("Attack Power: " + monster.getAp());
        Speed_Monster.setText("Speed: " + monster.getSpeed());
    }

    public void Run() throws IOException{
        if(HeroSpeed > monster.getSpeed()){
            Instruction.setText("Run successfully !!! Loading ...");
            // Delay the scene change by 1 second
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            Main m = new Main();
            pause.setOnFinished(event -> {
                try {
                    BackToDungeon();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            pause.play();
        }
        else{
            Instruction.setText("You are unable to run!!!");
        }
    }

    public void logOut() throws IOException {
        Main m = new Main();
        m.changeScene("loginPage.fxml");
    }
}