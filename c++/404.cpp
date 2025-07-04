// 404. Sum of Left Leaves
// Find the sum of all left leaves in a given binary tree.
//
// Example:
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
// There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

// 4 ms, faster than 99.49%
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
  int getSum(TreeNode* root, int curValue, bool left) {
    if (root == NULL) return 0;
    if (root -> left == NULL && root -> right == NULL && left == true) {
      return curValue + root->val;
    }
    return getSum(root->left, curValue, true) + getSum(root->right, curValue, false);
  }

  int sumOfLeftLeaves(TreeNode* root) {
    if (root == NULL) return 0;
    return getSum(root->left, 0, true) + getSum(root->right, 0, false);
  }
};