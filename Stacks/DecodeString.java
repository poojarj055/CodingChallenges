// Given an encoded string, return its decoded string.
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
// You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
// The test cases are generated so that the length of the output will never exceed 105.
// Example 1:

// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"
// Example 2:

// Input: s = "3[a2[c]]"
// Output: "accaccacc"
// Example 3:

// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"
 

// Constraints:

// 1 <= s.length <= 30
// s consists of lowercase English letters, digits, and square brackets '[]'.
// s is guaranteed to be a valid input.
// All the integers in s are in the range [1, 300].


import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ']') {
                //Pop characters until '[' to get the string to repeat
                StringBuilder temp = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    temp.insert(0, stack.pop()); 
                }
                stack.pop(); // Remove the "["

                //Pop all digits to get the full number (handles "100[a]")
                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    numStr.insert(0, stack.pop());
                }
                int n = Integer.parseInt(numStr.toString());

                // Repeat the string and push it back as a single block
                StringBuilder repeated = new StringBuilder();
                while (n-- > 0) {
                    repeated.append(temp);
                }
                stack.push(repeated.toString());
                
            } else {
                // Push everything else (numbers, letters, and '[') onto the stack
                stack.push(Character.toString(c));
            }
        }

        // Combine everything left in the stack
        StringBuilder sb = new StringBuilder();
        for (String st : stack) {
            sb.append(st);
        }
        return sb.toString();
    }
}

