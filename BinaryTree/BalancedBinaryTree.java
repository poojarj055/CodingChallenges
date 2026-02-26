// Given a binary tree, determine if it is height-balanced.
// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: true
// Example 2:


// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
// Example 3:

// Input: root = []
// Output: true
 

// Constraints:

// The number of nodes in the tree is in the range [0, 5000].
// -104 <= Node.val <= 104

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
    public boolean isBalanced(TreeNode root) {
        int diff= isBalancedRecur(root);
        return diff!=-1;
    }
    int isBalancedRecur(TreeNode root){
        if(root == null) return 0;
        //calculte left and right length and find the difference
        int rightNode=isBalancedRecur(root.right);
        int leftNode=isBalancedRecur(root.left);

        if(leftNode==-1 || rightNode==-1) return -1;
        if(Math.abs(leftNode-rightNode)>1) return -1;

        return Math.max(leftNode,rightNode)+1;
    }
}

/*
        1
       / \
      2   3
     /
    4
   /
  5
Step-by-step:
Node 5: left = 0, right = 0 → balanced → returns height = 1.

Node 4: left = 1, right = 0 → difference = 1 → balanced → returns height = 2.

Node 2: left = 2, right = 0 → difference = 2 → unbalanced → returns -1.

Node 1: sees leftNode == -1 → immediately returns -1.
*/
