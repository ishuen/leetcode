// 101. Symmetric Tree
// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//       1
//      / \
//     2   2
//    / \ / \
//   3  4 4  3
// But the following [1,2,2,null,3,null,3] is not:
//       1
//      / \
//     2   2
//      \   \
//      3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// 8 ms, faster than 24.05%
class Solution {
public:
  bool isSymmetric(TreeNode* root) {
    if (root == NULL) return true;
      return isOpposing(root->left, root->right);
  }
  bool isOpposing(TreeNode* left, TreeNode* right) {
    if (left == NULL) {
      if (right == NULL) return true;
      else return false;
    } else {
      if (right == NULL) return false;
    }
    if (left->val != right->val) return false;
    if(!isOpposing(left->left, right->right)) return false;
    if(!isOpposing(left->right, right->left)) return false;
    return true;
  }
};

// 4 ms, faster than 99.12%
class Solution {
public:
  bool isSymmetric(TreeNode* root) {
    if (root == NULL) return true;
    return isOpposing(root->left, root->right);
  }
  bool isOpposing(TreeNode* left, TreeNode* right) {
    if (left == NULL) {
      if (right == NULL) return true;
      else return false;
    }
    if (right == NULL) return false;
    if (left->val != right->val) return false;
    return isOpposing(left->left, right->right) && isOpposing(left->right, right->left);
  }
};