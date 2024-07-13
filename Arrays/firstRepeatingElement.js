```
Dry Run:
Let's dry run the code with the example input arr = [1, 5, 3, 4, 3, 5, 6].

Initialization:

map = new Map()
minIndex = Infinity
Iteration:

i	arr[i]	map                        	  minIndex	Action
0	1	      {1: 1}	                      Infinity	Store 1 at index 1 (1-based)
1	5	      {1: 1, 5: 2}	                Infinity	Store 5 at index 2 (1-based)
2	3	      {1: 1, 5: 2, 3: 3}	          Infinity	Store 3 at index 3 (1-based)
3	4	      {1: 1, 5: 2, 3: 3, 4: 4}	    Infinity	Store 4 at index 4 (1-based)
4	3	      {1: 1, 5: 2, 3: 3, 4: 4}	3	  Update minIndex to min(Infinity, 3) = 3
5	5	      {1: 1, 5: 2, 3: 3, 4: 4}	2	  Update minIndex to min(3, 2) = 2
6	6	      {1: 1, 5: 2, 3: 3, 4: 4, 6: 7}	2	      Store 6 at index 7 (1-based)

Since minIndex is 2, which is less than Infinity, return minIndex.
  ```
class Solution {
    // Function to return the position of the first repeating element.
    firstRepeated(arr) {
    let map = new Map();
    let minIndex = Infinity;
    
    for (let i = 0; i < arr.length; i++) {
        if (map.has(arr[i])) {
            // Update the index if it's the first repeating element
            minIndex = Math.min(minIndex, map.get(arr[i]));
        } else {
            // Store the first occurrence index
            map.set(arr[i], i + 1); // Store 1-based index
        }
    }
    
    if (minIndex === Infinity || minIndex === arr.length) {
        return -1; // No repeating element found
    } else {
        return minIndex; // Return 1-based index of the first repeating element
    }
    }
}
