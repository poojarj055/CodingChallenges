// Given a rod of length n inches and an array price[], where price[i] denotes the value of a piece of length i. 
// Your task is to determine the maximum value obtainable by cutting up the rod and selling the pieces.

// Note: n = size of price, and price[] is 1-indexed array.

// Example:

// Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
// Output: 22
// Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.
// Input: price[] = [3, 5, 8, 9, 10, 17, 17, 20]
// Output: 24
// Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1] = 8*3 = 24.
// Input: price[] = [3]
// Output: 3
// Explanation: There is only 1 way to pick a piece of length 1.

class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        Integer [][] cache=new Integer[n+1][n];
        return cutRodRecur(price, n, n-1,cache);
    }

    int cutRodRecur(int[] prices, int capacity, int index, Integer [][] cache) {
        if (capacity == 0) return 0;
        if (index < 0) return 0;

        if(cache[capacity][index]!=null){
            return cache[capacity][index];
        }

        int take = Integer.MIN_VALUE;
        int length=index + 1;
        if (length <= capacity) {
            take = prices[index] + cutRodRecur(prices, capacity -length, index,cache);
        }

        int dontTake = cutRodRecur(prices, capacity, index - 1,cache);

        cache[capacity][index]= Math.max(take, dontTake);
        return cache[capacity][index];
    }
}

