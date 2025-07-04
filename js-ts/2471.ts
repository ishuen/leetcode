// 2471. Minimum Number of Operations to Sort a Binary Tree by Level
//
// You are given the root of a binary tree with unique values.
//
// In one operation, you can choose any two nodes at the same level and swap their values.
//
// Return the minimum number of operations needed to make the values at each level sorted in a strictly increasing order.
//
// The level of a node is the number of edges along the path between it and the root node.
//
//
//
// Example 1:
//
//
// Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
// Output: 3
// Explanation:
// - Swap 4 and 3. The 2nd level becomes [3,4].
// - Swap 7 and 5. The 3rd level becomes [5,6,8,7].
// - Swap 8 and 7. The 3rd level becomes [5,6,7,8].
// We used 3 operations so return 3.
// It can be proven that 3 is the minimum number of operations needed.
// Example 2:
//
//
// Input: root = [1,3,2,7,6,5,4]
// Output: 3
// Explanation:
// - Swap 3 and 2. The 2nd level becomes [2,3].
// - Swap 7 and 4. The 3rd level becomes [4,6,5,7].
// - Swap 6 and 5. The 3rd level becomes [4,5,6,7].
// We used 3 operations so return 3.
// It can be proven that 3 is the minimum number of operations needed.
// Example 3:
//
//
// Input: root = [1,2,3,4,5,6]
// Output: 0
// Explanation: Each level is already sorted in increasing order so return 0.
//
//
// Constraints:
//
// The number of nodes in the tree is in the range [1, 105].
// 1 <= Node.val <= 105
// All the values of the tree are unique.

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

// Runtime 1168 ms Beats 43.48%
// Memory 98.82 MB Beats 82.61%
function minimumOperations(root: TreeNode | null): number {
    let queue: TreeNode[] = new Array()
    queue.push(root)
    let count = 0
    while (queue.length > 0) {
        let size = queue.length
        let values: number[] = new Array()
        for (let i = 0; i < size; i++) {
            let node = queue.shift()
            values.push(node.val)
            if (node.left) queue.push(node.left)
            if (node.right) queue.push(node.right)
        }
        count = count + swapOperation(values)
    }
    return count
};

function swapOperation(values: number[]): number {
    let count = 0
    for (let i = 0; i < values.length; i++) {
        let min = values[i]
        let minIndex = i
        for (let j = i + 1; j < values.length; j++) {
            if (min > values[j]) {
                min = values[j]
                minIndex = j
            }
        }
        if (min != values[i]) {
            count++
            let temp = values[i]
            values[i] = min
            values[minIndex] = temp
        }
    }
    return count
}



// Runtime 751 ms Beats 65.22%
// Memory 104.69 MB Beats 21.74%
function minimumOperations(root: TreeNode | null): number {
    let queue: TreeNode[] = new Array()
    queue.push(root)
    let count = 0
    while (queue.length > 0) {
        let size = queue.length
        let values: number[] = new Array()
        for (let i = 0; i < size; i++) {
            let node = queue.shift()
            values.push(node.val)
            if (node.left) queue.push(node.left)
            if (node.right) queue.push(node.right)
        }
        count = count + swapOperation(values)
    }
    return count
};

function swapOperation(values: number[]): number {
    let count = 0
    let sorted = [...values].sort((a, b) => a - b)
    const map = new Map()
    for (let i = 0; i < values.length; i++) {
        map.set(values[i], i)
    }
    for (let i = 0; i < values.length; i++) {
        if (sorted[i] !== values[i]) {
            const curPosition = map.get(sorted[i])
            count++
            values[curPosition] = values[i]
            values[i] = sorted[i]
            map.set(values[curPosition], curPosition)
        }
    }
    return count
}


// Runtime 699 ms Beats 65.22%
// Memory 98.18 MB Beats 91.30%
type nodeInfo = {
    value: number
    index: number
}
function minimumOperations(root: TreeNode | null): number {
    let queue: TreeNode[] = new Array()
    queue.push(root)
    let count = 0
    while (queue.length > 0) {
        let size = queue.length
        let values: nodeInfo[] = new Array()
        for (let i = 0; i < size; i++) {
            let node = queue.shift()
            values.push({value: node.val, index: i})
            if (node.left) queue.push(node.left)
            if (node.right) queue.push(node.right)
        }
        count = count + swapOperation(values)
    }
    return count
};

function swapOperation(info: nodeInfo[]): number {
    let count = 0
    info.sort((a, b) => a.value - b.value)
    for (let i = 0; i < info.length; i++) {
        while (info[i].index !== i) {
            const originalIndex = info[i].index
            info[i].index = info[originalIndex].index
            info[originalIndex].index = originalIndex
            count++
        }
    }
    return count
}
