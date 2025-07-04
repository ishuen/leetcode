// 889. Construct Binary Tree from Preorder and Postorder Traversal
//
// Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.
//
// If there exist multiple answers, you can return any of them.
//
//
//
// Example 1:
//
//
// Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
// Output: [1,2,3,4,5,6,7]
// Example 2:
//
// Input: preorder = [1], postorder = [1]
// Output: [1]
//
//
// Constraints:
//
// 1 <= preorder.length <= 30
// 1 <= preorder[i] <= preorder.length
// All the values of preorder are unique.
// postorder.length == preorder.length
// 1 <= postorder[i] <= postorder.length
// All the values of postorder are unique.
// It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.
//
// Runtime 1 ms Beats 89.25%
// Memory 43.1 MB Beats 13.59%
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = construct(0, preorder.length -1, 0, postorder.length - 1, preorder, postorder);
        return root;
    }

    private TreeNode construct(int preStart, int preEnd, int postStart, int postEnd, int[] preorder, int[] postorder) {
        if (preStart > preEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) return root;
        int rightIndex = preStart + 1;
        for (int i = preStart + 1; i <= preEnd; i++) {
            if (preorder[i] == postorder[postEnd - 1]) {
                rightIndex = i;
                break;
            }
        }
        root.left = construct(preStart + 1, rightIndex - 1, postStart, rightIndex - preStart - 2 + postStart, preorder, postorder);
        root.right = construct(rightIndex, preEnd, postEnd - 1 - preEnd + rightIndex, postEnd - 1, preorder, postorder);
        return root;
    }
}