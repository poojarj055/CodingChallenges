// Problem statement
// Given an array 'arr' containing 'n' elements, rotate this array left once and return it.

// Rotating the array left by one means shifting all elements by one place to the left and moving the first element to the last position in the array.

// Example:
// Input: 'a' = 5, 'arr' = [1, 2, 3, 4, 5]

// Output: [2, 3, 4, 5, 1]

import java.util.* ;
import java.io.*; 


public class Solution {

    static int[] rotateArray(int[] arr, int n) {
        // Write your code here.
        int temp=arr[0];
        
        for(int i=0;i<n-1;i++){
            arr[i]=arr[i+1];
        }
        arr[n-1]=temp;
        return arr;

    }
}
