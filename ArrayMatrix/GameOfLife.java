// According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

// The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

// Any live cell with fewer than two live neighbors dies as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population.
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
// The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

// Given the current state of the board, update the board to reflect its next state.
// Note that you do not need to return anything.
// Example 1:
// Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
// Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
// Example 2:


// Input: board = [[1,1],[1,0]]
// Output: [[1,1],[1,1]]


class Solution {
    public void gameOfLife(int[][] board) {
    
        int m=board.length;
        int n=board[0].length;
        
        int [][]directions={{0,1},{0,-1},{1,-1},{1,1},{-1,1},{1,0},{-1,0},{-1,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 int liveNeighbours=0;
                 
                 for(int d=0;d<directions.length;d++){
                    int nr=i+directions[d][0];
                    int nc=j+directions[d][1];
                 

                 if(nr<m && nc<n && nr>=0 && nc>=0){
                    if(board[nr][nc]==1 || board[nr][nc]==2){
                        liveNeighbours++;
                        }
                    }
                 }
            
               //<2 live neighbours -1 -dies --0
               //>2 live neighbours -1 -lives --1
                 if(board[i][j] == 1 && (liveNeighbours < 2 || liveNeighbours > 3)){
                    board[i][j]=2; //-- dies
                 }
                
               //=3 live neighbours = if died 0, becomes alive 1
                if(board[i][j]==0  && liveNeighbours==3){
                    board[i][j]=3; //-- alive 1
                }
        }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                 if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }

    }
}
