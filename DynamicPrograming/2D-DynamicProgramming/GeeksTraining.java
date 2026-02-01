// Geek is going for a training program for n days. He can perform any of these activities: Running, Fighting, 
// and Learning Practice. Each activity has some point on each day. As Geek wants to improve all his skills, he can't do the same activity on two consecutive days. Given a 2D matrix mat[][], where mat[i][0], mat[i][1], and mat[i][2] represent the merit points for Running, Fighting, and Learning on the i-th day, determine the maximum total merit points Geek can achieve .

// Example:

// Input: mat[][]= [[1, 2, 5],
//                [3, 1, 1], 
//                [3, 3, 3]]
// Output: 11
// Explanation: Geek will learn a new move and earn 5 point then on second day he will do running and earn 3 point and on third day he will do fighting and earn 3 points so, maximum merit point will be 11.
// Input: mat[][]= [[1, 1, 1],
//                [2, 2, 2],
//                [3, 3, 3]]
// Output: 6
// Explanation: Geek can perform any activity each day while adhering to the constraints, in order to maximize his total merit points as 6.
// Input: mat[][]= [[4, 2, 6]]
// Output: 6
// Explanation: Geek will learn a new move to make his merit points as 6.
// Constraint:
// 1 ≤ n ≤ 105   
// 1 ≤  arr[i][j] ≤ 100

class Solution {
    public int maximumPoints(int mat[][]) {
        int m = mat.length;
        // Use [m][4] to store results for each day and each of the 3 activities (+1 for "no activity")
        int[][] cache = new int[m][4];
        for (int[] row : cache) Arrays.fill(row, -1);
        
        return maximumPointsRecur(mat, 0, 3, cache); // 3 represents no activity yet
    }

    int maximumPointsRecur(int mat[][], int row, int lastActivity, int[][] cache) {
        if (row == mat.length) return 0;

        // Check if this specific (day, lastActivity) combo is already computed
        if (cache[row][lastActivity] != -1) return cache[row][lastActivity];

        int max = 0;
        for (int currActivity = 0; currActivity < 3; currActivity++) {
            if (currActivity != lastActivity) {
                int points = mat[row][currActivity] + maximumPointsRecur(mat, row + 1, currActivity, cache);
                max = Math.max(max, points);
            }
        }
        
        return cache[row][lastActivity] = max; // Memoize and return
    }
}
