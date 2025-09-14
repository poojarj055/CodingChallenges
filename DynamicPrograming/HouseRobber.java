// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
//   the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
// Example 1:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 2:

// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400


class Solution {
    public int rob(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max((dp[i-2]+nums[i]),dp[i-1]);
        }
        return dp[nums.length-1];
    }
}


``````````````````````````````````````````````````````````````
Core logic
The strategy is to build up the solution from the beginning of the street. For each house, the robber has two choices: 
Rob the current house: This is only possible if they did not rob the previous house. The total amount would be the money in the current house plus the maximum money stolen up to two houses before.
Skip the current house: The total amount would simply be the maximum money stolen up to the previous house. 
The solution for the current house is the maximum of these two choices.
  
Step-by-step breakdown
  
1. Edge cases
  
if (nums.length < 2) {
    return nums[0];
}
Use code with caution.

This handles the scenario where there is only one house to rob. In this case, the maximum amount you can steal is simply the money in that single house. 
If there are no houses, the loop will handle it, but it's good practice to consider all edge cases. 


2. Dynamic programming array

int dp[] = new int[nums.length];

A dp array is created to store the maximum amount of money that can be stolen up to each house. dp[i] will hold the maximum loot from houses 0 to i. 
3. Base cases (first two houses)
  
dp[0] = nums[0];
dp[1] = Math.max(nums[0], nums[1]);


For the first house (index 0): The only option is to rob it, so the maximum loot is nums[0].
For the second house (index 1): You can either rob the first house or the second, but not both. So, you take the maximum of the two amounts. 


4. The main loop

for (int i = 2; i < nums.length; i++) {
    dp[i] = Math.max((dp[i-2] + nums[i]), dp[i-1]);
}

This loop iterates through the rest of the houses, from the third house (i=2) to the end. For each house i, it calculates the maximum possible loot based on the two choices mentioned above: 
dp[i-2] + nums[i]: This represents robbing the current house i. You add the money from the current house (nums[i]) to the maximum amount you could have stolen two houses ago (dp[i-2]), since robbing the adjacent house (i-1) is forbidden.
dp[i-1]: This represents skipping the current house i. In this case, the maximum loot is the same as the maximum loot up to the previous house. 
The code then stores the maximum of these two choices in dp[i]. 


5. Final result

return dp[nums.length-1];

After the loop finishes, the last element of the dp array, dp[nums.length-1], will contain the maximum amount of money that can be stolen from all the houses. This is returned as the final answer. 
