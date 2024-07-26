// You are given a string that represents the prefix form of a valid mathematical expression. Convert it to its postfix form.

// Example:

// Input: 
// *-A/BC-/AKL
// Output: 
// ABC/-AK/L-*
// Explanation: 
// The above output is its valid postfix form.


class Solution {
    static String preToPost(String pre_exp) {
        Stack<String> stack = new Stack<>();
        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char c = pre_exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stack.push(Character.toString(c));
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
             // Pop two operands from the stack
                String op1 = stack.pop();
                String op2 = stack.pop();
                
                // Combine the operands and operator into a postfix expression
                String temp = op1 + op2 + c;
                
                // Push the combined expression back to the stack
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        String postfix = preToPost(prefix);
        System.out.println("Postfix expression: " + postfix);
    }
}
