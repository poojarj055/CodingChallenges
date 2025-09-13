// 120.Tiangle
//Given a triangle array, return the minimum path sum from top to bottom.

// For each step, you may move to an adjacent number of the row below. More formally, 
//if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
// Example 1:

// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation: The triangle looks like:
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
// Example 2:

// Input: triangle = [[-10]]
// Output: -10
 

// Constraints:

// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -104 <= triangle[i][j] <= 104




class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int height=triangle.size();
       int dp[][]=new int[height+1][height+1];
       for(int level=height-1;level>=0;level--){
        for(int i=0;i<=level;i++){
            dp[level][i]=triangle.get(level).get(i)+
            Math.min(dp[level+1][i],dp[level+1][i+1]);
        }
       }
       return dp[0][0];
    }
}

`````````````````````````````````````````````````````
Space complexity: (O(N^2))
Time complexity: (O(N^2))


``````````````````Explnation``````````````````````````
The strategy: Bottom-up dynamic programming
  
The code solves this problem by working backward, from the last row up to the top.
This makes sense because the minimum path sum for any element depends on the minimum path sums of the two elements directly below it. 


Step-by-step breakdown
1. int height = triangle.size();
This gets the number of rows in the triangle. It will be used to control the loops. 

2. int dp[][] = new int[height + 1][height + 1];
This creates a 2D array, dp, to store intermediate results.
dp[level][i] will store the minimum path sum starting from triangle[level][i] and going down.
The size is height + 1 to prevent any index out-of-bounds errors, especially when referencing dp[level+1].
The dp table is initialized to all zeros. 

3. for(int level = height - 1; level >= 0; level--) { ... }
This is the outer loop, which iterates through the rows of the triangle from the bottom up.
It starts at height - 1 (the last row) and goes up to 0 (the top row). 


4. for(int i = 0; i <= level; i++) { ... }
This is the inner loop, which iterates through each element at the current level.
The number of elements in each row increases by one, so the loop for i goes from 0 to level. 


5. dp[level][i] = triangle.get(level).get(i) + Math.min(dp[level + 1][i], dp[level + 1][i + 1]);
This is the core logic. For each element triangle[level][i], the code calculates the minimum path sum from that point downward.
triangle.get(level).get(i): The value of the current element.
dp[level + 1][i]: The minimum path sum from the element directly below it.
dp[level + 1][i + 1]: The minimum path sum from the adjacent element in the row below.
Math.min(...): This finds the minimum of the two possible next steps.
The result is the current element's value plus the minimum of its two possible next steps. 


Visualizing the logic:
For the last row (level = height - 1), dp[height - 1][i] will simply be triangle[height - 1][i] since dp[height][i] and dp[height][i + 1] are 0 (representing the end of a path).
For the second-to-last row, level = height - 2, the code calculates dp[height - 2][i] by adding the current element triangle[height - 2][i] to min(dp[height-1][i], dp[height-1][i+1]). This is the minimum path sum from the second-to-last row downwards.
This process continues all the way up to the top row. 


6. return dp[0][0];
After the loops complete, dp[0][0] will contain the minimum path sum starting from the very top of the triangle (triangle[0][0]). This is the final answer. 
