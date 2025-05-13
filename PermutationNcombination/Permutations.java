// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]



  class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        boolean used[]=new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), result, used);
        return result;
    }

    // * Mark it as used
    // * Add to `temp`
    // * Recurse
    // * Then backtrack: unmark it and remove from `temp`.

    private void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result, boolean [] used){
        if(temp.size()==nums.length) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;

            used[i]=true;
            temp.add(nums[i]);

            backtrack(nums,temp,result,used);

            used[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}
----------------------------------------------------------------------------------------------------------------

** Explanation:**

This Java code generates **all permutations of a given array `nums`** using **backtracking**.

#### ✅ Breakdown:

* **`permute()`**: Entry point. Initializes result list and a boolean `used[]` array to track which elements are already included in the current permutation.
* **`backtrack()`**:

  * Base case: If `temp.size() == nums.length`, we found a full permutation → add a copy to `result`.
  * Loop: For each element in `nums`, if not used:

    * Mark it as used
    * Add to `temp`
    * Recurse
    * Then backtrack: unmark it and remove from `temp`.

This way, it explores **all possible arrangements** (permutations) by **recursively building** and **backtracking**.

---

### ⏱️ **Time Complexity:**

**O(n × n!)**

* There are `n!` permutations for `n` numbers.
* For each permutation, copying the list takes `O(n)` time.
* So total = `O(n × n!)`

---

### 🧠 **Space Complexity:**

**O(n)** (excluding output)
**O(n × n!)** (including output)

* `used[]` array → O(n)
* `temp` list → O(n) stack space (due to recursion)
* Final result stores `n!` lists each of size `n` → O(n × n!) (if including output)

---

Let me know if you’d like a version that **handles duplicates** too (e.g., `[1, 1, 2]`).
  
