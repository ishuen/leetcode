// 108. Convert Sorted Array to Binary Search Tree
//     Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//     For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//     Example:
//
//     Given the sorted array: [-10,-3,0,5,9],
//
//     One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//           0
//          / \
//        -3   9
//        /   /
//      -10  5
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

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
// Memory Usage: 42.5 MB, less than 5.16% of Java online submissions for Convert Sorted Array to Binary Search Tree.
public class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (Objects.isNull(nums) || nums.length == 0) {
      return null;
    }
    return subtree(nums, 0, nums.length - 1);
  }

  private TreeNode subtree(int[] nums, int start, int end) {
    TreeNode root = null;
    if (start <= end) {
      int mid = (start + end) % 2 == 0 ? (start + end) / 2
              : (start + end) / 2 + 1;
      root = new TreeNode(nums[mid]);
      root.left = subtree(nums, start, mid - 1);
      root.right = subtree(nums, mid + 1, end);
    }
    return root;
  }
}