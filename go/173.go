// 173. Binary Search Tree Iterator

// Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

// BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
// boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
// int next() Moves the pointer to the right, then returns the number at the pointer.
// Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

// You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

 

// Example 1:


// Input
// ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
// [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
// Output
// [null, 3, 7, true, 9, true, 15, true, 20, false]

// Explanation
// BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
// bSTIterator.next();    // return 3
// bSTIterator.next();    // return 7
// bSTIterator.hasNext(); // return True
// bSTIterator.next();    // return 9
// bSTIterator.hasNext(); // return True
// bSTIterator.next();    // return 15
// bSTIterator.hasNext(); // return True
// bSTIterator.next();    // return 20
// bSTIterator.hasNext(); // return False
 

// Constraints:

// The number of nodes in the tree is in the range [1, 105].
// 0 <= Node.val <= 106
// At most 105 calls will be made to hasNext, and next.
 

// Follow up:

// Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?

// Runtime 11 ms Beats 6.70%
// Memory 10.85 MB Beats 52.23%

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
type BSTIterator struct {
    currentIndex int
    toVisit []*TreeNode
}

func Constructor(root *TreeNode) BSTIterator {
    toVisit := []*TreeNode{}
    var dfs func(root *TreeNode)
    dfs = func (root *TreeNode) {
        if root == nil {
            return 
        }
        dfs(root.Left)
        toVisit = append(toVisit, root)
        dfs(root.Right)
    }
    dfs(root)
    return BSTIterator{currentIndex: 0, toVisit: toVisit}
}


func (this *BSTIterator) Next() int {
    cur := this.currentIndex
    this.currentIndex++
    return this.toVisit[cur].Val
}


func (this *BSTIterator) HasNext() bool {
    return this.currentIndex < len(this.toVisit)
}


// Runtime 0 ms Beats 100.00%
// Memory 14.20 MB Beats 5.80%

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
type BSTIterator struct {
    pointer *TreeNode
}

func Constructor(root *TreeNode) BSTIterator {
    dummy := &TreeNode{ Val: -1}
    cur := dummy
    var dfs func(root *TreeNode)
    dfs = func (root *TreeNode) {
        if root == nil {
            return 
        }
        dfs(root.Left)
        root.Left = nil
        cur.Right = root
        cur = cur.Right
        dfs(root.Right)
    }
    dfs(root)
    return BSTIterator{pointer: dummy.Right}
}


func (this *BSTIterator) Next() int {
    if this.pointer == nil {
        return 0
    }
    val := this.pointer.Val
    this.pointer = this.pointer.Right
    return val
}


func (this *BSTIterator) HasNext() bool {
    return this.pointer != nil
}
