import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());    // 2
        System.out.println(stack.pop());    // 2
        System.out.println(stack.empty());  // false
    }
}



```````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
Explanation:
push(int x):
Add x to queue2.
Move all elements from queue1 to queue2.
Swap queue1 and queue2.
pop():
Remove and return the element from queue1 (which is the top of the stack).
top():
Return the front element of queue1 (which is the top of the stack).
empty():
Check if queue1 is empty.
This approach ensures that the most recently added element is always at the front of queue1, thus maintaining the LIFO order. 
The swapping of queues after each push operation ensures that subsequent operations can be performed efficiently.
`````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
