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
public class GamingDungeonControllergz implements Initializable {

    /**
     * Initializes the controller class.
     */
    Random rd=new Random();
    private Timeline moveRightTimeline;
    private Timeline moveLeftTimeline;
    private Timeline moveUpTimeline;
    private Timeline moveDownTimeline;
    private boolean isMovingRight = false;
    private boolean isMovingLeft = false;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    private static String characterName="";
    private static int currentHealth=0;
    private static int attack=0;
    private static int speed=0;
    private int counterIndexItem=10;
    private static int zoneLvl=1;
    loginController getFile = new loginController();
    CharacterCreationPageController getDetails = new CharacterCreationPageController();
    GameDifficultyPageController pass = new GameDifficultyPageController();
    String username=getFile.usernameLogin;
    String characterNamePass=pass.characterName;
    String characterRoleShow=pass.characterRole;
    String characterAttackShow=getDetails.characterAttackShow;
    String characterHealthShow=getDetails.characterHealthShow;
    String characterSpeedShow=getDetails.characterSpeedShow;
    String difficultyLevel=pass.levelDifficulty;
    //Split ahahhahahaha
    String[]element=new String[96];
    String[]items=new String[6];
    Canvas canvas = new Canvas(480, 320);  // Set the size of the canvas
    Canvas itemCanvas = new Canvas(180, 30);
    Canvas itemCanvasDelete = new Canvas(300, 50);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    GraphicsContext gcItem = itemCanvas.getGraphicsContext2D();
    GraphicsContext gcItemDelete = itemCanvasDelete.getGraphicsContext2D();
    Image rock = new Image(getClass().getClassLoader().getResourceAsStream("rock.jpg"));
    Image goblin= new Image(getClass().getClassLoader().getResourceAsStream("goblin.png"));
    Image slime= new Image(getClass().getClassLoader().getResourceAsStream("Slime_lvl1_Green.png"));
    Image spider= new Image(getClass().getClassLoader().getResourceAsStream("Laser Boost.jpg"));
    Image potion = new Image(getClass().getClassLoader().getResourceAsStream("potion.png"));
    Image shield = new Image(getClass().getClassLoader().getResourceAsStream("shield.png"));
    Image sword = new Image(getClass().getClassLoader().getResourceAsStream("sword.png"));
    Image door = new Image(getClass().getClassLoader().getResourceAsStream("megatron.gif"));
    Image profilePicImg = new Image(getClass().getClassLoader().getResourceAsStream("pic.png"));
    ImageView imgProfilePic = new ImageView(profilePicImg);
    private Image characterToLeft;
    private Image characterToRight;
//    private Image characterToLeft = new Image(getClass().getClassLoader().getResourceAsStream("warriorToLeft.png"));
//    private Image characterToRight = new Image(getClass().getClassLoader().getResourceAsStream("warriorToRight.png"));
    boolean rightLeg=true;
    boolean directionRight=true;
    private int numMonster=rd.nextInt(1,4);
    String[]monsterArray={"goblin","spider","slime"};
    String[]itemArray={"potion","shield","sword"};
    //int numItem=rd.nextInt(1,3);
    int numItem=8;
    int totalNumMonsterItem=numMonster+numItem;
    String[][]monsterItemPosition=new String[totalNumMonsterItem][2]; //0 is index, 1 is name
    Image imgPotionInList=new Image(getClass().getClassLoader().getResourceAsStream("potion.png"));
    ImageView potionInList = new ImageView(imgPotionInList);
    Image imgSwordInList=new Image(getClass().getClassLoader().getResourceAsStream("sword.png"));
    ImageView swordInList = new ImageView(imgSwordInList);
    Image imgShieldInList=new Image(getClass().getClassLoader().getResourceAsStream("shield.png"));
    ImageView shieldInList = new ImageView(imgShieldInList);
    public static String[]itemUser={"blank","blank","blank","blank","blank","blank"}; //Array for user item
    private int itemReplaced=7;
    private String currentItemFound="";
    private int doorPositionInMap=0;
    private int indexItemSelectedToUse=7;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (characterRoleShow.equalsIgnoreCase("WARRIOR")){
            characterToLeft = new Image(getClass().getClassLoader().getResourceAsStream("warriorToLeft.png"));
            characterToRight = new Image(getClass().getClassLoader().getResourceAsStream("warriorToRight.png"));
        }
        if (characterRoleShow.equalsIgnoreCase("ASSASSIN")){
            characterToLeft = new Image(getClass().getClassLoader().getResourceAsStream("Bob_Assasin.png"));
            characterToRight = new Image(getClass().getClassLoader().getResourceAsStream("Bob_Assasin_Right.png"));
        }
        if (characterRoleShow.equalsIgnoreCase("MARKSMAN")){
            characterToLeft = new Image(getClass().getClassLoader().getResourceAsStream("Bob_Maskman.png"));
            characterToRight = new Image(getClass().getClassLoader().getResourceAsStream("Bob_Maskman_Right.png"));
        }

