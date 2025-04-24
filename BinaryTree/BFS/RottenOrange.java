// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
// Example 1:
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0; // Count of fresh oranges

        Queue<int[]> queue = new LinkedList<>(); // Queue for BFS (stores rotten oranges' positions)

        // Step 1: Traverse the grid to find all rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    // Add rotten orange's position to the queue
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    // Count fresh oranges
                    freshCount++;
                }
            }
        }

        // Directions for exploring adjacent cells (up, down, left, right)
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        int minutes = 0; // Time counter

        // Step 2: Start BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of rotten oranges to process this minute
            boolean anyrotten = false; // To check if any orange got rotten this minute

            // Process all rotten oranges in the current layer
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll(); // Get current rotten orange position
                int r = current[0];
                int c = current[1];

                // Step 3: Check 4-directionally for fresh neighbors
                for (int d = 0; d < directions.length; d++) {
                    int ni = r + directions[d][0]; // New row index
                    int nj = c + directions[d][1]; // New column index

                    // Step 4: If the neighbor is within bounds and is a fresh orange
                    if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2; // Make the orange rotten
                        queue.offer(new int[] {ni, nj}); // Add to queue for next round
                        freshCount--; // Decrease fresh orange count
                        anyrotten = true; // At least one orange got rotten
                    }
                }
            }

            // Step 5: If any orange rotted this minute, increment the time
            if (anyrotten) minutes++;
        }

        // Step 6: If no fresh orange remains, return minutes, else return -1
        return freshCount == 0 ? minutes : -1;
    }
}

// Time Complexity: O(n * m)

// Space Complexity: O(n * m)


