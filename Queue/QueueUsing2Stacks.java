// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

// Implement the MyQueue class:

// void push(int x) Pushes element x to the back of the queue.
// int pop() Removes the element from the front of the queue and returns it.
// int peek() Returns the element at the front of the queue.
// boolean empty() Returns true if the queue is empty, false otherwise.
// Notes:

// You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

// Example 1:

// Input
// ["MyQueue", "push", "push", "peek", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 1, 1, false]

import java.util.Stack;

class MyQueue {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        // Shift input to output only if output is empty
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    public int peek() {
        // Shift input to output only if output is empty
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek()); // returns 1
        System.out.println(obj.pop());  // returns 1
        System.out.println(obj.empty());// returns false
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
Key Points:
1. Two Stack Mechanism: The use of two stacks allows us to simulate the behavior of a queue. 
  The input stack is used for enqueuing elements, and the output stack is used for dequeuing elements.
2. Reversing Order: The transfer of elements from input to output reverses their order, which is essential for the correct operation of the queue.
3. Efficient Operations: By transferring elements between stacks only when necessary, the implementation ensures efficient operations.
This approach ensures that the push operation is O(1), while pop and peek operations are amortized O(1).

``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````  
