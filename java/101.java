// 101. Symmetric Tree
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//
// Example 1:
//
//
// Input: root = [1,2,2,3,4,4,3]
// Output: true
// Example 2:
//
//
// Input: root = [1,2,2,null,3,null,3]
// Output: false
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 1000].
// -100 <= Node.val <= 100
//
//
// Follow up: Could you solve it both recursively and iteratively?

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
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null ^ root.right == null) return false;
        if (root.left == null && root.right == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null ^ right == null) return false;
        if (left == null && right == null) return true;
        if (!isSymmetric(left.left, right.right)) return false;
        if (!isSymmetric(left.right, right.left)) return false;
        return left.val == right.val;
    }
}

// if either left or right is null -> return false
// check left'left vs right's right - recursive
// check left'right vs right's left
// check val