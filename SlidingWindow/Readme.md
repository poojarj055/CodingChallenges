I'll create a comprehensive markdown file that combines both screenshots about sliding window techniques. This will be a great reference document for coding preparation.
Read file: /Users/praj8/Work/forked_repo/emplymnt-policies-paytypes
Ran tool
Perfect! I can see this is a project workspace with existing documentation. I'll create a comprehensive markdown file about sliding window techniques. Let me create it in the root directory alongside the other documentation files.
Read file: README.md
Now I'll create a comprehensive markdown file that covers both sliding window concepts from the screenshots:

```markdown:sliding-window-guide.md
# Sliding Window Techniques - Complete Guide

A comprehensive reference for identifying and implementing sliding window algorithms in coding problems.

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

```python
# Expand window by including arr[right]
window_sum += arr[right]
char_count[arr[right]] += 1
```

### 2. 🔵 **Shrink Window**
- **Action**: Move the left pointer to exclude elements
- **Purpose**: Reduce window size when constraints are violated
- **Implementation**: `left++`
- **When**: Usually done in a while loop when conditions are not met

```python
# Shrink window by excluding arr[left]
while window_is_invalid():
    window_sum -= arr[left]
    char_count[arr[left]] -= 1
    left += 1
```

### 3. 🟡 **Check Validity**
- **Action**: Evaluate if current window meets the problem's criteria
- **Tools Used**:
  - **HashSet**: For uniqueness checks
  - **Running Sum**: For sum-based problems
  - **Frequency Map**: For counting characters/elements
  - **Max/Min Queues**: For finding extremes in window
- **Purpose**: Determine if we have a valid solution or need to shrink

```python
# Check if window is valid
def is_valid_window():
    return len(char_set) <= k  # for "at most k distinct"
    # or return window_sum <= target  # for sum problems
```

### 4. 🟠 **Update Result**
- **Action**: Modify the result based on current window state
- **Common Operations**:
  - Update a counter (max length, count of valid windows)
  - Keep track of best solution found so far
- **When**: After confirming the window is valid

```python
# Update result with current valid window
max_length = max(max_length, right - left + 1)
valid_windows_count += 1
```

---

## Implementation Templates

### Variable-Size Window Template
```python
def variable_sliding_window(arr, target):
    left = 0
    result = 0
    window_state = {}  # or sum, set, etc.
    
    for right in range(len(arr)):
        # 1. EXPAND WINDOW
        # Add arr[right] to window_state
        
        # 2. CHECK VALIDITY & SHRINK IF NEEDED
        while window_is_invalid(window_state):
            # Remove arr[left] from window_state
            left += 1  # SHRINK WINDOW
        
        # 3. UPDATE RESULT
        result = max(result, right - left + 1)
    
    return result
```

### Fixed-Size Window Template
```python
def fixed_sliding_window(arr, k):
    window_sum = sum(arr[:k])  # Initialize first window
    max_sum = window_sum
    
    for i in range(k, len(arr)):
        # Slide window: remove left, add right
        window_sum = window_sum - arr[i - k] + arr[i]
        max_sum = max(max_sum, window_sum)
    
    return max_sum
```

### Frequency Map Template
```python
def frequency_sliding_window(s, k):
    from collections import defaultdict
    
    left = 0
    char_count = defaultdict(int)
    result = 0
    
    for right in range(len(s)):
        # EXPAND: Add character to window
        char_count[s[right]] += 1
        
        # SHRINK: While window has more than k distinct chars
        while len(char_count) > k:
            char_count[s[left]] -= 1
            if char_count[s[left]] == 0:
                del char_count[s[left]]
            left += 1
        
        # UPDATE: Track maximum window size
        result = max(result, right - left + 1)
    
    return result
```

---

## Common Patterns

### Pattern 1: Longest Valid Subarray/Substring
```python
def longest_valid_subarray(arr, condition):
    left = 0
    max_length = 0
    
    for right in range(len(arr)):
        # Add arr[right] to window
        
        while not condition_met():
            # Remove arr[left] from window
            left += 1
        
        max_length = max(max_length, right - left + 1)
    
    return max_length
```

### Pattern 2: Count of Valid Subarrays
```python
def count_valid_subarrays(arr, condition):
    left = 0
    count = 0
    
    for right in range(len(arr)):
        # Add arr[right] to window
        
        while not condition_met():
            # Remove arr[left] from window
            left += 1
        
        # All subarrays ending at 'right' and starting 
        # from 'left' to 'right' are valid
        count += right - left + 1
    
    return count
```

### Pattern 3: Minimum Window
```python
def minimum_valid_window(arr, target):
    left = 0
    min_length = float('inf')
    
    for right in range(len(arr)):
        # Add arr[right] to window
        
        while condition_satisfied():
            min_length = min(min_length, right - left + 1)
            # Remove arr[left] from window
            left += 1
    
    return min_length if min_length != float('inf') else 0
```

---

## Practice Problems

### Beginner Level
1. **Maximum Sum Subarray of Size K** (Fixed Window)
2. **Average of Subarrays of Size K** (Fixed Window)
3. **Longest Substring with At Most 2 Distinct Characters** (Variable Window)

### Intermediate Level
1. **Longest Substring Without Repeating Characters** (Variable Window + HashSet)
2. **Minimum Window Substring** (Variable Window + Frequency Map)
3. **Permutation in String** (Fixed Window + Frequency Map)

### Advanced Level
1. **Sliding Window Maximum** (Deque)
2. **Longest Substring with At Most K Distinct Characters** (Variable Window + HashMap)
3. **Minimum Number of K Consecutive Bit Flips** (Fixed Window + State Tracking)

---

## Key Tips for Success

1. **🎯 Identify the Pattern**: Look for keywords that indicate sliding window approach
2. **📏 Choose Window Type**: Determine if you need fixed-size or variable-size window
3. **🗂️ Select Data Structure**: Use appropriate data structure for tracking window state
4. **🔄 Follow the Flow**: Always expand → check → shrink → update
5. **⚡ Optimize**: Most sliding window solutions are O(n) time complexity

---

## Time Complexity Analysis

- **Fixed Window**: O(n) - each element visited once
- **Variable Window**: O(n) - each element visited at most twice (once by right, once by left pointer)
- **Space Complexity**: Usually O(k) where k is window size or number of distinct elements

---

*This guide covers the fundamental concepts and patterns needed to master sliding window techniques for coding interviews and competitive programming.*
```

This comprehensive markdown file combines both screenshots and provides:

1. **Problem Identification Section** - Based on the first screenshot's decision tree
2. **Components Section** - Based on the second screenshot's 4-step process
3. **Implementation Templates** - Practical code examples
4. **Common Patterns** - Reusable solution patterns
5. **Practice Problems** - Structured learning path
6. **Tips and Analysis** - Additional guidance

The file serves as a complete reference guide that developers can use for coding preparation, covering both the theoretical framework and practical implementation details shown in your screenshots.
