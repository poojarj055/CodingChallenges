// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with
//   the following restrictions:

// After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

// Example 1:

// Input: prices = [1,2,3,0,2]
// Output: 3
// Explanation: transactions = [buy, sell, cooldown, buy, sell]
// Example 2:

// Input: prices = [1]
// Output: 0
 

// Constraints:

// 1 <= prices.length <= 5000
// 0 <= prices[i] <= 1000


class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        Integer [][]cache=new Integer[n][2];
        return maxProfitRecur(prices,0,0,cache);
    }
    public int maxProfitRecur(int[] prices, int day, int hold, Integer[][]cache){
        if (day >= prices.length) return 0;

        if(cache[day][hold]!=null){
            return cache[day][hold];
        }
        int ans;
        if(hold==0){
            int skip=maxProfitRecur(prices, day+1, 0,cache);
            int buy=-prices[day]+maxProfitRecur(prices, day+1, 1,cache);
            ans= Math.max(skip,buy);
        }
        else{
            int skip=maxProfitRecur(prices, day+1, 1,cache);
            int sell=prices[day]+maxProfitRecur(prices, day+2, 0,cache);
            ans= Math.max(skip,sell);
        }
        cache[day][hold]=ans;
        return cache[day][hold];
    }
}
