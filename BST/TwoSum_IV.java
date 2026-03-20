// Given the root of a binary search tree and an integer k, 
// return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

// Example 1:


// Input: root = [5,3,6,2,4,null,7], k = 9
// Output: true
// Example 2:


// Input: root = [5,3,6,2,4,null,7], k = 28
// Output: false
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -104 <= Node.val <= 104
// root is guaranteed to be a valid binary search tree.
// -105 <= k <= 105

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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator l=new BSTIterator(root, false);
        BSTIterator r= new BSTIterator(root, true);

        int i=l.next();
        int j=r.next();

        while(i<j){
            if((i+j) == k){
            return true;
            }
            else if(i+j <k){
                i=l.next();
            }
            else{
                j=r.next();
            }
        }
        return false;
    }
}

class BSTIterator{
    private Stack<TreeNode> stack=new Stack<TreeNode>();
    boolean reverse=true;

    BSTIterator(TreeNode root, boolean isReverse){
            reverse=isReverse;
            pushAll(root);
    }
    public void pushAll(TreeNode node){
        while(node!=null){
            stack.push(node);
            if(reverse==true){
                node=node.right;
            }
            else{
                node=node.left;
            }
        }
    }
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    public int next(){
        TreeNode temp=stack.pop();
        if(reverse==false) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }

}

