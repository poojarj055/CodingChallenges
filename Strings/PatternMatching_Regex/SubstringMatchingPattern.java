// You are given a string s and a pattern string p, where p contains exactly one '*' character.
// The '*' in p can be replaced with any sequence of zero or more characters.
// Return true if p can be made a substring of s, and false otherwise.
// Example 1:

// Input: s = "leetcode", p = "ee*e"

// Output: true

// Explanation:

// By replacing the '*' with "tcod", the substring "eetcode" matches the pattern.

// Example 2:

// Input: s = "car", p = "c*v"

// Output: false

// Explanation:

// There is no substring matching the pattern.

// Example 3:

// Input: s = "luck", p = "u*"

// Output: true

// Explanation:

// The substrings "u", "uc", and "uck" match the pattern.


import java.util.regex.*;
class Solution {
    public boolean hasMatch(String s, String p) {
         // Convert pattern p to regex by replacing '*' with '.*'
        String regex = p.replace("*", ".*");

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Use Stream to check for match
        return pattern.matcher(s).find();
    }
}
 
