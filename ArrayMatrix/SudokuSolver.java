// Write a program to solve a Sudoku puzzle by filling the empty cells.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.
// Example 1:
// Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],
//   [".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],
//   ["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],
//   [".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],
//   [".",".",".",".","8",".",".","7","9"]]
// Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],
// ["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],
//   ["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],
//   ["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],
//   ["3","4","5","2","8","6","1","7","9"]]
// Explanation: The input board is shown above and the only valid solution is shown below:
// Constraints:

// board.length == 9
// board[i].length == 9
// board[i][j] is a digit or '.'.
// It is guaranteed that the input board has only one solution.

Backtracking Approach:
We iterate through each cell of the board.
If it's empty ('.'), we try placing digits '1' to '9'.
For each digit, we check if it is valid using the isValid() method.
If valid, we place it and recursively attempt to solve.
If we reach a dead-end, we backtrack and try the next number.


class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            
                            if (solve(board)) return true;
                            
                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // if no number fits
                }
            }
        }
        return true; // all cells are filled
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check row and column
            if (board[row][i] == num || board[i][col] == num) return false;

            // Check 3x3 subgrid
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }
}

