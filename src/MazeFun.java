import java.util.Scanner;

public class MazeFun {

    static char[][] maze = {
            {'#', '#', '#', '#', '#', '#'},
            {'#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', ' ', 'E', '#'},
            {'#', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', '#', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', '#'}
    };

    static int playerX = 1, playerY = 1; // Start position at 'S'

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMaze();
            System.out.print("Move (W/A/S/D): ");
            char move = scanner.next().toUpperCase().charAt(0);

            if (movePlayer(move)) {
                System.out.println("You reached the exit! Game Over.");
                break;
            }
        }
        scanner.close();
    }

    static void displayMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print("P "); // Player's current position
                } else {
                    System.out.print(maze[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static boolean movePlayer(char direction) {
        int newX = playerX, newY = playerY;

        switch (direction) {
            case 'W': newX--; break; // Up
            case 'S': newX++; break; // Down
            case 'A': newY--; break; // Left
            case 'D': newY++; break; // Right
            default:
                System.out.println("Invalid move! Use W/A/S/D.");
                return false;
        }

        // Check if the move is valid
        if (maze[newX][newY] == '#') {
            System.out.println("You hit a wall! Try a different direction.");
            return false;
        }

        // Check if the player reaches the exit
        if (maze[newX][newY] == 'E') {
            playerX = newX;
            playerY = newY;
            return true;
        }

        // Update player position
        playerX = newX;
        playerY = newY;
        return false;
    }
}
