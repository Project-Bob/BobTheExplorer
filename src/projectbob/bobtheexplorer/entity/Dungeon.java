package projectbob.bobtheexplorer.entity;

public class Dungeon extends Hero{

    public Dungeon(){}

    final int Dungeon_size = 10;
    int heroX = 4; 
    int heroY = 3;
    char[][] dungeon = {
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


    //display the map 
    public void displayDungeon() {
        System.out.println("===================");
        for (char[] row : dungeon) {
            for (char tile : row) {
                System.out.print(tile + " ");
            }
            System.out.println();
        }
        System.out.println("===================");
    }

    //controller for hero to move
    public void HeroMove(int dx, int dy) {
        int newX = heroX + dx;
        int newY = heroY + dy;

        //change the position of hero and if encounter the wall,display can't move message
        if (newX >= 0 && newX < Dungeon_size && newY >= 0 && newY < Dungeon_size && dungeon[newX][newY] != '#') {
            dungeon[heroX][heroY] = '.'; // Clear old position
            heroX = newX;
            heroY = newY;
            dungeon[heroX][heroY] = 'H'; // Set new position
        } 
        else {
            System.out.println("You can't move there!");
        }
    }


    /* 
    boolean Playing = false;

    System.out.println("Welcome to Adventure Quest! Enter play to start the game! ");
    scanner.nextLine();
    String start = scanner.nextLine();
    if(start.toUpperCase().equals("START")){
        Playing = true;
    }

    while (Playing) {
        displayDungeon();
        System.out.println("Use W, A, S, D to move.")
        System.out.println("Enter your move (W=up, A=left, S=down, D=right, Q=quit):");
        char move = scanner.next().toUpperCase().charAt(0);

        switch (move) {
            case 'W' -> HeroMove(-1, 0); 
            case 'S' -> HeroMove(1, 0); 
            case 'A' -> HeroMove(0, -1); 
            case 'D' -> HeroMove(0, 1);  
            case 'Q' -> Playing = false;
            default -> System.out.println("Invalid input!");
        }


        char CurrentPosition = dungeon[heroX][heroY];
        if (CurrentPosition == 'M') {
            System.out.print("You encounter a monster!")
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
    */






}



