// There is a row of N houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color. Find the minimum cost to paint all houses.

// The cost of painting each house in red, blue or green colour is given in the array r[], g[] and b[] respectively.


// Example 1:

// Input:
// N = 3
// r[] = {1, 1, 1}
// g[] = {2, 2, 2}
// b[] = {3, 3, 3}
// Output: 4
// Explanation: We can color the houses 
// in RGR manner to incur minimum cost.
// We could have obtained a cost of 3 if 
// we coloured all houses red, but we 
// cannot color adjacent houses with 
// the same color.

// Example 2:

// Input:
// N = 3
// r[] = {2, 1, 3}
// g[] = {3, 2, 1}
// b[] = {1, 3, 2} 
// Output: 3
// Explanation: We can color the houses
// in BRG manner to incur minimum cost.

// Your Task:  
// You don't need to read input or print anything. Your task is to complete the function distinctColoring() which takes the size N and the color arrays r[], g[], b[] as input parameters and returns the minimum cost of coloring such that the color of no two houses is same.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(N)

// Constraints:
// 1 <= N <= 5*104
// 1 <= r[i], g[i], b[i] <= 106

// User function Template for Java

class Solution {
    public static long distinctColoring(int N, int[] r, int[] g, int[] b) {
        // code here
        // last_color: 0=Red, 1=Green, 2=Blue, 3=None
        long[][]cache=new long[N][4];
        for (long[] row : cache) Arrays.fill(row, -1);
        
        return distinctColoringRecur(N,r, g,b,0,3,cache);
    }
    static long distinctColoringRecur(int N, int[] r, int[] g, int[] b, int idx, int lastColor,long [][]cache) {
        
        if(idx==N){
            return 0;
        }
        
        if(cache[idx][lastColor]!=-1){
            return cache[idx][lastColor];
        }
        
        long minCost=Long.MAX_VALUE;
        //red
        if(lastColor!=0){
            long cost=distinctColoringRecur(N,r, g,b,idx+1,0,cache)+r[idx];
            minCost=Math.min(cost,minCost);
        }
        //green
          if(lastColor!=1){
            long cost=distinctColoringRecur(N,r, g,b,idx+1,1,cache)+g[idx];
            minCost=Math.min(cost,minCost);
        }
        //blue
          if(lastColor!=2){
            long cost=distinctColoringRecur(N,r, g,b,idx+1,2,cache)+b[idx];
            minCost=Math.min(cost,minCost);
        }
        cache[idx][lastColor]=minCost;
        return cache[idx][lastColor];
    }
}



