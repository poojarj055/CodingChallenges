// Given an array of strings strs, group the 
// anagrams together. You can return the answer in any order.
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

You can solve this problem in Java using **HashMap**, where the key is the sorted version of each word, and the value is a list of words that are anagrams of each other.

---

### **Java Solution using HashMap**

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            // If key doesn't exist, create a new list
            anagramMap.putIfAbsent(sortedWord, new ArrayList<>());

            // Add the word to the corresponding anagram group
            anagramMap.get(sortedWord).add(word);
        }

        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}

---

### **Explanation**
1. Create a **HashMap** where:
   - **Key** = sorted version of the word (e.g., `"eat"` → `"aet"`).
   - **Value** = list of words that match this sorted key.
2. Iterate through the array:
   - Convert each word into a **character array**, sort it, and convert it back to a string.
   - If the sorted version is not in the map, add a **new list** for it.
   - Append the original word to the corresponding list.
3. Return the **values** of the map as a list of lists.

---

### **Example Execution**
#### **Input**
```java
String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
```
#### **Processing**
| Word  | Sorted Key | Anagram Groups |
|--------|----------|----------------|
| "eat"  | "aet"    | {"aet": ["eat"]} |
| "tea"  | "aet"    | {"aet": ["eat", "tea"]} |
| "tan"  | "ant"    | {"aet": ["eat", "tea"], "ant": ["tan"]} |
| "ate"  | "aet"    | {"aet": ["eat", "tea", "ate"], "ant": ["tan"]} |
| "nat"  | "ant"    | {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"]} |
| "bat"  | "abt"    | {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"], "abt": ["bat"]} |

#### **Output**
```java
[["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
```

---

### **Time Complexity**
- **Sorting each word**: \( O(K \log K) \), where \( K \) is the length of the word.
- **Iterating through the list**: \( O(N) \)
- **Overall Complexity**: \( O(NK \log K) \)

---

✅ **Optimized Approach**
Instead of sorting, we could use **character frequency counting** as a key to improve performance. Would you like an optimized solution? 🚀
