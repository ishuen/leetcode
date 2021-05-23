// 98. Validate Binary Search Tree
// Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//
// A valid BST is defined as follows:
//
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
//
//
// Example 1:
//
//
// Input: root = [2,1,3]
// Output: true
// Example 2:
//
//
// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 104].
// -2^31 <= Node.val <= 2^31 - 1
//
// Runtime: 3 ms, faster than 5.40% of Java online submissions for Validate Binary Search Tree.
// Memory Usage: 41 MB, less than 5.04% of Java online submissions for Validate Binary Search Tree.
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}

// in order traversal


// Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
// Memory Usage: 39 MB, less than 8.19% of Java online submissions for Validate Binary Search Tree.
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
// pre order
