// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
//(i.e., from left to right, then right to left for the next level and alternate between).
// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        zigzagLevelOrderRecur(root, 0, result);
        return result;
    }
    void zigzagLevelOrderRecur(TreeNode root, int level, List<List<Integer>> result){
        if(root==null) return;

        if(result.size()==level){
            result.add(new ArrayList<>());
        }

        if(level%2==0){
            //left to right
            result.get(level).add(root.val);
        }
        else{
            //right to left
            result.get(level).add(0,root.val);
        }

        //recurse the children
        zigzagLevelOrderRecur(root.left, level+1, result);
        zigzagLevelOrderRecur(root.right, level+1, result);
    }
}

/*

       3
      / \
     9   20
Level 0 (even): result.get(0).add(3) → [3]

Level 1 (odd):

Visit 9 → result.get(1).add(0, 9) → [9]

Visit 20 → result.get(1).add(0, 20) → [20, 9]
*/
