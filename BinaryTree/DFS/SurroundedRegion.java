// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
// Example 1:
// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
// In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
// Example 2:
// Input: board = [["X"]]
// Output: [["X"]]

class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Start DFS from border 'O's
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
        }

      //This identifies all 'O's on the outer borders of the matrix and runs DFS from them.
      //🧠 Why? Any 'O' connected to the edge cannot be surrounded and must be kept as 'O'.



        // Step 2: Flip remaining 'O' to 'X', and 'S' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'S') board[i][j] = 'O';
            }
        }
      //All 'O's not connected to the edge are still 'O' → convert them to 'X'
      //All safe 'O's were marked as 'S' → change them back to 'O'
    }

    // Mark safe regions starting from border 'O's
    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') return;

        board[r][c] = 'S'; // mark as safe

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}


// Time Complexity: O(m * n) → Every cell is visited at most once.
// Space Complexity: O(1) extra (if you ignore recursion stack)

  

