// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
// You may return the answer in any order.
// Example 1:
// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Explanation: There are 4 choose 2 = 6 total combinations.
// Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
// Example 2:
// Input: n = 1, k = 1
// Output: [[1]]
// Explanation: There is 1 choose 1 = 1 total combination.
// Constraints:

// 1 <= n <= 20
// 1 <= k <= n

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> subset=new ArrayList<>();
        generateSubset(1, subset, new ArrayList<>(),n, k);
        return subset;
    }
    public void generateSubset(int start, List<List<Integer>> subset, List<Integer> curr, int n, int k){
        if(curr.size()==k){
            subset.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<=n;i++){
            curr.add(i);
            generateSubset(i+1, subset, curr,n, k);
            curr.remove(curr.size()-1);
        }
    }
}

------------------------------------------------

// Base Case: If curr.size() == k, it means we’ve formed a valid combination of k elements, so we add it to subset.
// Recursive Case: Loop through numbers from start to n:
// Choose: Add i to curr (current combination).
// Explore: Recursively call generateSubset() with i + 1 as the new start. This ensures numbers are chosen in increasing order and avoids duplicates.
// Undo Choice (Backtracking): Remove the last element before moving to the next iteration.
  
