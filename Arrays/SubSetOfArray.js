// Given an integer array nums of unique elements, return all possible 
// subsets
//  (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

var subsets = function(nums) {
    let result = [[]]; // Start with an empty subset
    for (let num of nums) {
        const len = result.length;
        for (let i = 0; i < len; i++) {
            const subset = result[i].concat(num); // For each subset (result[i]), 
          //it creates a new subset by concatenating num to it (result[i].concat(num)). This creates a new array with num added to the existing subset.
            result.push(subset); // Add the new subset to the result
        }
    }
    return result;
};


Initial State:
result = [[]]

Iteration 1 (num = 1):
    len = 1 (result.length)
    subset = [1]
    result = [[], [1]]

Iteration 2 (num = 2):
    len = 2 (result.length)
    subset = [2], [1, 2]
    result = [[], [1], [2], [1, 2]]

Iteration 3 (num = 3):
    len = 4 (result.length)
    subset = [3], [1, 3], [2, 3], [1, 2, 3]
    result = [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]

Final Result:
[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
