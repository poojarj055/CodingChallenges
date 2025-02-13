// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position.
//  For example, if s = "abcde", then it will be "bcdea" after one shift.

// Example 1:

// Input: s = "abcde", goal = "cdeab"
// Output: true

// Example 2:

// Input: s = "abcde", goal = "abced"
// Output: false


class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.rotateString("abcde", "bcdea")); // Output: true
        System.out.println(solution.rotateString("abcde", "abced")); // Output: false
    }
}

### Explanation:
1. First, check if `s` and `goal` have the same length. If not, return `false`.
2. Concatenate `s` with itself (`s + s`). This contains all possible rotations of `s`.
3. Use `.contains(goal)` to check if `goal` appears as a substring in `s + s`.
4. If `goal` is found, return `true`, otherwise return `false`.

### Time Complexity:
- The time complexity is **O(N)**, where `N` is the length of the string.  
  This is because `.contains()` runs in **O(N)** time in the worst case.



 
