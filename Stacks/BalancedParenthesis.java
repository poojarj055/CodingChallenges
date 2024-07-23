// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 
// Example 1:

// Input: s = "()"
// Output: true

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(char c: s.toCharArray()){
            if (c == '(' || c == '[' || c == '{')
                st.push(c);
               else{
               if(st.isEmpty()) return false;
               char popEl=st.pop();
                //Compare the popped element with the current closing bracket. If they don't match, the string is invalid.
              if ((c == ')' && popEl != '(') || 
                    (c == '}' && popEl != '{') || 
                    (c == ']' && popEl != '[')) {
                    return false;
               }
               }
        }
        return st.isEmpty();
    }
}

````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
Example Walkthrough:
Consider the string "{[()]}".

Initialization:

Stack: []
Iteration:

c = '{' -> Push to stack.
Stack: ['{']
c = '[' -> Push to stack.
Stack: ['{', '[']
c = '(' -> Push to stack.
Stack: ['{', '[', '(']
c = ')' -> Pop from stack (popEl = '('). Match found.
Stack: ['{', '[']
c = ']' -> Pop from stack (popEl = '['). Match found.
Stack: ['{']
c = '}' -> Pop from stack (popEl = '{'). Match found.
Stack: []
Final Check:

Stack is empty, so the string is valid.
This solution ensures that all open brackets have corresponding close brackets in the correct order,
and it runs in O(n) time complexity, where n is the length of the string.

```````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````



