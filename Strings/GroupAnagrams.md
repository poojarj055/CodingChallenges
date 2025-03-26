// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Explanation:
// There is no string in strs that can be rearranged to form "bat".
// The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

// Example 2:
// Input: strs = [""]
// Output: [[""]]

// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]

### **Alternative Approach: Using Character Frequency Count**
Instead of sorting each word (which takes \(O(K \log K)\)), we can use a **frequency count array** (which takes only \(O(K)\)) to generate a unique key for each anagram group.

---

### **Key Idea:**
- Each word consists of lowercase English letters (`a-z`).
- We can represent each word as a **26-element array** where each index represents a letter's frequency.
- This **frequency-based key** helps identify anagrams efficiently.

---

### **Java Code Implementation**
```java
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> strMap = new HashMap<>();

        for (String word : strs) {
            int[] count = new int[26]; // Character frequency array
            
            // Count frequency of each character
            for (char c : word.toCharArray()) {
                count[c - 'a']++; 
            }

            // Convert frequency array to a string key
            String key = Arrays.toString(count);

            // Store anagrams in a hashmap
            strMap.putIfAbsent(key, new ArrayList<>());
            strMap.get(key).add(word);
        }

        return new ArrayList<>(strMap.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
```

---

### **Explanation of Steps:**
1. **Initialize a HashMap** → `HashMap<String, List<String>>` stores frequency-based keys and lists of anagrams.
2. **Iterate Through Each Word**:
   - Create a **size-26 integer array (`count[26]`)** to store letter frequencies.
   - Convert each letter in `word` into a frequency count (`count[c - 'a']++`).
   - Convert this array into a **string key** (using `Arrays.toString(count)`) for easy comparison.
3. **Store Words in HashMap**:
   - If the key doesn’t exist, create a new list.
   - Add the original word to the corresponding list.
4. **Return the grouped anagrams**.

---

### **Example Execution**
For input:
```java
String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
```
Each word is transformed into a frequency array:

| Word  | Frequency Array Representation | HashMap Key |
|-------|--------------------------------|------------|
| `"eat"` | `[1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0]` | `"1,0,0,0,1,0,0,0,0,...,0"` |
| `"tea"` | **Same as "eat"** | `"1,0,0,0,1,0,0,0,0,...,0"` |
| `"ate"` | **Same as "eat"** | `"1,0,0,0,1,0,0,0,0,...,0"` |
| `"tan"` | `[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0]` | `"1,0,0,0,0,0,0,0,0,...,0"` |
| `"nat"` | **Same as "tan"** | `"1,0,0,0,0,0,0,0,0,...,0"` |
| `"bat"` | `[1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0]` | `"1,1,0,0,0,0,0,0,0,...,0"` |

So, the **final output** will be:
```java
[["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
```

---

### **Time Complexity Analysis**
1. **Building frequency array:** \(O(K)\) (where \(K\) is the max word length)
2. **Looping through the words:** \(O(N)\)
3. **HashMap operations (insert & lookup):** \(O(1)\)
4. **Final conversion to list:** \(O(N)\)

**Total Time Complexity: \(O(NK)\)**, which is **faster than \(O(N K \log K)\)** (sorting-based approach).

---

### **Comparison of Both Approaches**
| Approach | Time Complexity | Space Complexity | Best For |
|----------|---------------|-----------------|----------|
| **Sorting-based** | \(O(NK \log K)\) | \(O(NK)\) | Short words, general cases |
| **Frequency-based** | \(O(NK)\) | \(O(NK)\) | Long words, fixed character set |

---

### **When to Use This Approach?**
- **For long words** (sorting becomes expensive).
- **When only lowercase English letters are involved**.
- **When performance matters**, as this approach is faster than sorting.
