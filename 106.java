// 106. Construct Binary Tree from Inorder and Postorder Traversal
// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
//
// Example 1:
//
//
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]
// Example 2:
//
// Input: inorder = [-1], postorder = [-1]
// Output: [-1]
//
//
// Constraints:
//
// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder and postorder consist of unique values.
// Each value of postorder also appears in inorder.
// inorder is guaranteed to be the inorder traversal of the tree.
// postorder is guaranteed to be the postorder traversal of the tree.
//
// Runtime: 8 ms, faster than 9.54% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
// Memory Usage: 89.9 MB, less than 5.28% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);
        int value = postorder[postorder.length - 1];
        TreeNode newRoot = new TreeNode(value);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value) {
                index = i;
                break;
            }
        }
        newRoot.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        newRoot.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));
        return newRoot;
    }
}
// inorder [left tree + root + right tree]
// postorder [left tree + right tree + root]

// Runtime: 3 ms, faster than 49.67% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
// Memory Usage: 38.8 MB, less than 82.28% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }
    public TreeNode buildTree(int iStart, int iEnd, int pStart, int pEnd, int[] inorder, int[] postorder) {
        if (iStart > iEnd || pStart > pEnd) return null;
        if (iStart == iEnd) return new TreeNode(inorder[iStart]);
        int value = postorder[pEnd];
        TreeNode newRoot = new TreeNode(value);
        int index = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == value) {
                index = i;
                break;
            }
        }
        newRoot.left = buildTree(iStart, index - 1, pStart, pStart + index - iStart - 1, inorder, postorder);
        newRoot.right = buildTree(index + 1, iEnd, pEnd - iEnd + index, pEnd - 1, inorder, postorder);
        return newRoot;
    }
}