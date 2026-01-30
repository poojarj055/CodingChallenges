// You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
//The robot can only move either down or right at any point in time.
// An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
// Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
// The testcases are generated so that the answer will be less than or equal to 2 * 109.

// Example 1:


// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2
// Explanation: There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right
// Example 2:


// Input: obstacleGrid = [[0,1],[0,0]]
// Output: 1
 

// Constraints:

// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] is 0 or 1.

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length-1;
        int n=obstacleGrid[m].length-1;
        if(obstacleGrid[m][n]==1) return 0;
        int row=0;
        int col=0;
        int [][]cache=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            Arrays.fill(cache[i],-1);
        }
        return uniquePathsWithObstacles(obstacleGrid,row, col,cache);
    }
    int uniquePathsWithObstacles(int[][] obstacleGrid,int row, int col, int [][]cache){
        int m=obstacleGrid.length-1;
        int n=obstacleGrid[m].length-1; 
        if(row==m && col==n){
            return 1;
        }

         if(row>m || col>n || obstacleGrid[row][col]==1){
            return 0;
        }
        
        if(cache[row][col]!=-1){
            return cache[row][col];
        }

        int right=uniquePathsWithObstacles(obstacleGrid, row, col+1,cache);
        int bottom=uniquePathsWithObstacles(obstacleGrid,row+1, col,cache);
        cache[row][col]= right+bottom;
        return cache[row][col];
    }
}
