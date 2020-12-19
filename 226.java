// 226. Invert Binary Tree
// Invert a binary tree.
//
// Example:
//
// Input:
//
//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
// Output:
//
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
// Trivia:
// This problem was inspired by this original tweet by Max Howell:
//
// Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
// Memory Usage: 36.1 MB, less than 96.56% of Java online submissions for Invert Binary Tree.

class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return root;
    root.left = invertTree(root.left);
    root.right = invertTree(root.right);
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    return root;
  }
}