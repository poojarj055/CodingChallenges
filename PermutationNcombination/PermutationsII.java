// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order

// Example 1:

// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]
// Example 2:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // important step to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, result, new ArrayList<>(), used);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // Skip duplicates (only the first unused occurrence is allowed)
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            temp.add(nums[i]);

            backtrack(nums, result, temp, used);

            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}


-------------------------------

### ✅ **Short Explanation:**

The code generates **all unique permutations** of a list of integers that **may contain duplicates**, using **backtracking** with **duplicate-skipping logic**.

---

### 🔁 **How it works (step-by-step):**

1. **Sort the array** to bring duplicates together.

   ```java
   Arrays.sort(nums);
   ```

2. **Use a boolean array `used[]`** to keep track of which elements are already in the current permutation (`temp`).

3. **Backtrack recursively**:

   * At each recursion level, loop through `nums[]`.
   * Skip:

     * Already used elements (`used[i] == true`)
     * Duplicates that have already been placed at this recursion level:

       ```java
       if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
       ```
     * This ensures each duplicate number is only used once **per tree level**.

4. **When `temp.size() == nums.length`**, a full permutation is formed → add it to `result`.

---

### ⏱️ **Time Complexity:**

* Worst-case: **O(n! \* n)**

  * `n!` — number of possible permutations.
  * Each permutation takes `O(n)` to copy into the result list.
* With duplicate-skipping, actual permutations are **less than `n!`**.

So:

> ✅ **Time Complexity: O(n! \* n)**

---

### 💾 **Space Complexity:**

* `used[]`: O(n)
* `temp`: O(n) (recursive stack depth)
* `result`: stores all permutations → **O(n! \* n)**

So:

> ✅ **Space Complexity: O(n! \* n)** (due to the result list)
> 🔁 Plus O(n) auxiliary space for recursion and `used[]`.

---

### 🧠 Summary:

| Aspect              | Complexity                                                |
| ------------------- | --------------------------------------------------------- |
| Time                | O(n! × n)                                                 |
| Space               | O(n! × n)                                                 |
| Handles duplicates? | ✅ Yes                                                     |
| Sorting needed?     | ✅ Yes                                                     |
| Core idea           | Backtracking + Skip duplicate elements at same tree level |

Let me know if you'd like a visual or dry-run for an input like `[1,1,2]`.

