// 107. Binary Tree Level Order Traversal II
// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
//
// [
//   [15,7],
//   [9,20],
//   [3]
// ]
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
 * @return {number[][]}
 */

// Runtime: 104 ms, faster than 8.04% of JavaScript online submissions for Binary Tree Level Order Traversal II.
// Memory Usage: 39.7 MB, less than 98.74% of JavaScript online submissions for Binary Tree Level Order Traversal II.
var levelOrderBottom = function(root) {
    if (root == null) return [];
    let ans = {
        record: [[root]],
        result: [[root.val]]
    };
    traverse(ans);
    return ans.result;
};

function traverse(ans) {
    let temp = ans.record[0];
    let curLevel = [];
    let curList = [];
    temp.forEach(x => {
        if (x.left) {
            curLevel.push(x.left);
            curList.push(x.left.val);
        }
        if (x.right) {
            curLevel.push(x.right);
            curList.push(x.right.val);
        }
    });
    if (curLevel.length == 0) return ans;
    ans.record.unshift(curLevel);
    ans.result.unshift(curList);
    if (curLevel.length > 0) return traverse(ans);
}

// Runtime: 80 ms, faster than 85.02% of JavaScript online submissions for Binary Tree Level Order Traversal II.
// Memory Usage: 43.4 MB, less than 5.36% of JavaScript online submissions for Binary Tree Level Order Traversal II.
var levelOrderBottom = function(root) {
    return root == null ? [] : traverse([root]);
};

function traverse(nodes) {
    if (nodes.length === 0) return [];
    let children = [];
    nodes.forEach(n => {
        if(n.left){
            children.push(n.left);
        }
        if(n.right) {
            children.push(n.right);
        }
    })
    return [...traverse(children), nodes.map(x => x.val)]
}