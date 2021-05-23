// 99. Recover Binary Search Tree
// You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
//
// Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
//
// Example 1:
// Input: root = [1,3,null,null,2]
// Output: [3,1,null,null,2]
// Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
// Example 2:
// Input: root = [3,1,4,null,null,2]
// Output: [2,1,4,null,null,3]
// Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
//
//
// Constraints:
// The number of nodes in the tree is in the range [2, 1000].
// -2^31 <= Node.val <= 2^31 - 1
//
// Runtime: 2 ms, faster than 84.31% of Java online submissions for Recover Binary Search Tree.
// Memory Usage: 39.4 MB, less than 43.23% of Java online submissions for Recover Binary Search Tree.
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
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if(first == null && prev.val > root.val) {
                first = prev;
            }
            if (first != null && prev.val > root.val) {
                second = root;
            }
            prev = root;
            inOrder(root.right);
        }
    }
}

// in order traversal --> smallest to the largest
// 2 wrong nodes
