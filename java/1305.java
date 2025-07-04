// 1305. All Elements in Two Binary Search Trees
//
// Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.
//
//
//
// Example 1:
//
//
// Input: root1 = [2,1,4], root2 = [1,0,3]
// Output: [0,1,1,2,3,4]
// Example 2:
//
//
// Input: root1 = [1,null,8], root2 = [8,1]
// Output: [1,1,8,8]
//
//
// Constraints:
//
// The number of nodes in each tree is in the range [0, 5000].
// -105 <= Node.val <= 105
//
// Runtime 15ms Beats 88.96%of users with Java
// Memory 45.18MB Beats 64.36%of users with Java
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> leftList = new ArrayList<>();
        getList(root1, leftList);
        List<Integer> rightList = new ArrayList<>();
        getList(root2, rightList);
        int left = 0;
        int right = 0;
        List<Integer> output = new ArrayList<>();
        while (left < leftList.size() && right < rightList.size()) {
            int l = leftList.get(left);
            int r = rightList.get(right);
            if (l <= r) {
                output.add(l);
                left++;
            } else {
                output.add(r);
                right++;
            }
        }
        while (left < leftList.size()) {
            output.add(leftList.get(left));
            left++;
        }
        while (right < rightList.size()) {
            output.add(rightList.get(right));
            right++;
        }
        return output;
    }

    private void getList(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) {
            getList(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            getList(root.right, list);
        } 
    }
}

// Runtime 19ms Beats 37.61%of users with Java
// Memory 44.21MB Beats 99.44%of users with Java
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> output = new ArrayList<>();
        while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }
            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().val <= stack2.peek().val)) {
                root1 = stack1.pop();
                output.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = stack2.pop();
                output.add(root2.val);
                root2 = root2.right;
            }
        }
        return output;
    }
}