//https://www.naukri.com/code360/problems/rotate-array_1230543?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays
import java.util.ArrayList;

public class Solution {

    public static void reverse(ArrayList<Integer> arr, int left, int right) {
        while (left < right) {
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            left++;
            right--;
        }
    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        
        // Handle cases where k is larger than n
        k = k % n;
        
        // Reverse the first k elements
        reverse(arr, 0, k - 1);
        // Reverse the rest of the elements
        reverse(arr, k, n - 1);
        // Reverse the entire array
        reverse(arr, 0, n - 1);

     return arr;
    }

  
}
