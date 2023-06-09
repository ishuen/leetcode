// 951. Flip Equivalent Binary Trees
//
// For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
//
// A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
//
// Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.
//
//
//
// Example 1:
//
// Flipped Trees Diagram
// Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
// Output: true
// Explanation: We flipped at nodes with values 1, 3, and 5.
// Example 2:
//
// Input: root1 = [], root2 = []
// Output: true
// Example 3:
//
// Input: root1 = [], root2 = [1]
// Output: false
//
//
// Constraints:
//
// The number of nodes in each tree is in the range [0, 100].
// Each tree will have unique node values in the range [0, 99].
//
// Runtime 1 ms Beats 5.90%
// Memory 40.1 MB Beats 89.62%
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode cur1 = stack1.pop();
            TreeNode cur2 = stack2.pop();
            if (cur1.val != cur2.val) return false;
            if ((cur1.left != null && cur2.right != null && cur1.left.val == cur2.right.val) || (cur1.right != null && cur2.left != null && cur1.right.val == cur2.left.val)) {
                TreeNode temp = cur2.right;
                cur2.right = cur2.left;
                cur2.left = temp;
            }
            if ((cur1.left == null && cur2.left != null) || (cur1.left != null && cur2.left == null) || (cur1.right == null && cur2.right != null) || (cur1.right != null && cur2.right == null)) return false;
            if (cur1.left != null && cur2.left != null) {
                stack1.push(cur1.left);
                stack2.push(cur2.left);
            }
            if (cur1.right != null && cur2.right != null) {
                stack1.push(cur1.right);
                stack2.push(cur2.right);
            }
        }
        return stack1.size() == stack2.size();
    }
}

// Runtime 0 ms Beats 100%
// Memory 40.3 MB Beats 83.18%
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        if ((root1.left != null && root2.right != null && root1.left.val == root2.right.val) || (root1.right != null && root2.left != null && root1.right.val == root2.left.val)) {
            TreeNode temp = root2.right;
            root2.right = root2.left;
            root2.left = temp;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }
}