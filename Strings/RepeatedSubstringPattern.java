// Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
// Example 1:

// Input: s = "abab"
// Output: true
// Explanation: It is the substring "ab" twice.
// Example 2:

// Input: s = "aba"
// Output: false
// Example 3:

// Input: s = "abcabcabcabc"
// Output: true
// Explanation: It is the substring "abc" four times or the substring "abcabc" twice.


  class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubleStr=s+s;
        return doubleStr.substring(1,doubleStr.length()-1).contains(s);
    }
}
TC: O(n)
// Explanation:
// Concatenate s with itself: This helps in detecting repeating patterns.
// Remove the first and last character: This prevents detecting s itself.
// Check if s exists in this new string: If true, it means s consists of a repeating pattern.

// 2nd Approach Using PatternMatching:
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String pattern = "^(.+)\\1+$"; // Regex pattern to check repeated substrings
        return Pattern.matches(pattern, s);
    }


Regex Explanation:
^ → Start of the string.
(.+) → Capturing group that matches one or more characters.
\\1+ → Ensures that the captured group is repeated at least once in the rest of the string.
$ → End of the string.


