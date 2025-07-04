// 23. Merge k Sorted Lists
// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
// Merge all the linked-lists into one sorted linked-list and return it.
//
//
//
// Example 1:
//
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
// Example 2:
//
// Input: lists = []
// Output: []
// Example 3:
//
// Input: lists = [[]]
// Output: []
//
//
// Constraints:
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] is sorted in ascending order.
// The sum of lists[i].length won't exceed 10^4.
//
// Runtime: 3 ms, faster than 80.91% of Java online submissions for Merge k Sorted Lists.
// Memory Usage: 40.9 MB, less than 21.13% of Java online submissions for Merge k Sorted Lists.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> sortingLists = new LinkedList<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) sortingLists.add(lists[i]);
        }
        while(sortingLists.size() > 1) {
            ListNode head1 = sortingLists.remove();
            ListNode head2 = sortingLists.remove();
            sortingLists.add(merge(head1, head2));
        }
        return sortingLists.size() == 1 ? sortingLists.remove() : null;
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode preHead = new ListNode();
        ListNode cur = preHead;
        while(p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 == null) cur.next = p2;
        if (p2 == null) cur.next = p1;
        return preHead.next;
    }
}