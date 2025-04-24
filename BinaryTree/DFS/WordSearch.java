// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example 1:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.


class Solution {
    public boolean exist(char[][] board, String word) {
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(dfs(board,i,j,word,0))
                    {
                        return true;
                    }
                }
            }
            return false;
    }
    public boolean dfs(char[][] board, int r, int c, String word, int wordIndex){
        int rows=board.length;
        int cols=board[0].length;
        if(wordIndex==word.length()){
            return true;
        }
        //out of bound condition
        if(r>=rows || r<0 || c>=cols || c<0 || board[r][c] != word.charAt(wordIndex)){
            return false;
        }
        //mark as visited
         char temp=board[r][c];
         board[r][c]='#';

        //go in all 4 direction
         boolean found =
        (dfs(board,r,c+1, word, wordIndex+1)||
        dfs(board,r+1,c, word, wordIndex+1)||
        dfs(board,r,c-1, word, wordIndex+1)||
        dfs(board,r-1,c, word, wordIndex+1));

        // Backtrack - restore original character
        board[r][c] = temp;
        return found;
    }
}


