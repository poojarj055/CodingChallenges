import java.util.* ;

public class Solution {
    // Helper function to count subarrays with at most 'k' distinct integers
    private static int countAtMostKDistinct(ArrayList<Integer> arr, int n, int k) {
        if (k == 0) return 0;
        
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0;
        
        for (int right = 0; right < n; right++) {
            // Add current element to the frequency map
            freq.put(arr.get(right), freq.getOrDefault(arr.get(right), 0) + 1);
            
            // If the window has more than 'k' distinct integers, move the left pointer
            while (freq.size() > k) {
                freq.put(arr.get(left), freq.get(arr.get(left)) - 1);
                if (freq.get(arr.get(left)) == 0) {
                    freq.remove(arr.get(left));
                }
                left++;
            }
            
            // The number of subarrays ending at 'right' with at most 'k' distinct integers
            count += (right - left + 1);
        }
        
        return count;
    }

    public static int goodSubarrays(ArrayList<Integer> arr, int n, int k) {
        // Calculate subarrays with exactly 'k' distinct integers
        return countAtMostKDistinct(arr, n, k) - countAtMostKDistinct(arr, n, k - 1);
    }

    public static void main(String[] args) {
        // Example usage:
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 3));
        int result1 = goodSubarrays(arr1, arr1.size(), 2);
        System.out.println(result1);  // Output: 7
        
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4));
        int result2 = goodSubarrays(arr2, arr2.size(), 3);
        System.out.println(result2);  // Output: 3
    }
}
