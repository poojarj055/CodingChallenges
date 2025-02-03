// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

// Example 1:

// Input: s = "abc", t = "ahbgdc"
// Output: true

// Example 2:

// Input: s = "axc", t = "ahbgdc"
// Output: false

public class SubsequenceChecker {
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0; // Pointers for s and t
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) { // Match found, move s pointer
                i++;
            }
            j++; // Always move t pointer
        }
        
        return i == s.length(); // If all characters of s are found in order
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isSubsequence("abc", "ahbgdc")); // Output: true
        System.out.println(isSubsequence("axc", "ahbgdc")); // Output: false
    }
}
 -----------------------------------------------------------------------------

 Explanation

    Use Two Pointers:
        i (for s) and j (for t).
    Iterate Through t:
        If s[i] == t[j], move i forward.
        Always move j forward.
    Check if i == s.length():
        If i reaches the end of s, it means s is a subsequence of t.

Complexity Analysis

    Time Complexity: O(n) (since we traverse t once).
    Space Complexity: O(1) (only two integer variables used).

  


