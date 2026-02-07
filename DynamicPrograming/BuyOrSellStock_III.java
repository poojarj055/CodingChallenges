// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete at most two transactions.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
// Example 1:

// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// Example 2:

// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
// Example 3:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

// Constraints:

// 1 <= prices.length <= 105
// 0 <= prices[i] <= 105

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        Integer[][][] cache=new Integer[n][2][3];
        return maxProfitRecur(prices, 0, 0,2,cache);
    }
    int maxProfitRecur(int[] prices, int day, int hold, int transaction_count, Integer [][][]cache){
        if(transaction_count==0 || day>=prices.length) return 0;

        if(cache[day][hold][transaction_count]!=null){
            return cache[day][hold][transaction_count];
        }
        int ans;
        if(hold==0){
            //buy or skip
            int skip=maxProfitRecur(prices,day+1,0,transaction_count,cache);
            int buy=-prices[day]+maxProfitRecur(prices,day+1,1,transaction_count,cache);
            ans= Math.max(skip,buy);
        }
        else{
            //sell or skip
            int skip=maxProfitRecur(prices,day+1,1,transaction_count,cache);
            int sell=prices[day]+maxProfitRecur(prices,day+1,0,transaction_count-1,cache);
            ans= Math.max(skip,sell);
        }
        cache[day][hold][transaction_count]=ans;
        return cache[day][hold][transaction_count];
    }
}
