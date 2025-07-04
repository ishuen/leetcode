// 515. Find Largest Value in Each Tree Row
//
// Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
//
//
//
// Example 1:
//
//
// Input: root = [1,3,2,5,3,null,9]
// Output: [1,3,9]
// Example 2:
//
// Input: root = [1,2,3]
// Output: [1,3]
//
//
// Constraints:
//
// The number of nodes in the tree will be in the range [0, 104].
// -231 <= Node.val <= 231 - 1
//
//
// Runtime 2 ms Beats 63.77%
// Memory 60.68 MB Beats 66.67%
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function largestValues(root: TreeNode | null): number[] {
    let output: number[] = []
    if (!root) return output
    let queue: TreeNode[] = [root]
    while (queue.length > 0) {
        const size = queue.length
        let max = Math.pow(-2, 31)
        for (let i = 0; i < size; i++) {
            let cur = queue.shift()
            if (cur.val > max) {
                max = cur.val
            }
            if (cur.left) {
                queue.push(cur.left)
            }
            if (cur.right) {
                queue.push(cur.right)
            }
        }
        output.push(max)
    }
    return output
};


// Runtime 1 ms Beats 84.06%
// Memory 60.04 MB Beats 86.96%
function largestValues(root: TreeNode | null): number[] {
    let output: number[] = []
    if (!root) return output
    traverse(root, 0, output)
    return output
};

function traverse(current: TreeNode, level: number, output: number[]): void {
    if (level >= output.length) {
        output.push(Number.MIN_SAFE_INTEGER)
    }
    output[level] = Math.max(current.val, output[level])
    if (current.left) {
        traverse(current.left, level + 1, output)
    }
    if (current.right) {
        traverse(current.right, level + 1, output)
    }
}