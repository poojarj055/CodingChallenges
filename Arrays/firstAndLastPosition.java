Problem statement
// You have been given a sorted array/list 'arr' consisting of ‘n’ elements. You are also given an integer ‘k’.

// Now, your task is to find the first and last occurrence of ‘k’ in 'arr'.

// Note :
// 1. If ‘k’ is not present in the array, then the first and the last occurrence will be -1. 
// 2. 'arr' may contain duplicate elements.

// Example:
// Input: 'arr' = [0,1,1,5] , 'k' = 1

// Output: 1 2

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
   int[] result = {-1, -1}; // Initialize with -1, -1 to handle case where k is not found

        // Initialize two pointers
        int left = 0;
        int right = n - 1;

        // Find the first occurrence
        while (left <= right) {
            if (arr.get(left) == k && result[0] == -1) {
                result[0] = left;
            }
            if (arr.get(right) == k && result[1] == -1) {
                result[1] = right;
            }
            if (result[0] != -1 && result[1] != -1) {
                break;
            }
            if (result[0] == -1) {
                left++;
            }
            if (result[1] == -1) {
                right--;
            }
        }
        return result;
    }
}
