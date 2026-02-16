// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
// You have the following three operations permitted on a word:
// Insert a character
// Delete a character
// Replace a character
// Example 1:
// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')
// Example 2:
// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation: 
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')
// Constraints:
// 0 <= word1.length, word2.length <= 500
// word1 and word2 consist of lowercase English letters.
class Solution {

    public int minDistance(String word1, String word2) {
        Integer [][] cache=new Integer[word1.length()+1][word2.length()+1];
        return minDistanceRecur(word1, word2, 0, 0, cache);
    }

    int minDistanceRecur(String word1, String word2, int index1, int index2, Integer [][] cache) {
        if (index1 > word1.length() - 1 && index2 > word2.length() - 1) {
            return 0;
        }

        if (index2 > word2.length() - 1) {
            // word2 over, word1 not over
            return word1.length() - index1;
        }

        if (index1 > word1.length() - 1) {
            // word1 over, word2 not over
            return word2.length() - index2;
        }

        if(cache[index1][index2]!=null){
            return cache[index1][index2];
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return minDistanceRecur(word1, word2, index1 + 1, index2 + 1, cache);
        } else {
            //in delete letter increase index of deleted word, if replace increase both the index
            int delete = minDistanceRecur(word1, word2, index1 + 1, index2, cache) + 1;
            
            int replace = minDistanceRecur(word1, word2, index1 + 1, index2 + 1, cache) + 1;

            int insert = minDistanceRecur(word1, word2, index1, index2 + 1, cache) + 1;

            cache[index1][index2]= Math.min(insert, Math.min(delete, replace));
            return cache[index1][index2];
        }
    }
}

---------------------------------------------------------------------------------------
⏱️ Time Complexity: O(m * n)
You’re iterating over a 2D table of size (m+1) × (n+1), where:

m = word1.length()

n = word2.length()

Every cell ans[i][j] is filled based on constant-time operations (comparisons and Math.min()).

✅ So, total operations = (m + 1) × (n + 1) ⇒ simplified to O(m × n)


🧠 Space Complexity: O(m * n)
You’re storing the entire (m+1) × (n+1) table in memory to keep track of subproblem solutions.  

-----------------------------------------------------------------------------------------
