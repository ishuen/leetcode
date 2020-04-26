// 104. Maximum Depth of Binary Tree
// Given a binary tree, find its maximum depth.
//
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its depth = 3.

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
// Memory Usage: 40.9 MB, less than 5.38% of Java online submissions for Maximum Depth of Binary Tree.

public class Solution {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */
  public int maxDepth(TreeNode root) {
    if (Objects.isNull(root)) {
      return 0;
    }
    return Math.max(checkLeaf(root.left), checkLeaf(root.right));
  }

  private int checkLeaf(TreeNode root) {
    if (Objects.isNull(root)) {
      return 1;
    }
    return 1 + Math.max(checkLeaf(root.right), checkLeaf(root.left));
  }
}