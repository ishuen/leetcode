// 993. Cousins in Binary Tree
//   In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//
//   Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
//
//   We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
//
//   Return true if and only if the nodes corresponding to the values x and y are cousins.
//     Example 1:
//
//
//     Input: root = [1,2,3,4], x = 4, y = 3
//     Output: false
//     Example 2:
//
//
//     Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
//     Output: true
//     Example 3:
//
//
//
//     Input: root = [1,2,3,null,4], x = 2, y = 3
//     Output: false
//
//
//     Constraints:
//
//     The number of nodes in the tree will be between 2 and 100.
//     Each node has a unique integer value from 1 to 100.
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Cousins in Binary Tree.
// Memory Usage: 36.7 MB, less than 63.92% of Java online submissions for Cousins in Binary Tree.
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
  public boolean isCousins(TreeNode root, int x, int y) {
    Queue<TreeNode> sameLayer = new LinkedList<>();
    sameLayer.add(root);
    boolean foundX = false;
    boolean foundY = false;
    while(!sameLayer.isEmpty()) {
      int len = sameLayer.size();
      for (int i = 0; i < len; i++) {
        TreeNode temp = sameLayer.poll();
        if (temp.val == x) {
          foundX = true;
        } else if (temp.val == y) {
          foundY = true;
        }
        if (temp.left != null && temp.right != null) {
          if (temp.left.val == x && temp.right.val == y || temp.left.val == y && temp.right.val == x) {
            return false;
          }
        }
        if (temp.left != null) {
          sameLayer.add(temp.left);
        }
        if (temp.right != null) {
          sameLayer.add(temp.right);
        }
        if (foundX && foundY) {
          return true;
        }
      }
      foundX = false;
      foundY = false;
    }
    return false;
  }
}