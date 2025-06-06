There is a snake in an n x n matrix grid and can move in four possible directions. Each cell in the grid is identified by the position: grid[i][j] = (i * n) + j.
The snake starts at cell 0 and follows a sequence of commands.
You are given an integer n representing the size of the grid and an array of strings commands where each command[i] is either "UP", "RIGHT", "DOWN", and "LEFT". It's guaranteed that the snake will remain within the grid boundaries throughout its movement.
Return the position of the final cell where the snake ends up after executing commands.

Example 1:
Input: n = 2, commands = ["RIGHT","DOWN"]
Output: 3
Explanation:
0	1
2	3

0	1
2	3

0	1
2	3
Example 2:
Input: n = 3, commands = ["DOWN","RIGHT","UP"]
Output: 1

public class SnakePosition {
    public static int getFinalPosition(int n, String[] commands) {
        // Starting position (top-left corner)
        int r = 0, c = 0;

        // Process each command
        for (String command : commands) {
            switch (command) {
                case "UP":
                    r--;
                    break;
                case "RIGHT":
                    c++;
                    break;
                case "DOWN":
                    r++;
                    break;
                case "LEFT":
                    c--;
                    break;
            }
        }

        // Return the final position in the matrix
        return (r * n) + c;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] commands = {"RIGHT", "DOWN"};
        System.out.println(getFinalPosition(n, commands));  // Output: 3
    }
}
