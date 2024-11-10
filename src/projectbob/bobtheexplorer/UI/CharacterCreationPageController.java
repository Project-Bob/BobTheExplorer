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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        usernameID.setText(username);
        
        Image img=new Image(getClass().getClassLoader().getResourceAsStream("logoutButton.png"));
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(20);
        imgView.setFitWidth(40);
        logOutButton.setGraphic(imgView);
        
    }    
    @FXML
    private Button confirmButton;
    @FXML
    private MenuButton generator;
    @FXML
    private Button previous;
    @FXML
    private Button next;
    @FXML
    private Button logOutButton;
    @FXML
    private MenuItem warrior;
    @FXML
    private MenuItem assasin;
    @FXML
    private MenuItem marksman;
    @FXML
    private TextField characterName;
    @FXML
    private TextField characterHP;
    @FXML
    private TextField characterAP;
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
    private Label difficultyShow;
    
    public void createHero(ActionEvent event) throws IOException{
        createHero();
    }
    public void getID(String username) throws IOException{
        System.out.print(username);
    }
    public void createHero() throws IOException{
        if(characterName.getText().isEmpty()|| characterHP.getText().isEmpty() || characterAP.getText().isEmpty()){
            wrongID.setText("Please fill up all data");
        }
        else{
            int characterHPValue=Integer.parseInt(characterHP.getText());
            int characterAPValue=Integer.parseInt(characterAP.getText());
        if(characterHPValue>150 || characterHPValue<50){
            wrongID.setText("The range of HP is between 50 and 150");
        }
        else{
            wrongID.setText("");
        }
        if (characterAPValue>30 || characterAPValue<10){
            wrongID.setText("The range of AP is between 10 and 30");
        }
        else{
            wrongID.setText("");
        }
        if (characterHPValue<=150 && characterHPValue>=50 && characterAPValue<=30 && characterAPValue>=10){
            create();
        }
        
        }
    }
    public void generateWarrior(ActionEvent event) throws IOException{
        generateWarrior();
    }
    public void generateWarrior() throws IOException{
        Random rd=new Random();
        int health=rd.nextInt(120,151);
        int attack=rd.nextInt(10,16);
        characterHP.setText(Integer.toString(health));
        characterAP.setText(Integer.toString(attack));
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Marksman")||characterName.getText().toString().equals("Bob The Assasin"))
            characterName.setText("Bob The Warrior");
        double difficulty=(50.00/health)+(20.00/attack);
        wrongID.setText(String.format("The difficulty level is: %.2f",difficulty));
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
        toWarrior();
        
    }
    
    public void generateAssasin(ActionEvent event) throws IOException{
        generateAssasin();
    }
    public void generateAssasin() throws IOException{
        Random rd=new Random();
        int health=rd.nextInt(80,121);
        int attack=rd.nextInt(16,25);
        characterHP.setText(Integer.toString(health));
        characterAP.setText(Integer.toString(attack));
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Warrior")||characterName.getText().toString().equals("Bob The Marksman"))
            characterName.setText("Bob The Assasin");
        double difficulty=(50.00/health)+(20.00/attack);
        wrongID.setText(String.format("The difficulty level is: %.2f",difficulty));
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
        toAssasin();
    }
   
    public void generateMarksman(ActionEvent event) throws IOException{
        generateMarksman();
    }
    
    public void generateMarksman() throws IOException{
        Random rd=new Random();
        int health=rd.nextInt(50,86);
        int attack=rd.nextInt(24,31);
        characterHP.setText(Integer.toString(health));
        characterAP.setText(Integer.toString(attack));
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Warrior")||characterName.getText().toString().equals("Bob The Assasin"))
            characterName.setText("Bob The Marksman");
        double difficulty=(50.00/health)+(20.00/attack);
        wrongID.setText(String.format("The difficulty level is: %.2f",difficulty));
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
        toMarksman();
    }
    public void create() throws IOException{
        String characterNameShow=characterName.getText();
        int health=Integer.parseInt(characterHP.getText());
        String characterHealthShow=characterHP.getText();
        int attack=Integer.parseInt(characterAP.getText());
        String characterAttackShow=characterAP.getText();
        String characterRoleShow=role.getText();
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
        nameShow.setText(characterNameShow);
        roleShow.setText(characterRoleShow);
        hpShow.setText(characterHealthShow);
        apShow.setText(characterAttackShow);
    }
    public void cancelCreation(ActionEvent event) throws IOException{
        popOut.setVisible(false);
        background.setVisible(true);
        popOut.managedProperty().bind(popOut.visibleProperty());
    }
    Image warriorPic=new Image(getClass().getClassLoader().getResourceAsStream("Mark 9.jpg"));
    Image assasinPic=new Image(getClass().getClassLoader().getResourceAsStream("Laser Boost.jpg"));
    Image marksmanPic=new Image(getClass().getClassLoader().getResourceAsStream("Boost Striker.jpg"));
    public void nextButton(ActionEvent event) throws IOException{
        for(int i=0;i<2;i++){
         if (role.getText().toString().equals("WARRIOR")){
            toAssasin();
            i++;
            break;
         }
         if (role.getText().toString().equals("ASSASIN")){
            toMarksman();
            i++;
            break;
         }
         if (role.getText().toString().equals("MARKSMAN")){
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
         if (role.getText().toString().equals("MARKSMAN")){
            toAssasin();
            i++;
            break;
         }
         if (role.getText().toString().equals("ASSASIN")){
            toWarrior();
            i++;
            break;
         }
        }
    }
    public void toWarrior() throws IOException{
        role.setText("WARRIOR");
        warriorPicture.setImage(warriorPic);
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Marksman")||characterName.getText().toString().equals("Bob The Assasin"))
            characterName.setText("Bob The Warrior");
    }
     public void toAssasin() throws IOException{
        role.setText("ASSASIN");
        warriorPicture.setImage(assasinPic);
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Warrior")||characterName.getText().toString().equals("Bob The Marksman"))
            characterName.setText("Bob The Assasin");
    }
    public void toMarksman() throws IOException{
        role.setText("MARKSMAN");
         warriorPicture.setImage(marksmanPic);
          if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Warrior")||characterName.getText().toString().equals("Bob The Assasin"))
            characterName.setText("Bob The Marksman");
    }
    public void logOut() throws IOException{
         Main m=new Main();
         m.changeScene("loginPage.fxml");
     
     }
}
