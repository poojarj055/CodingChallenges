// You are given an array arr[] containing n positive integers. These integers can be from 1 to p, and some numbers may be repeated or absent.
//   Your task is to count the frequency of all numbers that lie in the range 1 to n.
// Do modify the array in-place changes in arr[], such that arr[i] = frequency(i) and assume 1-based indexing.

// Note: The elements greater than n in the array can be ignored for counting. Read the explanation of examples for better clarification.

// Examples

// Input: n = 5 arr[] = {2, 3, 2, 3, 5} p = 5
// Output: 0 2 2 0 1
// Explanation: Counting frequencies of each array element We have: 1 occurring 0 times. 2 occurring 2 times. 3 occurring 2 times. 4 occurring 0 times. 5 occurring 1 time.

class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
         for (int i = 1; i <= N; i++) {
            map.put(i, 0);
        }
        for(int i=0;i<N;i++){
            if (map.containsKey(arr[i]))
             {
              map.put(arr[i], map.get(arr[i]) + 1);
             }
        }
         for (int i = 0; i < N; i++) {
            arr[i] = map.get(i + 1);
        }
    }
}


`````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
Explanation:
1. Initialization:
A HashMap is initialized with keys from 1 to N, each with a value of 0. This ensures that every possible element in the range 1 to N has an entry in the map.
2. Counting Frequencies:
The frequency of each element in the array is counted by iterating through the array and updating the map values accordingly.
3. Updating the Array:
The array is updated such that arr[i] contains the frequency of the element i + 1 from the map.
`````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````

