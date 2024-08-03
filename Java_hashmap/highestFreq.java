// Problem statement
// Ninja is given an array of integers that contain numbers in random order.
//He needs to write a program to find and return the number which occurs the maximum times in the given input. He needs your help to solve this problem.
// If two or more elements contend for the maximum frequency, return the element which occurs in the array first i.e. whose index is lowest.
// For example,
// For 'arr' = [ 1, 2, 3, 1, 2]. you need to return 1.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 5
// 1 <= N <= 10000
// -10 ^ 3 <= |arr| <= 10 ^ 3

// Time Limit: 1 sec
// Sample Input 1:
// 1 
// 13
// 2 12 2 11 -12 2 -1 2 2 11 12 2 -6 
// Sample Output 1:
// 2
// Explanation of Sample Input 1:
// Test case 1:
// For the first test case of sample output 1, as we start traveling the array, ‘2’ has the highest frequency, hence our answer is ‘2’.

import java.util.*;

public class Solution {
    
    public static int findMaxFrequencyElement(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> firstOccurrenceMap = new HashMap<>();
        
        // Calculate frequency and track first occurrence
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            if (!firstOccurrenceMap.containsKey(num)) {
                firstOccurrenceMap.put(num, i);
            }
        }
        
        // Find the element with the highest frequency
        int maxFrequency = 0;
        int result = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > maxFrequency || (frequency == maxFrequency && firstOccurrenceMap.get(num) < firstOccurrenceMap.get(result))) {
                maxFrequency = frequency;
                result = num;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); // Size of the array
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt(); // Read array elements
            }
            System.out.println(findMaxFrequencyElement(arr));
        }
        
        sc.close();
    }
}

```````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````|
Explanation:
Frequency and First Occurrence Calculation:
We use two maps: one to count frequencies (frequencyMap) and one to track the first occurrence of each element (firstOccurrenceMap).
Determining the Result:
We iterate through the entries of frequencyMap to find the element with the highest frequency.
In case of a tie (multiple elements with the same frequency), we use the firstOccurrenceMap to find the element that appears first in the array.
Example Walkthrough:
For the array [2, 12, 2, 11, -12, 2, -1, 2, 2, 11, 12, 2, -6]:

Frequency Map:
{2: 6, 12: 2, 11: 2, -12: 1, -1: 1, -6: 1}
First Occurrence Map:
{2: 0, 12: 1, 11: 3, -12: 4, -1: 6, -6: 12}
Result Calculation:
The maximum frequency is 6 for the element 2.
Thus, the output for this test case is 2.
````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````







