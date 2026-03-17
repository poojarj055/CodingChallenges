// Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

// It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

// A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, 
//and any descendant of Node.right has a value strictly greater than Node.val.

// A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

// Example 1:


// Input: preorder = [8,5,1,7,10,12]
// Output: [8,5,10,1,7,null,12]
// Example 2:

// Input: preorder = [1,3]
// Output: [1,null,3]
 

// Constraints:

// 1 <= preorder.length <= 100
// 1 <= preorder[i] <= 1000
// All the values of preorder are unique.

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

Intuition of your code
// The upper_bound ensures that values stay within BST rules.
// Left subtree nodes must be < root.val.
// Right subtree nodes must be < upper_bound but > root.val.
// The preorder array is consumed in order, so no backtracking is needed.

class Solution {
    private int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
       return helper(preorder, Integer.MAX_VALUE);
    }
    private TreeNode helper(int[] preorder, int upper_bound){
        if(index==preorder.length || preorder[index]>upper_bound){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = helper(preorder, root.val);
        root.right = helper(preorder, upper_bound);
        return root;
    }
}

Step-by-step visualization
Start with index = 0, upper_bound = ∞

preorder[0] = 8 → root = 8

Move index → 1

Build left subtree with upper_bound = 8

Left subtree of 8 (upper_bound = 8)

preorder[1] = 5 → node = 5

Move index → 2

Build left subtree with upper_bound = 5

Left subtree of 5 (upper_bound = 5)

preorder[2] = 1 → node = 1

Move index → 3

Build left subtree with upper_bound = 1

preorder[3] = 7 > 1 → stop → null

Build right subtree with upper_bound = 5

preorder[3] = 7 > 5 → stop → null

So node 1 is a leaf.

Right subtree of 5 (upper_bound = 8)

preorder[3] = 7 → node = 7

Move index → 4

Build left subtree with upper_bound = 7

preorder[4] = 10 > 7 → stop → null

Build right subtree with upper_bound = 8

preorder[4] = 10 > 8 → stop → null

So node 7 is a leaf.

Right subtree of 8 (upper_bound = ∞)

preorder[4] = 10 → node = 10

Move index → 5

Build left subtree with upper_bound = 10

preorder[5] = 12 > 10 → stop → null

Build right subtree with upper_bound = ∞

preorder[5] = 12 → node = 12

Move index → 6

Both children null (end of array)

Final BST structure
Code
        8
       / \
      5   10
     / \     \
    1   7     12



  
