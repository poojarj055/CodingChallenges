// Given a set of items, each with a weight and a value, represented by the array wt[] and val[] respectively. Also, a knapsack with a weight limit capacity.
// Your task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.

// Note: Each item can be taken any number of times.

// Examples:

// Input: val[] = [1, 1], wt[] = [2, 1], capacity = 3
// Output: 3
// Explanation: The optimal choice is to pick the 2nd element 3 times.
// Input: val[] = [10, 40, 50, 70], wt[] = [1, 3, 4, 5], capacity = 8
// Output: 110
// Explanation: The optimal choice is to pick the 2nd element and the 4th element.
// Input: val[] = [6, 8, 7, 100], wt[] = [2, 3, 4, 5], capacity = 1
// Output: 0
// Explanation: We can't pick any element. Hence, total profit is 0.
// Constraints:
// 1 ≤ val.size() = wt.size() ≤ 1000
// 1 ≤ capacity ≤ 1000
// 1 ≤ val[i], wt[i] ≤ 100


class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
        Integer cache[][]=new Integer[n+1][capacity+1];
        return knapSackRecur(val, wt, capacity, n-1,cache);
    }
    int knapSackRecur(int [] val, int [] wt, int capacity, int index, Integer cache[][]){
        if(index<0){
            return 0;
        }
        if(capacity>0 && index<0) return Integer.MIN_VALUE;
        
        if(cache[index][capacity]!=null){
            return cache[index][capacity];
        }
        
        int take=Integer.MIN_VALUE;
        //include
        if(wt[index]<=capacity){
            take=val[index]+knapSackRecur(val, wt, capacity-wt[index], index,cache);
        }
        //exclude
        int dontTake=knapSackRecur(val, wt, capacity, index-1, cache);
        cache[index][capacity]= Math.max(take, dontTake);
        return cache[index][capacity];
    }
}
