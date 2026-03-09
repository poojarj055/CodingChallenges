// You are given a root binary search tree and an integer x . Your task is to find the Ceil of x in the tree.
// Note: Ceil(x) is a number that is either equal to x or is immediately greater than x.
// If Ceil could not be found, return -1.

// Examples:

// Input: root = [5, 1, 7, N, 2, N, N, N, 3], x = 3

// Output: 3
// Explanation: We find 3 in BST, so ceil of 3 is 3.
// Input: root = [10, 5, 11, 4, 7, N, N, N, N, N, 8], x = 6

// Output: 7
// Explanation: We find 7 in BST, so ceil of 6 is 7.
// Constraints:
// 1  ≤ Number of nodes  ≤ 105
// 1  ≤ Value of nodes ≤ 105

/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

//iterative solution
class Solution {
    int findCeil(Node root, int x) {
        // code here
       int ceil = -1;  // -1 indicates no ceiling found yet

        while (root != null) {
            // If root itself is ceil
            if (root.data == x) {
                return root.data;
            }

            // If root's data is smaller, 
            // ceil must be in the right subtree
            if (x > root.data) {
                root = root.right;
            } 
            // Else either root can be ceil 
            // or a node in the left child
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}

//recursive solution

public class GfG {
    
    static int findCeil(Node root, int x) {
      
        // Base case
        if (root == null) {
            return -1;
        }

        // We found equal key
        if (root.key == x) {
            return root.key;
        }

        // If root's key is smaller, 
        // ceil must be in the right subtree
        if (root.key < x) {
            return findCeil(root.right, x);
        }

        // Else, either left subtree or root
        // has the ceil value
        int ceil = findCeil(root.left, x);
        return (ceil >= x) ? ceil : root.key;
    }

///
