// 687. Longest Univalue Path
// Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
//
// The length of the path between two nodes is represented by the number of edges between them.
//
//
//
// Example 1:
//
//
// Input: root = [5,4,5,1,1,5]
// Output: 2
// Example 2:
//
//
// Input: root = [1,4,5,4,4,5]
// Output: 2
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 104].
// -1000 <= Node.val <= 1000
// The depth of the tree will not exceed 1000.
//
// Runtime: 2 ms, faster than 95.36% of Java online submissions for Longest Univalue Path.
// Memory Usage: 64 MB, less than 5.88% of Java online submissions for Longest Univalue Path.
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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        univaluePath(root);
        return max;
    }
    private int univaluePath(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            if (root.left.val == root.val) left = 1 + univaluePath(root.left);
            else univaluePath(root.left);
        }
        if (root.right != null) {
            if (root.right.val == root.val) right = 1 + univaluePath(root.right);
            else univaluePath(root.right);
        }
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}