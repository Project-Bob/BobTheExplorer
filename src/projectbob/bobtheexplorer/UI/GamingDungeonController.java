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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author gztan
 */
public class GamingDungeonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    loginController getFile = new loginController();
    String username=getFile.usernameLogin;
    String[]element=new String[96];
    Canvas canvas = new Canvas(480, 320);  // Set the size of the canvas
    GraphicsContext gc = canvas.getGraphicsContext2D();
    Image rock = new Image(getClass().getClassLoader().getResourceAsStream("rock.png"));
    Image goblin= new Image(getClass().getClassLoader().getResourceAsStream("goblin.png"));
    Image slime= new Image(getClass().getClassLoader().getResourceAsStream("Slime_lvl1_Green.png"));
    Image spider= new Image(getClass().getClassLoader().getResourceAsStream("Laser Boost.jpg"));
    Image item = new Image(getClass().getClassLoader().getResourceAsStream("Laser Boost.jpg"));
    Image door = new Image(getClass().getClassLoader().getResourceAsStream("megatron.gif"));
    Image characterToLeft = new Image(getClass().getClassLoader().getResourceAsStream("warriorToLeft.png"));
    Image characterToRight = new Image(getClass().getClassLoader().getResourceAsStream("warriorToRight.png"));
    boolean rightLeg=true;
    boolean directionRight=true;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logOutButton.setFocusTraversable(false);
        Image imgLogout=new Image(getClass().getClassLoader().getResourceAsStream("logoutButton.png"));
        ImageView imgLogoutView = new ImageView(imgLogout);
        imgLogoutView.setFitHeight(20);
        imgLogoutView.setFitWidth(40);
        logOutButton.setGraphic(imgLogoutView);
        Image left=new Image(getClass().getClassLoader().getResourceAsStream("leftButton.png"));
        ImageView leftButtonView = new ImageView(left);
        leftButtonView.setFitHeight(40);
        leftButtonView.setFitWidth(40);
        leftButton.setGraphic(leftButtonView);
        Image right=new Image(getClass().getClassLoader().getResourceAsStream("rightButton.png"));
        ImageView rightButtonView = new ImageView(right);
        rightButtonView.setFitHeight(40);
        rightButtonView.setFitWidth(40);
        rightButton.setGraphic(rightButtonView);
        Image up=new Image(getClass().getClassLoader().getResourceAsStream("upButton.png"));
        ImageView upButtonView = new ImageView(up);
        upButtonView.setFitHeight(40);
        upButtonView.setFitWidth(40);
        upButton.setGraphic(upButtonView);
        Image down=new Image(getClass().getClassLoader().getResourceAsStream("downButton.png"));
        ImageView downButtonView = new ImageView(down);
        downButtonView.setFitHeight(40);
        downButtonView.setFitWidth(40);
        downButton.setGraphic(downButtonView);
        usernameID.setText(username);
        Random rd=new Random();
        int numMonster=rd.nextInt(1,4);
        String[]monsterArray={"goblin","spider","slime"};
        int numItem=rd.nextInt(1,3);
        int countMonster=0;
        for (int j=0; j<320;j+=40){
            for(int i=0; i<480;i+=40){
                gc.drawImage(rock, i, j, 40,40);  
            }
        }
        for (int i=0;i<element.length;i++)
            element[i]="rock";
        // Set position of monster
        while(countMonster<numMonster){
            int positionX=rd.nextInt(0,12);
            int positionY=rd.nextInt(0,8);
            int position=positionY*12+positionX;
            while(element[position].equals("goblin")||element[position].equals("spider")||element[position].equals("slime")){
                positionX=rd.nextInt(0,12);
                positionY=rd.nextInt(0,8);
                position=positionY*12+positionX;
            }
            String monsterName=monsterArray[rd.nextInt(0,monsterArray.length)];
            if (monsterName.equals("goblin"))
                gc.drawImage(goblin, positionX*40, positionY*40, 40,40); 
            else if (monsterName.equals("slime"))
                gc.drawImage(slime, positionX*40, positionY*40, 40,40); 
            else 
                gc.drawImage(spider, positionX*40, positionY*40, 40,40); 
            element[position]=monsterName;
            countMonster++;
        }
        // Origin position of character (BOB)
        int characterY=rd.nextInt(0,8);
        int positionCharacter=characterY*12;
        while(!(element[positionCharacter].equals("rock"))){
                characterY=rd.nextInt(0,8);
                positionCharacter=characterY*12;
        }
        element[positionCharacter]="Bob";
        gc.drawImage(characterToRight, 0, characterY*40, 40,40); 
        for (int i=0; i<element.length;i++){
            System.out.println(i+" "+element[i]);
        }
        // Door Position
        int doorY=rd.nextInt(0,8);
        int positionDoor=(doorY+1)*12-1;
        while(!(element[positionDoor].equals("rock"))){
                doorY=rd.nextInt(0,8);
                positionDoor=(doorY+1)*12-1;
        }
        element[positionDoor]="door";
        gc.drawImage(door, 440, doorY*40, 40,40); 
        for (int i=0; i<element.length;i++){
            System.out.println(i+" "+element[i]);
        }
        
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
    }    
    @FXML
    private Button logOutButton;
    @FXML
    private Button leftButton;
    @FXML
    private Button rightButton;
    @FXML
    private Button upButton;
    @FXML
    private Button downButton;
    @FXML
    private ImageView imgTest;
    @FXML
    private Label usernameID;
    
    
    public void logOut() throws IOException{
         Main m=new Main();
         m.changeScene("loginPage.fxml");
    }
    // Convert the canvas content into an Image
    public Image createImageFromCanvas(Canvas canvas) {
        // Create a writable image with the same size as the canvas
        javafx.scene.image.WritableImage writableImage = new javafx.scene.image.WritableImage(
                (int) canvas.getWidth(), (int) canvas.getHeight());

        // Get the graphics context of the writable image
        javafx.scene.image.PixelWriter pixelWriter = writableImage.getPixelWriter();
        javafx.scene.image.Image snapshot = canvas.snapshot(null, writableImage);

        // Copy the canvas snapshot into the writable image
        pixelWriter.setPixels(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight(),
                snapshot.getPixelReader(), 0, 0);

        return writableImage;
    }
    public void goToRight() throws IOException{
        //get character current position(0-96)
        int characterCurrentBlockPosition=0;
        for (int i=0; i<element.length; i++){
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition=i;
        }
        int row=((characterCurrentBlockPosition)/12)+1;
        int column=((characterCurrentBlockPosition)%12)+1;
        element[characterCurrentBlockPosition]="rock";
        if (characterCurrentBlockPosition%12!=11){
            element[characterCurrentBlockPosition+1]="Bob";
        }
        else
            element[characterCurrentBlockPosition]="Bob";
        int characterYPosition=(row-1)*40;
        int characterXPosition=(column-1)*40;
        int characterXPositionNew=characterXPosition+40;
        int characterYPositionNew=characterYPosition;
        if (characterXPositionNew>=480){
            characterYPositionNew=characterYPosition;
            characterXPositionNew=characterXPosition;
        }
        gc.clearRect(characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(rock,characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(characterToRight, characterXPositionNew, characterYPositionNew, 40,40); 
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
        directionRight=true;
    }
    public void goToLeft() throws IOException{
        //get character current position(0-96)
        int characterCurrentBlockPosition=0;
        for (int i=0; i<element.length; i++){
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition=i;
        }
        int row=((characterCurrentBlockPosition)/12)+1;
        int column=((characterCurrentBlockPosition)%12)+1;
        element[characterCurrentBlockPosition]="rock";
        if (characterCurrentBlockPosition%12!=0){
            element[characterCurrentBlockPosition-1]="Bob";
        }
        else
            element[characterCurrentBlockPosition]="Bob";
        int characterYPosition=(row-1)*40;
        int characterXPosition=(column-1)*40;
        int characterXPositionNew=characterXPosition-40;
        int characterYPositionNew=characterYPosition;
        if (characterXPositionNew<0){
            characterYPositionNew=characterYPosition;
            characterXPositionNew=characterXPosition;
        }
        gc.clearRect(characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(rock,characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(characterToLeft, characterXPositionNew, characterYPositionNew, 40,40); 
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
        directionRight=false;
    }
    public void goUp() throws IOException{
        //get character current position(0-96)
        int characterCurrentBlockPosition=0;
        for (int i=0; i<element.length; i++){
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition=i;
        }
        int row=((characterCurrentBlockPosition)/12)+1;
        int column=((characterCurrentBlockPosition)%12)+1;
        element[characterCurrentBlockPosition]="rock";
        if (characterCurrentBlockPosition/12!=0){
            element[characterCurrentBlockPosition-12]="Bob";
        }
        else
            element[characterCurrentBlockPosition]="Bob";
        int characterYPosition=(row-1)*40;
        int characterXPosition=(column-1)*40;
        int characterXPositionNew=characterXPosition;
        int characterYPositionNew=characterYPosition-40;
        if (characterYPositionNew<0){
            characterYPositionNew=characterYPosition;
            characterXPositionNew=characterXPosition;
        }
        gc.clearRect(characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(rock,characterXPosition, characterYPosition, 40, 40);
        if(directionRight==true)
            gc.drawImage(characterToRight, characterXPositionNew, characterYPositionNew, 40,40); 
        else
            gc.drawImage(characterToLeft, characterXPositionNew, characterYPositionNew, 40,40); 
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
    }
    public void goDown() throws IOException{
        //get character current position(0-96)
        int characterCurrentBlockPosition=0;
        for (int i=0; i<element.length; i++){
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition=i;
        }
        int row=((characterCurrentBlockPosition)/12)+1;
        int column=((characterCurrentBlockPosition)%12)+1;
        element[characterCurrentBlockPosition]="rock";
        if (characterCurrentBlockPosition/12!=7){
            element[characterCurrentBlockPosition+12]="Bob";
        }
        else
            element[characterCurrentBlockPosition]="Bob";
        int characterYPosition=(row-1)*40;
        int characterXPosition=(column-1)*40;
        int characterXPositionNew=characterXPosition;
        int characterYPositionNew=characterYPosition+40;
        if (characterYPositionNew>=320){
            characterYPositionNew=characterYPosition;
            characterXPositionNew=characterXPosition;
        }
        gc.clearRect(characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(rock,characterXPosition, characterYPosition, 40, 40);
        if(directionRight==true)
            gc.drawImage(characterToRight, characterXPositionNew, characterYPositionNew, 40,40); 
        else
            gc.drawImage(characterToLeft, characterXPositionNew, characterYPositionNew, 40,40); 
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
    }
}
