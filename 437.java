// 437. Path Sum III
// Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
//
// The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
//
//
//
// Example 1:
//
//
// Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
// Output: 3
// Explanation: The paths that sum to 8 are shown.
// Example 2:
//
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: 3
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 1000].
// -109 <= Node.val <= 109
// -1000 <= targetSum <= 1000
//
// Runtime: 23 ms, faster than 15.33% of Java online submissions for Path Sum III.
// Memory Usage: 45.6 MB, less than 6.24% of Java online submissions for Path Sum III.
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
    private int count;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        count = 0;
        pathSum(root, new ArrayList<>(), targetSum);
        return count;
    }
    
    public void pathSum(TreeNode root, List<Integer> list, int target) {
        if (root.val == target) count++;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            num = num + root.val;
            if (num == target) count++;
            list.set(i, num);
        }
        list.add(root.val);
        if (root.left != null) pathSum(root.left, new ArrayList<>(list), target);
        if (root.right != null) pathSum(root.right, list, target);
    }
}

// Runtime: 22 ms, faster than 23.67% of Java online submissions for Path Sum III.
// Memory Usage: 38.9 MB, less than 59.19% of Java online submissions for Path Sum III.
public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return pathSumFrom(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) 
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}