        // TODO
        zoneLevel.setText("Zone "+zoneLvl);
        for(int i=0;i<itemUser.length;i++){
        if(!itemUser[i].equals("blank"))
            putItemInItemListLoop(itemUser[i],i);
        }
            System.out.println("");
        buttonItem1.setFocusTraversable(false);
        buttonItem2.setFocusTraversable(false);
        buttonItem3.setFocusTraversable(false);
        buttonItem4.setFocusTraversable(false);
        buttonItem5.setFocusTraversable(false);
        buttonItem6.setFocusTraversable(false);
        logOutButton.setFocusTraversable(false);
        Image imgLogout=new Image(getClass().getClassLoader().getResourceAsStream("logoutButton.png"));
        ImageView imgLogoutView = new ImageView(imgLogout);
        imgLogoutView.setFitHeight(20);
        imgLogoutView.setFitWidth(40);
        logOutButton.setGraphic(imgLogoutView);
        imgProfilePic.setFitHeight(68);
        imgProfilePic.setFitWidth(68);
        profilePic.setImage(imgProfilePic.getImage());
        characterName=characterNamePass;
        name.setText(characterName);
        characterRole.setText("Role: "+characterRoleShow);
        currentHealth=Integer.parseInt(characterHealthShow);
        attack=Integer.parseInt(characterAttackShow);
        speed=Integer.parseInt(characterSpeedShow);
        hpBar.setText("HP: "+currentHealth+" / "+characterHealthShow);
        characterAP.setText("Attack Power: "+attack);
        characterSpeed.setText("Speed: "+speed);
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
        int countMonster=0;
        int countItem=0;
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
        
