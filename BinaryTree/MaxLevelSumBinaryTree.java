// Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
// Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
// Example 1:

// Input: root = [1,7,0,7,-8,null,null]
// Output: 2
// Explanation: 
// Level 1 sum = 1.
// Level 2 sum = 7 + 0 = 7.
// Level 3 sum = 7 + -8 = -1.
// So we return the level with the maximum sum which is level 2.
// Example 2:

// Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
// Output: 2
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -105 <= Node.val <= 105
 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        //traverse through list and take out max level
        List<Integer> sums =new ArrayList<>();
        maxLevelSumRecur(root, 0, sums);
        int maxSum=Integer.MIN_VALUE;
        int maxLevel=0;
        for(int i=0;i<sums.size();i++){
            if(sums.get(i)>maxSum){
                maxSum=sums.get(i);
                maxLevel=i;
            }
        }
        return maxLevel+1;
    }
    void maxLevelSumRecur(TreeNode root, int level,  List<Integer> sums){
        if(root == null) return;

        // Ensure sums list has space for this level
        if(sums.size()==level){
            sums.add(0);
        }
        // Add current node value to its level sum
        sums.set(level, root.val + sums.get(level));

        // Recurse children
        maxLevelSumRecur(root.left, level+1, sums);
        maxLevelSumRecur(root.right, level+1, sums);

    }
}

Time and space complexity : O(n)
