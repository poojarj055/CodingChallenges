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

Recursive solution:
``````````````````````````````````````````````````````````````````````
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        return isSubsetSumcheck(arr,n,sum);
    }
    private static boolean isSubsetSumcheck(int array[],int n,int sum){
        if(sum==0){
            return true;
        }
        else if(n==0 && sum>0){
            return false;
        }
        else if(sum<0){
            return false;
        }
        else{
        boolean include= isSubsetSumcheck(array,n-1,sum-array[n-1]);
        boolean exclude= isSubsetSumcheck(array, n - 1, sum);
        return include||exclude;
        }
    }
}

Recursive + Memoization solution:
```````````````````````````````````````
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        Integer memo[][]=new Integer[n][sum+1];
        return isSubsetSumcheck(arr,n-1,sum,memo);
    }
    private static boolean isSubsetSumcheck(int array[],int n,int sum,Integer[][]memo){
        //base case
        if(sum==0){
            return true;
        }
        if(n<0 || sum<0){
            return false;
        }
        if(memo[n][sum]!=null){
            return memo[n][sum]==1;
        }
       if (array[n] > sum) {
            boolean result = isSubsetSumcheck(array, n - 1, sum, memo);
            memo[n][sum] = result ? 1 : 0; 
            return result;
       }
       else{
        boolean include= isSubsetSumcheck(array,n-1,sum-array[n],memo);
        boolean exclude= isSubsetSumcheck(array, n - 1, sum,memo);
        boolean result= include||exclude;
       
        memo[n][sum]=result?1:0;
        return result;
       }
    }
}


DP:
```````````````````````````````````````````````````

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        boolean dp[][]=new boolean[arr.length+1][sum+1];
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }
}

Explanation
https://share.google/aimode/8oBGoleT7q52jA7L0

