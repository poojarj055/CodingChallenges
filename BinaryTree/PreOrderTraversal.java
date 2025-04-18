// Given the root of a binary tree, return the preorder traversal of its nodes' values.
// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,2,3]

// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [1,2,4,5,6,7,3,8,9]

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) return;
        
        list.add(node.val);              // 1. Visit the root
        helper(node.left, list);         // 2. Traverse left subtree
        helper(node.right, list);        // 3. Traverse right subtree
    }
}

//Explain

