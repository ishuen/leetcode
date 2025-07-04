// 1315. Sum of Nodes with Even-Valued Grandparent
//
// Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.
//
// A grandparent of a node is the parent of its parent if it exists.
//
//
//
// Example 1:
//
//
// Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
// Output: 18
// Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
// Example 2:
//
//
// Input: root = [1]
// Output: 0
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 104].
// 1 <= Node.val <= 100
//
// Runtime 6 ms Beats 16.83% of users with Java
// Memory 44.92 MB Beats 13.17% of users with Java
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
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (cur.val % 2 == 0) {
                    sum = sum + sumGrandChildren(cur);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return sum;
    }

    private int sumGrandChildren(TreeNode root) {
        int sum = 0;
        if (root.left != null) {
            TreeNode left = root.left;
            if (left.left != null) {
                sum = sum + left.left.val;
            }
            if (left.right != null) {
                sum = sum + left.right.val;
            }
        }
        if (root.right != null) {
            TreeNode right = root.right;
            if (right.left != null) {
                sum = sum + right.left.val;
            }
            if (right.right != null) {
                sum = sum + right.right.val;
            }
        }
        return sum;
    }
}


// Runtime 1 ms Beats 100.00% of users with Java
// Memory 44.57 MB Beats 27.68% of users with Java
class Solution {
    private int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        sumGrandChildren(root);
        return sum;
    }

    private void sumGrandChildren(TreeNode root) {
        if (root == null) return;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                TreeNode left = root.left;
                if (left.left != null) {
                    sum = sum + left.left.val;
                }
                if (left.right != null) {
                    sum = sum + left.right.val;
                }
            }
            if (root.right != null) {
                TreeNode right = root.right;
                if (right.left != null) {
                    sum = sum + right.left.val;
                }
                if (right.right != null) {
                    sum = sum + right.right.val;
                }
            }
        }
        sumGrandChildren(root.left);
        sumGrandChildren(root.right); 
    }
}
