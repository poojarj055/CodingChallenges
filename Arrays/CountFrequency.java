// Given an Array Arr of N positive integers and an integer X. Return the frequency of X in the array.
// Example 1:

// Input:
// N = 5
// Arr = {1, 1, 1, 1, 1}
// X = 1
// Output: 
// 5
// Explanation: Frequency of 1 is 5.

class Solution{
    int findFrequency(int Arr[], int X){
        int counter=0;
       
        for(int i=0;i<Arr.length;i++)
        {
            if (Arr[i]==X)
            counter++;
        }
        
        return counter;
    }
}
O(n)
```````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````

public class Solution {
    public static int count(int arr[], int n, int x) {
        // Find the first occurrence of x
        int first = findOccurrence(arr, 0, n - 1, x, true);
        if (first == -1) {
            return 0; // x is not present in the array
        }
        
        // Find the last occurrence of x
        int last = findOccurrence(arr, 0, n - 1, x, false);
        
        // The count is the difference between the last and first indices plus one
        return last - first + 1;
    }
    
    private static int findOccurrence(int[] arr, int left, int right, int x, boolean findFirst) {
        int result = -1; // Initialize result to -1 to indicate not found
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == x) {
                result = mid; // Update result to the current mid
                if (findFirst) {
                    right = mid - 1; // Continue searching in the left half for the first occurrence
                } else {
                    left = mid + 1; // Continue searching in the right half for the last occurrence
                }
            } else if (arr[mid] < x) {
                left = mid + 1; // Move right if x is greater than arr[mid]
            } else {
                right = mid - 1; // Move left if x is less than arr[mid]
            }
        }
        return result;
    }
}



````````````````````````````````````````````````````````````````````````````````````````````````````````
Explanation:
1. count Method:
Calls findOccurrence twice: once to find the first occurrence (findFirst set to true) and once to find the last occurrence (findFirst set to false).
2. findOccurrence Method:
Uses binary search to find the index of x in the array.
Depending on whether you are finding the first or last occurrence, adjust the search range:
For the first occurrence, continue searching in the left half even after finding x.
For the last occurrence, continue searching in the right half.
3. Counting:
The count is calculated as last - first + 1, which gives the number of times x appears in the array.
---Key Points:
1. This approach works well because it efficiently finds both the first and last occurrences of x using binary search.
2. It ensures that the count is calculated based on indices found, making it simple and efficient for sorted arrays.
3. It runs in O(log n) time complexity for each binary search, resulting in an overall time complexity of O(log n) for finding the count of occurrences.




    
