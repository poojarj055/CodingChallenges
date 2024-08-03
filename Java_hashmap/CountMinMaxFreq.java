// Problem statement
// Let’s define the beauty of an array to be equal to the value present in the array, which is having the maximum frequency. If there are multiple such values, then the smallest among such values will be selected.
// Alice gave Bob an array ‘A’ of size ‘N’ and asked him to find the beauty of the frequencies of the values present in the array. In simple words, Bob first needs to find the frequencies of all values present in the array, then find the beauty of this frequency array.
// Help Bob in finding the beauty of the frequencies of the values present in the array.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 10
// 1 <= N <= 10^4
// 1 <= A[i] <= 10 

// Time Limit: 1 sec
// Sample Input 1:
// 2
// 5
// 1 2 1 2 3
// 3
// 7 5 5
// Sample Output 1:
// 2
// 1
// Explanation for Sample Input 1:
// In the first test case, the frequency of 1, 2 and 3 is 2, 2 and 1, respectively. So the frequency array becomes [2, 2, 1]. Beauty of this array is 2 as it has the highest frequency.

// In the second test case, the frequency of 7 and 5 is 1 and 2, respectively. So the frequency array becomes [1, 2]. In this array both elements have the same frequency, so we select the smaller one, i.e. 1.


import java.util.* ;
import java.io.*; 
public class Solution {

    public static int maxFrequency(int[] A) {

       Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Calculate the frequency of each element
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Calculate the frequency of these frequencies
        Map<Integer, Integer> frequencyOfFrequencyMap = new HashMap<>();
        for (int frequency : frequencyMap.values()) {
            frequencyOfFrequencyMap.put(frequency, frequencyOfFrequencyMap.getOrDefault(frequency, 0) + 1);
        }
        
        // Find the maximum frequency of frequencies
        int maxFrequency = 0;
        for (int freq : frequencyOfFrequencyMap.values()) {
            if (freq > maxFrequency) {
                maxFrequency = freq;
            }
        }
        
        // Find the smallest frequency value with the maximum frequency
        int smallestNumberWithMaxFreq = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : frequencyOfFrequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                if (entry.getKey() < smallestNumberWithMaxFreq) {
                    smallestNumberWithMaxFreq = entry.getKey();
                }
            }
        }
        
        return smallestNumberWithMaxFreq;
    }
}


````````````````````````````````````````````````````````````````````````````````````````````````````````````````````

Explanation:
1. Calculate the Frequency of Each Element:
2. Use a HashMap to count how many times each number appears in the array.
3. Calculate the Frequency of These Frequencies:
4. Use another HashMap to count how many times each frequency occurs.
5. Find the Maximum Frequency:
6. Determine the highest value in the frequency-of-frequencies map.
7. Select the Smallest Value with the Maximum Frequency:
8. Iterate through the entries of the frequency-of-frequencies map to find the smallest key that has the maximum value.
9. This code correctly processes multiple test cases and determines the "beauty" of the array based on the given criteria.


```````````````````````````````````````````````````````````````````````````````````````````````````````````````````




