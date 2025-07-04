// 114. Flatten Binary Tree to Linked List
// Given the root of a binary tree, flatten the tree into a "linked list":
//
// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.
//
//
// Example 1:
//
//
// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]
// Example 2:
//
// Input: root = []
// Output: []
// Example 3:
//
// Input: root = [0]
// Output: [0]
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100
//
// Runtime: 1 ms, faster than 28.61% of Java online submissions for Flatten Binary Tree to Linked List.
// Memory Usage: 38.2 MB, less than 71.51% of Java online submissions for Flatten Binary Tree to Linked List.
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> visitedNodes = new Stack();
        visitedNodes.push(root);
        while(!visitedNodes.isEmpty()) {
            TreeNode current = visitedNodes.pop();
            if (current.right != null) visitedNodes.push(current.right);
            if (current.left != null) visitedNodes.push(current.left);
            current.left = null;
            current.right = visitedNodes.isEmpty() ? null : visitedNodes.peek();
        }
    }
}

// put children into stack
// modify the current node's childern
