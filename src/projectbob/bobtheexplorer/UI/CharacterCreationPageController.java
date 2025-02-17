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

/**
 * FXML Controller class
 *
 * @author gztan
 */
public class CharacterCreationPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    loginController getFile = new loginController();
    String username=getFile.usernameLogin;
    public static String characterNameText="";
    public static String characterRole="";
    public static String characterHealthShow="";
    public static String characterAttackShow="";
    public static String characterSpeedShow="";
    int status=0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        usernameID.setText(username);
        Image img=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/logoutButton.png"));
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(20);
        imgView.setFitWidth(40);
        logOutButton.setGraphic(imgView);
        generator.setFocusTraversable(false);
        confirmCharacterButton.setDefaultButton(false);
        rulesButton.setFocusTraversable(false);
        logOutButton.setFocusTraversable(false);
        if (MusicPlayerManager.getInstance().isPlaying()) {
            MusicPlayerManager.getInstance().playMusic(); // Ensure music continues playing
        } else {
            MusicPlayerManager.getInstance().stopMusic(); // Ensure music stays stopped
        }
    }
    @FXML
    private Button confirmButton;
    @FXML
    private MenuButton generator;
    @FXML
    private Button previous;
    @FXML
    private Button rulesButton;
    @FXML
    private Button next;
    @FXML
    private Button logOutButton;
    @FXML
    private Button confirmCharacterButton;
    @FXML
    private Button backToHeroCreationButton;
    @FXML
    private MenuItem warrior;
    @FXML
    private MenuItem assassin;
    @FXML
    private MenuItem marksman;
    @FXML
    private TextField characterName;
    @FXML
    private TextField characterHP;
    @FXML
    private TextField characterAP;
    @FXML
    private TextField characterSpeed;
    @FXML
    private Label wrongID;
    @FXML
    private Label difficultyLevel;
    @FXML
    private Label role;
    @FXML
    private Label usernameID;
    @FXML
    private ImageView warriorPicture;
    @FXML
    private AnchorPane popOut;
    @FXML
    private AnchorPane rules;
    @FXML
    private VBox background;
    @FXML
    private Label nameShow;
    @FXML
    private Label roleShow;
    @FXML
    private Label hpShow;
    @FXML
    private Label apShow;
    @FXML
    private Label speedShow;
    @FXML
    private Label difficultyShow;
    @FXML
    private AnchorPane characterCreation;
    @FXML
    private Button buttonMusicOn;
    @FXML
    private Button ButtonMusicOff;

    public void createHero(ActionEvent event) throws IOException{
        createHero();
    }
    public void createHero() throws IOException{
        if(characterName.getText().isEmpty()|| characterHP.getText().isEmpty() || characterAP.getText().isEmpty()){
            wrongID.setText("Please fill up all data");
        }
        else{
            int characterHPValue = 0;
            int characterAPValue = 0;
            int characterSpeedValue = 0;

            try {
                characterHPValue = Integer.parseInt(characterHP.getText());
                characterAPValue = Integer.parseInt(characterAP.getText());
                characterSpeedValue = Integer.parseInt(characterSpeed.getText());
            }
            catch(NumberFormatException e){
                wrongID.setText("Please enter integer value only");
                return;
            }
            if(characterHPValue>150 || characterHPValue<50){
                wrongID.setText("The range of HP is between 50 and 150");
                return;
            }
            if (characterAPValue>30 || characterAPValue<10){
                wrongID.setText("The range of AP is between 10 and 30");
                return;
            }
            if(characterSpeedValue>30 || characterSpeedValue<10){
                wrongID.setText("The range of speed is between 10 and 30");
                return;
            }
            //pass the data for other class uses
//            HeroStatus hero = new HeroStatus(characterHPValue, characterAPValue, characterSpeedValue);

            //hero is created only when all the requirement is meet
            create();
            HeroStatus hero = new HeroStatus(characterHPValue, characterAPValue, characterSpeedValue);
        }
    }
    public void generateWarrior(ActionEvent event) throws IOException{
        generateWarrior();
    }
    public void generateWarrior() throws IOException{
        Random rd=new Random();
        int health=rd.nextInt(120,151);
        int attack=rd.nextInt(10,16);
        int speed=rd.nextInt(10,20);
        characterHP.setText(Integer.toString(health));
        characterAP.setText(Integer.toString(attack));
        characterSpeed.setText(Integer.toString(speed));
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Archer")||characterName.getText().toString().equals("Bob The Assassin"))
            characterName.setText("Bob The Warrior");
        toWarrior();

    }

    public void generateAssassin(ActionEvent event) throws IOException{
        generateAssassin();
    }
    public void generateAssassin() throws IOException{
        Random rd=new Random();
        int health=rd.nextInt(80,121);
        int attack=rd.nextInt(16,25);
        int speed=rd.nextInt(23,31);
        characterHP.setText(Integer.toString(health));
        characterAP.setText(Integer.toString(attack));
        characterSpeed.setText(Integer.toString(speed));
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Warrior")||characterName.getText().toString().equals("Bob The Archer"))
            characterName.setText("Bob The Assassin");
        toAssassin();
    }

    public void generateMarksman(ActionEvent event) throws IOException{
        generateMarksman();
    }

    public void generateMarksman() throws IOException{
        Random rd=new Random();
        int health=rd.nextInt(50,86);
        int attack=rd.nextInt(24,31);
        int speed=rd.nextInt(14,23);
        characterHP.setText(Integer.toString(health));
        characterAP.setText(Integer.toString(attack));
        characterSpeed.setText(Integer.toString(speed));
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Warrior")||characterName.getText().toString().equals("Bob The Assassin"))
            characterName.setText("Bob The Archer");
        toMarksman();
    }
    public void create() throws IOException{
        characterNameText=characterName.getText();
        int health=Integer.parseInt(characterHP.getText());
        characterHealthShow=characterHP.getText();
        int attack=Integer.parseInt(characterAP.getText());
        characterAttackShow=characterAP.getText();
        String characterRoleShow=role.getText();
        characterRole=characterRoleShow;
        int speed=Integer.parseInt(characterSpeed.getText());
        characterSpeedShow=characterSpeed.getText();
        double difficulty=(50.00/health)+(20.00/attack);
        difficultyShow.setText(String.format("The difficulty level is: %.2f",difficulty));
        int star=(int)(difficulty/0.5);
        if (star==6)
            difficultyLevel.setText("★ ★ ★ ★ ★ ★");
        else if (star==5)
            difficultyLevel.setText("★ ★ ★ ★ ★");
        else if (star==4)
            difficultyLevel.setText("★ ★ ★ ★");
        else if (star==3)
            difficultyLevel.setText("★ ★ ★");
        else if (star==2)
            difficultyLevel.setText("★ ★");
        else
            difficultyLevel.setText("★");
        popOut.setVisible(true);
        background.setVisible(false);
        background.managedProperty().bind(background.visibleProperty());
        next.setVisible(false);
        previous.setVisible(false);
        nameShow.setText(characterNameText);
        roleShow.setText(characterRoleShow);
        hpShow.setText(characterHealthShow);
        apShow.setText(characterAttackShow);
        speedShow.setText(characterSpeedShow);
        status=1;
        confirmButton.setDefaultButton(false);
        confirmCharacterButton.setDefaultButton(true);
    }
    public void cancelCreation(ActionEvent event) throws IOException{
        popOut.setVisible(false);
        background.setVisible(true);
        popOut.managedProperty().bind(popOut.visibleProperty());
        next.setVisible(true);
        previous.setVisible(true);
        status=0;
        confirmCharacterButton.setDefaultButton(false);
        confirmButton.setDefaultButton(true);
    }
    Image warriorPic=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/Bob_Warrior.png"));
    Image assassinPic=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/Bob_Assasin.png"));
    Image marksmanPic=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/Bob_Maskman.png"));
    public void nextButton(ActionEvent event) throws IOException{
        for(int i=0;i<2;i++){
            if (role.getText().toString().equals("WARRIOR")){
                toAssassin();
                i++;
                break;
            }
            if (role.getText().toString().equals("ASSASSIN")){
                toMarksman();
                i++;
                break;
            }
            if (role.getText().toString().equals("ARCHER")){
                toWarrior();
                i++;
                break;
            }
        }

    }
    public void previousButton(ActionEvent event) throws IOException{
        for(int i=0;i<2;i++){
            if (role.getText().toString().equals("WARRIOR")){
                toMarksman();
                i++;
                break;
            }
            if (role.getText().toString().equals("ARCHER")){
                toAssassin();
                i++;
                break;
            }
            if (role.getText().toString().equals("ASSASSIN")){
                toWarrior();
                i++;
                break;
            }
        }
    }
    public void toWarrior() throws IOException{
        role.setText("WARRIOR");
        warriorPicture.setImage(warriorPic);
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Archer")||characterName.getText().toString().equals("Bob The Assassin"))
            characterName.setText("Bob The Warrior");
    }
    public void toAssassin() throws IOException{
        role.setText("ASSASSIN");
        warriorPicture.setImage(assassinPic);
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Warrior")||characterName.getText().toString().equals("Bob The Archer"))
            characterName.setText("Bob The Assassin");
    }
    public void toMarksman() throws IOException{
        role.setText("ARCHER");
        warriorPicture.setImage(marksmanPic);
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Warrior")||characterName.getText().toString().equals("Bob The Assassin"))
            characterName.setText("Bob The Archer");
    }
    public void logOut() throws IOException{
        App m=new App();
        m.changeScene("loginPage.fxml");
    }

    public void goToDifficulty() throws IOException{
        App m=new App();
        m.changeScene("GameDifficultyPage.fxml");
    }
    public void displayRules(ActionEvent event) throws IOException{
        rules.setVisible(true);
        background.setVisible(false);
        background.managedProperty().bind(background.visibleProperty());
        popOut.setVisible(false);
        popOut.managedProperty().bind(popOut.visibleProperty());
        warriorPicture.setVisible(false);
        rulesButton.setVisible(false);
    }
    public void cancelRules(ActionEvent event) throws IOException{
        if (status==0){
            background.setVisible(true);
            rulesButton.setVisible(true);
            rules.setVisible(false);
            rules.managedProperty().bind(rules.visibleProperty());
            warriorPicture.setVisible(true);
        }
        else{
            popOut.setVisible(true);
            rulesButton.setVisible(true);
            rules.setVisible(false);
            rules.managedProperty().bind(rules.visibleProperty());
            warriorPicture.setVisible(true);
        }
    }
    public void actionMusicOn(ActionEvent actionEvent) {
        MusicPlayerManager.getInstance().playMusic();
    }

    public void actionMusicOff(ActionEvent actionEvent) {
        MusicPlayerManager.getInstance().stopMusic();
    }
}
