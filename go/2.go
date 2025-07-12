// 2. Add Two Numbers

// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

// Example 1:


// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
// Example 2:

// Input: l1 = [0], l2 = [0]
// Output: [0]
// Example 3:

// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]
 

// Constraints:

// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading zeros.


// Runtime 0 ms Beats 100.00%
// Memory 6.05 MB Beats 96.94%
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    p1 := l1
    p2 := l2
    proceed := false
    for ; p1 != nil; {
        if proceed == true {
            p1.Val++
            proceed = false
        }
        if p2 != nil {
            fmt.Println(p1.Val, p2.Val)
            p1.Val = p1.Val + p2.Val
            if p1.Val >= 10 {
                proceed = true
                p1.Val = p1.Val - 10
            }
            if p1.Next == nil && (p2.Next != nil || proceed == true) {
                p1.Next = &ListNode{Val: 0}
            }
            p2 = p2.Next
        } else {
            if p1.Val >= 10 {
                proceed = true
                p1.Val = p1.Val - 10
            }
            if p1.Next == nil && proceed == true {
                p1.Next = &ListNode{Val: 1}
                proceed = false
            }
        }
        p1 = p1.Next
    }
    return l1
}