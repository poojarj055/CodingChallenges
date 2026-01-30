// Given an array arr[] of size n, where arr[i] denotes the height of ith stone. Geek starts from stone 0 and from stone i, 
//   he can jump to stones i + 1, i + 2, … i + k. The cost for jumping from stone i to stone j is abs(arr[i] – arr[j]). Find the minimum cost for Geek to reach the last stone.

// Example:

// Input: k = 3, arr[]= [10, 30, 40, 50, 20]
// Output: 30
// Explanation: Geek will follow the path 1->2->5, the total cost would be |10-30| + |30-20| = 30, which is minimum.
// Input: k = 1, arr[]= [10, 20, 10]
// Output: 20
// Explanation: Geek will follow the path 1->2->3, the total cost would be |10 - 20| + |20 - 10| = 20.
// Constraints:

// 1 <= arr.size() <=104
// 1 <= k <= 100
// 1 <= arr[i] <= 104

// User function Template for Java

class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n = arr.length; 
        int [] cache=new int[n+1];
        Arrays.fill(cache,-1);
        return minimizeCostRecur(n - 1, k, arr,cache);
        } 
        int minimizeCostRecur(int i, int k, int arr[], int cache[]) {
            if (i == 0) return 0; 
            int minCost = Integer.MAX_VALUE; 
            if(cache[i]!=-1){
                return cache[i];
            }
            for (int j = 1; j <= k; j++) 
            { 
                if (i - j >= 0) 
                { 
                    int cost = minimizeCostRecur(i - j, k, arr,cache) + Math.abs(arr[i] - arr[i - j]); 
                    minCost = Math.min(minCost, cost); 
                    cache[i]=minCost;
                    
                } 
                
            } 
            return cache[i];
    }
}

