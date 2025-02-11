// Given an integer array nums and an integer k, return the maximum length of a 
// subarray
//  that sums to k. If there is not one, return 0 instead.
// Example 1:

// Input: nums = [1,-1,5,-2,3], k = 3
// Output: 4
// Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
// Example 2:

// Input: nums = [-2,-1,2,1], k = 1
// Output: 2
// Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 
## **Optimized Approach (Using HashMap)**
1. **Use a HashMap** to store `(prefixSum → index)`, where `prefixSum` is the cumulative sum from the beginning of the array.
2. **Iterate through the array** while maintaining a running sum.
3. **Check if `sum - k` exists in the map**, which means there's a subarray with sum `k`.
   - If found, update the `maxLength` by comparing with `(current index - stored index)`.
4. **If `sum == k`**, update `maxLength` because the subarray starts from index `0`.
5. **Store `sum` in the map** if it hasn't been stored before (to ensure we always use the leftmost occurrence for max length).

---
import java.util.HashMap;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores prefix sum → index

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // If sum equals k, update maxLength
            if (sum == k) {
                maxLength = right + 1;
            }

            // If (sum - k) exists in the map, update maxLength
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, right - map.get(sum - k));
            }

            // Store sum in map only if it's not present
            if (!map.containsKey(sum)) {
                map.put(sum, right);
            }
        }

        return maxLength;
    }
}

---

## **Explanation with Example**
### **Example 1: `nums = [1,-1,5,-2,3], k = 3`**
| Step | Right | Num  | Sum  | Map (Prefix Sum → Index) | Max Length |
|------|------|-----|-----|----------------------|------------|
| 1    | 0    | 1   | 1   | `{1 → 0}`            | 0          |
| 2    | 1    | -1  | 0   | `{1 → 0, 0 → 1}`     | 0          |
| 3    | 2    | 5   | 5   | `{1 → 0, 0 → 1, 5 → 2}` | 0          |
| 4    | 3    | -2  | 3   | `{1 → 0, 0 → 1, 5 → 2, 3 → 3}` | **4** (subarray `[1, -1, 5, -2]`) |
| 5    | 4    | 3   | 6   | `{1 → 0, 0 → 1, 5 → 2, 3 → 3, 6 → 4}` | **4** |

✅ **Output: `4`** (subarray `[1, -1, 5, -2]` sums to `3`)

---

### **Example 2: `nums = [-2,-1,2,1], k = 1`**
| Step | Right | Num  | Sum  | Map (Prefix Sum → Index) | Max Length |
|------|------|-----|-----|----------------------|------------|
| 1    | 0    | -2  | -2  | `{-2 → 0}`           | 0          |
| 2    | 1    | -1  | -3  | `{-2 → 0, -3 → 1}`   | 0          |
| 3    | 2    | 2   | -1  | `{-2 → 0, -3 → 1, -1 → 2}` | 0          |
| 4    | 3    | 1   | 0   | `{-2 → 0, -3 → 1, -1 → 2, 0 → 3}` | **2** (subarray `[-1,2]` sums to `1`) |

✅ **Output: `2`** (subarray `[-1,2]` sums to `1`)

---

## **Complexity Analysis**
- **Time Complexity**: **O(n)** → We iterate through `nums` once, and HashMap operations take **O(1)** on average.
- **Space Complexity**: **O(n)** → In the worst case, we store all prefix sums.

---

## **Edge Cases Considered**
1. **No valid subarray**  
   - `nums = [1, 2, 3], k = 7` → Output: `0`
2. **Entire array sums to `k`**  
   - `nums = [3, 3, 3], k = 9` → Output: `3`
3. **Negative numbers in the array**  
   - `nums = [-1, 2, -1, 3], k = 3` → Output: `4`

---
