// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
// You may assume all four edges of the grid are surrounded by water.

// The area of an island is the number of cells with a value 1 in the island.

// Return the maximum area of an island in grid. If there is no island, return 0.

// Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Output: 6
// Explanation: The answer is not 11, because the island must be connected 4-directionally.
  
// Input: grid = [[0,0,0,0,0,0,0,0]]
// Output: 0


class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                   int area=dfs(grid,i,j);
                   maxArea=Math.max(area,maxArea);
                }
            }
            
        }
        return maxArea;
    }
    public static int dfs(int[][] grid, int r, int c){
        int rows=grid.length;
        int cols=grid[0].length;
        //check out of bound and invalid cases
        if(r<0 || c<0 || r>=rows || c>=cols || grid[r][c]!=1){
            return 0;
        }

        //mark the visited 1s
        grid [r][c]=2;
        // go in all 4 direction n add the total area
        return 1+ dfs(grid,r+1,c)+
                  dfs(grid,r-1,c)+
                  dfs(grid,r,c+1)+
                  dfs(grid,r,c-1);
        
    }
    
}

//TC & SC: O(M*N)
//Explanation

start from each land cell (1)

DFS collects area (adds 1 for each cell)

Return the maximum area found from all such DFS calls


  
