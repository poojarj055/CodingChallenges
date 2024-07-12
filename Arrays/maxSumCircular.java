// n = 4
// arr = [7, 2, 4, 5]



import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static int maxSum(ArrayList<Integer> arr,int n)
    {
        // Write your code here.
       // Arrays.sort(arr);
       Collections.sort(arr);
//      arr = [2, 4, 5, 7]

        int[] rearranged = new int[n];
        int left = 0;
        int right = n - 1;
        int index = 0;

        // Rearrange the elements alternatively from start and end
        while (left <= right) {
            if (left == right) {
                rearranged[index++] = arr.get(left++);
            } else {
                rearranged[index++] = arr.get(left++);
                rearranged[index++] = arr.get(right--);
            }
        }

// left = 0, right = 3
// rearranged = []

// Iteration 1: rearranged = [2], left = 1
// Iteration 2: rearranged = [2, 7], right = 2
// Iteration 3: rearranged = [2, 7, 4], left = 2
// Iteration 4: rearranged = [2, 7, 4, 5], right = 1

      
        // Calculate the maximum sum of absolute differences
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += Math.abs(rearranged[i] - rearranged[(i + 1) % n]);
        }

//   |2-7| + |7-4| + |4-5| + |5-2|
// = 5 + 3 + 1 + 3
// = 12    

        return maxSum;

    }
}
