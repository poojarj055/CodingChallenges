// You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
// Return the size of the largest island in grid after applying this operation.
// An island is a 4-directionally connected group of 1s.
// Example 1:

// Input: grid = [[1,0],[0,1]]
// Output: 3
// Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
// Example 2:

// Input: grid = [[1,1],[1,0]]
// Output: 4
// Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
// Example 3:

// Input: grid = [[1,1],[1,1]]
// Output: 4
// Explanation: Can't change any 0 to 1, only one island with area = 4.

class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        Map<Integer, Integer> map=new HashMap<>();
        int id=2;
        int maxArea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area=dfs(grid,i,j,id);
                    map.put(id, area);
                    maxArea=Math.max(area,maxArea);
                    id++;
                }
            }
        }

        //replace 0 with 1 and check maxArea

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Set<Integer> seen=new HashSet<>();
                int area=1;
                if(grid[i][j]==0){
            // Up
            if (i > 0 && grid[i-1][j] > 1 && seen.add(grid[i-1][j])) {
                area += map.get(grid[i-1][j]);
            }
            // Down
            if (i < n - 1 && grid[i+1][j] > 1 && seen.add(grid[i+1][j])) {
                area += map.get(grid[i+1][j]);
            }
            // Left
            if (j > 0 && grid[i][j-1] > 1 && seen.add(grid[i][j-1])) {
                area += map.get(grid[i][j-1]);
            }
            // Right
            if (j < n - 1 && grid[i][j+1] > 1 && seen.add(grid[i][j+1])) {
                area += map.get(grid[i][j+1]);
            }

            maxArea = Math.max(maxArea, area);
                }
            }
    }
     return maxArea;
    }
    public static int dfs(int[][] grid, int r, int c, int id){
        int rows=grid.length;
        //out of bound case
        if(r<0 || r>=rows || c<0 || c>=rows || grid[r][c]!=1){
            return 0;
        }
        //mark the visited cell
        grid[r][c]=id;
        
        //go in all 4 direction and calculate the area
        return 1+ dfs(grid, r+1, c, id)+
                  dfs(grid, r-1, c, id)+
                  dfs(grid, r, c+1, id)+
                  dfs(grid, r, c-1, id);
    }
}


Time: O(n²)

Space: O(n²)

// You're:
// Marking all islands with unique IDs and calculating their sizes.
// Trying each 0 as a flip and checking what island sizes it can combine.
// Returning the max possible island size.


