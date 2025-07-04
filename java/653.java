// 653. Two Sum IV - Input is a BST
// Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
//
//
//
// Example 1:
// Input: root = [5,3,6,2,4,null,7], k = 9
// Output: true
// Example 2:
// Input: root = [5,3,6,2,4,null,7], k = 28
// Output: false
// Example 3:
// Input: root = [2,1,3], k = 4
// Output: true
// Example 4:
// Input: root = [2,1,3], k = 1
// Output: false
// Example 5:
// Input: root = [2,1,3], k = 3
// Output: true

// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -104 <= Node.val <= 104
// root is guaranteed to be a valid binary search tree.
// -105 <= k <= 105


// Runtime: 65 ms, faster than 5.25% of Java online submissions for Two Sum IV - Input is a BST.
// Memory Usage: 40.5 MB, less than 6.06% of Java online submissions for Two Sum IV - Input is a BST.

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return false;
        }
        return checkSum(root.left, root, k) || checkSum(root, root.right, k);
    }
    
    private boolean checkSum(TreeNode left, TreeNode right, int k) {
        if (Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        }
        int sum = left.val + right.val;
        if (sum == k && left != right) {
            return true;
        } else if (sum < k) {
            return checkSum(left, right.right, k) || checkSum(left.right, right, k);
        } else {
            return checkSum(left.left, right, k) || checkSum(left, right.left, k);
        }
    }
    
}

// Runtime: 3 ms, faster than 54.16% of Java online submissions for Two Sum IV - Input is a BST.
// Memory Usage: 40 MB, less than 6.06% of Java online submissions for Two Sum IV - Input is a BST.
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        for (TreeNode cur = root; cur != null; cur = cur.left) {
            left.push(cur);
        }
        for (TreeNode cur = root; cur != null; cur = cur.right) {
            right.push(cur);
        }
        
        while (left.size() > 0 && right.size() > 0 && left.peek() != right.peek()) {
            int sum = left.peek().val + right.peek().val;
            if (sum == k) {
                return true;
            } else if (sum < k) {
                for (TreeNode cur = left.pop().right; cur != null; cur = cur.left) 
                    left.push(cur);
            } else {
                for (TreeNode cur = right.pop().left; cur != null; cur = cur.right)
                    right.push(cur);
            }
        }
        return false;
    }
}