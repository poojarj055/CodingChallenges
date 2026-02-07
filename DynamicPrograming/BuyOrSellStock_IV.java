// You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

// Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Example 1:

// Input: k = 2, prices = [2,4,1]
// Output: 2
// Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
// Example 2:

// Input: k = 2, prices = [3,2,6,5,0,3]
// Output: 7
// Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

// Constraints:

// 1 <= k <= 100
// 1 <= prices.length <= 1000
// 0 <= prices[i] <= 1000
 

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        Integer [][][]cache=new Integer[n][2][k+1];
        return  maxProfitRecur(k, prices,0,0,cache); 
    }
    int maxProfitRecur(int k, int[]prices, int day, int hold, Integer [][][]cache){
        if(k==0 || day>=prices.length) return 0;

        if(cache[day][hold][k]!=null){
            return cache[day][hold][k];
        }

        int ans;

        if(hold==0){
            int skip=maxProfitRecur(k,prices,day+1,0,cache);
            int buy=-prices[day]+maxProfitRecur(k,prices,day+1,1,cache);
            ans= Math.max(skip,buy);
        }
        else{
            int skip=maxProfitRecur(k,prices,day+1,1,cache);
            int sell=prices[day]+maxProfitRecur(k-1,prices,day+1,0,cache);
            ans= Math.max(skip,sell);
        } 
        cache[day][hold][k]=ans;
        return cache[day][hold][k];
    }
}
