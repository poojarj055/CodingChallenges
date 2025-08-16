I'll create the markdown file again with Java implementations instead of Python. Let me create the comprehensive sliding window guide with Java code examples.

```java:sliding-window-guide.md
# Sliding Window Techniques - Complete Guide (Java)

A comprehensive reference for identifying and implementing sliding window algorithms in coding problems using Java.

## Table of Contents
- [Problem Identification](#problem-identification)
- [Components of Sliding Window](#components-of-sliding-window)
- [Implementation Templates](#implementation-templates)
- [Common Patterns](#common-patterns)
- [Practice Problems](#practice-problems)

---

## Problem Identification

Use this decision tree to identify which sliding window approach to use based on your problem statement:

### 🎯 **Contiguous Subarray/Substring** → **Variable-Size Window**
- **Keywords**: "contiguous", "subarray", "substring"
- **Use Case**: Find subarrays/substrings that meet certain conditions
- **Window Behavior**: Size changes dynamically based on problem constraints
- **Examples**: 
  - Longest substring without repeating characters
  - Minimum window substring
  - Longest subarray with sum ≤ k

### 📏 **Longest/Shortest Segment** → **Variable-Size Window**
- **Keywords**: "longest", "shortest", "optimal length"
- **Use Case**: Finding optimal length segments
- **Examples**:
  - Longest subarray with sum ≤ k
  - Shortest subarray with sum ≥ target
  - Longest substring with at most k distinct characters

### 🔢 **Max Sum/Min Value** → **Fixed-Size Window**
- **Keywords**: "maximum sum of k elements", "minimum in window of size k"
- **Use Case**: When you know the exact window size beforehand
- **Window Behavior**: Constant size k
- **Examples**:
  - Maximum sum of k consecutive elements
  - Minimum in every window of size k
  - Average of k consecutive elements

### 🎚️ **At Most/At Least K Elements** → **Shrinking Window Strategy**
- **Keywords**: "at most k", "at least k", "no more than k"
- **Use Case**: Dealing with constraints on element counts
- **Examples**:
  - Subarray with at most k distinct elements
  - Longest substring with at most k unique characters

### 🔗 **Unique Elements** → **HashSet or Frequency Map**
- **Keywords**: "unique", "distinct", "no duplicates"
- **Use Case**: Tracking unique elements or character frequencies
- **Data Structures**: HashSet, HashMap, frequency arrays
- **Examples**:
  - Longest substring with all unique characters
  - Count distinct elements in every window

### 📊 **Moving Average/Rolling Sum** → **Constant Width Window**
- **Keywords**: "moving average", "rolling sum", "running statistics"
- **Use Case**: Calculating running statistics over fixed windows
- **Examples**:
  - Moving average of stock prices
  - Rolling sum over time series data

---

## Components of Sliding Window

Every sliding window algorithm consists of these 4 core components:

### 1. 🟢 **Expand Window**
- **Action**: Move the right pointer to include more elements
- **Purpose**: Grow the window by adding new elements
- **Implementation**: `right++`
- **When**: Typically done in the main loop iteration

```java
// Expand window by including arr[right]
windowSum += arr[right];
charCount.put(arr[right], charCount.getOrDefault(arr[right], 0) + 1);
```

### 2. 🔵 **Shrink Window**
- **Action**: Move the left pointer to exclude elements
- **Purpose**: Reduce window size when constraints are violated
- **Implementation**: `left++`
- **When**: Usually done in a while loop when conditions are not met

```java
// Shrink window by excluding arr[left]
while (isWindowInvalid()) {
    windowSum -= arr[left];
    charCount.put(arr[left], charCount.get(arr[left]) - 1);
    if (charCount.get(arr[left]) == 0) {
        charCount.remove(arr[left]);
    }
    left++;
}
```

### 3. 🟡 **Check Validity**
- **Action**: Evaluate if current window meets the problem's criteria
- **Tools Used**:
  - **HashSet**: For uniqueness checks
  - **Running Sum**: For sum-based problems
  - **HashMap**: For counting characters/elements
  - **Deque**: For finding extremes in window
- **Purpose**: Determine if we have a valid solution or need to shrink

```java
// Check if window is valid
private boolean isValidWindow() {
    return charSet.size() <= k; // for "at most k distinct"
    // or return windowSum <= target; // for sum problems
}
```

### 4. 🟠 **Update Result**
- **Action**: Modify the result based on current window state
- **Common Operations**:
  - Update a counter (max length, count of valid windows)
  - Keep track of best solution found so far
- **When**: After confirming the window is valid

```java
// Update result with current valid window
maxLength = Math.max(maxLength, right - left + 1);
validWindowsCount++;
```

---

## Implementation Templates

### Variable-Size Window Template
```java
public int variableSlidingWindow(int[] arr, int target) {
    int left = 0;
    int result = 0;
    Map<Integer, Integer> windowState = new HashMap<>(); // or sum, set, etc.
    
    for (int right = 0; right < arr.length; right++) {
        // 1. EXPAND WINDOW
        // Add arr[right] to windowState
        windowState.put(arr[right], windowState.getOrDefault(arr[right], 0) + 1);
        
        // 2. CHECK VALIDITY & SHRINK IF NEEDED
        while (isWindowInvalid(windowState)) {
            // Remove arr[left] from windowState
            windowState.put(arr[left], windowState.get(arr[left]) - 1);
            if (windowState.get(arr[left]) == 0) {
                windowState.remove(arr[left]);
            }
            left++; // SHRINK WINDOW
        }
        
        // 3. UPDATE RESULT
        result = Math.max(result, right - left + 1);
    }
    
    return result;
}
```

### Fixed-Size Window Template
```java
public int fixedSlidingWindow(int[] arr, int k) {
    // Initialize first window
    int windowSum = 0;
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    
    int maxSum = windowSum;
    
    for (int i = k; i < arr.length; i++) {
        // Slide window: remove left, add right
        windowSum = windowSum - arr[i - k] + arr[i];
        maxSum = Math.max(maxSum, windowSum);
    }
    
    return maxSum;
}
```

### Frequency Map Template
```java
public int frequencySlidingWindow(String s, int k) {
    int left = 0;
    Map<Character, Integer> charCount = new HashMap<>();
    int result = 0;
    
    for (int right = 0; right < s.length(); right++) {
        // EXPAND: Add character to window
        char rightChar = s.charAt(right);
        charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
        
        // SHRINK: While window has more than k distinct chars
        while (charCount.size() > k) {
            char leftChar = s.charAt(left);
            charCount.put(leftChar, charCount.get(leftChar) - 1);
            if (charCount.get(leftChar) == 0) {
                charCount.remove(leftChar);
            }
            left++;
        }
        
        // UPDATE: Track maximum window size
        result = Math.max(result, right - left + 1);
    }
    
    return result;
}
```

---

## Common Patterns

### Pattern 1: Longest Valid Subarray/Substring
```java
public int longestValidSubarray(int[] arr) {
    int left = 0;
    int maxLength = 0;
    
    for (int right = 0; right < arr.length; right++) {
        // Add arr[right] to window
        
        while (!conditionMet()) {
            // Remove arr[left] from window
            left++;
        }
        
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
}
```

### Pattern 2: Count of Valid Subarrays
```java
public int countValidSubarrays(int[] arr) {
    int left = 0;
    int count = 0;
    
    for (int right = 0; right < arr.length; right++) {
        // Add arr[right] to window
        
        while (!conditionMet()) {
            // Remove arr[left] from window
            left++;
        }
        
        // All subarrays ending at 'right' and starting 
        // from 'left' to 'right' are valid
        count += right - left + 1;
    }
    
    return count;
}
```

### Pattern 3: Minimum Window
```java
public int minimumValidWindow(int[] arr, int target) {
    int left = 0;
    int minLength = Integer.MAX_VALUE;
    
    for (int right = 0; right < arr.length; right++) {
        // Add arr[right] to window
        
        while (conditionSatisfied()) {
            minLength = Math.min(minLength, right - left + 1);
            // Remove arr[left] from window
            left++;
        }
    }
    
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
```

### Pattern 4: Sliding Window Maximum (Using Deque)
```java
import java.util.*;

public int[] slidingWindowMaximum(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>(); // stores indices
    int[] result = new int[nums.length - k + 1];
    
    for (int i = 0; i < nums.length; i++) {
        // Remove indices outside current window
        while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
            deque.pollFirst();
        }
        
        // Remove indices of smaller elements
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast();
        }
        
        deque.offerLast(i);
        
        // Add to result when window is complete
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.peekFirst()];
        }
    }
    
    return result;
}
```

---

## Complete Example Problems

### Example 1: Longest Substring Without Repeating Characters
```java
public int lengthOfLongestSubstring(String s) {
    Set<Character> charSet = new HashSet<>();
    int left = 0;
    int maxLength = 0;
    
    for (int right = 0; right < s.length(); right++) {
        // Shrink window until no duplicates
        while (charSet.contains(s.charAt(right))) {
            charSet.remove(s.charAt(left));
            left++;
        }
        
        // Add current character and update result
        charSet.add(s.charAt(right));
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
}
```

### Example 2: Minimum Window Substring
```java
public String minWindow(String s, String t) {
    Map<Character, Integer> targetCount = new HashMap<>();
    for (char c : t.toCharArray()) {
        targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
    }
    
    int left = 0, minStart = 0, minLength = Integer.MAX_VALUE;
    int formed = 0, required = targetCount.size();
    Map<Character, Integer> windowCount = new HashMap<>();
    
    for (int right = 0; right < s.length(); right++) {
        char rightChar = s.charAt(right);
        windowCount.put(rightChar, windowCount.getOrDefault(rightChar, 0) + 1);
        
        if (targetCount.containsKey(rightChar) && 
            windowCount.get(rightChar).intValue() == targetCount.get(rightChar).intValue()) {
            formed++;
        }
        
        while (formed == required) {
            if (right - left + 1 < minLength) {
                minLength = right - left + 1;
                minStart = left;
            }
            
            char leftChar = s.charAt(left);
            windowCount.put(leftChar, windowCount.get(leftChar) - 1);
            if (targetCount.containsKey(leftChar) && 
                windowCount.get(leftChar) < targetCount.get(leftChar)) {
                formed--;
            }
            left++;
        }
    }
    
    return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
}
```

---

## Practice Problems

### Beginner Level
1. **Maximum Sum Subarray of Size K** (Fixed Window)
2. **Average of Subarrays of Size K** (Fixed Window)
3. **Longest Substring with At Most 2 Distinct Characters** (Variable Window)

### Intermediate Level
1. **Longest Substring Without Repeating Characters** (Variable Window + HashSet)
2. **Minimum Window Substring** (Variable Window + HashMap)
3. **Permutation in String** (Fixed Window + HashMap)

### Advanced Level
1. **Sliding Window Maximum** (Deque)
2. **Longest Substring with At Most K Distinct Characters** (Variable Window + HashMap)
3. **Minimum Number of K Consecutive Bit Flips** (Fixed Window + State Tracking)

---

## Key Tips for Success

1. **🎯 Identify the Pattern**: Look for keywords that indicate sliding window approach
2. **📏 Choose Window Type**: Determine if you need fixed-size or variable-size window
3. **🗂️ Select Data Structure**: Use appropriate data structure for tracking window state
   - `HashMap<Character, Integer>` for frequency counting
   - `HashSet<Character>` for uniqueness
   - `Deque<Integer>` for min/max in sliding window
4. **🔄 Follow the Flow**: Always expand → check → shrink → update
5. **⚡ Optimize**: Most sliding window solutions are O(n) time complexity

---

## Common Java Data Structures for Sliding Window

```java
// For frequency counting
Map<Character, Integer> charCount = new HashMap<>();

// For uniqueness checks
Set<Character> charSet = new HashSet<>();

// For min/max in sliding window
Deque<Integer> deque = new ArrayDeque<>();

// For simple sum calculations
int windowSum = 0;

// For string building
StringBuilder sb = new StringBuilder();
```

---

## Time Complexity Analysis

- **Fixed Window**: O(n) - each element visited once
- **Variable Window**: O(n) - each element visited at most twice (once by right, once by left pointer)
- **Space Complexity**: Usually O(k) where k is window size or number of distinct elements

---

*This guide covers the fundamental concepts and patterns needed to master sliding window techniques for coding interviews and competitive programming using Java.*
```

This comprehensive Java version includes:

1. **All Java-specific syntax** - HashMap, HashSet, Deque, etc.
2. **Proper Java method signatures** - public int, String, etc.
3. **Java collections** - ArrayList, HashMap.getOrDefault(), etc.
4. **Complete working examples** - Full implementations of classic problems
5. **Java-specific tips** - Data structure recommendations for Java
6. **Proper error handling** - Integer.MAX_VALUE for impossible cases

The guide maintains the same structure as the Python version but with idiomatic Java code that's ready to use in coding interviews or competitive programming.
