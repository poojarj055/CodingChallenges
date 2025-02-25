// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
// Example 1:

// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
// Example 2:

// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]
 
To solve this problem optimally in **O(n) time complexity**, we can use the **two-pointer technique** instead of sorting the squared values after computation. Since the given array is **sorted in non-decreasing order**, we take advantage of this property.

### **Optimal Approach: Two-Pointer Technique**
1. **Observation:**  
   - The smallest numbers are at the left (`nums[0]`).
   - The largest numbers are at the right (`nums[n-1]`).
   - Squaring negative numbers makes them positive, so the largest squared values will be either at the leftmost (`nums[0]`) or rightmost (`nums[n-1]`).

2. **Two Pointers Approach:**  
   - Use two pointers, one starting at the left (`i = 0`) and one at the right (`j = n - 1`).
   - Compare the absolute values of both pointers and place the **larger squared value at the end** of the result array.
   - Move the respective pointer inward.

---

### **Efficient Java Implementation**
```java
import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int index = n - 1; // Start filling from the largest index

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++; // Move left pointer rightward
            } else {
                result[index] = rightSquare;
                right--; // Move right pointer leftward
            }
            index--; // Move backward in the result array
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {-4,-1,0,3,10};
        int[] nums2 = {-7,-3,2,3,11};

        System.out.println(Arrays.toString(solution.sortedSquares(nums1))); // Output: [0,1,9,16,100]
        System.out.println(Arrays.toString(solution.sortedSquares(nums2))); // Output: [4,9,9,49,121]
    }
}
```

---

### **Time & Space Complexity Analysis**
- **Time Complexity:** **O(n)**  
  - We iterate through the array **only once** using two pointers.
- **Space Complexity:** **O(n)**  
  - We use an output array of size `n`.

---

### **Dry Run Example**
#### **Input:** `nums = [-4, -1, 0, 3, 10]`
| Step | Left (`nums[left]`) | Right (`nums[right]`) | Left² | Right² | Insert at `index` | Result |
|------|----------------------|----------------------|------|------|----------------|---------|
| 1    | `-4`                | `10`                 | `16` | `100` | `4` → `100`    | `[_, _, _, _, 100]` |
| 2    | `-4`                | `3`                  | `16` | `9`   | `3` → `16`     | `[_, _, _, 16, 100]` |
| 3    | `-1`                | `3`                  | `1`  | `9`   | `2` → `9`      | `[_, _, 9, 16, 100]` |
| 4    | `-1`                | `0`                  | `1`  | `0`   | `1` → `1`      | `[_, 1, 9, 16, 100]` |
| 5    | `0`                 | `0`                  | `0`  | `0`   | `0` → `0`      | `[0, 1, 9, 16, 100]` |

**Final Output:** `[0, 1, 9, 16, 100]`

---

### Key Takeaways
✅ **O(n) time complexity** instead of O(n log n) sorting.  
✅ **Two-pointer technique** efficiently processes negative numbers.  
✅ **Memory efficient**, using only an extra array for the result.  