        // Set position of items
        while(countItem<numItem){
            int positionX=rd.nextInt(0,12);
            int positionY=rd.nextInt(0,8);
            int position=positionY*12+positionX;
            while(element[position].equals("goblin")||element[position].equals("spider")||element[position].equals("slime")||element[position].equals("potion")){
                positionX=rd.nextInt(0,12);
                positionY=rd.nextInt(0,8);
                position=positionY*12+positionX;
            }
            String itemName=itemArray[rd.nextInt(0,itemArray.length)];
            if (itemName.equals("potion"))
                gc.drawImage(potion, positionX*40, positionY*40, 40,40); 
            else if (itemName.equals("shield"))
                gc.drawImage(shield, positionX*40, positionY*40, 40,40); 
            else 
                gc.drawImage(sword, positionX*40, positionY*40, 40,40); 
            element[position]=itemName;
            countItem++;
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
        doorPositionInMap=positionDoor;
        gc.drawImage(door, 440, doorY*40, 40,40); 
        
        //Get position of all monster and items(including their name)
        int countMonsterItemPosition=0;
        for (int i=0;i<element.length;i++){
            if (!(element[i].equals("rock"))&&!(element[i].equals("Bob"))&&!(element[i].equals("door"))){
                monsterItemPosition[countMonsterItemPosition][0]=String.valueOf(i);
                monsterItemPosition[countMonsterItemPosition][1]=element[i];
                countMonsterItemPosition++;
            }
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
        //Item Bar Delete
        gcItemDelete.setFill(javafx.scene.paint.Color.LIGHTYELLOW);
        gcItemDelete.fillRect(0, 0, 300, 50); // Draw a filled rectangle
        gcItemDelete.setStroke(javafx.scene.paint.Color.BLACK);
        gcItemDelete.setLineWidth(1);
        for (int i=0;i<6;i++){
            gcItemDelete.strokeLine(50*i+1.5, 1.5, 50*i+48.5, 1.5); // Draw a line
            gcItemDelete.strokeLine(50*i+1.5, 48.5, 50*i+48.5, 48.5);
            gcItemDelete.strokeLine(50*i+1.5, 1.5, 50*i+1.5, 48.5);
            gcItemDelete.strokeLine(50*i+48.5, 1.5, 50*i+48.5, 48.5);
        }
        //Split
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
        Image itemList = createImageFromCanvas(itemCanvas);
        itemBar.setImage(itemList);
        Image itemListDelete = createImageFromCanvas(itemCanvasDelete);
        itemBarDelete.setImage(itemListDelete);
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
    private ImageView itemBarDelete;
    @FXML
    private ImageView profilePic;
    @FXML
    private ImageView imageItemNew;
    @FXML
    private ImageView imageItemToBeUsed;
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
    @FXML
    private Label zoneLevel;
    @FXML
    private Label errorMsg;
    @FXML
    private Label useItemName;
    @FXML
    private Button buttonItem1;
    @FXML
    private Button buttonItem2;
    @FXML
    private Button buttonItem3;
    @FXML
    private Button buttonItem4;
    @FXML
    private Button buttonItem5;
    @FXML
    private Button buttonItem6;
    @FXML
    private AnchorPane itemOverflow;
    @FXML
    private AnchorPane confirmUseItem;
    @FXML
    private Button buttonItemReplace1;
    @FXML
    private Button buttonItemReplace2;
    @FXML
    private Button buttonItemReplace3;
    @FXML
    private Button buttonItemReplace4;
    @FXML
    private Button buttonItemReplace5;
    @FXML
    private Button buttonItemReplace6;
    @FXML
    private Button confirmUseItemButton;
    @FXML
    private Button cancelUseItem;
    
    
    public void logOut() throws IOException{
        zoneLvl=1;
         App m=new App();
         m.changeScene("loginPage.fxml");
    }
    public void checkStatus(int characterCurrentBlockPosition)throws IOException{
        errorMsg.setText("");
        if(doorPositionInMap==characterCurrentBlockPosition){
            if(numMonster==0){
                zoneLvl++;
                App m=new App();
                m.changeScene("GamingDungeon.fxml");
            }
            else{
                errorMsg.setText("There are still "+numMonster+" left in the dungeon");
            }
            
        }
        System.out.println(numMonster);
        for (int i=0;i<totalNumMonsterItem;i++){
            if (monsterItemPosition[i][0].equals(String.valueOf(characterCurrentBlockPosition))){
                for (int j=0; j<itemArray.length;j++){
                    if(monsterItemPosition[i][1].equals(itemArray[j])){
                        putItemInItemList(monsterItemPosition[i][1]);
                        clearItem(characterCurrentBlockPosition);
                        monsterItemPosition[i][1]="rock";
                    }
                }
                for(int j=0;j<monsterArray.length;j++){
                    if(monsterItemPosition[i][1].equals(monsterArray[j])){
                        monsterItemPosition[i][1]="rock";
                        numMonster--;
                    }
                }
            }
        }
    }
    public void putItemInItemList(String itemName){
        // Create a Map to store ImageViews with their respective names
        currentItemFound=itemName;
        Map<String, ImageView> imageViewMap = new HashMap<>();
        imageViewMap.put("potionInList", potionInList);
        imageViewMap.put("swordInList", swordInList);
        imageViewMap.put("shieldInList", shieldInList);
        //Button
        Map<String, Button> buttonMap = new HashMap<>();
        buttonMap.put("0", buttonItem1);
        buttonMap.put("1", buttonItem2);
        buttonMap.put("2", buttonItem3);
        buttonMap.put("3", buttonItem4);
        buttonMap.put("4", buttonItem5);
        buttonMap.put("5", buttonItem6);
        //ButtonReplaced Item
        Map<String, Button> buttonMapReplaceItem = new HashMap<>();
        buttonMapReplaceItem.put("0", buttonItemReplace1);
        buttonMapReplaceItem.put("1", buttonItemReplace2);
        buttonMapReplaceItem.put("2", buttonItemReplace3);
        buttonMapReplaceItem.put("3", buttonItemReplace4);
        buttonMapReplaceItem.put("4", buttonItemReplace5);
        buttonMapReplaceItem.put("5", buttonItemReplace6);
        
        //Split
        String imageViewName=itemName+"InList";
        counterIndexItem=10;
        for (int i=0;i<6;i++){
            if(itemUser[i].equals("blank")){
                counterIndexItem=i;
                itemUser[i]=itemName;
                break;
            }
        }
        String itemIndex=String.valueOf(counterIndexItem);
        Button buttonItem=buttonMap.get(itemIndex);
        Button buttonItemReplaced=buttonMapReplaceItem.get(itemIndex);
        ImageView imageView = new ImageView(imageViewMap.get(imageViewName).getImage());
        if(counterIndexItem<6){
        if (imageView != null) {
            imageView.setFitHeight(25);
            imageView.setFitWidth(25);
            buttonItem.setVisible(true);
            buttonItem.setGraphic(imageView);
            buttonItem.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
            ImageView imageViewReplaced = new ImageView(imageViewMap.get(imageViewName).getImage());
            imageViewReplaced.setFitHeight(45);
            imageViewReplaced.setFitWidth(45);
            buttonItemReplaced.setVisible(true);
            buttonItemReplaced.setGraphic(imageViewReplaced);
            buttonItemReplaced.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
            /*
            ImageView imageViewReplaced = new ImageView(imageViewMap.get(imageViewName).getImage());
            imageViewReplaced.setFitHeight(45);
            imageViewReplaced.setFitWidth(45);
            buttonItemReplaced.setVisible(true);
            buttonItemReplaced.setGraphic(imageViewReplaced); // Fixed: Use imageViewReplaced for the replaced button
            buttonItemReplaced.setStyle("-fx-padding: 0; -fx-background-color: transparent;");*/
        }
        }
        else{
            itemOverflow.setVisible(true);
            upButton.setDisable(true);
            downButton.setDisable(true);
            leftButton.setDisable(true);
            rightButton.setDisable(true);
            buttonItem1.setDisable(true);
            buttonItem2.setDisable(true);
            buttonItem3.setDisable(true);
            buttonItem4.setDisable(true);
            buttonItem5.setDisable(true);
            buttonItem6.setDisable(true);
            Image imageNew = imageViewMap.get(imageViewName).getImage();
            imageItemNew.setImage(imageNew);
        }
        
    }
    public void putItemInItemListLoop(String itemName, int index){
        // Create a Map to store ImageViews with their respective names
        Map<String, ImageView> imageViewMap = new HashMap<>();
        imageViewMap.put("potionInList", potionInList);
        imageViewMap.put("swordInList", swordInList);
        imageViewMap.put("shieldInList", shieldInList);
        //Button
        Map<String, Button> buttonMap = new HashMap<>();
        buttonMap.put("0", buttonItem1);
        buttonMap.put("1", buttonItem2);
        buttonMap.put("2", buttonItem3);
        buttonMap.put("3", buttonItem4);
        buttonMap.put("4", buttonItem5);
        buttonMap.put("5", buttonItem6);
        //ButtonReplaced Item
        Map<String, Button> buttonMapReplaceItem = new HashMap<>();
        buttonMapReplaceItem.put("0", buttonItemReplace1);
        buttonMapReplaceItem.put("1", buttonItemReplace2);
        buttonMapReplaceItem.put("2", buttonItemReplace3);
        buttonMapReplaceItem.put("3", buttonItemReplace4);
        buttonMapReplaceItem.put("4", buttonItemReplace5);
        buttonMapReplaceItem.put("5", buttonItemReplace6);
        
        //Split
        String imageViewName=itemName+"InList";
        String itemIndex=String.valueOf(index);
        Button buttonItem=buttonMap.get(itemIndex);
        Button buttonItemReplaced=buttonMapReplaceItem.get(itemIndex);
        ImageView imageView = new ImageView(imageViewMap.get(imageViewName).getImage());
        if(!(itemName.equals("blank"))){
        if (imageView != null) {
            imageView.setFitHeight(25);
            imageView.setFitWidth(25);
            buttonItem.setVisible(true);
            buttonItem.setGraphic(imageView);
            buttonItem.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
            ImageView imageViewReplaced = new ImageView(imageViewMap.get(imageViewName).getImage());
            imageViewReplaced.setFitHeight(45);
            imageViewReplaced.setFitWidth(45);
            buttonItemReplaced.setVisible(true);
            buttonItemReplaced.setGraphic(imageViewReplaced);
            buttonItemReplaced.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
            /*
            ImageView imageViewReplaced = new ImageView(imageViewMap.get(imageViewName).getImage());
            imageViewReplaced.setFitHeight(45);
            imageViewReplaced.setFitWidth(45);
            buttonItemReplaced.setVisible(true);
            buttonItemReplaced.setGraphic(imageViewReplaced); // Fixed: Use imageViewReplaced for the replaced button
            buttonItemReplaced.setStyle("-fx-padding: 0; -fx-background-color: transparent;");*/
        }
        }
        
    }
    //Clear item once Bob reached its position
    public void clearItem(int characterPosition){
        int characterXPosition=characterPosition%12*40;
        int characterYPosition=characterPosition/12*40;
        gc.clearRect(characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(rock,characterXPosition, characterYPosition, 40, 40);
        if(directionRight==true)
            gc.drawImage(characterToRight, characterXPosition, characterYPosition, 40,40); 
        else
            gc.drawImage(characterToLeft, characterXPosition, characterYPosition, 40,40); 
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
    }
    public void setItemDeleteBarBorder(int index){
        gcItemDelete.setStroke(javafx.scene.paint.Color.BLACK);
        gcItemDelete.setLineWidth(1);
        for (int i=0;i<6;i++){
            gcItemDelete.clearRect(50*i+1.5, 1.5, 50*i+48.5, 1.5); // Draw a line
            gcItemDelete.clearRect(50*i+1.5, 48.5, 50*i+48.5, 48.5);
            gcItemDelete.clearRect(50*i+1.5, 1.5, 50*i+1.5, 48.5);
            gcItemDelete.clearRect(50*i+48.5, 1.5, 50*i+48.5, 48.5);
        }
        for (int i=0;i<6;i++){
            gcItemDelete.strokeLine(50*i+1.5, 1.5, 50*i+48.5, 1.5); // Draw a line
            gcItemDelete.strokeLine(50*i+1.5, 48.5, 50*i+48.5, 48.5);
            gcItemDelete.strokeLine(50*i+1.5, 1.5, 50*i+1.5, 48.5);
            gcItemDelete.strokeLine(50*i+48.5, 1.5, 50*i+48.5, 48.5);
        }
        gcItemDelete.setStroke(javafx.scene.paint.Color.BLUE);
        gcItemDelete.setLineWidth(2);
            int i=index-1;
            gcItemDelete.strokeLine(50*i+1.5, 1.5, 50*i+48.5, 1.5); // Draw a line
            gcItemDelete.strokeLine(50*i+1.5, 48.5, 50*i+48.5, 48.5);
            gcItemDelete.strokeLine(50*i+1.5, 1.5, 50*i+1.5, 48.5);
            gcItemDelete.strokeLine(50*i+48.5, 1.5, 50*i+48.5, 48.5);
        
        Image itemListDelete = createImageFromCanvas(itemCanvasDelete);
        itemBarDelete.setImage(itemListDelete);
    }
    public void selectButtonReplace1(ActionEvent event) throws IOException{
        itemReplaced=1;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemDeleteBarBorder(itemReplaced);
    }
       
    public void selectButtonReplace2(ActionEvent event) throws IOException{
        itemReplaced=2;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemDeleteBarBorder(itemReplaced);
        
    }
    public void selectButtonReplace3(ActionEvent event) throws IOException{
        itemReplaced=3;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemDeleteBarBorder(itemReplaced);
    }
    public void selectButtonReplace4(ActionEvent event) throws IOException{
        itemReplaced=4;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemDeleteBarBorder(itemReplaced);
    }
    public void selectButtonReplace5(ActionEvent event) throws IOException{
        itemReplaced=5;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemDeleteBarBorder(itemReplaced);
    }
    public void selectButtonReplace6(ActionEvent event) throws IOException{
        itemReplaced=6;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemDeleteBarBorder(itemReplaced);
    }
    public void confirmReplaceItem() throws IOException{
        itemUser[itemReplaced-1]=currentItemFound;
        Map<String, ImageView> imageViewMap = new HashMap<>();
        imageViewMap.put("potionInList", potionInList);
        imageViewMap.put("swordInList", swordInList);
        imageViewMap.put("shieldInList", shieldInList);
        //Button
        Map<String, Button> buttonMap = new HashMap<>();
        buttonMap.put("1", buttonItem1);
        buttonMap.put("2", buttonItem2);
        buttonMap.put("3", buttonItem3);
        buttonMap.put("4", buttonItem4);
        buttonMap.put("5", buttonItem5);
        buttonMap.put("6", buttonItem6);
        //ButtonReplaced Item
        Map<String, Button> buttonMapReplaceItem = new HashMap<>();
        buttonMapReplaceItem.put("1", buttonItemReplace1);
        buttonMapReplaceItem.put("2", buttonItemReplace2);
        buttonMapReplaceItem.put("3", buttonItemReplace3);
        buttonMapReplaceItem.put("4", buttonItemReplace4);
        buttonMapReplaceItem.put("5", buttonItemReplace5);
        buttonMapReplaceItem.put("6", buttonItemReplace6);
        
        //Split
        String imageViewName=currentItemFound+"InList";
        String itemIndex=String.valueOf(itemReplaced);
        Button buttonItem=buttonMap.get(itemIndex);
        Button buttonItemReplaced=buttonMapReplaceItem.get(itemIndex);
        ImageView imageView = new ImageView(imageViewMap.get(imageViewName).getImage());
        if (imageView != null) {
            imageView.setFitHeight(25);
            imageView.setFitWidth(25);
            buttonItem.setVisible(true);
            buttonItem.setGraphic(imageView);
            buttonItem.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
            ImageView imageViewReplaced = new ImageView(imageViewMap.get(imageViewName).getImage());
            imageViewReplaced.setFitHeight(45);
            imageViewReplaced.setFitWidth(45);
            buttonItemReplaced.setVisible(true);
            buttonItemReplaced.setGraphic(imageViewReplaced);
            buttonItemReplaced.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
            /*
            ImageView imageViewReplaced = new ImageView(imageViewMap.get(imageViewName).getImage());
            imageViewReplaced.setFitHeight(45);
            imageViewReplaced.setFitWidth(45);
            buttonItemReplaced.setVisible(true);
            buttonItemReplaced.setGraphic(imageViewReplaced); // Fixed: Use imageViewReplaced for the replaced button
            buttonItemReplaced.setStyle("-fx-padding: 0; -fx-background-color: transparent;");*/
        }
        closeItemReplaceBar();
    }
    
    //Use Items
    public void useItem1(ActionEvent event) throws IOException{
        useItemMethod(0);
    }
    public void useItem2(ActionEvent event) throws IOException{
        useItemMethod(1);
    }
    public void useItem3(ActionEvent event) throws IOException{
        useItemMethod(2);
    }
    public void useItem4(ActionEvent event) throws IOException{
        useItemMethod(3);
    }
    public void useItem5(ActionEvent event) throws IOException{
        useItemMethod(4);
    }
    public void useItem6(ActionEvent event) throws IOException{
        useItemMethod(5);
    }
    public void useItemMethod(int indexItem){
        indexItemSelectedToUse=indexItem;
        Map<String, ImageView> imageViewMap = new HashMap<>();
        imageViewMap.put("potionInList", potionInList);
        imageViewMap.put("swordInList", swordInList);
        imageViewMap.put("shieldInList", shieldInList);
        String imageViewName=itemUser[indexItem]+"InList";
        confirmUseItem.setVisible(true);
        upButton.setDisable(true);
        downButton.setDisable(true);
        leftButton.setDisable(true);
        rightButton.setDisable(true);
        buttonItem1.setDisable(true);
        buttonItem2.setDisable(true);
        buttonItem3.setDisable(true);
        buttonItem4.setDisable(true);
        buttonItem5.setDisable(true);
        buttonItem6.setDisable(true);
        useItemName.setText(itemUser[indexItem]);
        Image imageNew = imageViewMap.get(imageViewName).getImage();
        imageItemToBeUsed.setImage(imageNew);
    }
    public void confirmUseItem(ActionEvent event) throws IOException{
        System.out.println("Use "+itemUser[indexItemSelectedToUse]);
        String itemName=itemUser[indexItemSelectedToUse];
        itemUser[indexItemSelectedToUse]="blank";
        System.out.println("Now "+indexItemSelectedToUse+" is "+itemUser[indexItemSelectedToUse]);
        if (itemName.equals("potion")){
            currentHealth+=20;
            if (currentHealth>Integer.parseInt(characterHealthShow))
                currentHealth=Integer.parseInt(characterHealthShow);
            hpBar.setText("HP: "+currentHealth+" / "+characterHealthShow);
        }
        Map<String, Button> buttonMap = new HashMap<>();
        buttonMap.put("1", buttonItem1);
        buttonMap.put("2", buttonItem2);
        buttonMap.put("3", buttonItem3);
        buttonMap.put("4", buttonItem4);
        buttonMap.put("5", buttonItem5);
        buttonMap.put("6", buttonItem6);
        String itemIndex=String.valueOf(indexItemSelectedToUse+1);
        Button buttonItem=buttonMap.get(itemIndex);
        buttonItem.setGraphic(null);
        cancelUseItem();
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
    public void closeItemReplaceBar() throws IOException{
        itemOverflow.setVisible(false);
        upButton.setDisable(false);
        downButton.setDisable(false);
        leftButton.setDisable(false);
        rightButton.setDisable(false);
        buttonItem1.setDisable(false);
        buttonItem2.setDisable(false);
        buttonItem3.setDisable(false);
        buttonItem4.setDisable(false);
        buttonItem5.setDisable(false);
        buttonItem6.setDisable(false);
        counterIndexItem=5;
    }
    public void cancelUseItem() throws IOException{
        confirmUseItem.setVisible(false);
        upButton.setDisable(false);
        downButton.setDisable(false);
        leftButton.setDisable(false);
        rightButton.setDisable(false);
        buttonItem1.setDisable(false);
        buttonItem2.setDisable(false);
        buttonItem3.setDisable(false);
        buttonItem4.setDisable(false);
        buttonItem5.setDisable(false);
        buttonItem6.setDisable(false);
        counterIndexItem=5;
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
        for (int i=0; i<element.length; i++){
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition=i;
        }
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
        checkStatus(characterCurrentBlockPosition);
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
        for (int i=0; i<element.length; i++){
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition=i;
        }
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
        if(characterCurrentBlockPosition+1==doorPositionInMap){
            gc.drawImage(door,characterXPosition, characterYPosition, 40, 40);
        }
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
        directionRight=false;
        checkStatus(characterCurrentBlockPosition);
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
        for (int i=0; i<element.length; i++){
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition=i;
        }
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
        if(characterCurrentBlockPosition+12==doorPositionInMap){
            gc.drawImage(door,characterXPosition, characterYPosition, 40, 40);
        }
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
        checkStatus(characterCurrentBlockPosition);
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
        for (int i=0; i<element.length; i++){
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition=i;
        }
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
        if(characterCurrentBlockPosition-12==doorPositionInMap){
            gc.drawImage(door,characterXPosition, characterYPosition, 40, 40);
        }
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
        checkStatus(characterCurrentBlockPosition);
    }
    
}
