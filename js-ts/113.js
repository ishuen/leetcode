// 113. Path Sum II
// Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
//
// A leaf is a node with no children.
//
// Example 1:
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: [[5,4,11,2],[5,8,4,5]]
// Example 2:
//
//
// Input: root = [1,2,3], targetSum = 5
// Output: []
// Example 3:
//
// Input: root = [1,2], targetSum = 0
// Output: []
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [0, 5000].
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000
//
// Runtime: 96 ms, faster than 70.81% of JavaScript online submissions for Path Sum II.
// Memory Usage: 41.7 MB, less than 74.32% of JavaScript online submissions for Path Sum II.

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function(root, targetSum) {
    let ansList = [];
    checkPath(root, targetSum, [], ansList);
    return ansList;
};

var checkPath = function(root, target, tempList, ansList) {
    if (!root) return;
    if (!root.left && !root.right && root.val == target) {
        tempList.push(root.val);
        ansList.push([...tempList]);
        tempList.pop();
    }
    if (root.left) {
        tempList.push(root.val);
        checkPath(root.left, target - root.val, tempList, ansList);
        tempList.pop();
    }
    if (root.right) {
        tempList.push(root.val);
        checkPath(root.right, target - root.val, tempList, ansList);
        tempList.pop();
    }
}
