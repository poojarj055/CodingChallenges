// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
// Example 1:

// Input: nums = [3,2,3]
// Output: [3]
// Example 2:

// Input: nums = [1]
// Output: [1]
// Example 3:

// Input: nums = [1,2]
// Output: [1,2]

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num)>(nums.length/3)){
                list.add(num);
            }
        }
        return list;
    }
}


///---------------------------------

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> set=new HashSet<>();
        Arrays.sort(nums);
        int i=0;
        int count =0;
        while(i<nums.length){
            int j=i+1;
            while(j< nums.length && nums[i]==nums[j]){
                j++;
            }
            if(j-i>(nums.length/3))
            {
                set.add(nums[i]);
                count=0;
            }
            i=j;
        }
        return new ArrayList<>(set);
    }
                
}


//-----------------------------------------

---

### Line-by-line explanation

1. **Sort the array**

   ```java
   Arrays.sort(nums);
   ```

   After sorting, any value that appears multiple times will be in one contiguous block (or “run”).

2. **Initialize pointers**

   ```java
   int i = 0;
   int n = nums.length;
   ```

   `i` marks the start of the current run; `n/3` is the threshold.

3. **Outer loop**

   ```java
   while (i < n) { … }
   ```

   We’ll repeat until we’ve processed every run in the array.

4. **Find end of run**

   ```java
   int j = i + 1;
   while (j < n && nums[j] == nums[i]) {
       j++;
   }
   ```

   Now all indices from `i` up to `j-1` hold the same value `nums[i]`.

5. **Check run‐length**

   ```java
   if (j - i > n / 3) {
       set.add(nums[i]);
   }
   ```

   If that block’s size exceeds `n/3`, this value is one of our answers.

6. **Move to next run**

   ```java
   i = j;
   ```

   Restart the process at the next new number.

7. **Return results**
   We put the found values into a list (any order).

---

### Dry run on an example

Let’s take

```
nums = [3, 2, 3, 1, 1, 1, 2, 2]
```

* `n = 8`, so threshold `n/3 = 2` (we look for runs of length > 2).

**After sorting**

```
nums = [1, 1, 1, 2, 2, 2, 3, 3]
       ── run of 1 ──  ── run of 2 ──  ─ run of 3 ─
 idx:   0  1  2    3  4  5    6  7
```

| Iteration |   i   | nums\[i] | j starts at | j stops at | Run length = j−i | > 8/3? | Action         |
| :-------: | :---: | :------: | :---------: | :--------: | :--------------: | :----: | :------------- |
|     1     |   0   |     1    |      1      |      3     |         3        |   Yes  | add 1 to `set` |
|     2     | i ← 3 |     2    |      4      |      6     |         3        |   Yes  | add 2 to `set` |
|     3     | i ← 6 |     3    |      7      |      8     |         2        |   No   | skip           |
|     4     | i ← 8 |     –    |  loop ends  |      –     |         –        |    –   | done           |

* **Iteration 1:** `i=0`, run of three 1’s → 3 > 2 ✓ → add 1
* **Iteration 2:** `i=3`, run of three 2’s → 3 > 2 ✓ → add 2
* **Iteration 3:** `i=6`, run of two 3’s → 2 ≯ 2 ✗ → don’t add
* **End:** `set = {1, 2}` → return `[1, 2]`

---

### Why this works

* **Sorting** guarantees each distinct value is grouped.
* **Single scan** of those groups takes O(n) after sorting (total O(n log n)).
* **O(1) extra space**, aside from the result set/list.

This straightforward “sort + count runs” method is easy to read, and for moderate-sized inputs (up to a few million elements), the n log n sort is perfectly acceptable.


