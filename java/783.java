// 783. Minimum Distance Between BST Nodes
// Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
//
//
//
// Example 1:
//
//
// Input: root = [4,2,6,1,3]
// Output: 1
// Example 2:
//
//
// Input: root = [1,0,48,null,null,12,49]
// Output: 1
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [2, 100].
// 0 <= Node.val <= 105
//
//
// Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Distance Between BST Nodes.
// Memory Usage: 36.7 MB, less than 33.21% of Java online submissions for Minimum Distance Between BST Nodes.
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
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public int minDiffInBST(TreeNode root) {
        
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (prev != null) min = Math.min(min, root.val - prev);
        prev = root.val;
        
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return min;
    }
}