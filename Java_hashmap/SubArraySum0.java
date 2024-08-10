// Problem statement
// Ninja loves playing with numbers. So his friend gives him an array on his birthday. The array consists of positive and negative integers. Now Ninja is interested in finding the length of the longest subarray whose sum is zero.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 10
// 1 <= N <= 10^4
// -10^5 <= arr[i] <= 10^5

// Time Limit: 1 sec
// Sample Input 1:
// 2 
// 5
// 1 3 -1 4 -4
// 4
// 1 -1 2 -2 
// Sample Output 1:
// 2
// 4 

import java.util.*;

public class Solution {

    public static int findLongestZeroSumSubarray(int[] arr) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If prefixSum is zero, update the maxLength
            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            // If prefixSum has been seen before, calculate the length of zero-sum subarray
            if (prefixSumMap.containsKey(prefixSum)) {
                int previousIndex = prefixSumMap.get(prefixSum);
                int length = i - previousIndex;
                maxLength = Math.max(maxLength, length);
            } else {
                // Store the index of the prefixSum
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int N = sc.nextInt(); // Size of the array
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(findLongestZeroSumSubarray(arr));
        }

        sc.close();
    }
}


``````````````````````````````````````````````````````````````````````````````````````````
Algorithm:
1. Initialize a HashMap to store the prefix sums and their corresponding indices.
2. Initialize variables to keep track of the maximum length of zero-sum subarrays and the current prefix sum.
3. Iterate through the array:
4. Update the prefix sum with the current element.
5. If the prefix sum is zero, update the maximum length (because the subarray from the start to the current index has a zero sum).
6. If the prefix sum has been seen before, calculate the length of the subarray from the first occurrence of this prefix sum to the current index and update the maximum length if this length is greater.
7. Store the index of the first occurrence of each prefix sum in the HashMap if it is not already present.
`````````````````````````````````````````````````````````````````````````````````````````````````````
