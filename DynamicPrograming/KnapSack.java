0 - 1 Knapsack Problem
Difficulty: MediumAccuracy: 31.76%Submissions: 527K+Points: 4
Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 

Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.

Examples :

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] 
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.
Constraints:
2 ≤ val.size() = wt.size() ≤ 103
1 ≤ W ≤ 103
1 ≤ val[i] ≤ 103
1 ≤ wt[i] ≤ 103


class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        // dp[i][w] stores the maximum value using the first 'i' items
        // with a knapsack capacity of 'w'.
        int dp[][] = new int[n + 1][W + 1];

        // Fill the dp table in a bottom-up manner.
        // i represents the number of items considered.
        for (int i = 0; i <= n; i++) {
            // w represents the current knapsack capacity.
            for (int w = 0; w <= W; w++) {
                // Base Case: No items or no capacity means zero value.
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    // If the current item's weight is less than or equal to the capacity:
                    // We have two choices:
                    // 1. Include the current item:
                    //    val[i-1] + dp[i-1][w-wt[i-1]] -> Add the value of the current item
                    //    plus the max value for the remaining capacity (w - wt[i-1]) from the previous items (i-1).
                    // 2. Exclude the current item:
                    //    dp[i-1][w] -> Use the max value obtained without the current item.
                    // We take the maximum of these two choices.
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    // If the current item's weight is greater than the current capacity,
                    // we cannot include it. The maximum value is the same as the previous item's result.
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        // The final answer is the maximum value using all 'n' items
        // with the full knapsack capacity 'W'.
        return dp[n][W];
    }
}
