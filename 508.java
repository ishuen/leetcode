// 508. Most Frequent Subtree Sum
// Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.
//
// The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
//
//
//
// Example 1:
//
//
// Input: root = [5,2,-3]
// Output: [2,-3,4]
// Example 2:
//
//
// Input: root = [5,2,-5]
// Output: [2]
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 104].
// -105 <= Node.val <= 105
//
// Runtime: 3 ms, faster than 95.41% of Java online submissions for Most Frequent Subtree Sum.
// Memory Usage: 39.2 MB, less than 87.54% of Java online submissions for Most Frequent Subtree Sum.
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
    Map<Integer, Integer> occurrance;
    public int[] findFrequentTreeSum(TreeNode root) {
        occurrance = new HashMap<>();
        getSum(root);
        List<Integer> sums = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : occurrance.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                sums.clear();
                sums.add(entry.getKey());
            } else if (entry.getValue() == max) {
                sums.add(entry.getKey());
            }
        }
        int[] ans = new int[sums.size()];
        for (int i = 0; i < sums.size(); i++) {
            ans[i] = sums.get(i);
        }
        return ans;
    }
    public int getSum(TreeNode root) {
        if (root == null) return 0;
        int sum = getSum(root.left) + getSum(root.right) + root.val;
        occurrance.put(sum, occurrance.getOrDefault(sum, 0) + 1);
        return sum;
    }
}


