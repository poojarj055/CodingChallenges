Implement a Queue using an Array. Queries in the Queue are of the following type:
(i) 1 x   (a query of this type means  pushing 'x' into the queue)
(ii) 2     (a query of this type means to pop element from queue and print the poped element)

Examples:

Input:
Q = 5
Queries = 1 2 1 3 2 1 4 2
Output: 2 3


class MyQueue {
    
    constructor(){
		this.front = 0;
		this.rear = 0;
		this.size = 0;
		this.capacity=100005;
		this.arr = new Array(this.capacity);
	}

	//Function to push an element x in a queue.
	
	push(x)
	{
	    // Your code here
	    if(this.size==this.capacity){
	        return;
	    }
	    this.arr[this.rear]=x;
	    this.rear=(this.rear+1)%this.capacity;
	    this.size++;
	} 
	
	/**
     * @returns {number}
    */

    //Function to pop an element from queue and return that element.
	pop()
	{
	     if (this.size === 0) {
            return -1; // If queue is empty, return -1
        }
	     let poppedElement = this.arr[this.front];
	     this.front=(this.front+1)%this.capacity;
	     this.size--;
	     return poppedElement;
		// Your code here
	} 
}

