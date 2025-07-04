// 543. Diameter of Binary Tree
// Given the root of a binary tree, return the length of the diameter of the tree.
//
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
// The length of a path between two nodes is represented by the number of edges between them.
//
//
//
// Example 1:
//
//
// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
// Example 2:
//
// Input: root = [1,2]
// Output: 1
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 104].
// -100 <= Node.val <= 100
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
// Memory Usage: 40.6 MB, less than 7.34% of Java online submissions for Diameter of Binary Tree.
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
    int maxDepth;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxDepth = 0;
        int depth = 0;
        if (root.left != null) {
            depth = 1 + getDepth(root.left);
        }
        if (root.right != null) {
            depth = depth + 1 + getDepth(root.right);
        }
        return Math.max(depth, maxDepth);
    }
    
    private int getDepth(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = 1 + getDepth(root.left);
        }
        if (root.right != null) {
            right = 1 + getDepth(root.right);
        }
        if (left + right > maxDepth) maxDepth = left + right;
        return Math.max(left, right);
    }
}