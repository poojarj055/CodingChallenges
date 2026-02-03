// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. 
//However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.

// Find and return the maximum profit you can achieve.

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 7
// Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
// Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
// Total profit is 4 + 3 = 7.
// Example 2:

// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Total profit is 4.
// Example 3:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
// // 
Recursive soltion:
  ------------------------
class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, false);
    }

    private int dfs(int[] prices, int day, boolean holding) {
        if (day == prices.length) return 0;

        if (!holding) {
            // Not holding: either skip or buy
            int skip = dfs(prices, day + 1, false);
            int buy = dfs(prices, day + 1, true) - prices[day];
            return Math.max(skip, buy);
        } else {
            // Holding: either skip or sell
            int skip = dfs(prices, day + 1, true);
            int sell = dfs(prices, day + 1, false) + prices[day];
            return Math.max(skip, sell);
        }
    }
}

Top-down approach:
-----------------------------

  class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[day][holding] initialized to -1 (uncomputed)
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return dfs(prices, 0, false, dp);
    }

    private int dfs(int[] prices, int day, boolean holding, int[][] dp) {
        if (day == prices.length) return 0;

        int holdIndex = holding ? 1 : 0;
        if (dp[day][holdIndex] != -1) return dp[day][holdIndex];

        int result;
        if (!holding) {
            // Not holding: skip or buy
            int skip = dfs(prices, day + 1, false, dp);
            int buy = dfs(prices, day + 1, true, dp) - prices[day];
            result = Math.max(skip, buy);
        } else {
            // Holding: skip or sell
            int skip = dfs(prices, day + 1, true, dp);
            int sell = dfs(prices, day + 1, false, dp) + prices[day];
            result = Math.max(skip, sell);
        }

        dp[day][holdIndex] = result;
        return result;
    }
}
