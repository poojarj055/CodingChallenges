// Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place). In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
// If there are multiple solutions, find the lexicographically smallest one.

// Note: The given array is sorted in ascending order, and you don't need to return anything to change the original array.

// Examples:

// Input: n = 5, arr[] = {1,2,3,4,5}
// Output: 2 1 4 3 5
// Explanation: Array elements after sorting it in the waveform are 2 1 4 3 5.


class Solution {
    public static void convertToWave(int n, int[] arr) {
        // code here
        int p1=0;
        int p2=1;
        int p1limit, p2limit;
        if(n%2==1){
         p1limit=n-3;
         p2limit=n-2;
        }
        else{
         p1limit=n-2;
         p2limit=n-1;
        }
        while(p1<p2 && p1<=p1limit && p2<=p2limit){
            if(arr[p2]>arr[p1]){
                int temp=arr[p2];
                arr[p2]=arr[p1];
                arr[p1]=temp;
            }
            p1=p1+2;
            p2=p2+2;
        }
    }
}
