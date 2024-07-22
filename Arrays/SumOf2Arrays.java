import java.util.*;
import java.io.*;

public class Solution {
    public static int[] findArraySum(int[] a, int n, int[] b, int m) {
        // Determine the maximum length between the two arrays
        int maxLength = Math.max(n, m);
        
        // Result array can be at most one digit longer than the longest input array
        int[] result = new int[maxLength + 1];
        
        // Indices for traversing the arrays a, b, and the result array
        int i = n - 1;
        int j = m - 1;
        int k = maxLength;
        
        // Carry for addition
        int carry = 0;
        
        // Iterate as long as there are digits in either array or there is a carry left
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry; // Start with the carry from the previous step
            
            // Add the current digit from array a if available
            if (i >= 0) {
                sum += a[i];
                i--;
            }
            
            // Add the current digit from array b if available
            if (j >= 0) {
                sum += b[j];
                j--;
            }
            
            // Compute the new carry
            carry = sum / 10;
            
            // Compute the current digit to store in the result
            result[k] = sum % 10;
            
            // Move to the next position in the result array
            k--;
        }
        
        // If the most significant digit is 0, it means there was no carry, so we skip it
        if (result[0] == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        }
        
        // Return the result array
        return result;
    }
    
    public static void main(String[] args) {
        // Example test
        int[] a = {9, 9, 9};
        int[] b = {1};
        int[] result = findArraySum(a, a.length, b, b.length);
        System.out.println(Arrays.toString(result));  // Output should be [1, 0, 0, 0]
    }
}
