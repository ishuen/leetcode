// 617. Merge Two Binary Trees
//   Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
//
//   You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
//
//   Example 1:
//
//   Input:
//     Tree 1                     Tree 2
//             1                         2
//            / \                       / \
//           3   2                     1   3
//          /                           \   \
//         5                             4   7
//   Output:
//   Merged tree:
//          3
//         / \
//        4   5
//       / \   \
//      5   4   7
//
//
//   Note: The merging process must start from the root nodes of both trees.

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Binary Trees.
// Memory Usage: 39.1 MB, less than 17.56% of Java online submissions for Merge Two Binary Trees.

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return checkNode(t1, t2);
    }
    
  private TreeNode checkNode(TreeNode t1, TreeNode t2) {
    if (Objects.isNull(t1)) {
      return t2;
    }
    if (Objects.isNull(t2)) {
      return t1;
    }
    TreeNode node = new TreeNode(t1.val + t2.val);
    node.left = checkNode(t1.left, t2.left);
    node.right = checkNode(t1.right, t2.right);
    return node;
  }
}