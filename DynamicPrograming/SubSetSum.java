// Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

// Examples:

// Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
// Output: true 
// Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
// Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
// Output: false
// Explanation: There is no subset with target sum 30.
// Input: arr[] = [1, 2, 3], sum = 6
// Output: true
// Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
// Constraints:
// 1 <= arr.size() <= 200
// 1<= arr[i] <= 200
// 1<= sum <= 104

  class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        Boolean [][] cache=new Boolean[sum+1][arr.length+1];
        return isSubsetSumRecur(arr, sum, 0,cache);
    }

    static boolean isSubsetSumRecur(int arr[], int sum, int index, Boolean[][] cache) {
        // Base cases
        if (sum == 0) return true;             
        if (index >= arr.length) return false; 

        if(cache[sum][index]!=null){
            return cache[sum][index];
        }

        // Choice 1: include arr[index]
        boolean include = false;
        if(sum>=arr[index]){
               include= isSubsetSumRecur(arr, sum - arr[index], index + 1, cache);
        }
        
        // Choice 2: exclude arr[index]
        boolean exclude = isSubsetSumRecur(arr, sum, index + 1,cache);
 
        cache[sum][index]=include||exclude;
        
        return cache[sum][index];
    }
}
