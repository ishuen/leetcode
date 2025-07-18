// 117. Populating Next Right Pointers in Each Node II

// Given a binary tree

// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

 

// Example 1:


// Input: root = [1,2,3,4,5,null,7]
// Output: [1,#,2,3,#,4,5,7,#]
// Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
// Example 2:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 6000].
// -100 <= Node.val <= 100
 

// Follow-up:

// You may only use constant extra space.
// The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.

// Runtime 3 ms Beats 56.80%
// Memory 8.17 MB Beats 52.00%

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Next *Node
 * }
 */

func connect(root *Node) *Node {
    if root == nil {
        return root
    }
	arr := []*Node{}
    arr = append(arr, root)
    for ; len(arr) > 0; {
        size := len(arr)
        var next *Node
        next = nil
        for i := 0; i < size; i++ {
            head := arr[0]
            head.Next = next
            next = head
            arr = arr[1:]
            if head.Right != nil {
                arr = append(arr, head.Right)
            }
            if head.Left != nil {
                arr = append(arr, head.Left)
            }
        }
    }
    return root
}


// Runtime 0 ms Beats 100.00%
// Memory 8.55 MB Beats 7.60%
func connect(root *Node) *Node {
    if root == nil {
        return root
    }
    arr := []*Node{}
    arr = append(arr, root)
    for ; len(arr) > 0; {
        size := len(arr)
        var next *Node
        next = nil
        for i := 0; i < size; i++ {
            head := arr[i]
            head.Next = next
            next = head
            if head.Right != nil {
                arr = append(arr, head.Right)
            }
            if head.Left != nil {
                arr = append(arr, head.Left)
            }
        }
        arr = arr[size:]
    }
    return root
}