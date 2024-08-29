// Problem statement
// You are given an array ‘ARR’ of length ‘N’ which is filled with the values such that ARR[i] = (2*i + 1). You have to perform operations on the ‘ARR’ to make all elements of the array equal.
// In one operation, you can choose two elements from the array ‘ARR’ say ‘i’ and ‘j’, and can increment the value of ‘ARR[i]’ by one and decrement the value of ‘ARR[j]’ by one.
// You have to find the minimum number of operations to make all the elements of the array ‘ARR’ equal. It is guaranteed that all elements of the array can be made equal using some operations.


import java.util.* ;
import java.io.*; 

public class Solution 
{
    public static long makeArrayEqual(int n) 
    {
        // Initialize the array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 2 * i + 1;
        }

        // The target is the median of the array
        int median = arr[n / 2];
        long operations = 0;

        // Calculate the total operations needed to make all elements equal to the target
        for (int num : arr) {
            operations += Math.abs(num - median);
        }

        return operations;
    }
}
