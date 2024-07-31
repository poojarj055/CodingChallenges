// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.

 

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Current minimum: " + minStack.getMin()); // Returns -3
        minStack.pop();
        System.out.println("Top element: " + minStack.top()); // Returns 0
        System.out.println("Current minimum: " + minStack.getMin()); // Returns -2
    }
}


````````````````````````````````````````````````````````````````````````````````````````
1. push(int x): Push x onto the main stack. If the min stack is empty or x is less than or equal to the top element of the min stack, push x onto the min stack. 
  Otherwise, push the top element of the min stack again.
2. pop(): Pop an element from both the main stack and the min stack.
3. top(): Return the top element of the main stack.
4. getMin(): Return the top element of the min stack, which represents the current minimum value.

```````````````````````````````````````````````````````````````````````````````````````




