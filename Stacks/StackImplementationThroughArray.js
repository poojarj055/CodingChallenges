//Write a program to implement a Stack using Array

function MyStack() {
    this.arr = {};
    this.top = -1;
}

// Function to push an integer into the stack.
MyStack.prototype.push = function(x) {
    this.top++;
    this.arr[this.top] = x;
}

// Function to remove an item from top of the stack.
MyStack.prototype.pop = function() {
    if (this.top < 0) {
        return -1; // Stack is empty
    } else {
        let x = this.arr[this.top];
        delete this.arr[this.top]; // Optional: clean up the stack
        this.top--;
        return x;
    }
}

// Example usage:
let stack = new MyStack();
stack.push(1);
stack.push(2);
console.log(stack.pop()); // 2
console.log(stack.pop()); // 1
console.log(stack.pop()); // -1
