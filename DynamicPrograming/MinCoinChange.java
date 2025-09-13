322. Coin Change

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
// You may assume that you have an infinite number of each kind of coin.
// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Example 3:

// Input: coins = [1], amount = 0
// Output: 0
 

// Constraints:

// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        int [] coinChangeDp=new int[amount+1];
        for(int i=1;i<=amount;i++){
            coinChangeDp[i]=Integer.MAX_VALUE;
            for(int coin:coins){
               if(coin<=i && coinChangeDp[i-coin]!=Integer.MAX_VALUE){
                 coinChangeDp[i]=Math.min(coinChangeDp[i], coinChangeDp[i-coin]+1);
                }
            }
        if(coinChangeDp[amount]==Integer.MAX_VALUE){
            return -1;
            }
        }
        return coinChangeDp[amount];
    }
}


`````````````````````````````````````

Explanation

`````````````````````````````````````

if(amount < 1) return 0;
This is the base case. If the target amount is 0 or less, you need zero coins. The function immediately returns 0. 

int [] coinChangeDp = new int[amount + 1];
This creates an array called coinChangeDp. It's a table to store our results. The array will have a size of amount + 1 to hold results for every amount from 0 up to amount.

coinChangeDp[i] will eventually store the minimum number of coins needed to make the amount i. 

for(int i = 1; i <= amount; i++) { ... }
This is the main loop that builds the solution from the bottom up. It calculates the minimum number of coins for each amount i, starting from 1 and going up to the target amount. 

coinChangeDp[i] = Integer.MAX_VALUE;
At the beginning of each loop for amount i, we assume it's impossible to make that amount. We use a very large number, Integer.MAX_VALUE, to represent this "infinity". 


for(int coin : coins) { ... }
Inside the main loop, we have a nested loop that goes through each type of coin we have (e.g., 1, 2, 5). The code asks, "What if I use this specific coin to help me make amount i?" 


if(coin <= i && coinChangeDp[i - coin] != Integer.MAX_VALUE)
This is the key logic. It checks if two conditions are met:

coin <= i: The current coin denomination must be smaller than or equal to the current target amount i. You can't use a 5-cent coin to make 3 cents.

coinChangeDp[i - coin] != Integer.MAX_VALUE: This checks if it's actually possible to make the remaining amount (i - coin). If it was impossible, we can't use this coin. 


coinChangeDp[i] = Math.min(coinChangeDp[i], coinChangeDp[i - coin] + 1);
This line finds the best solution so far for amount i.
The current best solution for amount i is stored in coinChangeDp[i].
We compare it with a new possible solution: using the current coin plus the minimum number of coins needed for the remaining amount (i - coin).

coinChangeDp[i - coin] + 1 means the number of coins for the smaller problem + one more coin (the current coin). We choose the smaller of these two values. 

if(coinChangeDp[amount] == Integer.MAX_VALUE) { return -1; }

This check happens after the outer loop is finished. If the final value in coinChangeDp for the target amount is still Integer.MAX_VALUE, it means no combination of coins could reach that amount. In that case, we return -1. 
return coinChangeDp[amount];




Time complexity: \(O(amount*N)\) amount: 
The target amount.N: The number of coin denominations (the size of the coins array).
The time complexity is determined by the nested loops in the code. The outer loop runs from i = 1 up to amount.
The inner loop runs through every coin in the coins array. In the worst-case scenario, the algorithm performs amount * N operations.
For example, if amount is 100 and there are 3 coins, the inner loop runs 3 times for every iteration of the outer loop, leading to roughly 300 operations.


Space complexity: \(O(amount)\) amount: 
The target amount. The space complexity is determined by the coinChangeDp array, which has a size of amount + 1.
This array is used to store the minimum number of coins needed for every amount from 0 up to the target amount. 
The space required grows linearly with the target amount, making the space complexity \(O(amount)\)
If we successfully found a solution, we return the value stored in the final index of our coinChangeDp array. This is the minimum number of coins required.
  
