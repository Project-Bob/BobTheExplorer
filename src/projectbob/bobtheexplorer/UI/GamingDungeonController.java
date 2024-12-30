/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projectbob.bobtheexplorer.UI;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.IOException;
import javafx.event.ActionEvent;

import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.*;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

/**
 * FXML Controller class
 *
 * @author gztan
 */
public class GamingDungeonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Random rd = new Random();
    private Timeline moveRightTimeline;
    private Timeline moveLeftTimeline;
    private Timeline moveUpTimeline;
    private Timeline moveDownTimeline;
    private boolean isMovingRight = false;
    private boolean isMovingLeft = false;
    private boolean isMovingUp = false;
    private boolean isMovingDown = false;
    public static String characterName = "";
    private int counterIndexItem = 10;
    private static int zoneLvl=1;
    loginController getFile = new loginController();
    CharacterCreationPageController getDetails = new CharacterCreationPageController();
    GameDifficultyPageController pass = new GameDifficultyPageController();
    String username = getFile.usernameLogin;
    String characterNamePass = pass.characterName;
    String characterRoleShow = pass.characterRole;
    String characterAttackShow = getDetails.characterAttackShow;
    String characterHealthShow = getDetails.characterHealthShow;
    String characterSpeedShow = getDetails.characterSpeedShow;
    String difficultyLevel = pass.levelDifficulty;
    public static String monster_Detect;

    ///////////////////////////////////split///////////////////////////////////
    String[] element = new String[96];
    Canvas canvas = new Canvas(480, 320);  // Set the size of the canvas
    Canvas itemCanvas = new Canvas(180, 30);
    Canvas itemCanvasDelete = new Canvas(300, 50);
    Canvas itemCanvasUsed = new Canvas(300,50);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    GraphicsContext gcItem = itemCanvas.getGraphicsContext2D();
    GraphicsContext gcItemDelete = itemCanvasDelete.getGraphicsContext2D();
    GraphicsContext gcItemUsed = itemCanvasUsed.getGraphicsContext2D();
    Image rock = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/rock.jpg"));
    Image goblin = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/goblin.png"));
    Image slime = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/Slime_lvl1_Green.png"));
    Image spider = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/spider.png"));
    Image potion = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/potion.png"));
    Image shield = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/shield.png"));
    Image sword = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/sword.png"));
    Image door = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/door.jpg"));
    Image profilePicImg = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/warriorToRight.png"));
    ImageView imgProfilePic = new ImageView(profilePicImg);
    Image characterToLeft = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/warriorToLeft.png"));
    Image characterToRight = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/warriorToRight.png"));
    boolean directionRight = true;
    private int numMonster =
            "Level 1".equals(difficultyLevel) ? new Random().nextInt(1, 4) :
                    "Level 2".equals(difficultyLevel) ? new Random().nextInt(2, 5) :
                            "Level 3".equals(difficultyLevel) ? new Random().nextInt(3, 6):
                                    new Random().nextInt(1,4);
    String[] monsterArray = {"goblin", "spider", "slime"};
    String[] itemArray = {"potion", "shield", "sword"};
    //int numItem=rd.nextInt(1,3);
    int numItem = 8;
    int totalNumMonsterItem = numMonster + numItem;
    String[][] monsterItemPosition = new String[totalNumMonsterItem][2]; //0 is index, 1 is name
    Image imgPotionInList = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/potion.png"));
    ImageView potionInList = new ImageView(imgPotionInList);
    Image imgSwordInList = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/sword.png"));
    ImageView swordInList = new ImageView(imgSwordInList);
    Image imgShieldInList = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/shield.png"));
    ImageView shieldInList = new ImageView(imgShieldInList);
    public static String[] itemUser = {"blank", "blank", "blank", "blank", "blank", "blank"}; //Array for user item
    private int itemReplaced = 7;
    private String currentItemFound = "";
    protected int counterShieldUsed = 0;
    private int indexItemSelectedToUseOrRemove =7;
    private boolean berserkActivated = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        timeStart();//timer start
        itemOverflow.setVisible(false);
        itemUsed.setVisible(false);
        result.setVisible(false);
        System.out.println(itemUser[0]);
        zoneLevel.setText("Zone " + zoneLvl);
        for (int i = 0; i < itemUser.length; i++) {
            if (!itemUser[i].equals("blank"))
                putItemInItemListLoop(itemUser[i], i);
        }
        //putItemInItemList("potion");
        System.out.println("");
        buttonItem1.setFocusTraversable(false);
        buttonItem2.setFocusTraversable(false);
        buttonItem3.setFocusTraversable(false);
        buttonItem4.setFocusTraversable(false);
        buttonItem5.setFocusTraversable(false);
        buttonItem6.setFocusTraversable(false);
        logOutButton.setFocusTraversable(false);
        Image imgLogout = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/logoutButton.png"));
        ImageView imgLogoutView = new ImageView(imgLogout);
        imgLogoutView.setFitHeight(20);
        imgLogoutView.setFitWidth(40);
        logOutButton.setGraphic(imgLogoutView);
        imgProfilePic.setFitHeight(68);
        imgProfilePic.setFitWidth(68);
        profilePic.setImage(imgProfilePic.getImage());
        characterName = characterNamePass;
        name.setText(characterName);
        characterRole.setText("Role: " + characterRoleShow);
        hpBar.setText("HP: " + hero.getHP_Hero() + " / " + characterHealthShow);
        characterAP.setText("Attack Power: " + characterAttackShow);
        characterSpeed.setText("Speed: " + characterSpeedShow);
        Image left = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/leftButton.png"));
        ImageView leftButtonView = new ImageView(left);
        leftButtonView.setFitHeight(40);
        leftButtonView.setFitWidth(40);
        leftButton.setGraphic(leftButtonView);
        Image right = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/rightButton.png"));
        ImageView rightButtonView = new ImageView(right);
        rightButtonView.setFitHeight(40);
        rightButtonView.setFitWidth(40);
        rightButton.setGraphic(rightButtonView);
        Image up = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/upButton.png"));
        ImageView upButtonView = new ImageView(up);
        upButtonView.setFitHeight(40);
        upButtonView.setFitWidth(40);
        upButton.setGraphic(upButtonView);
        Image down = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/downButton.png"));
        ImageView downButtonView = new ImageView(down);
        downButtonView.setFitHeight(40);
        downButtonView.setFitWidth(40);
        downButton.setGraphic(downButtonView);
        usernameID.setText(username);
        int countMonster = 0;
        int countItem = 0;
        
        // Handler function for key press event
        EventHandler<KeyEvent> handleKeyPress = event -> {
            // Ignore key press if overlay is active
            if (itemOverflow.isVisible() || confirmUseItem.isVisible()) return;
            // Handle each key press for movement
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                if (!isMovingRight) {
                    isMovingRight = true;
                    try {
                        goToRight();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    moveRightTimeline.play(); // Move character to the right
                    rightButton.setFocusTraversable(true);
                    rightButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingLeft) {
                    isMovingLeft = true;
                    try {
                        goToLeft();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    moveLeftTimeline.play(); // Move character to the right
                    leftButton.setFocusTraversable(true);
                    leftButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingUp) {
                    isMovingUp = true;
                    try {
                        goUp();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    moveUpTimeline.play(); // Move character to the right
                    upButton.setFocusTraversable(true);
                    upButton.requestFocus();
                }
            } else if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                if (!isMovingDown) {
                    isMovingDown = true;
                    try {
                        goDown();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    moveDownTimeline.play(); // Move character to the right
                    downButton.setFocusTraversable(true);
                    downButton.requestFocus();
                }
            }
        };
        
        // Handler function for key release event
        EventHandler<KeyEvent> handleKeyRelease = event -> {
            if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
                // Stop moving the character to the left when the key is released
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop(); // Stop the timeline
            } else if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
                // Stop moving the character to the right when the key is released
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop(); // Stop the timeline
            } else if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {
                // Stop moving the character to the down when the key is released
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop(); // Stop the timeline
            } else if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) {
                // Stop moving the character to the up when the key is released
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop(); // Stop the timeline
            }
        };
        
        // Handler function for mouse press event
        EventHandler<MouseEvent> handleMousePress = event -> {
            // Ignore mouse press if overlay is active
            if (itemOverflow.isVisible() || confirmUseItem.isVisible()) return;

            // Handle each mouse press for movement
            if (event.getSource().equals(rightButton)) {
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                if (!isMovingRight) {
                    isMovingRight = true;
                    try {
                        goToRight();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    moveRightTimeline.play(); // Move character to the right
                    rightButton.setFocusTraversable(true);
                    rightButton.requestFocus();
                }
            } else if (event.getSource().equals(leftButton)) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingLeft) {
                    isMovingLeft = true;
                    try {
                        goToLeft();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    moveLeftTimeline.play(); // Move character to the right
                    leftButton.setFocusTraversable(true);
                    leftButton.requestFocus();
                }
            } else if (event.getSource().equals(upButton)) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop();
                if (!isMovingUp) {
                    isMovingUp = true;
                    try {
                        goUp();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    moveUpTimeline.play(); // Move character to the right
                    upButton.setFocusTraversable(true);
                    upButton.requestFocus();
                }
            } else if (event.getSource().equals(downButton)) {
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop();
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop();
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop();
                if (!isMovingDown) {
                    isMovingDown = true;
                    try {
                        goDown();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    moveDownTimeline.play(); // Move character to the right
                    downButton.setFocusTraversable(true);
                    downButton.requestFocus();
                }
            }
        };
        
        // Handler function for mouse release event
        EventHandler<MouseEvent> handleMouseRelease = event -> {
            if (event.getSource().equals(leftButton)) {
                // Stop moving the character to the left when the key is released
                isMovingLeft = false; // Stop the movement
                moveLeftTimeline.stop(); // Stop the timeline
            } else if (event.getSource().equals(rightButton)) {
                // Stop moving the character to the right when the key is released
                isMovingRight = false; // Stop the movement
                moveRightTimeline.stop(); // Stop the timeline
            } else if (event.getSource().equals(downButton)) {
                // Stop moving the character to the down when the key is released
                isMovingDown = false; // Stop the movement
                moveDownTimeline.stop(); // Stop the timeline
            } else if (event.getSource().equals(upButton)) {
                // Stop moving the character to the up when the key is released
                isMovingUp = false; // Stop the movement
                moveUpTimeline.stop(); // Stop the timeline
            }
        };

        // Set position of rock
        for (int j = 0; j < 320; j += 40) {
            for (int i = 0; i < 480; i += 40) {
                gc.drawImage(rock, i, j, 40, 40);
            }
        }
        for (int i = 0; i < element.length; i++)
            element[i] = "rock";

        // Set position of monster
        while (countMonster < numMonster) {
            int positionX = rd.nextInt(0, 12);
            int positionY = rd.nextInt(0, 8);
            int position = positionY * 12 + positionX;
            while (!(element[position].equals("rock"))) {
                positionX = rd.nextInt(0, 12);
                positionY = rd.nextInt(0, 8);
                position = positionY * 12 + positionX;
            }
            String monsterName = monsterArray[rd.nextInt(0, monsterArray.length)];
            if (monsterName.equals("goblin"))
                gc.drawImage(goblin, positionX * 40, positionY * 40, 40, 40);
            else if (monsterName.equals("slime"))
                gc.drawImage(slime, positionX * 40, positionY * 40, 40, 40);
            else
                gc.drawImage(spider, positionX * 40, positionY * 40, 40, 40);
            element[position] = monsterName;
            countMonster++;
        }

        // Set position of items
        while (countItem < numItem) {
            int positionX = rd.nextInt(0, 12);
            int positionY = rd.nextInt(0, 8);
            int position = positionY * 12 + positionX;
            while (!(element[position].equals("rock"))) {
                positionX = rd.nextInt(0, 12);
                positionY = rd.nextInt(0, 8);
                position = positionY * 12 + positionX;
            }
            String itemName = itemArray[rd.nextInt(0, itemArray.length)];
            if (itemName.equals("potion"))
                gc.drawImage(potion, positionX * 40, positionY * 40, 40, 40);
            else if (itemName.equals("shield"))
                gc.drawImage(shield, positionX * 40, positionY * 40, 40, 40);
            else
                gc.drawImage(sword, positionX * 40, positionY * 40, 40, 40);
            element[position] = itemName;
            countItem++;
        }

        // Origin position of character (BOB)
        int characterY = rd.nextInt(0, 8);
        int positionCharacter = characterY * 12;
        while (!(element[positionCharacter].equals("rock"))) {
            characterY = rd.nextInt(0, 8);
            positionCharacter = characterY * 12;
        }
        element[positionCharacter] = "Bob";
        gc.drawImage(characterToRight, 0, characterY * 40, 40, 40);
        for (int i = 0; i < element.length; i++) {
            System.out.println(i + " " + element[i]);
        }
        // Door Position
        int doorY = rd.nextInt(0, 8);
        int positionDoor = (doorY + 1) * 12 - 1;
        while (!(element[positionDoor].equals("rock"))) {
            doorY = rd.nextInt(0, 8);
            positionDoor = (doorY + 1) * 12 - 1;
        }
        element[positionDoor] = "door";
        gc.drawImage(door, 440, doorY * 40, 40, 40);

        //Get position of all monster and items(including their name)
        int countMonsterItemPosition = 0;
        for (int i = 0; i < element.length; i++) {
            if (!(element[i].equals("rock")) && !(element[i].equals("Bob")) && !(element[i].equals("door"))) {
                monsterItemPosition[countMonsterItemPosition][0] = String.valueOf(i);
                monsterItemPosition[countMonsterItemPosition][1] = element[i];
                countMonsterItemPosition++;
            }
        }
        gcItem.setFill(javafx.scene.paint.Color.LIGHTYELLOW);
        gcItem.fillRect(0, 0, 180, 30); // Draw a filled rectangle
        gcItem.setStroke(javafx.scene.paint.Color.BLACK);
        gcItem.setLineWidth(1);
        for (int i = 0; i < 6; i++) {
            gcItem.strokeLine(30 * i + 1.5, 1.5, 30 * i + 28.5, 1.5); // Draw a line
            gcItem.strokeLine(30 * i + 1.5, 28.5, 30 * i + 28.5, 28.5);
            gcItem.strokeLine(30 * i + 1.5, 1.5, 30 * i + 1.5, 28.5);
            gcItem.strokeLine(30 * i + 28.5, 1.5, 30 * i + 28.5, 28.5);
        }
        //Item Bar Delete
        gcItemDelete.setFill(javafx.scene.paint.Color.LIGHTYELLOW);
        gcItemDelete.fillRect(0, 0, 300, 50); // Draw a filled rectangle
        gcItemDelete.setStroke(javafx.scene.paint.Color.BLACK);
        gcItemDelete.setLineWidth(1);
        for (int i = 0; i < 6; i++) {
            gcItemDelete.strokeLine(50 * i + 1.5, 1.5, 50 * i + 48.5, 1.5); // Draw a line
            gcItemDelete.strokeLine(50 * i + 1.5, 48.5, 50 * i + 48.5, 48.5);
            gcItemDelete.strokeLine(50 * i + 1.5, 1.5, 50 * i + 1.5, 48.5);
            gcItemDelete.strokeLine(50 * i + 48.5, 1.5, 50 * i + 48.5, 48.5);
        }
        //Item Bar Used
        gcItemUsed.setFill(javafx.scene.paint.Color.LIGHTYELLOW);
        gcItemUsed.fillRect(0, 0, 300, 50); // Draw a filled rectangle
        gcItemUsed.setStroke(javafx.scene.paint.Color.BLACK);
        gcItemUsed.setLineWidth(1);
        for (int i = 0; i < 6; i++) {
            gcItemUsed.strokeLine(50 * i + 1.5, 1.5, 50 * i + 48.5, 1.5); // Draw a line
            gcItemUsed.strokeLine(50 * i + 1.5, 48.5, 50 * i + 48.5, 48.5);
            gcItemUsed.strokeLine(50 * i + 1.5, 1.5, 50 * i + 1.5, 48.5);
            gcItemUsed.strokeLine(50 * i + 48.5, 1.5, 50 * i + 48.5, 48.5);
        }

        //Split
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
        Image itemList = createImageFromCanvas(itemCanvas);
        itemBar.setImage(itemList);
        Image itemListDelete = createImageFromCanvas(itemCanvasDelete);
        itemBarDelete.setImage(itemListDelete);
        Image itemListUsed = createImageFromCanvas(itemCanvasUsed);
        itemBarUsed.setImage(itemListUsed);

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
        leftButton.setOnKeyPressed(handleKeyPress);
        leftButton.setOnKeyReleased(handleKeyRelease);
        rightButton.setOnKeyPressed(handleKeyPress);
        rightButton.setOnKeyReleased(handleKeyRelease);
        upButton.setOnKeyPressed(handleKeyPress);
        upButton.setOnKeyReleased(handleKeyRelease);
        downButton.setOnKeyPressed(handleKeyPress);
        downButton.setOnKeyReleased(handleKeyRelease);
        
        // Add mouse event listener to the canvas
        leftButton.setOnMousePressed(handleMousePress);
        leftButton.setOnMouseReleased(handleMouseRelease);
        rightButton.setOnMousePressed(handleMousePress);
        rightButton.setOnMouseReleased(handleMouseRelease);
        upButton.setOnMousePressed(handleMousePress);
        upButton.setOnMouseReleased(handleMouseRelease);
        downButton.setOnMousePressed(handleMousePress);
        downButton.setOnMouseReleased(handleMouseRelease);


        //////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////battle status .///////////////////////////////////////

        //disable visibility of battle status page
        BattlePage.setVisible(false);

        //Hero Info
        Image Picture_Hero = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/warriorToRight.png"));
        Hero_PIC.setImage(Picture_Hero);
        Name_Hero.setText(characterName);
        HP_Hero.setText("HP: " + hero.getHP_Hero() + " / " + characterHealthShow);
        Role_Hero.setText("Role: " + characterRoleShow);
        AP_Hero.setText("Attack Power: " + characterAttackShow);
        Speed_Hero.setText("Speed: " + characterSpeedShow);

        //Monster Info
        Image Picture_Monster = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/megatron.gif"));
        Monster_PIC.setImage(Picture_Monster);
        Name_Monster.setText(GamingDungeonController.monster_Detect);
        monster = Monster_Slime.createSlime(difficultyLevel);
        HP_Monster.setText("HP: " + monster.getHp());
        AP_Monster.setText("Attack Power: " + monster.getAp());
        Speed_Monster.setText("Speed: " + monster.getSpeed());

        //Instruction Info
        Instruction.setText("Please choose your next step!!!");
        Instruction.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 16));
        Instruction.setTextFill(Color.DARKBLUE);
        Instruction.setWrapText(true);
        Instruction.setStyle("-fx-border-color: white; -fx-background-color: white; -fx-padding: 15px;");

        //Background
        Image BattlePageBackGroundPIC = new Image(getClass().getResourceAsStream("/projectbob/bobtheexplorer/test/battle status.jpg"));
        BattlePageBackground.setImage(BattlePageBackGroundPIC);
