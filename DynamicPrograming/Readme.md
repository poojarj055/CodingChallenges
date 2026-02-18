# Dynamic Programming Problems

This repository contains solutions to various Dynamic Programming problems organized by categories. Each problem includes links to LeetCode and/or GeeksforGeeks for practice.

## Table of Contents

- [Stock Trading Problems](#stock-trading-problems)
- [Knapsack Problems](#knapsack-problems)
- [House Robber Problems](#house-robber-problems)
- [Coin Change Problems](#coin-change-problems)
- [Subset Sum & Partition Problems](#subset-sum--partition-problems)
- [Climbing Stairs & Jump Problems](#climbing-stairs--jump-problems)
- [String/Sequence Problems](#stringsequence-problems)
- [Path & Grid Problems](#path--grid-problems)
- [Other DP Problems](#other-dp-problems)
- [2D Dynamic Programming](#2d-dynamic-programming)

---

## Stock Trading Problems

### 1. Best Time to Buy and Sell Stock I
- **File:** `BuyOrSellStock_I.java`
- **LeetCode:** [Problem 121 - Easy](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
- **Description:** Single transaction allowed (one buy, one sell)

### 2. Best Time to Buy and Sell Stock II
- **File:** `BuyOrSellStock_II.java`
- **LeetCode:** [Problem 122 - Medium](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
- **Description:** Unlimited transactions allowed

### 3. Best Time to Buy and Sell Stock III
- **File:** `BuyOrSellStock_III.java`
- **LeetCode:** [Problem 123 - Hard](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
- **Description:** Limited to at most 2 transactions

### 4. Best Time to Buy and Sell Stock IV
- **File:** `BuyOrSellStock_IV.java`
- **LeetCode:** [Problem 188 - Hard](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)
- **Description:** Limited to at most k transactions

### 5. Best Time to Buy and Sell Stock with Cooldown
- **File:** `BuyOrSellStock_CoolDown.java`
- **LeetCode:** [Problem 309 - Medium](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
- **Description:** Unlimited transactions with one-day cooldown after selling

### 6. Best Time to Buy and Sell Stock with Transaction Fee
- **File:** `BuyOrSellStock_TransactionFee.java`
- **LeetCode:** [Problem 714 - Medium](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)
- **GeeksforGeeks:** [Buy Stock with Transaction Fee](https://www.geeksforgeeks.org/problems/buy-stock-with-transaction-fee/1)
- **Description:** Unlimited transactions with fixed transaction fee per buy-sell pair

### 7. Best Time to Buy and Sell Stock (Short Selling)
- **File:** `BuyOrSellStock_shortSelling.java`
- **Description:** Stock trading with short selling allowed

---

## Knapsack Problems

### 8. 0/1 Knapsack
- **File:** `KnapSack.java`
- **GeeksforGeeks:** [0/1 Knapsack Problem - DP-10](https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/)
- **Description:** Select items with given profits and weights to maximize profit without exceeding capacity (each item can be included or excluded entirely)

### 9. Unbounded Knapsack
- **File:** `KnapSackWithDuplicate.java`
- **GeeksforGeeks:** [Unbounded Knapsack](https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/)
- **Description:** Unlimited instances of each item allowed

### 10. Rod Cutting
- **File:** `RodCutting.java`
- **GeeksforGeeks:** [Rod Cutting - DP-13](https://www.geeksforgeeks.org/cutting-a-rod-dp-13/)
- **Description:** Find maximum value by cutting a rod of length n into pieces

---

## House Robber Problems

### 11. House Robber I
- **File:** `HouseRobber.java`
- **LeetCode:** [Problem 198 - Medium](https://leetcode.com/problems/house-robber/)
- **Description:** Rob houses to maximize money without robbing adjacent houses

### 12. House Robber II
- **File:** `HouseRobberII.java`
- **LeetCode:** [Problem 213 - Medium](https://leetcode.com/problems/house-robber-ii/)
- **Description:** Houses arranged in a circle; cannot rob first and last house together

### 13. Maximum Sum of Non-Adjacent Elements
- **File:** `Maximum_sum_of_non-adjacent_elements.java`
- **GeeksforGeeks:** [Stickler Thief](https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/)
- **LeetCode:** [Maximum Sum of Subsequence With Non-adjacent Elements](https://leetcode.com/problems/maximum-sum-of-subsequence-with-non-adjacent-elements/)
- **Description:** Find maximum sum such that no two elements are adjacent


---

## Coin Change Problems

### 14. Coin Change (Minimum Coins)
- **File:** `MinCoinChange.java`
- **LeetCode:** [Problem 322 - Medium](https://leetcode.com/problems/coin-change/)
- **GeeksforGeeks:** [Minimum Number of Coins](https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/)
- **Description:** Find minimum number of coins needed to make a target sum

### 15. Coin Change 2 (Number of Ways)
- **File:** `CoinsChange_2.java`
- **LeetCode:** [Problem 518 - Medium](https://leetcode.com/problems/coin-change-2/)
- **Description:** Count number of ways to make amount using given coins

---

## Subset Sum & Partition Problems

### 16. Subset Sum
- **File:** `SubSetSum.java` / `SubsetSum.java`
- **GeeksforGeeks:** [Subset Sum Problem - DP-25](https://www.geeksforgeeks.org/subset-sum-problem-dp-25/)
- **Description:** Check if a subset exists with a given target sum

### 17. Partition Equal Subset Sum
- **File:** `PartionSubsetSum.java`
- **LeetCode:** [Problem 416 - Medium](https://leetcode.com/problems/partition-equal-subset-sum/)
- **Description:** Check if array can be partitioned into two subsets with equal sums

### 18. Partition with Given Difference
- **File:** `PartitionsGivenDifference.java`
- **GeeksforGeeks:** [Partition with Given Difference](https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/)
- **Description:** Count ways to partition array into two subsets with given difference

### 19. Perfect Sum Problem
- **File:** `PerfectSum.java`
- **GeeksforGeeks:** [Perfect Sum Problem](https://www.geeksforgeeks.org/perfect-sum-problem/)
- **Description:** Print all subsets with sum equal to target K

### 20. Target Sum
- **File:** `TargetSum.java`
- **LeetCode:** [Problem 494 - Medium](https://leetcode.com/problems/target-sum/)
- **Description:** Assign '+' or '-' symbols before each array element to reach target sum

### 21. Minimum Sum Partition
- **File:** `MinSumPartition.java`
- **GeeksforGeeks:** [Minimum Sum Partition](https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/)
- **Description:** Partition array into two subsets such that difference of subset sums is minimum

---

## Climbing Stairs & Jump Problems

### 22. Climbing Stairs
- **File:** `ClimbingStairs.java`
- **LeetCode:** [Problem 70 - Easy](https://leetcode.com/problems/climbing-stairs/)
- **Description:** Find distinct ways to climb n steps (1 or 2 steps at a time)

### 23. Min Cost Climbing Stairs
- **File:** `MinCostToClimStairs.java`
- **LeetCode:** [Problem 746 - Easy](https://leetcode.com/problems/min-cost-climbing-stairs/)
- **Description:** Minimize cost to reach the top starting from index 0 or 1

### 24. Frog Jump
- **File:** `FrogJump.java`
- **LeetCode:** [Problem 403 - Hard](https://leetcode.com/problems/frog-jump/)
- **Description:** Determine if a frog can cross a river by jumping on stones

### 25. Minimal Cost
- **File:** `MinimalCost.java`
- **GeeksforGeeks:** [Minimal Cost](https://www.geeksforgeeks.org/minimal-cost-to-reach-the-end-of-array/)
- **Description:** Find minimal cost to reach end of array with given jump costs

---

## String/Sequence Problems

### 26. Longest Common Subsequence
- **File:** `LongestCommonSubsequence.java`
- **LeetCode:** [Problem 1143 - Medium](https://leetcode.com/problems/longest-common-subsequence/)
- **GeeksforGeeks:** [Longest Common Subsequence](https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/)
- **Description:** Find the length of the longest common subsequence between two strings

### 27. Edit Distance
- **File:** `EditStrings.java`
- **LeetCode:** [Problem 72 - Hard](https://leetcode.com/problems/edit-distance/)
- **GeeksforGeeks:** [Edit Distance](https://www.geeksforgeeks.org/edit-distance-dp-5/)
- **Description:** Find minimum number of operations (insert, delete, replace) to convert one string to another

### 28. Delete Operation for Two Strings
- **File:** `DeleteOperationFor2Strings.java`
- **LeetCode:** [Problem 583 - Medium](https://leetcode.com/problems/delete-operation-for-two-strings/)
- **Description:** Find minimum number of steps required to make two strings the same, where each step deletes exactly one character from either string (based on Longest Common Subsequence)

### 29. Shortest Common Supersequence
- **File:** `ShortestCommonSequence.java`
- **LeetCode:** [Problem 1092 - Hard](https://leetcode.com/problems/shortest-common-supersequence/)
- **GeeksforGeeks:** [Shortest Common Supersequence](https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1)
- **Description:** Find the shortest string that has both given strings as subsequences (based on Longest Common Subsequence)

### 30. Longest Palindromic Subsequence
- **File:** `LongestPalandromicSubsequence.java`
- **LeetCode:** [Problem 516 - Medium](https://leetcode.com/problems/longest-palindromic-subsequence/)
- **GeeksforGeeks:** [Longest Palindromic Subsequence - DP-12](https://www.geeksforgeeks.org/dsa/longest-palindromic-subsequence-dp-12/)
- **Description:** Find the length of the longest palindromic subsequence in a given string

### 31. Wildcard Matching
- **File:** `WildcardMatching.java`
- **LeetCode:** [Problem 44 - Hard](https://leetcode.com/problems/wildcard-matching/)
- **Description:** Implement pattern matching with support for `?` and `*` wildcards

### 32. Longest Repeating Subsequence
- **File:** `LongestRepeatingSubsequence.java`
- **GeeksforGeeks:** [Longest Repeating Subsequence](https://www.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1)
- **Description:** Find the length of the longest subsequence that appears at least twice in the string

### 33. Distinct Subsequences
- **File:** `DistinctSubsequences.java`
- **LeetCode:** [Problem 115 - Hard](https://leetcode.com/problems/distinct-subsequences/)
- **Description:** Count the number of distinct subsequences of string `s` that equal string `t`

### 34. Print Longest Common Subsequence
- **File:** `PrintLongestCommonSubsequence.java`
- **Naukri Code360:** [Print Longest Common Subsequence](https://www.naukri.com/code360/problems/print-longest-common-subsequence_8416383?leftPanelTabValue=PROBLEM)
- **Description:** Print the longest common subsequence between two strings

---

## Path & Grid Problems

### 31. Triangle (Minimum Path Sum)
- **File:** `Triangle.java`
- **LeetCode:** [Problem 120 - Medium](https://leetcode.com/problems/triangle/)
- **GeeksforGeeks:** [Minimum Sum Path in a Triangle](https://www.geeksforgeeks.org/minimum-sum-path-triangle/)
- **Description:** Find minimum path sum from top to bottom in a triangular array

---

## Other DP Problems


### 32. Nth Tribonacci Number
- **File:** `NthTriFibonaciSeries.java`
- **LeetCode:** [Problem 1137 - Easy](https://leetcode.com/problems/n-th-tribonacci-number/)
- **Description:** Calculate the nth Tribonacci number (T(n) = T(n-1) + T(n-2) + T(n-3))

---

## 2D Dynamic Programming

For 2D DP problems, please refer to the [`2D-DynamicProgramming`](./2D-DynamicProgramming/) folder.

---


### Time Complexity:
- **Naive Recursion:** O(2^n) or O(n!)
- **Memoization/Tabulation:** O(n) or O(n²) or O(n*capacity)
- **Space Optimized:** Same time complexity with reduced space

---

## Resources

- [LeetCode Dynamic Programming](https://leetcode.com/tag/dynamic-programming/)
- [GeeksforGeeks Dynamic Programming](https://www.geeksforgeeks.org/dynamic-programming/)
- [NeetCode DP Playlist](https://neetcode.io/practice)

---

**Happy Coding! 🚀**
