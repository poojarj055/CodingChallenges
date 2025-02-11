// Given a string s, find the length of the longest 
// substring without repeating characters.
// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>(); // Use HashSet<Character>

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));  // Add character directly
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left)); // Remove character directly
                left++;
            }
        }
        
        return maxLength;
    }
}


--------------------------------


Explanation:
Use a HashSet to keep track of unique characters in the current window.
Expand right pointer while the character is unique.
If a duplicate is found:
Shrink the window from the left (left++) until the duplicate is removed.
Update maxLength whenever a longer unique substring is found.


Time Complexity:
O(n) → Each character is processed at most twice (once added and once removed).
O(min(n, 26)) Space → Since we store characters in a HashSet (max 26 for lowercase English letters).

  
