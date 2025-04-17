// Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
// Players take turns placing characters into empty squares ' '.
// The first player A always places 'X' characters, while the second player B always places 'O' characters.
// 'X' and 'O' characters are always placed into empty squares, never on filled ones.
// The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
// The game also ends if all squares are non-empty.
// No more moves can be played if the game is over.
// Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
// You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
// Example 1:
// Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
// Output: "A"
// Explanation: A wins, they always play first.
// Example 2:


// Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
// Output: "B"
// Explanation: B wins.
// Example 3:


// Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
// Output: "Draw"
// Explanation: The game ends in a draw since there are no moves to make.
 

// Constraints:

// 1 <= moves.length <= 9
// moves[i].length == 2
// 0 <= rowi, coli <= 2
// There are no repeated elements on moves.
// moves follow the rules of tic tac toe.



```
public class Solution {
    public static String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0, antiDiag = 0;

        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0]; // gets the row number of the move
            int c = moves[i][1]; // gets the column number of the move
            int player = (i % 2 == 0) ? 1 : -1;

            rows[r] += player;
            cols[c] += player;
            if (r == c) diag += player;
            if (r + c == 2) antiDiag += player;

            if (Math.abs(rows[r]) == 3 || Math.abs(cols[c]) == 3 ||
                Math.abs(diag) == 3 || Math.abs(antiDiag) == 3) {
                return player == 1 ? "A" : "B";
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    public static void main(String[] args) {
        int[][] moves = {
            {0, 0}, {1, 1},
            {0, 1}, {1, 0},
            {0, 2}
        };
        System.out.println("Result: " + tictactoe(moves));  // Output: A
    }
}
```
Perfect! Let's walk through a **diagrammatic explanation** with a sample game and code run. We'll use:

```java
int[][] moves = {
    {0, 0}, // A
    {1, 1}, // B
    {0, 1}, // A
    {1, 0}, // B
    {0, 2}  // A - wins!
};
```

---

## 🎮 Board Layout

Each move updates this board (rows and columns range from 0 to 2):

```
  C0  C1  C2
R0 A   A   A   ← A wins this row!
R1 B   B
R2
```

---

## 🧠 Step-by-step Logic with the Correct Code:

We track 4 things:
- `rows[3]`
- `cols[3]`
- `diag`
- `antiDiag`

### 🔁 Loop over each move:

| Move # | Player | Move      | Update          | rows[]         | cols[]         | diag | antiDiag | Winner? |
|--------|--------|-----------|------------------|----------------|----------------|-------|-----------|---------|
| 0      | A (+1) | [0,0]     | rows[0] += 1     | [1, 0, 0]      | [1, 0, 0]      | 1     | 0         | No      |
| 1      | B (-1) | [1,1]     | rows[1] -= 1     | [1, -1, 0]     | [1, -1, 0]     | 0     | 0         | No      |
| 2      | A (+1) | [0,1]     | rows[0] += 1     | [2, -1, 0]     | [1, 0, 0]      | 0     | 0         | No      |
| 3      | B (-1) | [1,0]     | rows[1] -= 1     | [2, -2, 0]     | [0, 0, 0]      | 0     | 0         | No      |
| 4      | A (+1) | [0,2]     | rows[0] += 1     | [3, -2, 0]     | [0, 0, 1]      | 0     | 1         | ✅ A     |

---

## ✅ Result: Player **A wins**!

---
---
