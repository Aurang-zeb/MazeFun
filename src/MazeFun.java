import java.util.Scanner;
public class MazeFun {

    // Define the maze with 'S' as the start, 'E' as the end, '#' as walls, and '.' as empty space
    static char[][] maze = {
            {'S', '.', '.', '.', '#', '#', '#', '#'},
            {'.', '#', '#', '#', '.', '.', '.', '#'},
            {'.', '#', '.', '.', '.', '#', '.', '#'},
            {'.', '.', '.', '#', '.', '#', '.', '.'},
            {'#', '.', '.', '#', '.', '#', '.', 'E'}
    };

    // Starting position of the player
    static int playerRow = 0, playerCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main game loop
        while (true) {
            // Display the maze
            displayMaze();

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

            // Check if the player reached the exit
            if (maze[playerRow][playerCol] == 'E') {
                displayMaze();
                System.out.println("Congratulations! You reached the exit! you won the prize");
                break;
            }
        }

        scanner.close();
    }

    // Function to display the maze
    public static void displayMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print("P "); // P is the player
                } else {
                    System.out.print(maze[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // Function to move the player up
    public static void moveUp() {
        if (playerRow > 0 && maze[playerRow - 1][playerCol] != '#') {
            playerRow--;
        } else {
            System.out.println("Can't move up! There's a wall.");
        }
    }

    // Function to move the player down
    public static void moveDown() {
        if (playerRow < maze.length - 1 && maze[playerRow + 1][playerCol] != '#') {
            playerRow++;
        } else {
            System.out.println("Can't move down! There's a wall.");
        }
    }

    // Function to move the player left
    public static void moveLeft() {
        if (playerCol > 0 && maze[playerRow][playerCol - 1] != '#') {
            playerCol--;
        } else {
            System.out.println("Can't move left! There's a wall.");
        }
    }

    // Function to move the player right
    public static void moveRight() {
        if (playerCol < maze[0].length - 1 && maze[playerRow][playerCol + 1] != '#') {
            playerCol++;
        } else {
            System.out.println("Can't move right! There's a wall.");
        }
    }
}
