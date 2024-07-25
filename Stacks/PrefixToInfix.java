// You are given a string S of size N that represents the prefix form of a valid mathematical expression. Convert it to its infix form.

// Example 1:

// Input: 
// *-A/BC-/AKL
// Output: 
// ((A-(B/C))*((A/K)-L))
// Explanation: 
The above output is its valid infix form.

import java.util.Stack;

public class PrefixToInfix {
    // Function to check if character is an operator
    private static boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }

    // Function to convert prefix to infix
    public static String convert(String prefix) {
        Stack<String> stack = new Stack<>();
        
        // Traverse from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            
            // If character is operator, pop two elements from stack
            if (isOperator(c)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                
                // Combine them in infix format
                String temp = "(" + op1 + c + op2 + ")";
                
                // Push resulting expression back to stack
                stack.push(temp);
            }
            // If character is operand, push it to stack
            else {
                stack.push(c + "");
            }
        }
        
        // Stack now contains the infix expression
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        System.out.println("Prefix: " + prefix);
        System.out.println("Infix: " + convert(prefix));
    }
}


````````````````````````````````````````````````````
Here's the step-by-step approach:

1. Initialize an empty stack.
2. Traverse the prefix expression from right to left.
3. If the current character is an operand, push it to the stack.
4. If the current character is an operator, pop two operands from the stack, combine them with the operator in infix form (operand1 operator operand2), and push the result back to the stack.
5. At the end of the traversal, the stack will contain the infix expression.
```````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````