//        BattlePage.setStyle("-fx-background-color:black;");
    }

    @FXML
    private Label errorMsg;
    @FXML
    private Label useItemName;
    @FXML
    private Label zoneLevel;
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
    private Button confirmRemoveItemButton;
    @FXML
    private Button cancelUseItem;


    public void logOut() throws IOException {
        timeStop();
        zoneLvl=1;
        App m = new App();
        m.changeScene("loginPage.fxml");
    }

    //Detect item
    public void checkStatus(int characterCurrentBlockPosition, String direction) throws IOException {
        if (direction.equals("right") && characterCurrentBlockPosition % 12 != 11)
            characterCurrentBlockPosition += 1;
        else if (direction.equals("left") && characterCurrentBlockPosition % 12 != 0)
            characterCurrentBlockPosition -= 1;
        else if (direction.equals("up") && characterCurrentBlockPosition / 12 != 0)
            characterCurrentBlockPosition -= 12;
        else if (direction.equals("down") && characterCurrentBlockPosition / 12 != 7)
            characterCurrentBlockPosition += 12;
        for (int i = 0; i < totalNumMonsterItem; i++) {
            if (monsterItemPosition[i][0].equals(String.valueOf(characterCurrentBlockPosition))) {
                for (int j = 0; j < itemArray.length; j++) {
                    if (monsterItemPosition[i][1].equals(itemArray[j])) {
                        putItemInItemList(monsterItemPosition[i][1]);
                        clearItem(characterCurrentBlockPosition);
                        monsterItemPosition[i][1] = "rock";
                    }
                }
            }
        }
    }

    //Store the item
    public void putItemInItemList(String itemName) {
        // Create a Map to store ImageViews with their respective names
        currentItemFound = itemName;
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
        //ButtonUsed Item
        Map<String, Button> buttonMapUsedItem = new HashMap<>();
        buttonMapUsedItem.put("0", buttonItemUsed1);
        buttonMapUsedItem.put("1", buttonItemUsed2);
        buttonMapUsedItem.put("2", buttonItemUsed3);
        buttonMapUsedItem.put("3", buttonItemUsed4);
        buttonMapUsedItem.put("4", buttonItemUsed5);
        buttonMapUsedItem.put("5", buttonItemUsed6);

        //Split
        String imageViewName = itemName + "InList";
        counterIndexItem = 10;
        for (int i = 0; i < 6; i++) {
            if (itemUser[i].equals("blank")) {
                counterIndexItem = i;
                itemUser[i] = itemName;
                break;
            }
        }

        String itemIndex = String.valueOf(counterIndexItem);
        Button buttonItem = buttonMap.get(itemIndex);
        Button buttonItemReplaced = buttonMapReplaceItem.get(itemIndex);
        Button buttonItemUsed = buttonMapUsedItem.get(itemIndex);
        ImageView imageView = new ImageView(imageViewMap.get(imageViewName).getImage());
        if (counterIndexItem < 6) {
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
                ImageView imageViewUsed= new ImageView(imageViewMap.get(imageViewName).getImage());
                imageViewUsed.setFitHeight(45);
                imageViewUsed.setFitWidth(45);
                buttonItemUsed.setVisible(true);
                buttonItemUsed.setGraphic(imageViewUsed);
                buttonItemUsed.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
            }
        } else {
            // Resets character momentum
            isMovingRight = false; // Stop the movement
            moveRightTimeline.stop();
            isMovingLeft = false; // Stop the movement
            moveLeftTimeline.stop();
            isMovingUp = false; // Stop the movement
            moveUpTimeline.stop();
            isMovingDown = false; // Stop the movement
            moveDownTimeline.stop();
            itemOverflow.setVisible(true);
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


    public void putItemInItemListLoop(String itemName, int index) {
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
        //ButtonUsed Item
        Map<String, Button> buttonMapUsedItem = new HashMap<>();
        buttonMapUsedItem.put("0", buttonItemUsed1);
        buttonMapUsedItem.put("1", buttonItemUsed2);
        buttonMapUsedItem.put("2", buttonItemUsed3);
        buttonMapUsedItem.put("3", buttonItemUsed4);
        buttonMapUsedItem.put("4", buttonItemUsed5);
        buttonMapUsedItem.put("5", buttonItemUsed6);

        //Split
        String imageViewName = itemName + "InList";
        String itemIndex = String.valueOf(index);
        Button buttonItem = buttonMap.get(itemIndex);
        Button buttonItemReplaced = buttonMapReplaceItem.get(itemIndex);
        Button buttonItemUsed = buttonMapUsedItem.get(itemIndex);
        ImageView imageView = new ImageView(imageViewMap.get(imageViewName).getImage());
        ImageView imageViewUsed= new ImageView(imageViewMap.get(imageViewName).getImage());
        ImageView imageViewReplaced = new ImageView(imageViewMap.get(imageViewName).getImage());
        if (!(itemName.equals("blank"))) {
            if (imageView != null) {
                imageView.setFitHeight(25);
                imageView.setFitWidth(25);
                buttonItem.setVisible(true);
                buttonItem.setGraphic(imageView);
                buttonItem.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
//                ImageView imageViewReplaced = new ImageView(imageViewMap.get(imageViewName).getImage());
                imageViewReplaced.setFitHeight(45);
                imageViewReplaced.setFitWidth(45);
                buttonItemReplaced.setVisible(true);
                buttonItemReplaced.setGraphic(imageViewReplaced);
                buttonItemReplaced.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
//                ImageView imageViewUsed= new ImageView(imageViewMap.get(imageViewName).getImage());
                imageViewUsed.setFitHeight(45);
                imageViewUsed.setFitWidth(45);
                buttonItemUsed.setVisible(true);
                buttonItemUsed.setGraphic(imageViewUsed);
                buttonItemUsed.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
            }
        }
    }

    //reset the button
    private void resetButtonToOriginalState(int index) {
        Map<String, Button> buttonMap = new HashMap<>();
        buttonMap.put("0", buttonItem1);
        buttonMap.put("1", buttonItem2);
        buttonMap.put("2", buttonItem3);
        buttonMap.put("3", buttonItem4);
        buttonMap.put("4", buttonItem5);
        buttonMap.put("5", buttonItem6);

        Map<String, Button> buttonMapReplaceItem = new HashMap<>();
        buttonMapReplaceItem.put("0", buttonItemReplace1);
        buttonMapReplaceItem.put("1", buttonItemReplace2);
        buttonMapReplaceItem.put("2", buttonItemReplace3);
        buttonMapReplaceItem.put("3", buttonItemReplace4);
        buttonMapReplaceItem.put("4", buttonItemReplace5);
        buttonMapReplaceItem.put("5", buttonItemReplace6);

        Map<String, Button> buttonMapUsedItem = new HashMap<>();
        buttonMapUsedItem.put("0", buttonItemUsed1);
        buttonMapUsedItem.put("1", buttonItemUsed2);
        buttonMapUsedItem.put("2", buttonItemUsed3);
        buttonMapUsedItem.put("3", buttonItemUsed4);
        buttonMapUsedItem.put("4", buttonItemUsed5);
        buttonMapUsedItem.put("5", buttonItemUsed6);

        String itemIndex = String.valueOf(index);

        // Reset buttons
        Button buttonItem = buttonMap.get(itemIndex);
        Button buttonItemReplaced = buttonMapReplaceItem.get(itemIndex);
        Button buttonItemUsed = buttonMapUsedItem.get(itemIndex);

        if (buttonItem != null) {
            buttonItem.setVisible(false); // Hide the button
            buttonItem.setGraphic(null); // Remove any graphic
            buttonItem.setStyle(""); // Reset the style
        }
        if (buttonItemReplaced != null) {
            buttonItemReplaced.setVisible(false);
            buttonItemReplaced.setGraphic(null);
            buttonItemReplaced.setStyle("");
        }
        if (buttonItemUsed != null) {
            buttonItemUsed.setVisible(false);
            buttonItemUsed.setGraphic(null);
            buttonItemUsed.setStyle("");
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

    public void setItemUsedBarBorder(int index){
        gcItemUsed.setStroke(javafx.scene.paint.Color.BLACK);
        gcItemUsed.setLineWidth(1);
        for (int i=0;i<6;i++){
            gcItemUsed.clearRect(50*i+1.5, 1.5, 50*i+48.5, 1.5); // Draw a line
            gcItemUsed.clearRect(50*i+1.5, 48.5, 50*i+48.5, 48.5);
            gcItemUsed.clearRect(50*i+1.5, 1.5, 50*i+1.5, 48.5);
            gcItemUsed.clearRect(50*i+48.5, 1.5, 50*i+48.5, 48.5);
        }
        for (int i=0;i<6;i++){
            gcItemUsed.strokeLine(50*i+1.5, 1.5, 50*i+48.5, 1.5); // Draw a line
            gcItemUsed.strokeLine(50*i+1.5, 48.5, 50*i+48.5, 48.5);
            gcItemUsed.strokeLine(50*i+1.5, 1.5, 50*i+1.5, 48.5);
            gcItemUsed.strokeLine(50*i+48.5, 1.5, 50*i+48.5, 48.5);
        }
        gcItemUsed.setStroke(javafx.scene.paint.Color.BLUE);
        gcItemUsed.setLineWidth(2);
        int i=index-1;
        gcItemUsed.strokeLine(50*i+1.5, 1.5, 50*i+48.5, 1.5); // Draw a line
        gcItemUsed.strokeLine(50*i+1.5, 48.5, 50*i+48.5, 48.5);
        gcItemUsed.strokeLine(50*i+1.5, 1.5, 50*i+1.5, 48.5);
        gcItemUsed.strokeLine(50*i+48.5, 1.5, 50*i+48.5, 48.5);

        Image itemListUsed = createImageFromCanvas(itemCanvasUsed);
        itemBarUsed.setImage(itemListUsed);
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
        //ButtonUsed Item
        Map<String, Button> buttonMapUsedItem = new HashMap<>();
        buttonMapUsedItem.put("1", buttonItemUsed1);
        buttonMapUsedItem.put("2", buttonItemUsed2);
        buttonMapUsedItem.put("3", buttonItemUsed3);
        buttonMapUsedItem.put("4", buttonItemUsed4);
        buttonMapUsedItem.put("5", buttonItemUsed5);
        buttonMapUsedItem.put("6", buttonItemUsed6);
        //Split
        String imageViewName=currentItemFound+"InList";
        String itemIndex=String.valueOf(itemReplaced);
        Button buttonItem=buttonMap.get(itemIndex);
        Button buttonItemReplaced=buttonMapReplaceItem.get(itemIndex);
        Button buttonItemUsed=buttonMapUsedItem.get(itemIndex);
        ImageView imageView = new ImageView(imageViewMap.get(imageViewName).getImage());
        ImageView imageViewReplaced = new ImageView(imageViewMap.get(imageViewName).getImage());
        ImageView imageViewUsed = new ImageView(imageViewMap.get(imageViewName).getImage());
        if (imageView != null) {
            imageView.setFitHeight(25);
            imageView.setFitWidth(25);
            buttonItem.setVisible(true);
            buttonItem.setGraphic(imageView);
            buttonItem.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
//            ImageView imageViewReplaced = new ImageView(imageViewMap.get(imageViewName).getImage());
            imageViewReplaced.setFitHeight(45);
            imageViewReplaced.setFitWidth(45);
            buttonItemReplaced.setVisible(true);
            buttonItemReplaced.setGraphic(imageViewReplaced);
            buttonItemReplaced.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
//            ImageView imageViewUsed = new ImageView(imageViewMap.get(imageViewName).getImage());
            imageViewUsed.setFitHeight(45);
            imageViewUsed.setFitWidth(45);
            buttonItemUsed.setVisible(true);
            buttonItemUsed.setGraphic(imageViewReplaced);
            buttonItemUsed.setStyle("-fx-padding: 0; -fx-background-color: transparent;");
            /*
            ImageView imageViewReplaced = new ImageView(imageViewMap.get(imageViewName).getImage());
            imageViewReplaced.setFitHeight(45);
            imageViewReplaced.setFitWidth(45);
            buttonItemReplaced.setVisible(true);
            buttonItemReplaced.setGraphic(imageViewReplaced); // Fixed: Use imageViewReplaced for the replaced button
            buttonItemReplaced.setStyle("-fx-padding: 0; -fx-background-color: transparent;");*/
        }
        for (int i = 0; i < itemUser.length; i++) {
            if (!itemUser[i].equals("blank"))
                putItemInItemListLoop(itemUser[i], i);
        }
        closeItemReplaceBar();
    }

    public void confirmUsedItem() throws IOException {
        useItemBarMethod((itemReplaced - 1));
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
        indexItemSelectedToUseOrRemove =indexItem;
        Map<String, ImageView> imageViewMap = new HashMap<>();
        imageViewMap.put("potionInList", potionInList);
        imageViewMap.put("swordInList", swordInList);
        imageViewMap.put("shieldInList", shieldInList);
        String imageViewName=itemUser[indexItem]+"InList";
        confirmUseItem.setVisible(true);
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

        System.out.println("Use "+itemUser[indexItemSelectedToUseOrRemove]);
        String itemName=itemUser[indexItemSelectedToUseOrRemove];
        itemUser[indexItemSelectedToUseOrRemove]="blank";
        System.out.println("Now "+ indexItemSelectedToUseOrRemove +" is "+itemUser[indexItemSelectedToUseOrRemove]);
        if (itemName.equals("potion")){
            System.out.println("Use "+itemUser[indexItemSelectedToUseOrRemove]);
            itemUser[indexItemSelectedToUseOrRemove]="blank";
            System.out.println("Now "+ indexItemSelectedToUseOrRemove +" is "+itemUser[indexItemSelectedToUseOrRemove]);
            hero.setHP(hero.getHP_Hero()+20);
            if (hero.getHP_Hero()>Integer.parseInt(characterHealthShow))
                hero.setHP( Integer.parseInt(characterHealthShow));
            hpBar.setText("HP: "+hero.getHP_Hero()+" / "+characterHealthShow);
            HP_Hero.setText("HP: " + hero.getHP_Hero() + " / " + characterHealthShow);
        }
        if (itemName.equals("sword")){
            hero.setAP(hero.getAP_Hero()+10);
            characterAP.setText("Attack Power: " + hero.getAP_Hero());
            AP_Hero.setText("Attack Power: " + hero.getAP_Hero());
        }
        if(itemName.equals("shield")){
            counterShieldUsed = 2;
        }
        Map<String, Button> buttonMap = new HashMap<>();
        buttonMap.put("1", buttonItem1);
        buttonMap.put("2", buttonItem2);
        buttonMap.put("3", buttonItem3);
        buttonMap.put("4", buttonItem4);
        buttonMap.put("5", buttonItem5);
        buttonMap.put("6", buttonItem6);
        String itemIndex=String.valueOf(indexItemSelectedToUseOrRemove +1);
        Button buttonItem=buttonMap.get(itemIndex);
        buttonItem.setGraphic(null);
        cancelUseItem();
        for (int i = 0; i < itemUser.length; i++) {
            if (!itemUser[i].equals("blank"))
                putItemInItemListLoop(itemUser[i], i);
            else {
                resetButtonToOriginalState(i);
            }
        }
    }

    public void confirmRemoveItem(ActionEvent actionEvent)throws  IOException{
        System.out.println("Remove "+itemUser[indexItemSelectedToUseOrRemove]);
        itemUser[indexItemSelectedToUseOrRemove]="blank";
        System.out.println("Now "+ indexItemSelectedToUseOrRemove +" is "+itemUser[indexItemSelectedToUseOrRemove]);
        for (int i = 0; i < itemUser.length; i++) {
            if (!itemUser[i].equals("blank"))
                putItemInItemListLoop(itemUser[i], i);
            else {
                resetButtonToOriginalState(i);
            }
        }
        cancelUseItem();
    }

    public void useItemBarMethod(int indexItem){
        System.out.println("Use "+itemUser[indexItem]);
        String itemName=itemUser[indexItem];
        itemUser[indexItem]="blank";
        System.out.println("Now "+indexItem+" is "+itemUser[indexItem]);
        if (itemName.equals("potion")){
            hero.setHP(hero.getHP_Hero()+20);
            if (hero.getHP_Hero()>Integer.parseInt(characterHealthShow))
                hero.setHP( Integer.parseInt(characterHealthShow));
            hpBar.setText("HP: "+hero.getHP_Hero()+" / "+characterHealthShow);
            HP_Hero.setText("HP: " + hero.getHP_Hero() + " / " + characterHealthShow);
        }
        if (itemName.equals("sword")){
            hero.setAP(hero.getAP_Hero()+10);
            characterAP.setText("Attack Power: " + hero.getAP_Hero());
            AP_Hero.setText("Attack Power: " + hero.getAP_Hero());
        }
        if(itemName.equals("shield")){
            counterShieldUsed = 2;
        }
        for (int i = 0; i < itemUser.length; i++) {
            if (!itemUser[i].equals("blank"))
                putItemInItemListLoop(itemUser[i], i);
            else {
                resetButtonToOriginalState(i);
            }
        }
    }


    public void selectButtonUsed1(ActionEvent event) throws IOException{
        itemReplaced=1;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemUsedBarBorder(itemReplaced);
    }

    public void selectButtonUsed2(ActionEvent event) throws IOException{
        itemReplaced=2;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemUsedBarBorder(itemReplaced);

    }
    public void selectButtonUsed3(ActionEvent event) throws IOException{
        itemReplaced=3;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemUsedBarBorder(itemReplaced);
    }
    public void selectButtonUsed4(ActionEvent event) throws IOException{
        itemReplaced=4;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemUsedBarBorder(itemReplaced);
    }
    public void selectButtonUsed5(ActionEvent event) throws IOException{
        itemReplaced=5;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemUsedBarBorder(itemReplaced);
    }
    public void selectButtonUsed6(ActionEvent event) throws IOException{
        itemReplaced=6;
        System.out.println(itemReplaced);
        System.out.println(itemUser[itemReplaced-1]);
        setItemUsedBarBorder(itemReplaced);
    }

    public void closeItemReplaceBar() throws IOException{
        itemOverflow.setVisible(false);
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
        buttonItem1.setDisable(false);
        buttonItem2.setDisable(false);
        buttonItem3.setDisable(false);
        buttonItem4.setDisable(false);
        buttonItem5.setDisable(false);
        buttonItem6.setDisable(false);
        counterIndexItem=5;
    }

    public void closeItemUsedBar() throws IOException{
        itemUsed.setVisible(false);
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

    public void goToRight() throws IOException {
        //get character current position(0-96)
        App m = new App();
        int characterCurrentBlockPosition = 0;
        for (int i = 0; i < element.length; i++) {
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition = i;
        }
        //detect the door

        if(detectDoor(characterCurrentBlockPosition, "right")){
            if(numMonster==0 && zoneLvl<5){
                hero.setAP(HeroAP);//to reset the attackpower to initial attackpower
                zoneLvl++;
                timeStop();
                m.changeScene("GamingDungeon.fxml");
            }
            else if(numMonster>0){
                errorMsg.setText("There are still "+numMonster+" left in the dungeon");
                return;
            }
            else if(numMonster==0 && zoneLvl==5){
                message.setText("Victory");
                result.setVisible(true);
            }
        }

        //detect the monster
        if (detectMonster(characterCurrentBlockPosition, "right")) {
            Instruction.setText("Please choose your next step!!!");
            Name_Monster.setText(GamingDungeonController.monster_Detect);
            HP_Monster.setText("HP: " + monster.getHp());
            AP_Monster.setText("Attack Power: " + monster.getAp());
            Speed_Monster.setText("Speed: " + monster.getSpeed());
            BattlePage.setVisible(true);

        }

        int row = ((characterCurrentBlockPosition) / 12) + 1;
        int column = ((characterCurrentBlockPosition) % 12) + 1;
        element[characterCurrentBlockPosition] = "rock";

        if (characterCurrentBlockPosition % 12 != 11) {
            element[characterCurrentBlockPosition + 1] = "Bob";
            numOfMovement++;
        } else
            element[characterCurrentBlockPosition] = "Bob";
        int characterYPosition = (row - 1) * 40;
        int characterXPosition = (column - 1) * 40;
        int characterXPositionNew = characterXPosition + 40;
        int characterYPositionNew = characterYPosition;
        if (characterXPositionNew >= 480) {
            characterYPositionNew = characterYPosition;
            characterXPositionNew = characterXPosition;
        }

        checkStatus(characterCurrentBlockPosition, "right");
        gc.clearRect(characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(rock, characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(characterToRight, characterXPositionNew, characterYPositionNew, 40, 40);
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
        directionRight = true;

    }

    public void goToLeft() throws IOException {
        //get character current position(0-96)
        int characterCurrentBlockPosition = 0;
        for (int i = 0; i < element.length; i++) {
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition = i;
        }

        //detect monster
        if (detectMonster(characterCurrentBlockPosition, "left") == true) {
            Instruction.setText("Please choose your next step!!!");
            Name_Monster.setText(GamingDungeonController.monster_Detect);
            HP_Monster.setText("HP: " + monster.getHp());
            AP_Monster.setText("Attack Power: " + monster.getAp());
            Speed_Monster.setText("Speed: " + monster.getSpeed());
            BattlePage.setVisible(true);
        }

        int row = ((characterCurrentBlockPosition) / 12) + 1;
        int column = ((characterCurrentBlockPosition) % 12) + 1;
        element[characterCurrentBlockPosition] = "rock";
        if (characterCurrentBlockPosition % 12 != 0) {
            element[characterCurrentBlockPosition - 1] = "Bob";
            numOfMovement++;
        } else
            element[characterCurrentBlockPosition] = "Bob";
        int characterYPosition = (row - 1) * 40;
        int characterXPosition = (column - 1) * 40;
        int characterXPositionNew = characterXPosition - 40;
        int characterYPositionNew = characterYPosition;
        if (characterXPositionNew < 0) {
            characterYPositionNew = characterYPosition;
            characterXPositionNew = characterXPosition;
        }
        checkStatus(characterCurrentBlockPosition, "left");
        gc.clearRect(characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(rock, characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(characterToLeft, characterXPositionNew, characterYPositionNew, 40, 40);
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
        directionRight = false;
    }

    public void goUp() throws IOException {
        //get character current position(0-96)
        App m = new App();
        int characterCurrentBlockPosition = 0;
        for (int i = 0; i < element.length; i++) {
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition = i;
        }
        //detect door
        if(detectDoor(characterCurrentBlockPosition, "up")){
            if(numMonster==0 && zoneLvl<5){
                hero.setAP(HeroAP);//to reset the attackpower to initial attackpower
                zoneLvl++;
                timeStop();
                m.changeScene("GamingDungeon.fxml");
            }
            else if(numMonster>0){
                errorMsg.setText("There are still "+numMonster+" left in the dungeon");
                return;
            }
            else if(numMonster==0 && zoneLvl==5){
                message.setText("Victory");
                result.setVisible(true);
            }
        }
        //detect monster
        if (detectMonster(characterCurrentBlockPosition, "up") == true) {
            Instruction.setText("Please choose your next step!!!");
            Name_Monster.setText(GamingDungeonController.monster_Detect);
            HP_Monster.setText("HP: " + monster.getHp());
            AP_Monster.setText("Attack Power: " + monster.getAp());
            Speed_Monster.setText("Speed: " + monster.getSpeed());
            BattlePage.setVisible(true);
        }

        int row = ((characterCurrentBlockPosition) / 12) + 1;
        int column = ((characterCurrentBlockPosition) % 12) + 1;
        element[characterCurrentBlockPosition] = "rock";
        if (characterCurrentBlockPosition / 12 != 0) {
            element[characterCurrentBlockPosition - 12] = "Bob";
            numOfMovement++;
        } else
            element[characterCurrentBlockPosition] = "Bob";
        int characterYPosition = (row - 1) * 40;
        int characterXPosition = (column - 1) * 40;
        int characterXPositionNew = characterXPosition;
        int characterYPositionNew = characterYPosition - 40;
        if (characterYPositionNew < 0) {
            characterYPositionNew = characterYPosition;
            characterXPositionNew = characterXPosition;
        }

        checkStatus(characterCurrentBlockPosition, "up");
        gc.clearRect(characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(rock, characterXPosition, characterYPosition, 40, 40);
        if (directionRight == true)
            gc.drawImage(characterToRight, characterXPositionNew, characterYPositionNew, 40, 40);
        else
            gc.drawImage(characterToLeft, characterXPositionNew, characterYPositionNew, 40, 40);
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
    }

    public void goDown() throws IOException {
        //get character current position(0-96)
        App m = new App();
        int characterCurrentBlockPosition = 0;
        for (int i = 0; i < element.length; i++) {
            if (element[i].equals("Bob"))
                characterCurrentBlockPosition = i;
        }
        //detect door
        if(detectDoor(characterCurrentBlockPosition, "down")){
            if(numMonster==0 && zoneLvl<5){
                hero.setAP(HeroAP); //to reset the attackpower to initial attackpower
                zoneLvl++;
                timeStop();
                m.changeScene("GamingDungeon.fxml");
            }
            else if(numMonster>0){
                errorMsg.setText("There are still "+numMonster+" left in the dungeon");
                return;
            }
            else if(numMonster==0 && zoneLvl==5){
                message.setText("Victory");
                result.setVisible(true);
            }
        }
        //detect monster
        if (detectMonster(characterCurrentBlockPosition, "down") == true) {
            Instruction.setText("Please choose your next step!!!");
            Name_Monster.setText(GamingDungeonController.monster_Detect);
            HP_Monster.setText("HP: " + monster.getHp());
            AP_Monster.setText("Attack Power: " + monster.getAp());
            Speed_Monster.setText("Speed: " + monster.getSpeed());
            BattlePage.setVisible(true);

        }

        int row = ((characterCurrentBlockPosition) / 12) + 1;
        int column = ((characterCurrentBlockPosition) % 12) + 1;
        element[characterCurrentBlockPosition] = "rock";
        if (characterCurrentBlockPosition / 12 != 7) {
            element[characterCurrentBlockPosition + 12] = "Bob";
            numOfMovement++;
        } else
            element[characterCurrentBlockPosition] = "Bob";
        int characterYPosition = (row - 1) * 40;
        int characterXPosition = (column - 1) * 40;
        int characterXPositionNew = characterXPosition;
        int characterYPositionNew = characterYPosition + 40;


        if (characterYPositionNew >= 320) {
            characterYPositionNew = characterYPosition;
            characterXPositionNew = characterXPosition;
        }

        checkStatus(characterCurrentBlockPosition, "down");
        gc.clearRect(characterXPosition, characterYPosition, 40, 40);
        gc.drawImage(rock, characterXPosition, characterYPosition, 40, 40);
        if (directionRight == true)
            gc.drawImage(characterToRight, characterXPositionNew, characterYPositionNew, 40, 40);
        else
            gc.drawImage(characterToLeft, characterXPositionNew, characterYPositionNew, 40, 40);
        Image map = createImageFromCanvas(canvas);
        imgTest.setImage(map);
    }

    public boolean detectMonster(int characterCurrentBlockPosition, String direction) throws IOException {
        switch (direction) {
            case "right":
                if (characterCurrentBlockPosition % 12 != 11 && (element[characterCurrentBlockPosition + 1].equals("slime") ||
                        element[characterCurrentBlockPosition + 1].equals("goblin") ||
                        element[characterCurrentBlockPosition + 1].equals("spider"))) {
                    numMonster--;
                    monster_Detect = element[characterCurrentBlockPosition + 1].toUpperCase();
                    if(monster_Detect.equalsIgnoreCase("goblin")){
                        Monster_PIC.setImage(goblin);
                        berserkActivated = false;
                    }
                    else if(monster_Detect.equalsIgnoreCase("spider")){
                        Monster_PIC.setImage(spider);
                    }
                    else if(monster_Detect.equalsIgnoreCase("slime")){
                        Monster_PIC.setImage(slime);
                    }
                    monster = Monster_Slime.createSlime(difficultyLevel);
                    return true;
                }
                break;
            case "left":
                if (characterCurrentBlockPosition % 12 != 0 && (element[characterCurrentBlockPosition - 1].equals("slime") ||
                        element[characterCurrentBlockPosition - 1].equals("goblin") ||
                        element[characterCurrentBlockPosition - 1].equals("spider"))) {
                    numMonster--;
                    monster_Detect = element[characterCurrentBlockPosition - 1].toUpperCase();
                    if(monster_Detect.equalsIgnoreCase("goblin")){
                        Monster_PIC.setImage(goblin);
                        berserkActivated = false;
                    }
                    else if(monster_Detect.equalsIgnoreCase("spider")){
                        Monster_PIC.setImage(spider);
                    }
                    else if(monster_Detect.equalsIgnoreCase("slime")){
                        Monster_PIC.setImage(slime);
                    }
                    monster = Monster_Slime.createSlime(difficultyLevel);
                    return true;
                }
                break;
            case "up":
                if (characterCurrentBlockPosition / 12 != 0 && (element[characterCurrentBlockPosition - 12].equals("slime") ||
                        element[characterCurrentBlockPosition - 12].equals("goblin") ||
                        element[characterCurrentBlockPosition - 12].equals("spider"))) {
                    numMonster--;
                    monster_Detect = element[characterCurrentBlockPosition - 12].toUpperCase();
                    if(monster_Detect.equalsIgnoreCase("goblin")){
                        Monster_PIC.setImage(goblin);
                        berserkActivated = false;
                    }
                    else if(monster_Detect.equalsIgnoreCase("spider")){
                        Monster_PIC.setImage(spider);
                    }
                    else if(monster_Detect.equalsIgnoreCase("slime")){
                        Monster_PIC.setImage(slime);
                    }
                    monster = Monster_Slime.createSlime(difficultyLevel);
                    return true;
                }
                break;
            case "down":
                if (characterCurrentBlockPosition / 12 != 7 && (element[characterCurrentBlockPosition + 12].equals("slime") ||
                        element[characterCurrentBlockPosition + 12].equals("goblin") ||
                        element[characterCurrentBlockPosition + 12].equals("spider"))) {
                    numMonster--;
                    monster_Detect = element[characterCurrentBlockPosition + 12].toUpperCase();
                    if(monster_Detect.equalsIgnoreCase("goblin")){
                        Monster_PIC.setImage(goblin);
                        berserkActivated = false;
                    }
                    else if(monster_Detect.equalsIgnoreCase("spider")){
                        Monster_PIC.setImage(spider);
                    }
                    else if(monster_Detect.equalsIgnoreCase("slime")){
                        Monster_PIC.setImage(slime);
                    }
                    monster = Monster_Slime.createSlime(difficultyLevel);
                    return true;
                }

                break;
        }
        return false;
    }

    public boolean detectDoor(int characterCurrentBlockPosition, String direction) throws IOException {
        switch (direction) {
            case "right":
                if (characterCurrentBlockPosition % 12 != 11 && (element[characterCurrentBlockPosition + 1].equals("door"))) {
                    return true;
                }
                break;
            case "up":
                if (characterCurrentBlockPosition / 12 != 0 && (element[characterCurrentBlockPosition - 12].equals("door"))) {
                    return true;
                }
                break;
            case "down":
                if (characterCurrentBlockPosition / 12 != 7 && (element[characterCurrentBlockPosition + 12].equals("door"))) {
                    return true;
                }
                break;
        }
        return false;
    }


    ////////////////////////////////////////////////////////////////////////////////
    /////////battle  status ////////////////////////////////////////////////////////

    Monster_Slime monster;
    int HeroHP = Integer.parseInt(characterHealthShow);
    int HeroAP = Integer.parseInt(characterAttackShow);
    int HeroSpeed = Integer.parseInt(characterSpeedShow);
    public static int timeSpent;
    public static int numMonstersDefeated;
    public static int numOfMovement;
    public static int numOfAction;

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
    @FXML
    private AnchorPane DungeonPage;
    @FXML
    private AnchorPane itemUsed;
    @FXML
    private ImageView itemBarUsed;
    @FXML
    private Button buttonItemUsed1;
    @FXML
    private Button buttonItemUsed2;
    @FXML
    private Button buttonItemUsed3;
    @FXML
    private Button buttonItemUsed4;
    @FXML
    private Button buttonItemUsed5;
    @FXML
    private Button buttonItemUsed6;
    @FXML
    private Button buttonConfirmUsedItem;
    @FXML
    private Button closedButton;
    @FXML
    private ImageView BattlePageBackground;

    //pass the herostatus hero
    HeroStatus hero = new HeroStatus();

    //animation things
    TranslateTransition translate = new TranslateTransition();

    //hero attack button
    public void Attack_Hero(ActionEvent actionEvent) throws IOException {
        numOfAction++;
        counterShieldUsed--;
        if (HeroSpeed >= monster.getSpeed()) {
            //animation things
            translate.setNode(Hero_PIC);
            translate.setDuration(Duration.millis(1000));
            translate.setByX(100);
            translate.setByY(-100);
            translate.setAutoReverse(true);
            translate.play();

            // Reset position after the animation finishes
            translate.setOnFinished(event -> {
                Hero_PIC.setTranslateX(0); // Reset X position
                Hero_PIC.setTranslateY(0); // Reset Y position
            });

            monster.takeDamage(hero.getAP_Hero());
            Instruction.setText(GamingDungeonController.monster_Detect + " take " + hero.getAP_Hero() + " damage. ");

            if (monster.getHp() > 0 ) {
                if(counterShieldUsed<0){
                    hero.takeDamage(monster.getAp());
                    Instruction.setText(GamingDungeonController.monster_Detect + " take " + hero.getAP_Hero() + " damage. Hero takes " + monster.getAp() + " damage. ");
                }
                else{
                    if(monster_Detect.equalsIgnoreCase("Slime")){
                        counterShieldUsed = 0;
                        Instruction.setText("Your shield has been dissolved by the slime!!!");
                        hero.takeDamage(monster.getAp());PauseTransition pause1 = new PauseTransition(Duration.seconds(1));
                        PauseTransition pause3 = new PauseTransition(Duration.seconds(1.5));
                        pause3.setOnFinished(event -> {
                            Instruction.setText(GamingDungeonController.monster_Detect + " take " + hero.getAP_Hero() + " damage. Hero takes " + monster.getAp() + " damage. ");
                        });
                        pause3.play();
                    }
                    else{
                        Instruction.setText(GamingDungeonController.monster_Detect + " take " + hero.getAP_Hero() + " damage. Hero used shield to defend ");
                    }
                }
            }
        }else {
            //animation things
            translate.setNode(Hero_PIC);
            translate.setDuration(Duration.millis(1000));
            translate.setByX(100);
            translate.setByY(-100);
            translate.setAutoReverse(true);
            translate.play();

            // Reset position after the animation finishes
            translate.setOnFinished(event -> {
                Hero_PIC.setTranslateX(0); // Reset X position
                Hero_PIC.setTranslateY(0); // Reset Y position
            });
            if(counterShieldUsed<0) {
                hero.takeDamage(monster.getAp());
                Instruction.setText(characterName + " take " + monster.getAp() + " damage. ");
            }
            if (hero.getHP_Hero() > 0 ) {
                if(counterShieldUsed<0){
                    Instruction.setText(GamingDungeonController.monster_Detect + " take " + hero.getAP_Hero() + " damage. Hero takes " + monster.getAp() + " damage. ");
                }
                else{
                    if(monster_Detect.equalsIgnoreCase("Slime")){
                        counterShieldUsed = 0;
                        Instruction.setText("Your shield has been dissolved by the slime!!!");
                        hero.takeDamage(monster.getAp());PauseTransition pause1 = new PauseTransition(Duration.seconds(1));
                        PauseTransition pause3 = new PauseTransition(Duration.seconds(1.5));
                        pause3.setOnFinished(event -> {
                            Instruction.setText(GamingDungeonController.monster_Detect + " take " + hero.getAP_Hero() + " damage. Hero takes " + monster.getAp() + " damage. ");
                        });
                        pause3.play();
                    }
                    else{
                        Instruction.setText(GamingDungeonController.monster_Detect + " take " + hero.getAP_Hero() + " damage. Hero used shield to defend ");
                    }
                }
                monster.takeDamage(hero.getAP_Hero());
            }
        }

        if(monster_Detect.equalsIgnoreCase("goblin") && monster.getHp()>0 && monster.getHp()<=25){
            if(berserkActivated == false) {
                PauseTransition pause4 = new PauseTransition(Duration.seconds(1));
                pause4.setOnFinished(event -> {
                    Instruction.setText("Goblin has entered berserk mode!!! Goblin attack rise 10 points.");
                    monster.setAp(monster.getAp() + 10);
                    AP_Monster.setText("Attack Power: " + monster.getAp());
                });
                pause4.play();
            }
            berserkActivated = true;
        }
        if(monster.getHp()>0) {
            if (monster_Detect.equalsIgnoreCase("Spider")) {
                PauseTransition pause5 = new PauseTransition(Duration.seconds(1));
                pause5.setOnFinished(event -> {
                    Instruction.setText("You are poison by the Spider!!! HP -5 points");
                    hero.setHP(hero.getHP_Hero() - 5);
                    HP_Hero.setText("HP: " + hero.getHP_Hero() + " / " + characterHealthShow);
                });
                pause5.play();
            }
        }

        //display the status of hero
        HP_Hero.setText("HP: " + hero.getHP_Hero() + " / " + characterHealthShow);
        AP_Hero.setText("Attack Power: " + hero.getAP_Hero());
        Speed_Hero.setText("Speed: " + characterSpeedShow);
        hpBar.setText("HP: " + hero.getHP_Hero() + " / " + characterHealthShow);

        //display the status of monster
        HP_Monster.setText("HP: " + monster.getHp());
        AP_Monster.setText("Attack Power: " + monster.getAp());
        Speed_Monster.setText("Speed: " + monster.getSpeed());

        if (hero.getHP_Hero()  == 0) {
            timeStop();
            timeSpent = seconds;
            System.out.println("The total number of monster defeated is " + numMonstersDefeated);
            System.out.println("The total time spend is " + timeSpent);
            System.out.println("The total number of movement is " + numOfMovement);
            System.out.println("The total number of action is " + numOfAction);
            PauseTransition pause1 = new PauseTransition(Duration.seconds(1));
            PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
            pause1.setOnFinished(event -> {
                Instruction.setText("GAME OVER !!!");

            });
            pause2.setOnFinished(event -> {
                message.setText("Game Over");
                result.setVisible(true);
            });
            pause1.play();
            pause2.play();
        }

        if (monster.getHp() <= 0) {
            numMonstersDefeated ++;
            hero.setAP(HeroAP);
            characterAP.setText("Attack Power: " + hero.getAP_Hero());
            AP_Hero.setText("Attack Power: " + hero.getAP_Hero());
            PauseTransition pause1 = new PauseTransition(Duration.seconds(1));
            PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
            pause1.setOnFinished(event -> {
                Instruction.setText("You Defeat The Monster !");
            });
            pause2.setOnFinished(event -> {
                BattlePage.setVisible(false);
            });
            pause1.play();
            pause2.play();
        }
    }

    //hero inventory button
    public void openInventory(ActionEvent actionEvent) throws IOException{
        itemUsed.setVisible(true);
    }

    //hero run button
    public void Run(ActionEvent actionEvent) throws IOException {
        numOfAction++;
        counterShieldUsed = 0;
        hero.setAP(HeroAP);
        characterAP.setText("Attack Power: " + hero.getAP_Hero());
        AP_Hero.setText("Attack Power: " + hero.getAP_Hero());
        if (HeroSpeed > monster.getSpeed()) {
            Instruction.setText("Run successfully !!! Loading ...");
            // Delay the scene change by 1 second
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                BattlePage.setVisible(false);
            });
            pause.play();
        } else {
            Instruction.setText("You are unable to run!!!");
        }
    }

    ///////////////////////////////Timer to track time spend/////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private Label timerlabel;
    @FXML
    private AnchorPane MainPage;

    public static int seconds;
    private Timeline timeline;

    private void timeStart() {
        // Create a Timeline that runs every second
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> updateTimer())  // Updates the timer every second
        );
        timeline.setCycleCount(Timeline.INDEFINITE);  // Run the timeline indefinitely
        timeline.play();  // Start the timeline

    }
    private void updateTimer() {
        seconds++;  // Increment the seconds
        timerlabel.setText("Time: " + seconds);  // Update the display text
    }

    private void timeStop() {
        if (timeline != null) {  // Check if the timeline is initialized
            timeline.stop();  // Stop the timeline
        }
    }

    //display messages victory or game over
    @FXML
    private AnchorPane result;
    @FXML
    private Label message;
    @FXML
    private Button continueButton;

    public void actionContinue(ActionEvent actionEvent) throws IOException{
        App m = new App();
        zoneLvl = 1;
        timeStop();
        m.changeScene("ScoreBoard.fxml");
    }

    public void monsterAbility(String name){
        if(name.equals("slime")){
            counterShieldUsed = 0;
        }
        else if(name.equals("spider")){
            Instruction.setText("Unable to attack! You are trap by web!");

        }
        else if(name.equals("goblin")){

        }
    }
}

