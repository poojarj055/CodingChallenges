// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
// A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
// The path sum of a path is the sum of the node's values in the path.
// Given the root of a binary tree, return the maximum path sum of any non-empty path.
// Example 1:


// Input: root = [1,2,3]
// Output: 6
// Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
// Example 2:


// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
// Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

// Constraints:

// The number of nodes in the tree is in the range [1, 3 * 104].
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
    public int maxPathSum(TreeNode root) {
        int [] sum=new int[1];
        sum[0]=Integer.MIN_VALUE;
        heightSum(root, sum);
        return sum[0];
        
    }
    int heightSum(TreeNode root, int [] sum){
        if(root == null) return 0;
        
        // Get max path sums from left and right subtrees
        // For current node: don't include negative branches (they reduce sum)
        int leftVal = Math.max(0, heightSum(root.left, sum));
        int rightVal = Math.max(0, heightSum(root.right, sum));
        
        sum[0]=Math.max(sum[0], root.val+leftVal+rightVal);

        // Return max path sum that can be extended upward (current node + best branch
        return root.val+ Math.max(leftVal, rightVal);
    }
}

/*

Tree:

    1
   / \
 -2   -3
Step-by-Step:

Node -2:

left = 0, right = 0 → leftVal = 0, rightVal = 0
current = -2 + 0 + 0 = -2 → maxSum = -2
Return -2 (but parent will ignore it since negative)
Node -3:

Same as above → maxSum = max(-2, -3) = -2
Return -3
Node 1:

left = -2 → leftVal = 0, right = -3 → rightVal = 0
current = 1 + 0 + 0 = 1 → maxSum = max(-2, 1) = 1
Return 1 + max(0,0) = 1
Result: 1 (correct, the path is just the root node).


*/
