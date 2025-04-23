// you are given an m x n grid rooms initialized with these three possible values.
// -1 A wall or an obstacle.
// 0 A gate.
// INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
// Example 1:

// Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
// Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
// Example 2:

// Input: rooms = [[-1]]
// Output: [[-1]]
 

// Constraints:

// m == rooms.length
// n == rooms[i].length
// 1 <= m, n <= 250
// rooms[i][j] is -1, 0, or 231 - 1.

class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;

        // Queue for BFS traversal
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all gate positions (value == 0) to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Step 2: Define directions (Down, Up, Right, Left)
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Step 3: Perform BFS from each gate
        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); // Remove the front of the queue
            int i = cell[0], j = cell[1]; // Get current cell's row and column

            // Step 4: Check all 4 directions
            for (int d = 0; d < direction.length; d++) {
                int ni = i + direction[d][0]; // Neighbor row
                int nj = j + direction[d][1]; // Neighbor column

                // Step 5: Check if neighbor is within bounds
                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                    // Step 6: If neighbor is an empty room (INF), update it
                    if (rooms[ni][nj] == 2147483647) {
                        rooms[ni][nj] = rooms[i][j] + 1; // Distance from gate
                        queue.offer(new int[]{ni, nj}); // Add neighbor to queue for further BFS
                    }
                }
            }
        }
    }
}


// We start BFS from all gates (0) simultaneously.
// Each empty room (INF = 2147483647) will get the minimum distance to the nearest gate.
// Walls (-1) are ignored and never traversed.


Time	O(m * n)
Space	O(m * n)
