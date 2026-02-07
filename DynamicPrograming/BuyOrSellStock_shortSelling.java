// You are given an integer array prices where prices[i] is the price of a stock in dollars on the ith day, and an integer k.

// You are allowed to make at most k transactions, where each transaction can be either of the following:

// Normal transaction: Buy on day i, then sell on a later day j where i < j. You profit prices[j] - prices[i].

// Short selling transaction: Sell on day i, then buy back on a later day j where i < j. You profit prices[i] - prices[j].

// Note that you must complete each transaction before starting another. Additionally, you can't buy or sell on the same day you are selling or buying back as part of a previous transaction.

// Return the maximum total profit you can earn by making at most k transactions.

// Example 1:

// Input: prices = [1,7,9,8,2], k = 2

// Output: 14

// Explanation:

// We can make $14 of profit through 2 transactions:
// A normal transaction: buy the stock on day 0 for $1 then sell it on day 2 for $9.
// A short selling transaction: sell the stock on day 3 for $8 then buy back on day 4 for $2.
// Example 2:

// Input: prices = [12,16,19,19,8,1,19,13,9], k = 3

// Output: 36

// Explanation:

// We can make $36 of profit through 3 transactions:
// A normal transaction: buy the stock on day 0 for $12 then sell it on day 2 for $19.
// A short selling transaction: sell the stock on day 3 for $19 then buy back on day 4 for $8.
// A normal transaction: buy the stock on day 5 for $1 then sell it on day 6 for $19.



class Solution {

    public long maximumProfit(int[] prices, int k) {
        int n=prices.length;
        Long [][][] cache=new Long[n][4][k+1];
        return maximumProfitRecur(prices, k, 0, 0,cache);
    }

    long maximumProfitRecur(int[] prices, int k, int day, int hold, Long[][][]cache) {
        if (day >= prices.length && hold == 3) return Long.MIN_VALUE;
        if (k == 0 || day >= prices.length) return 0;

        if(cache[day][hold][k]!=null){
            return cache[day][hold][k];
        }
        long ans;
        if (hold == 0) {
            long skip = maximumProfitRecur(prices, k, day + 1, 0, cache);
            long buy = -prices[day] + maximumProfitRecur(prices, k, day + 1, 1, cache);
            long shortSell = prices[day] + maximumProfitRecur(prices, k, day + 1, 3, cache);
            ans= Math.max(shortSell, Math.max(skip, buy));
        } else if (hold == 1) {
            long skip = maximumProfitRecur(prices, k, day + 1, 1,cache);
            long sell = prices[day] + maximumProfitRecur(prices, k - 1, day + 1, 0,cache);
            ans= Math.max(skip, sell);
        } else {
            long buy = - prices[day] + maximumProfitRecur(prices, k - 1, day + 1, 0,cache);
            long skip = maximumProfitRecur(prices, k, day + 1, 3,cache);
            ans= Math.max(skip, buy);
        }
        cache[day][hold][k]=ans;
        return cache[day][hold][k];
    }
}
/*
if not bought
    1. buy
    2. don't buy(skip)
else if bought
    1. sell
    2. don't sell(skip)
--------

hold 3
0 - BUY
1 - SELL
3 - Shortsell

if not bought(0)
    1. buy (1)
    2. dont buy(skip)(0)
    3. sell(3)
else bought(1)
    1. sell(0)
    2. dont sell(skip)(1)
else (3)
    1. buy(0)
    2. dont buy (3)
    */

