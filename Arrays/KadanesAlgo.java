// Given an integer array arr[]. Find the contiguous sub-array(containing at least one number) that has the maximum sum and return its sum.
// Examples:
// Input: arr[] = [1, 2, 3, -2, 5]
// Output: 9
// Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.

class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int[] arr) {

        // Your code here
        long sum=0;
        long maxsum=arr[0];
       
        for(int i=0;i<arr.length;i++){
           sum=sum+ arr[i];
           if(sum>maxsum){
               maxsum=sum;
           }
            if (sum < 0) {
                sum = 0;
            }
           
        }
        return maxsum;
    }
}
