import java.util.Random;
import java.util.Scanner;

public class MazeFun {

    // Define the maze with 'S' as the start, 'E' as the end, '#' as walls, '.' as empty space,
    // 'P' as the player,
    // 'X' as the enemy
    static char[][] gameboard = {
            {'S', '.', '.', '.', '#', '#', '#', '#'},
            {'.', '#', '#', '#', '.', '.', '.', '#'},
            {'.', '#', '.', '.', '.', '#', '.', '#'},
            {'.', '.', '.', '#', '.', '#', '.', '.'},
            {'#', '.', '.', '#', '.', '#', '.', 'E'}
    };

    // Starting position of the player
    static int heroRow = 0, heroCol = 0;

    // Enemy position
    static int enemyRow = 2, enemyCol = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Main game loop
        while (true) {
            // Display the maze
            displaygameboard();

            // Get the player's next move
            System.out.println("Enter your move (up, down, left, right): ");
            String move = scanner.nextLine().toLowerCase();

            // Update player position based on the move
            if (move.equals("up")) {
                moveUp();
            } else if (move.equals("down")) {
                moveDown();
            } else if (move.equals("left")) {
                moveLeft();
            } else if (move.equals("right")) {
                moveRight();
            }

            moveEnemy(random);

            // Check if the player reached the exit
            if (gameboard[heroRow][heroCol] == 'E') {
                displaygameboard();
                System.out.println("Congratulations! You reached the exit! You won the prize.");
                break;
            }

            // Check if the player collides with the enemy
            if (heroRow == enemyRow && heroCol == enemyCol) {
                displaygameboard();
                System.out.println("Oh no! You were caught by the enemy. Game over.");
                break;
            }
        }

        scanner.close();
    }

    // Function to display the maze
    public static void displaygameboard() {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if (i == heroRow && j == heroCol) {
                    System.out.print("P "); // P is the player
                } else if (i == enemyRow && j == enemyCol) {
                    System.out.print("X "); // X is the enemy
                } else {
                    System.out.print(gameboard[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // Function to move the player up
    public static void moveUp() {
        if (heroRow > 0 && gameboard[heroRow - 1][heroCol] != '#') {
            heroRow--;
        } else {
            System.out.println("Can't move up! There's a wall.");
        }
    }

    // Function to move the player down
    public static void moveDown() {
        if (heroRow < gameboard.length - 1 && gameboard[heroRow + 1][heroCol] != '#') {
            heroRow++;
        } else {
            System.out.println("Can't move down! There's a wall.");
        }
    }

    // Function to move the player left
    public static void moveLeft() {
        if (heroCol > 0 && gameboard[heroRow][heroCol - 1] != '#') {
            heroCol--;
        } else {
            System.out.println("Can't move left! There's a wall.");
        }
    }

    // Function to move the player right
    public static void moveRight() {
        if (heroCol < gameboard[0].length - 1 && gameboard[heroRow][heroCol + 1] != '#') {
            heroCol++;
        } else {
            System.out.println("Can't move right! There's a wall.");
        }
    }

    // Function to move the enemy randomly
    public static void moveEnemy(Random random) {
        int direction = random.nextInt(4);

        switch (direction) {
            case 0: // Move up
                if (enemyRow > 0 && gameboard[enemyRow - 1][enemyCol] != '#') {
                    enemyRow--;
                }
                break;
            case 1: // Move down
                if (enemyRow < gameboard.length - 1 && gameboard[enemyRow + 1][enemyCol] != '#') {
                    enemyRow++;
                }
                break;
            case 2: // Move left
                if (enemyCol > 0 && gameboard[enemyRow][enemyCol - 1] != '#') {
                    enemyCol--;
                }
                break;
            case 3: // Move right
                if (enemyCol < gameboard[0].length - 1 && gameboard[enemyRow][enemyCol + 1] != '#') {
                    enemyCol++;
                }
                break;
        }
    }
}
