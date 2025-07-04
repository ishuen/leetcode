// 988. Smallest String Starting From Leaf
//
// You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.
//
// Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
//
// As a reminder, any shorter prefix of a string is lexicographically smaller.
//
// For example, "ab" is lexicographically smaller than "aba".
// A leaf of a node is a node that has no children.
//
//
//
// Example 1:
//
//
// Input: root = [0,1,2,3,4,3,4]
// Output: "dba"
// Example 2:
//
//
// Input: root = [25,1,3,1,3,0,2]
// Output: "adz"
// Example 3:
//
//
// Input: root = [2,2,1,null,1,0,null,0]
// Output: "abc"
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 8500].
// 0 <= Node.val <= 25

// Runtime 1 ms Beats 100%
// Memory 44.1 MB Beats 11.15%
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
    public String smallestFromLeaf(TreeNode root) {
        getSmallestFromLeaf(root, new StringBuilder());
        return ans;
    }
    private String ans = "~";
    private void getSmallestFromLeaf(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        char c = (char) (root.val + 'a');
        sb = sb.append(c);
        if (root.left == null && root.right == null) {
            sb.reverse();
            String reversedString = sb.toString();
            if (reversedString.compareTo(ans) < 0) {
                ans = reversedString;
            }
            sb.reverse();
        }
        getSmallestFromLeaf(root.left, sb);
        getSmallestFromLeaf(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}