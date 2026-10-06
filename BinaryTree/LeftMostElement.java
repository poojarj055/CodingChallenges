// You are given the root of a binary tree.
// Return the leftmost value in the last row of the tree.
// Example 1:
// Input: root = [2,1,3]
// Output: 1
// Explanation: The last row is [1,3], so the leftmost value is 1.
// Example 2:
// Input: root = [1,2,3,4,null,5,6,null,null,7]
// Output: 7
// Explanation: The last row contains only the node 7.
// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1

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
    public int findBottomLeftValue(TreeNode root) {
        int ans=1;
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode currElement=queue.poll();
                if(i==size-1){
                    ans=currElement.val;
                }
                if(currElement.right!=null){
                    queue.add(currElement.right);
                }
                if(currElement.left!=null){
                    queue.add(currElement.left);
                }
            }
        }
        return ans;
    }
}
    }
}
