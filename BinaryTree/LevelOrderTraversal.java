// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []



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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrapList=new ArrayList<List<Integer>>();
        if(root == null) return wrapList;

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        
       
        while(!queue.isEmpty()){
            int qsize=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<qsize;i++){
                if(queue.peek().left!=null) {
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null) {
                    queue.offer(queue.peek().right);
                }
                list.add(queue.poll().val);
            }
            wrapList.add(list);
        }
        return wrapList;
    }
}
