// 105. Construct Binary Tree from Preorder and Inorder Traversal
//
// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
//
//
//
// Example 1:
//
//
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Example 2:
//
// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
//
//
// Constraints:
//
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.
//
//
// Runtime: 3 ms, faster than 48.18% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
// Memory Usage: 38.5 MB, less than 95.35% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.

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
    private int[] inorder;
    private int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        return buildTree(0, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int preStart, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > inorder.length - 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int splitPoint = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[preStart]) {
                splitPoint = i;
                break;
            }
        }
        root.left = buildTree(preStart + 1, inStart, splitPoint - 1);
        root.right = buildTree(preStart + splitPoint - inStart + 1, splitPoint + 1, inEnd);
        return root;
    }
}

