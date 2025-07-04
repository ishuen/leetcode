// 872. Leaf-Similar Trees
//
// Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
//
//
//
// For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
// Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//
//
//
// Example 1:
//
//
// Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
// Output: true
// Example 2:
//
//
// Input: root1 = [1,2,3], root2 = [1,3,2]
// Output: false
//
//
// Constraints:
//
// The number of nodes in each tree will be in the range [1, 200].
// Both of the given trees will have values in the range [0, 200].
//
// Runtime 91 ms Beats 5.02% of users with JavaScript
// Memory 45.14 MB Beats 7.42% of users with JavaScript

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var leafSimilar = function(root1, root2) {
    let stack1 = [root1];
    let stack2 = [root2];
    while (stack1.length && stack2.length) {
        let node1 = findNextLeaf(stack1);
        let node2 = findNextLeaf(stack2);
        console.log(node1, node2);
        if (node1.val != node2.val) return false;
    }
    if (stack1.length) return false;
    if (stack2.length) return false;
    return true;
};

const findNextLeaf = function(stack) {
    while (stack && (stack[0].left || stack[0].right)) {
        let top = stack.shift();
        if (top.right) {
            stack.unshift(top.right);
        }
        if (top.left) {
            stack.unshift(top.left);
        }
    }
    return stack.shift();
};


// Runtime 61 ms Beats 43.57% of users with JavaScript
// Memory 43.73 MB Beats 95.30% of users with JavaScript
var leafSimilar = function(root1, root2) {
    let list1 = findLeaves(root1);
    let list2 = findLeaves(root2);
    if (list1.length != list2.length) return false;
    for (let i = 0; i < list1.length; i++) {
        if (list1[i].val != list2[i].val) return false;
    }
    return true;
};

const findLeaves = function(root) {
    let list = [];
    if (!root) return list;
    if (!root.left && !root.right) {
        list.push(root);
    } else {
        list.push(...findLeaves(root.left));
        list.push(...findLeaves(root.right));
    }
    return list;
};