// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
// You may assume that you have an infinite number of each kind of coin.
// The answer is guaranteed to fit into a signed 32-bit integer.

// Example 1:

// Input: amount = 5, coins = [1,2,5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1
// Example 2:

// Input: amount = 3, coins = [2]
// Output: 0
// Explanation: the amount of 3 cannot be made up just with coins of 2.
// Example 3:

// Input: amount = 10, coins = [10]
// Output: 1
 

// Constraints:

// 1 <= coins.length <= 300
// 1 <= coins[i] <= 5000
// All the values of coins are unique.
// 0 <= amount <= 5000

class Solution {
    public int change(int amount, int[] coins) {
        Integer cache[][]=new Integer[coins.length+1][amount+1];
        return changeRecur(amount, coins, coins.length-1,cache);
    }
    int changeRecur(int amount, int []coins, int index, Integer cache[][]){
        if(amount==0) 
         {
            return 1;
         }

        if(index<0){
            return 0;
        }
        
        if(cache[index][amount]!=null){
            return cache[index][amount];
        }

        int take=0;
        //take the coin
        //also check if taken then how many more can be taken to make it equal to the given amount so stay at same index
        if(coins[index]<=amount){
            take=changeRecur(amount-coins[index], coins,index,cache);
        }

        //dont take the coin
        int dontTake=changeRecur(amount, coins,index-1,cache);

        cache[index][amount]= take+dontTake;
        return cache[index][amount];
    }
}
