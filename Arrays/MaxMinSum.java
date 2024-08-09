// You are given an array “ARR” of size N. Your task is to find out the sum of maximum and minimum elements in the array.
// Sample Input 1:
// 2
// 7
// 1 2 4 5 6 6 6 
// 6
// -1 -4 5 8 9 3
// Sample Output 1:
// 7
// 5


import java.util.* ;
import java.io.*; 
public class Solution {
  public static int sumOfMaxMin(int[] arr, int n) {
      // Write your code here.
       int minValue = Integer.MAX_VALUE;
       int maxValue= Integer.MIN_VALUE;
       
        // Iterate through the array
        for (int num : arr) {
            minValue = Math.min(minValue, num);
            maxValue= Math.max(maxValue, num);

        }
    int s=minValue+maxValue;
    return s;

  }
}


another way:
`````````````````````````````````````````````````````````````
public class Solution {
  public static int sumOfMaxMin(int[] arr, int n) {
      // Write your code here.
      int max=Integer.MAX_VALUE;
      int min=Integer.MIN_VALUE;
      for(int i=0;i<n;i++){
        if(min<arr[i]){
          min=arr[i];
        }
        if(max>arr[i]){
          max=arr[i];
        }
      }
      return min+max;
  }
}
