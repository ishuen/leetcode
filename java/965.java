// 965. Univalued Binary Tree
// A binary tree is univalued if every node in the tree has the same value.
//
// Return true if and only if the given tree is univalued.
//
// Example 1:
// Input: [1,1,1,1,1,null,1]
// Output: true
// Example 2:
// Input: [2,2,2,5,2]
// Output: false
//
// Note:
// The number of nodes in the given tree will be in the range [1, 100].
// Each node's value will be an integer in the range [0, 99].
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Univalued Binary Tree.
// Memory Usage: 36.5 MB, less than 54.43% of Java online submissions for Univalued Binary Tree.

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
    public boolean isUnivalTree(TreeNode root) {
        return traverseAndCheck(root.val, root);
    }
    
    private boolean traverseAndCheck(int val, TreeNode node) {
        if (node == null) {
            return true;
        } else if (node.val == val) {
            return traverseAndCheck(val, node.left) && traverseAndCheck(val, node.right);
        }
        return false;
    }
}