// Problem statement
// You are given an array 'ARR' of integers of length N. Your task is to find the next smaller element for each of the array elements.
// Next Smaller Element for an array element is the first element to the right of that element which has a value strictly smaller than that element.
// If for any array element the next smaller element does not exist, you should print -1 for that array element.
// For Example:
// If the given array is [ 2, 3, 1], we need to return [1, 1, -1]. Because for  2, 1 is the Next Smaller element. 
//   For 3, 1 is the Next Smaller element and for 1, there is no next smaller element hence the answer for this element is -1.

// Sample Input 1:
// 2
// 4
// 2 1 4 3
// 3
// 1 3 2
// Sample Output 1:
// 1 -1 3 -1
// -1 2 -1
// Explanation for Sample Input 1:
// For the first test case : 
// 1) For ARR [1] = 2 ,  the next smaller element is 1. 
// 2) For ARR [2] = 1 ,  the next smaller element is -1 as no element in the array has value smaller than 1.
// 3) For ARR [3] = 4 ,  the next smaller element is 3.
// 4) For ARR [4] = 3 ,  the next smaller element is -1 as no element exists in the right of it.
// Hence, we will return the array [ 1, -1, 3, -1] in this case.



import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
         Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> nse = new ArrayList<>(Collections.nCopies(n, -1));  // Initialize the list with size n and default value -1
        
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that are greater than or equal to the current element
            while (!stack.isEmpty() && stack.peek() >= arr.get(i)) {
                stack.pop();
            }
            // If stack is empty, it means there is no smaller element, so store -1
            int value = stack.isEmpty() ? -1 : stack.peek();
            nse.set(i, value);
            // Push the current element onto the stack
            stack.push(arr.get(i));
        }
        
        return nse;
    }
}
    
