// Given an array arr[]  containing non-negative integers, the task is to divide it into two sets set1 and set2 such that the absolute difference between their sums is minimum and find the minimum difference.

// Examples:

// Input: arr[] = [1, 6, 11, 5]
// Output: 1
// Explanation: 
// Subset1 = {1, 5, 6}, sum of Subset1 = 12 
// Subset2 = {11}, sum of Subset2 = 11 
// Hence, minimum difference is 1.  
// Input: arr[] = [1, 4]
// Output: 3
// Explanation: 
// Subset1 = {1}, sum of Subset1 = 1
// Subset2 = {4}, sum of Subset2 = 4
// Hence, minimum difference is 3.
// Input: arr[] = [1]
// Output: 1
// Explanation: 
// Subset1 = {1}, sum of Subset1 = 1
// Subset2 = {}, sum of Subset2 = 0
// Hence, minimum difference is 1.
// Constraints:
// 1 ≤ arr.size()*|sum of array elements| ≤ 105
// 1 <= arr[i] <= 105

// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        // Your code goes here
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        Integer [][]cache=new Integer[arr.length+1][sum+1];
        return minDifferenceRecur(arr, 0, 0, sum, cache);
    }
    int minDifferenceRecur(int arr[], int index, int subsetSum, int sum, Integer[][] cache){
        
        if (index == arr.length) { 
            return Math.abs(sum - 2 * subsetSum); 
            
        }
        if(cache[index][subsetSum]!=null){
            return cache[index][subsetSum];
        }
        //include
            int include=minDifferenceRecur(arr, index+1, subsetSum+arr[index],sum,cache);
        //exclude
            int exclude=minDifferenceRecur(arr, index+1, subsetSum, sum, cache);
            
            cache[index][subsetSum]= Math.min(include,exclude);
            return cache[index][subsetSum];
        
    }
}

