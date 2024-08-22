import java.util.PriorityQueue;


public class Solution 
{    
    public static int getFourthLargest(int[] arr) 
    {
        // Your code goes here
        if (arr.length < 4) {
            return -2147483648; //or return null
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int num:arr){
            minHeap.add(num);
            if(minHeap.size()>4){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}


