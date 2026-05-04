// Given a string s of '(' , ')' and lowercase English characters.

// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

// Formally, a parentheses string is valid if and only if:

// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
 

// Example 1:

// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// Example 2:

// Input: s = "a)b(c)d"
// Output: "ab(c)d"
// Example 3:

// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.
 

// Constraints:

// 1 <= s.length <= 105
// s[i] is either '(' , ')', or lowercase English letter.


import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        // Step 1: Use a Stack to store the INDICES of '('
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.push(i); // Remember where this '(' is
            } else if (sb.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Found a partner, so this '(' is now valid
                } else {
                    // No partner found for this ')', mark it for removal
                    sb.setCharAt(i, '*'); 
                }
            }
        }

        // Step 2: Any '(' left in stack have no partners
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*'); // Mark them for removal
        }

        // Step 3: Filter out the marked '*' characters
        return sb.toString().replace("*", "");
    }
}

