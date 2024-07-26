// You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its prefix form.

// Example 1:

// Input: 
// ABC/-AK/L-*
// Output: 
// *-A/BC-/AKL
// Explanation: 
// The above output is its valid prefix form.


class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> stack=new Stack<>();
        for(int i=0;i<post_exp.length();i++){
            char c=post_exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(Character.toString(c));
            }
            else if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^'){
                // Pop two operands from the stack
                String op1 = stack.pop();
                String op2 = stack.pop();
                
                // Form a prefix expression by combining the operator and operands
                String temp = c + op2 + op1;
                
                // Push the result back to the stack
                stack.push(temp);
            }
        }
        return stack.pop();
    }
}


