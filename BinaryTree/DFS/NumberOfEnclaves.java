// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
// A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
// Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
// Example 1:
// Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
// Output: 3
// Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
// Example 2:

class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //Check edges and mark it as 0
        for(int i=0;i<m;i++){
            dfs(grid,i,0);
            dfs(grid,i,n-1);
        }
        for(int j=0;j<n;j++){
            dfs(grid,0,j);
            dfs(grid,m-1,j);
        }
        int land=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                        land++;
                }
            }
        }
        return land;
    }
    private static void dfs(int[][] grid, int r, int c){
        int rows=grid.length;
        int cols=grid[0].length;
        //check out of bound
        if(r<0|| c<0|| r>=rows || c>=cols || grid[r][c]!=1){
            return;
        }

        grid[r][c]=0;
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}

------------------------------------------------------------------
Time Complexity	O(m × n)
Space Complexity	O(m × n) (recursive stack)
  ---------------------------------------------------------------
  
