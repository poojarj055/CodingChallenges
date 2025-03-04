// Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.

// Note: The pairs must be returned in sorted order, the solution array should also be sorted, and the answer must not contain any duplicate pairs.

// Examples:

// Input: arr = [-1, 0, 1, 2, -1, -4]
// Output: [[-1, 1]]
// Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.
// arr[2] + arr[4] = 1 + (-1) = 0.
// The distinct pair are [-1,1].
// Input: arr = [6, 1, 8, 0, 4, -9, -1, -10, -6, -5]
// Output: [[-6, 6],[-1, 1]]
// Explanation: The distinct pairs are [-1, 1] and [-6, 6].

Logic
Use a HashMap<Integer, Boolean> to track the presence of numbers.
Traverse the array:
If -num exists in the map, it forms a valid pair.
Store the pair in a TreeSet to maintain order.
Return the final pairs as an ArrayList of ArrayLists.



import java.util.*;
class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Map<Integer, Boolean> map = new HashMap<>();
        TreeSet<ArrayList<Integer>> result = new TreeSet<>(Comparator.comparingInt(a -> a.get(0))); // Sort by first element

        for (int num : arr) {
            if (map.containsKey(-num)) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(Math.min(num, -num)); // Ensure ordering (-num, num)
                pair.add(Math.max(num, -num));
                result.add(pair);
            }
            map.put(num, true);
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 8, 0, 4, -9, -1, -10, -6, -5};
        ArrayList<ArrayList<Integer>> pairs = getPairs(arr);

        for (ArrayList<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }
}
