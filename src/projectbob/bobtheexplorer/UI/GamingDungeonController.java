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
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
/**
 * FXML Controller class
 *
 * @author gztan
 */
public class GamingDungeonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Timeline moveRightTimeline;
    private Timeline moveLeftTimeline;
    private Timeline moveUpTimeline;
    private Timeline moveDownTimeline;
    private boolean isMovingRight = false;
    private boolean isMovingLeft = false;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    public static int currentHealth=0;
    loginController getFile = new loginController();
    CharacterCreationPageController getDetails = new CharacterCreationPageController();
    projectbob.bobtheexplorer.UI.GameDifficultyPageController pass = new projectbob.bobtheexplorer.UI.GameDifficultyPageController();
    String username=getFile.usernameLogin;
    String characterName=pass.characterName;
    String characterRoleShow=pass.characterRole;
    String characterAttackShow=getDetails.characterAttackShow;
    String characterHealthShow=getDetails.characterHealthShow;
    String characterSpeedShow=getDetails.characterSpeedShow;
    String difficultyLevel=pass.levelDifficulty;
    public static String monster_Detect;
    String[]element=new String[96];
    String[]items=new String[6];
    Canvas canvas = new Canvas(480, 320);  // Set the size of the canvas
    Canvas itemCanvas = new Canvas(180, 30);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    GraphicsContext gcItem = itemCanvas.getGraphicsContext2D();
    Image rock = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/rock.jpg"));
    Image goblin= new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/goblin.png"));
    Image slime= new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/Slime_lvl1_Green.png"));
    Image spider= new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/Laser Boost.jpg"));
    Image item = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/Laser Boost.jpg"));
    Image door = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/megatron.gif"));
    Image profilePicImg = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/pic.png"));
    ImageView imgProfilePic = new ImageView(profilePicImg);
    Image characterToLeft = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/warriorToLeft.png"));
    Image characterToRight = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/warriorToRight.png"));
    boolean rightLeg=true;
    boolean directionRight=true;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logOutButton.setFocusTraversable(false);
        Image imgLogout=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/logoutButton.png"));
        ImageView imgLogoutView = new ImageView(imgLogout);
        imgLogoutView.setFitHeight(20);
        imgLogoutView.setFitWidth(40);
        logOutButton.setGraphic(imgLogoutView);
        imgProfilePic.setFitHeight(68);
        imgProfilePic.setFitWidth(68);
        profilePic.setImage(imgProfilePic.getImage());
        name.setText(characterName);
        characterRole.setText("Role: "+characterRoleShow);
        currentHealth=Integer.parseInt(characterHealthShow);
        currentHealth--;
        hpBar.setText("HP: "+currentHealth+" / "+characterHealthShow);
        characterAP.setText("Attack Power: "+characterAttackShow);
        characterSpeed.setText("Speed: "+characterSpeedShow);
        Image left=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/leftButton.png"));
        ImageView leftButtonView = new ImageView(left);
        leftButtonView.setFitHeight(40);
        leftButtonView.setFitWidth(40);
        leftButton.setGraphic(leftButtonView);
        Image right=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/rightButton.png"));
        ImageView rightButtonView = new ImageView(right);
        rightButtonView.setFitHeight(40);
        rightButtonView.setFitWidth(40);
        rightButton.setGraphic(rightButtonView);
        Image up=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/upButton.png"));
        ImageView upButtonView = new ImageView(up);
        upButtonView.setFitHeight(40);
        upButtonView.setFitWidth(40);
        upButton.setGraphic(upButtonView);
        Image down=new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/downButton.png"));
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
        gcItem.setFill(javafx.scene.paint.Color.LIGHTYELLOW);
        gcItem.fillRect(0, 0, 180, 30); // Draw a filled rectangle
        gcItem.setStroke(javafx.scene.paint.Color.BLACK);
        gcItem.setLineWidth(1);
        for (int i=0;i<6;i++){
            gcItem.strokeLine(30*i+1.5, 1.5, 30*i+28.5, 1.5); // Draw a line
            gcItem.strokeLine(30*i+1.5, 28.5, 30*i+28.5, 28.5);
            gcItem.strokeLine(30*i+1.5, 1.5, 30*i+1.5, 28.5);
            gcItem.strokeLine(30*i+28.5, 1.5, 30*i+28.5, 28.5);
        }
        gcItem.drawImage(door, 2.5, 2.5, 25,25);
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
        Image itemList = createImageFromCanvas(itemCanvas);
        itemBar.setImage(itemList);
        // Make sure the canvas can capture keyboard input
        moveRightTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.15), event -> {
                    try {
                        if (isMovingRight) {
                            goToRight(); // Call the goToRight method every 0.5s
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
        );
        moveRightTimeline.setCycleCount(Timeline.INDEFINITE); // Make it repeat indefinitely
        moveLeftTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.15), event -> {
                    try {
                        if (isMovingLeft) {
                            goToLeft(); // Call the goToLeft method every 0.5s
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
        );
        moveLeftTimeline.setCycleCount(Timeline.INDEFINITE); // Make it repeat indefinitely
        moveUpTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.15), event -> {
                    try {
                        if (isMovingUp) {
                            goUp(); // Call the goUp method every 0.5s
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
        );
        moveUpTimeline.setCycleCount(Timeline.INDEFINITE); // Make it repeat indefinitely
        moveDownTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.15), event -> {
                    try {
                        if (isMovingDown) {
                            goDown(); // Call the goDown method every 0.5s
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
        );
        moveDownTimeline.setCycleCount(Timeline.INDEFINITE); // Make it repeat indefinitely

        leftButton.setFocusTraversable(true);
        leftButton.requestFocus();
        rightButton.setFocusTraversable(true);
        rightButton.requestFocus();
        upButton.setFocusTraversable(true);
        upButton.requestFocus();
        downButton.setFocusTraversable(true);
        downButton.requestFocus();
        // Add key event listener to the canvas
        leftButton.setOnKeyPressed(event -> {
            // Handle each key press for movement
            if (event.getCode() == KeyCode.RIGHT||event.getCode() == KeyCode.D) {
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingRight) {
                    isMovingRight = true;
                    moveRightTimeline.play(); // Move character to the right
                    rightButton.setFocusTraversable(true);
                    rightButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.LEFT||event.getCode() == KeyCode.A) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingLeft) {
                    isMovingLeft = true;
                    moveLeftTimeline.play(); // Move character to the right
                    leftButton.setFocusTraversable(true);
                    leftButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.UP||event.getCode() == KeyCode.W) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingUp) {
                    isMovingUp = true;
                    moveUpTimeline.play(); // Move character to the right
                    upButton.setFocusTraversable(true);
                    upButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.DOWN||event.getCode() == KeyCode.S) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                if (!isMovingDown) {
                    isMovingDown = true;
                    moveDownTimeline.play(); // Move character to the right
                    downButton.setFocusTraversable(true);
                    downButton.requestFocus();
                }
            }
        });
        leftButton.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.LEFT|| event.getCode() == KeyCode.A) {
                // Stop moving the character to the left when the key is released
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop(); // Stop the timeline
            }
        });
        rightButton.setOnKeyPressed(event -> {
            // Handle each key press for movement
            if (event.getCode() == KeyCode.RIGHT||event.getCode() == KeyCode.D) {
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingRight) {
                    isMovingRight = true;
                    moveRightTimeline.play(); // Move character to the right
                    rightButton.setFocusTraversable(true);
                    rightButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.LEFT||event.getCode() == KeyCode.A) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingLeft) {
                    isMovingLeft = true;
                    moveLeftTimeline.play(); // Move character to the right
                    leftButton.setFocusTraversable(true);
                    leftButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.UP||event.getCode() == KeyCode.W) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingUp) {
                    isMovingUp = true;
                    moveUpTimeline.play(); // Move character to the right
                    upButton.setFocusTraversable(true);
                    upButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.DOWN||event.getCode() == KeyCode.S) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                if (!isMovingDown) {
                    isMovingDown = true;
                    moveDownTimeline.play(); // Move character to the right
                    downButton.setFocusTraversable(true);
                    downButton.requestFocus();
                }
            }
        });
        rightButton.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
                // Stop moving the character to the right when the key is released
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop(); // Stop the timeline
            }
        });
        upButton.setOnKeyPressed(event -> {
            // Handle each key press for movement
            if (event.getCode() == KeyCode.RIGHT||event.getCode() == KeyCode.D) {
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingRight) {
                    isMovingRight = true;
                    moveRightTimeline.play(); // Move character to the right
                    rightButton.setFocusTraversable(true);
                    rightButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.LEFT||event.getCode() == KeyCode.A) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingLeft) {
                    isMovingLeft = true;
                    moveLeftTimeline.play(); // Move character to the right
                    leftButton.setFocusTraversable(true);
                    leftButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.UP||event.getCode() == KeyCode.W) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingUp) {
                    isMovingUp = true;
                    moveUpTimeline.play(); // Move character to the right
                    upButton.setFocusTraversable(true);
                    upButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.DOWN||event.getCode() == KeyCode.S) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                if (!isMovingDown) {
                    isMovingDown = true;
                    moveDownTimeline.play(); // Move character to the right
                    downButton.setFocusTraversable(true);
                    downButton.requestFocus();
                }
            }
        });
        upButton.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) {
                // Stop moving the character to the up when the key is released
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop(); // Stop the timeline
            }
        });
        downButton.setOnKeyPressed(event -> {
            // Handle each key press for movement
            if (event.getCode() == KeyCode.RIGHT||event.getCode() == KeyCode.D) {
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingRight) {
                    isMovingRight = true;
                    moveRightTimeline.play(); // Move character to the right
                    rightButton.setFocusTraversable(true);
                    rightButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.LEFT||event.getCode() == KeyCode.A) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingLeft) {
                    isMovingLeft = true;
                    moveLeftTimeline.play(); // Move character to the right
                    leftButton.setFocusTraversable(true);
                    leftButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.UP||event.getCode() == KeyCode.W) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingUp) {
                    isMovingUp = true;
                    moveUpTimeline.play(); // Move character to the right
                    upButton.setFocusTraversable(true);
                    upButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.DOWN||event.getCode() == KeyCode.S) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                if (!isMovingDown) {
                    isMovingDown = true;
                    moveDownTimeline.play(); // Move character to the right
                    downButton.setFocusTraversable(true);
                    downButton.requestFocus();
                }
            }
        });
        downButton.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {
                // Stop moving the character to the down when the key is released
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop(); // Stop the timeline
            }
        });

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
    private ImageView itemBar;
    @FXML
    private ImageView profilePic;
    @FXML
    private Label usernameID;
    @FXML
    private Label name;
    @FXML
    private Label hpBar;
    @FXML
    private Label characterRole;
    @FXML
    private Label characterAP;
    @FXML
    private Label characterSpeed;


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
        //detect the monster
        detectMonster(characterCurrentBlockPosition,"right");

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

        //detect monster
        detectMonster(characterCurrentBlockPosition,"left");

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

        //detect monster
        detectMonster(characterCurrentBlockPosition,"up");

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

        //detect monster
        detectMonster(characterCurrentBlockPosition,"down");

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

    public void detectMonster(int characterCurrentBlockPosition, String direction )throws IOException{
        Main m = new Main();
        switch(direction){
            case "right":
                if(characterCurrentBlockPosition%12!=11&&(element[characterCurrentBlockPosition+1].equals("slime")||
                        element[characterCurrentBlockPosition+1].equals("goblin")||
                        element[characterCurrentBlockPosition+1].equals("spider"))){
                    monster_Detect = element[characterCurrentBlockPosition+1].toUpperCase();
                    m.changeScene("BattleStatusPage.fxml");
                }
                break;
            case "left":
                if(characterCurrentBlockPosition%12!=0&&(element[characterCurrentBlockPosition-1].equals("slime")||
                        element[characterCurrentBlockPosition-1].equals("goblin")||
                        element[characterCurrentBlockPosition-1].equals("spider"))){
                    monster_Detect = element[characterCurrentBlockPosition-1].toUpperCase();
                    m.changeScene("BattleStatusPage.fxml");
                }
                break;
            case "up":
                if(characterCurrentBlockPosition/12!=0&&(element[characterCurrentBlockPosition-12].equals("slime")||
                        element[characterCurrentBlockPosition-12].equals("goblin")||
                        element[characterCurrentBlockPosition-12].equals("spider"))){
                    monster_Detect = element[characterCurrentBlockPosition-12].toUpperCase();
                    m.changeScene("BattleStatusPage.fxml");
                }
                break;
            case "down":
                if(characterCurrentBlockPosition/12!=7&&(element[characterCurrentBlockPosition+12].equals("slime")||
                        element[characterCurrentBlockPosition+12].equals("goblin")||
                        element[characterCurrentBlockPosition+12].equals("spider"))){
                    monster_Detect = element[characterCurrentBlockPosition+12].toUpperCase();
                    m.changeScene("BattleStatusPage.fxml");
                }
                break;
        }
    }

    @FXML
    private Button CheckingButton;
    public void checking() throws IOException{
        Main m= new Main();
        m.changeScene("BattleStatusPage.fxml");
    }


}
