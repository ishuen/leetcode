// 655. Print Binary Tree
// Given the root of a binary tree, construct a 0-indexed m x n string matrix res that represents a formatted layout of the tree. The formatted layout matrix should be constructed using the following rules:
//
// The height of the tree is height and the number of rows m should be equal to height + 1.
// The number of columns n should be equal to 2height+1 - 1.
// Place the root node in the middle of the top row (more formally, at location res[0][(n-1)/2]).
// For each node that has been placed in the matrix at position res[r][c], place its left child at res[r+1][c-2height-r-1] and its right child at res[r+1][c+2height-r-1].
// Continue this process until all the nodes in the tree have been placed.
// Any empty cells should contain the empty string "".
// Return the constructed matrix res.
//
//
//
// Example 1:
//
//
// Input: root = [1,2]
// Output:
// [["","1",""],
//  ["2","",""]]
// Example 2:
//
//
// Input: root = [1,2,3,null,4]
// Output:
// [["","","","1","","",""],
//  ["","2","","","","3",""],
//  ["","","4","","","",""]]
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 210].
// -99 <= Node.val <= 99
// The depth of the tree will be in the range [1, 10].
//
// Runtime: 1 ms, faster than 99.64% of Java online submissions for Print Binary Tree.
// Memory Usage: 39.2 MB, less than 69.12% of Java online submissions for Print Binary Tree.
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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        int row = getHeight(root);
        int col = (int) Math.pow(2, row) - 1;
        List<String> initRow = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            initRow.add("");
        }
        for (int i = 0; i < row; i++) {
            ans.add(new ArrayList<>(initRow));
        }
        traverse(root, 0, col - 1, 0, row, ans);
        return ans;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    
    private void traverse(TreeNode root, int left, int right, int curRow, int row, List<List<String>> ans) {
        ans.get(curRow).set((left + right) / 2, String.valueOf(root.val));
        if (root.left != null) traverse(root.left, left, (left + right) / 2 - 1, curRow + 1, row, ans);
        if (root.right != null) traverse(root.right, (left + right) / 2 + 1, right, curRow + 1, row, ans);
    }
}

// first get the height
// use the formula to calculate the col num -> init empty strings
// traverse the tree again
// replace empty strings with value

