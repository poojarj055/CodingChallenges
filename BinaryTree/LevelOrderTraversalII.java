// Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[15,7],[9,20],[3]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int height = getHeight(root);   // compute once
        helper(root, height - 1, result); // start from bottom index
        return result;
    }

    int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = 1+getHeight(root.left);
        int right = 1+getHeight(root.right);
        return Math.max(left, right);
    }

    void helper(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return;

        // Ensure result has enough lists up to this level
        while (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        // Recurse children with one level up (towards top)
        helper(root.left, level - 1, result);
        helper(root.right, level - 1, result);
    }
}
