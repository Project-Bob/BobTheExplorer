/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package testing123;
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

/**
 * FXML Controller class
 *
 * @author gztan
 */
public class CharacterCreationPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    String username="";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
    public void createHero(ActionEvent event) throws IOException{
        createHero();
    }
    public void getID(String username1) throws IOException{
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
            double difficulty=(50.00/characterHPValue)+(20.00/characterAPValue);
            wrongID.setText(Double.toString(difficulty));
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
            difficultyLevel.setText("★");
        else if (star==5)
            difficultyLevel.setText("★ ★");
        else if (star==4)
            difficultyLevel.setText("★ ★ ★");
        else if (star==3)
            difficultyLevel.setText("★ ★ ★ ★");
        else if (star==2)
            difficultyLevel.setText("★ ★ ★ ★ ★");
        else
            difficultyLevel.setText("★ ★ ★ ★ ★ ★");
        
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
            difficultyLevel.setText("★");
        else if (star==5)
            difficultyLevel.setText("★ ★");
        else if (star==4)
            difficultyLevel.setText("★ ★ ★");
        else if (star==3)
            difficultyLevel.setText("★ ★ ★ ★");
        else if (star==2)
            difficultyLevel.setText("★ ★ ★ ★ ★");
        else
            difficultyLevel.setText("★ ★ ★ ★ ★ ★");
    }
   
    public void generateMarksman(ActionEvent event) throws IOException{
        generateMarksman();
    }
    
    public void generateMarksman() throws IOException{
        Random rd=new Random();
        int health=rd.nextInt(40,86);
        int attack=rd.nextInt(24,31);
        characterHP.setText(Integer.toString(health));
        characterAP.setText(Integer.toString(attack));
        if(characterName.getText().isEmpty()||characterName.getText().toString().equals("Bob The Warrior")||characterName.getText().toString().equals("Bob The Assasin"))
            characterName.setText("Bob The Marksman");
        double difficulty=(50.00/health)+(20.00/attack);
        wrongID.setText(String.format("The difficulty level is: %.2f",difficulty));
        int star=(int)(difficulty/0.5);
        if (star==6)
            difficultyLevel.setText("★");
        else if (star==5)
            difficultyLevel.setText("★ ★");
        else if (star==4)
            difficultyLevel.setText("★ ★ ★");
        else if (star==3)
            difficultyLevel.setText("★ ★ ★ ★");
        else if (star==2)
            difficultyLevel.setText("★ ★ ★ ★ ★");
        else
            difficultyLevel.setText("★ ★ ★ ★ ★ ★");
    }
    public void create() throws IOException{
         Main m=new Main();
         m.changeScene("loginPage.fxml");
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
}
