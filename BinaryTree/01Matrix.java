// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
// The distance between two cells sharing a common edge is 1.
// Example 1:
// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]
// Example 2:
// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;         // Get the number of rows in the matrix
        int cols = mat[0].length;      // Get the number of columns in the matrix

        Queue<int[]> queue = new LinkedList<>();  // Queue to perform BFS

        // Step 1: Add all 0s positions to the queue and mark 1s as infinity (unvisited)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});  // Enqueue position of 0
                } else {
                    mat[i][j] = Integer.MAX_VALUE; // Mark 1s as unvisited (infinity)
                }
            }
        }

        // Step 2: Define directions for up, down, left, right
        int[][] directions = {
            {1, 0},   // Down
            {-1, 0},  // Up
            {0, 1},   // Right
            {0, -1}   // Left
        };

        // Step 3: Perform BFS from all 0s simultaneously
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();    // Dequeue the current cell
            int i = cell[0], j = cell[1]; // Get the cell's row and column

            // Step 4: Visit all 4 adjacent cells
            for (int d = 0; d < directions.length; d++) {
                int ni = i + directions[d][0]; // New row index
                int nj = j + directions[d][1]; // New column index

                // Step 5: Check bounds and update distance if shorter path found
                if (ni >= 0 && nj >= 0 && ni < rows && nj < cols) {
                    // If current path offers a shorter distance
                    if (mat[ni][nj] > mat[i][j] + 1) {
                        mat[ni][nj] = mat[i][j] + 1; // Update to shorter distance
                        queue.offer(new int[]{ni, nj}); // Enqueue for next level
                    }
                }
            }
        }

        // Step 6: Return the final updated matrix
        return mat;
    }
}


### Summary:
This algorithm uses **Breadth-First Search (BFS)** starting from all the `0`s in the matrix to update each `1` with the distance to the nearest `0`. 
  It works because BFS guarantees that we reach the nearest `0` first.
Let me know if you want a visual diagram or a dry-run with an example!


Time Complexity: O(m * n)
Space Complexity: O(m * n)



