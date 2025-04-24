// Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

// All the visited cells of the path are 0.
// All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
// The length of a clear path is the number of visited cells of this path.

// Example 1:


// Input: grid = [[0,1],[1,0]]
// Output: 2
// Example 2:


// Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
// Output: 4
// Example 3:

// Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
// Output: -1


class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // 🚫 If the starting or ending cell is blocked (not 0), there's no valid path
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        // ✅ Initialize BFS queue with starting cell (0,0)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        // 🧭 Mark the starting point with path length = 1
        grid[0][0] = 1;

        // 🔀 All 8 possible directions (including diagonals)
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, -1}, {0, 1},     // down, up, left, right
            {1, -1}, {-1, 1}, {1, 1}, {-1, -1}     // diagonals: down-left, up-right, down-right, up-left
        };

        // 🔁 Standard BFS loop
        while (!queue.isEmpty()) {
            int[] current = queue.poll();       // Get current cell
            int r = current[0];                 // Current row
            int c = current[1];                 // Current column
            int dist = grid[r][c];              // Current distance from start

            // 🎯 If we’ve reached the bottom-right cell, return the path length
            if (r == n - 1 && c == n - 1) return dist;

            // 🔁 Explore all 8 directions
            for (int d = 0; d < directions.length; d++) {
                int ni = r + directions[d][0];  // New row
                int nj = c + directions[d][1];  // New column

                // ✅ If new cell is within bounds and is a 0 (unvisited)
                if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 0) {
                    queue.offer(new int[]{ni, nj});     // Add new cell to the queue
                    grid[ni][nj] = dist + 1;            // Mark it visited and update path length
                }
            }
        }

        // ❌ If destination is never reached, return -1
        return -1;
    }
}
