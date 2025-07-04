// 530. Minimum Absolute Difference in BST
//
// Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
//
//
//
// Example 1:
//
//
// Input: root = [4,2,6,1,3]
// Output: 1
// Example 2:
//
//
// Input: root = [1,0,48,null,null,12,49]
// Output: 1
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [2, 104].
// 0 <= Node.val <= 105
//
// Runtime 3 ms Beats 19.32%
// Memory 43.4 MB Beats 26.93%
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
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            min = Math.min(min, getNearest(cur));
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return min;
    }

    private int getNearest(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            min = Math.min(root.val - cur.val, min);
        }
        if (root.right != null) {
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            min = Math.min(cur.val - root.val, min);
        }
        return min;
    }
}

// Runtime 1 ms Beats 59.21%
// Memory 43.1 MB Beats 52.37%
class Solution {
    private int prev = Integer.MAX_VALUE;
    private int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root.left != null) {
            getMinimumDifference(root.left);
        }
        min = Math.min(min, Math.abs(root.val - prev));
        prev = root.val;
        if (root.right != null) {
            getMinimumDifference(root.right);
        }
        return min;
    }
}