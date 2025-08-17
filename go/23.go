// 23. Merge k Sorted Lists

// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

 

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted linked list:
// 1->1->2->3->4->4->5->6
// Example 2:

// Input: lists = []
// Output: []
// Example 3:

// Input: lists = [[]]
// Output: []
 

// Constraints:

// k == lists.length
// 0 <= k <= 104
// 0 <= lists[i].length <= 500
// -104 <= lists[i][j] <= 104
// lists[i] is sorted in ascending order.
// The sum of lists[i].length will not exceed 104.

// Runtime 3 ms Beats 57.50%
// Memory 6.83 MB Beats 53.35%

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeKLists(lists []*ListNode) *ListNode {
    length := len(lists)
    if length == 0 {
        return nil
    } else if length == 1 {
        return lists[0]
    }
    tempList := []*ListNode{}
    for i := 0; i < length / 2; i++ {
        tempList = append(tempList, merge2Lists(lists[i], lists[length - i - 1]))
    }
    if length % 2 == 1 {
        tempList = append(tempList, lists[length / 2])
    }
    return mergeKLists(tempList)
}

func merge2Lists(list1, list2 *ListNode) *ListNode{
    dummyHead := &ListNode{}
    cur := dummyHead
    list1P := list1
    list2P := list2
    for ; list1P != nil && list2P != nil; {
        if list1P.Val < list2P.Val {
            cur.Next = list1P
            list1P = list1P.Next
        } else {
            cur.Next = list2P
            list2P = list2P.Next
        }
        cur = cur.Next
    }
    if list1P != nil {
        cur.Next = list1P
    } else {
        cur.Next = list2P
    }
    return dummyHead.Next
}