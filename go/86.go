// 86. Partition List

// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

 

// Example 1:


// Input: head = [1,4,3,2,5,2], x = 3
// Output: [1,2,2,4,3,5]
// Example 2:

// Input: head = [2,1], x = 2
// Output: [1,2]
 

// Constraints:

// The number of nodes in the list is in the range [0, 200].
// -100 <= Node.val <= 100
// -200 <= x <= 200

// Runtime 0 ms Beats 100.00%
// Memory 4.17 MB Beats 94.07%
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func partition(head *ListNode, x int) *ListNode {
    if head == nil {
        return head
    }
    p1 := &ListNode{}
    p2 := &ListNode{}
    cur1 := p1
    cur2 := p2
    for cur3 := head; cur3 != nil; {
        temp := cur3.Next
        cur3.Next = nil
        if cur3.Val >= x {
            cur2.Next = cur3
            cur2 = cur2.Next
        } else {
            cur1.Next = cur3
            cur1 = cur1.Next
        }
        cur3 = temp
    }
    cur1.Next = p2.Next
    return p1.Next
}