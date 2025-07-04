// 230. Kth Smallest Element in a BST
// Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
//
// Example 1:
// Input: root = [3,1,4,null,2], k = 1
// Output: 1
// Example 2:
// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3
// Constraints:
//
// The number of nodes in the tree is n.
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
// Memory Usage: 39.4 MB, less than 22.86% of Java online submissions for Kth Smallest Element in a BST.
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallest(root, k, list);
        return list.get(k - 1);
    }
    
    public void kthSmallest(TreeNode root, int target, List<Integer> list)  {
        if (root == null) return;
        if (root.left != null) {
            kthSmallest(root.left, target, list);
        }
        list.add(root.val);
        if (root.right != null) {
            kthSmallest(root.right, target, list);
        }
    }
}