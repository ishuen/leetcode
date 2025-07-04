// 872. Leaf-Similar Trees
//
// Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
//
//
//
// For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
// Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//
//
//
// Example 1:
//
//
// Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
// Output: true
// Example 2:
//
//
// Input: root1 = [1,2,3], root2 = [1,3,2]
// Output: false
//
//
// Constraints:
//
// The number of nodes in each tree will be in the range [1, 200].
// Both of the given trees will have values in the range [0, 200].
//
// Runtime 1 ms Beats 20.82% of users with Java
// Memory 40.73 MB Beats 18.75% of users with Java
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> sequence1 = getSequence(root1);
        List<Integer> sequence2 = getSequence(root2);
        if (sequence1.size() != sequence2.size()) return false;
        for (int i = 0; i < sequence1.size(); i++) {
            if (sequence1.get(i) != sequence2.get(i)) return false;
        }
        return true;
    }
    private List<Integer> getSequence(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> sequence = new ArrayList<>(); 
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left == null && cur.right == null) {
                sequence.add(cur.val);
                continue;
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return sequence;
    }
}