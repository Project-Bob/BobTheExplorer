package projectbob.bobtheexplorer.entity;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Dungeon extends Hero{

    final int Dungeon_size = 10;
    int heroX = 4; 
    int heroY = 3;
    ArrayList<char[][]> room = new ArrayList<char[][]>();

    public Dungeon(){

        char[][] room1 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', 'M', '.', '.', '.', '.', 'M', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'H', '.', '.', '.', '.', 'B', 'E'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', 'I', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'M', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

        char[][] room2 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', 'M', '.', '.', '.', '.', '#'},
            {'#', 'M', '.', '.', '.', '.', '.', 'M', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'H', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', 'B', 'E'},
            {'#', '.', 'I', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'M', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

        char[][] room3 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', 'M', '.', '.', '.', '.', 'M', '.', 'M', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'H', 'M', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', 'B', 'E'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', 'I', '.', '.', 'M', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

        char[][] room4 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'H', '.', '.', '.', 'M', 'M', '#'},
            {'#', '.', '.', '.', '.', '.', '.', 'M', 'B', 'E'},
            {'#', '.', '.', '.', '.', '.', '.', 'M', 'M', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

        char[][] room5 = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'M', '.', '.', 'I', '.', '.', '#'},
            {'#', '.', 'M', 'H', 'M', '.', '.', '.', '.', '#'},
            {'#', '.', '.', 'M', '.', '.', '.', '.', 'B', 'E'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        };

            room.add(room1);
            room.add(room2);
            room.add(room3);
            room.add(room4);
            room.add(room5);

        }   

    //display the map 
    public void displayDungeon(char[][]room) {
        System.out.println("===================");
        for (char[] row : room) {
            for (char tile : row) {
                System.out.print(tile + " ");
            }
            System.out.println();
        }
        System.out.println("===================");
    }

    //controller for hero to move
    public void HeroMove(int dx, int dy, char currentRoom[][]) {
        int newX = heroX + dx;
        int newY = heroY + dy;

        //change the position of hero and if encounter the wall,display can't move message
        if (newX >= 0 && newX < Dungeon_size && newY >= 0 && newY < Dungeon_size && currentRoom[newX][newY] != '#') {
            currentRoom[heroX][heroY] = '.'; // Clear old position
            heroX = newX;
            heroY = newY;
            currentRoom[heroX][heroY] = 'H'; // Set new position
        } 
        else {
            System.out.println("You can't move there!");
        }
    }


    public void Map(){

        Scanner map = new Scanner (System.in);
        Random random = new Random();
        int RoomNumber = random.nextInt(5);

        boolean Playing = false;

        System.out.println("Welcome to Adventure Quest! Enter play to start the game! ");
        String start = map.nextLine();
        if(start.toUpperCase().equals("START")){
            Playing = true;
        }

        while (Playing) {
            char currentRoom[][] = room.get(RoomNumber);
            displayDungeon(currentRoom);
            System.out.println("Use W, A, S, D to move.");
            System.out.println("Enter your move (W=up, A=left, S=down, D=right, Q=quit):");
            char move = map.next().toUpperCase().charAt(0);

            switch (move) {
                case 'W' -> HeroMove(-1, 0, currentRoom); 
                case 'S' -> HeroMove(1, 0, currentRoom); 
                case 'A' -> HeroMove(0, -1, currentRoom); 
                case 'D' -> HeroMove(0, 1, currentRoom);  
                case 'Q' -> Playing = false;
                default -> System.out.println("Invalid input!");
            }


            char CurrentPosition = currentroom[heroX][heroY];
            if (CurrentPosition == 'M') {
                System.out.print("You encounter a monster!");
                displayBattleStatus();
            } else if (CurrentPosition == 'I') {
                System.out.println("You found an item!");
                //Item random logic is required
                dungeon[heroX][heroY] = '.';
            } else if (CurrentPosition == 'B') {
                System.out.println("You encountered the boss!");
                displayBattleStatus();
            } else if (CurrentPosition == 'E') {
                System.out.println("You have entered the next room");  
            }
        }
    }
    */






}



