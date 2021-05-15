// 700. Search in a Binary Search Tree
// You are given the root of a binary search tree (BST) and an integer val.
//
// Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
//
// Example 1:
// Input: root = [4,2,7,1,3], val = 2
// Output: [2,1,3]
// Example 2:
// Input: root = [4,2,7,1,3], val = 5
// Output: []
//
// Constraints:
// The number of nodes in the tree is in the range [1, 5000].
// 1 <= Node.val <= 10^7
// root is a binary search tree.
// 1 <= val <= 10^7
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
// Memory Usage: 39.3 MB, less than 74.95% of Java online submissions for Search in a Binary Search Tree.
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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (Objects.nonNull(cur)) {
            if (val == cur.val) return cur;
            else if (val < cur.val) {
                cur = cur.left;
            } else if (val > cur.val) {
                cur = cur.right;
            }
        }
        return cur;
    }
}