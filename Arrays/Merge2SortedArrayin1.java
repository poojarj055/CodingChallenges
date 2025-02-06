// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
// Example 1:
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
// Example 2:

// Input: nums1 = [1], m = 1, nums2 = [], n = 0
// Output: [1]
// Explanation: The arrays we are merging are [1] and [].
// The result of the merge is [1].

class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;        // Last valid element in arr1
        int j = n - 1;        // Last element in arr2
        int k = m + n - 1;    // Merge position (last index of arr1)

       while(k >=0)
       {
         if(i>=0 && j>=0)  {
                arr1[k--]=arr1[i]>arr2[j] ? arr1[i--] : arr2[j--];
         }          
        else if(i>=0){
            arr1[k--]=arr1[i--];
        }
        else
        {
            arr1[k--]=arr2[j--];
        }
       }
    }
    
}


-------------------------------------

This **Java solution** efficiently merges two sorted arrays (`arr1` and `arr2`) **in-place** using a **two-pointer** approach. Here's a **step-by-step breakdown**:

---

### **Approach:**
1. **Pointers Initialization:**
   - `i = m - 1` → Points to the **last valid element** in `arr1`
   - `j = n - 1` → Points to the **last element** in `arr2`
   - `k = m + n - 1` → Points to the **last index** in `arr1` (where merging happens)

2. **Merging in Reverse Order (from the end of `arr1`):**
   - If `arr1[i] > arr2[j]`, place `arr1[i]` at `arr1[k]` and decrement `i` & `k`.
   - Otherwise, place `arr2[j]` at `arr1[k]` and decrement `j` & `k`.

3. **Handling Remaining Elements:**
   - If elements remain in `arr1`, copy them directly.
   - If elements remain in `arr2`, copy them into `arr1` (this ensures all elements are merged).

---

### **Time Complexity & Space Complexity:**
- **Time Complexity:** **O(m + n)** (since we iterate through both arrays once)
- **Space Complexity:** **O(1)** (modifies `arr1` in-place)

---

### **Example Dry Run**
```java
int[] arr1 = {1, 2, 3, 0, 0, 0};
int m = 3;
int[] arr2 = {2, 5, 6};
int n = 3;
```
**Initial pointers:**
```
i = 2 (points to 3 in arr1)
j = 2 (points to 6 in arr2)
k = 5 (last index in arr1)
```

#### **Step-by-step merging:**
```
arr1[5] = 6  (from arr2)  → arr1 = [1, 2, 3, 0, 0, 6]
arr1[4] = 5  (from arr2)  → arr1 = [1, 2, 3, 0, 5, 6]
arr1[3] = 3  (from arr1)  → arr1 = [1, 2, 3, 3, 5, 6]
arr1[2] = 2  (from arr2)  → arr1 = [1, 2, 2, 3, 5, 6]
arr1[1] = 2  (from arr1)  → arr1 = [1, 2, 2, 3, 5, 6]
arr1[0] = 1  (from arr1)  → arr1 = [1, 2, 2, 3, 5, 6]
```
**Final Output:**
```
arr1 = [1, 2, 2, 3, 5, 6]
```

---
### **Key Takeaways**
✅ **Efficient O(m + n) solution** without extra space  
✅ **Merges from the end** to avoid unnecessary shifting  
✅ **Handles all edge cases** (empty `arr2`, `arr1` fully populated, etc.)  

🚀 **This is an optimal and clean way to merge two sorted arrays in-place!**

