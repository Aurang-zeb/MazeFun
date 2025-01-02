import java.util.Scanner;

public class MazeFun {

    private static final char[][] maze = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', 'P', ' ', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', '#', '#', '#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', 'E', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };

    // Player's starting position
    private static int playerX = 1;
    private static int playerY = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("Welcome to the Maze Game!");
        System.out.println("Navigate to 'E' to exit the maze. Use W/A/S/D to move.");

        while (gameRunning) {
            printMaze();
            System.out.print("Enter your move (W/A/S/D): ");
            char move = scanner.nextLine().toUpperCase().charAt(0);

            switch (move) {
                case 'W': movePlayer(-1, 0); break; // Up
                case 'A': movePlayer(0, -1); break; // Left
                case 'S': movePlayer(1, 0); break; // Down
                case 'D': movePlayer(0, 1); break; // Right
                default: System.out.println("Invalid move. Use W/A/S/D.");
            }

            if (maze[playerX][playerY] == 'E') {
                System.out.println("Congratulations! You reached the exit!");
                gameRunning = false;
            }
        }

        scanner.close();
    }

    private static void printMaze() {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static void movePlayer(int dx, int dy) {
        int newX = playerX + dx;
        int newY = playerY + dy;

        if (maze[newX][newY] == '#' || newX < 0 || newY < 0 || newX >= maze.length || newY >= maze[0].length) {
            System.out.println("You hit a wall! Try another direction.");
        } else {
            maze[playerX][playerY] = ' ';
            playerX = newX;
            playerY = newY;
            maze[playerX][playerY] = 'P';
        }
    }
}
