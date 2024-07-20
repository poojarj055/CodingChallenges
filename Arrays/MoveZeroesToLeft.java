// Problem statement
// You are given an array 'ARR' of integers. 
// Your task is to modify the array so that all the array elements having zero values get pushed to the left and 
// all the array elements having non-zero value come after them while maintaining their relative order.
// For example :
// Consider the array { 1, 1, 0, 2, 0 }. 
// For the given array the modified array should be {0,0,1,1,2} . 
// Arrays { 0, 0, 1, 2, 1 } and  { 0, 0, 2, 1, 1 } are not the correctly reorganized array even 
//   if they have all the zero values pushed to the left as in both the arrays the relative order of non-zero elements is not maintained.

import java.util.ArrayList;

public class Solution {
	public static void pushZerosAtEnd(ArrayList<Integer> arr)
	{
		 // Initialize a pointer for the position to place zeros
        int nonZeroIndex = n - 1;

        // Iterate from the end of the array to the start
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[nonZeroIndex--] = arr[i];
            }
        }

        // Fill the remaining positions with zeros
        while (nonZeroIndex >= 0) {
            arr[nonZeroIndex--] = 0;
        }
//	System.out.print(arr+ " ");
	}
}
