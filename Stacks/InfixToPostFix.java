// Given an infix expression in the form of string str. Convert this infix expression to postfix expression.

// Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
// Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
// Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. Ignore the right associativity of ^.
// Example 1:

// Input: str = "a+b*(c^d-e)^(f+g*h)-i"
// Output: abcd^e-fgh*+^*+i-
// Explanation:
// After converting the infix expression 
// into postfix expression, the resultant 
// expression will be abcd^e-fgh*+^*+i-

import java.util.Stack;

class Solution {
    // Function to return the precedence of operators.
    private int getPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert an infix expression to a postfix expression.
    public String infixToPostfix(String exp) {
        // Create a stack and an empty result string.
        Stack<Character> stack = new Stack<>();
        String result = "";

        // Iterate over the given expression.
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the character is an operand, add it to the result.
            if (Character.isLetterOrDigit(c)) {
                result += c;
            }
            // If the character is '(', push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is ')', pop and output from the stack until '(' is found.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop(); // Remove '(' from the stack.
            }
            // If the character is an operator.
            else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack.
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression"; // Invalid expression
            }
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(sol.infixToPostfix(exp)); // Expected output: "abcd^e-fgh*+^*+i-"
    }
}




````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
Explanation:
Precedence Handling: The getPrecedence method is directly implemented within the Solution class to return the precedence of a given operator.
Infix to Postfix Conversion:
1. Iterates over each character in the expression.
2. Appends operands directly to the result string.
3. Pushes ( to the stack.
4. On encountering ), pops from the stack to the result string until ( is found.
5. Handles operators by comparing precedence and popping from the stack accordingly.
6. Final Popping: Ensures all remaining operators are popped from the stack and added to the result string.

```````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````

