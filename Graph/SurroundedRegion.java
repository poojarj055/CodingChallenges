// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: A region is surrounded if none of the 'O' cells in that region are on the edge of the board. Such regions are completely enclosed by 'X' cells.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

// Example 1:

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

// Explanation:


// In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

// Example 2:

// Input: board = [["X"]]

// Output: [["X"]]

 

// Constraints:

// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is 'X' or 'O'.


class Solution {
    public void solve(char[][] board) {
        int rows=board.length;
        int cols=board[0].length;
        for(int r=0;r<rows;r++){
            dfs(board, r, 0);
            dfs(board, r, cols-1);
        }
        for(int c=0;c<cols;c++){
            dfs(board,0,c);
            dfs(board,rows-1,c);
        }
        //flip
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }
    public void dfs(char board[][], int r, int c){
        int rows=board.length;
        int cols=board[0].length;
        //check out of bound
        if(r<0 || c<0 || r>rows-1 || c> cols-1 || board[r][c]!='O'){
            return;
        }
        board[r][c]='#';
        dfs(board, r+1, c);
        dfs(board, r-1,c);
        dfs(board, r, c+1);
        dfs(board, r, c-1);
    }
}
