// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.
// Example 1:


// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// Example 2:

// Input: grid = [[1,2,3],[4,5,6]]
// Output: 12
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 200
 
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][]cache=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(cache[i],-1);
        }
        return minPathSumRecur(grid,0,0,cache);
    }
    int minPathSumRecur(int[][]grid, int row, int col, int[][]cache){
        int m=grid.length;
        int n=grid[0].length;
        if(row==m-1 && col==n-1){
            return grid[row][col];
        }
        if (row >= m || col >= n) { 
            return Integer.MAX_VALUE; 
        }
        if(cache[row][col]!=-1){
            return cache[row][col];
        }

        int rightSum=minPathSumRecur(grid,row,col+1,cache);
        int bottomSum=minPathSumRecur(grid,row+1,col,cache);
        cache[row][col]= grid[row][col]+ Math.min(rightSum,bottomSum); 
        return cache[row][col];
    }
}

