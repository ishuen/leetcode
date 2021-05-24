// 148. Sort List
// Given the head of a linked list, return the list after sorting it in ascending order.
//
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
//
// Example 1:
// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:
// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
// Example 3:
// Input: head = []
// Output: []
// Constraints:
// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105
//
// Runtime: 340 ms, faster than 5.02% of Java online submissions for Sort List.
// Memory Usage: 43.4 MB, less than 97.55% of Java online submissions for Sort List.
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
    public ListNode sortList(ListNode head) {
        if(head == null){
            return head;
         }
         ListNode dummy = new ListNode();
         ListNode cur = head;
         ListNode pre = dummy;
         ListNode next;
         while(cur != null){
             next = cur.next;
             if (pre.next != null && pre.next.val > cur.val) pre = dummy;
             while(pre.next != null && pre.next.val < cur.val){
                 pre = pre.next;
             }
             cur.next = pre.next;
             pre.next = cur;
             cur = next;
         }
         return dummy.next;
    }
}
// insertion sort

// Runtime: 6 ms, faster than 81.09% of Java online submissions for Sort List.
// Memory Usage: 46.7 MB, less than 78.64% of Java online submissions for Sort List.
public class Solution {
  
  public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode prev = null;
      ListNode slow = head;
      ListNode fast = head;
      while(fast!= null && fast.next!= null) {
          prev = slow;
          slow = slow.next;
          fast = fast.next.next;
      }
      prev.next = null;
      ListNode head1 = sortList(head);
      ListNode head2 = sortList(slow);
      return merge(head1, head2);
  }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode cur = new ListNode();
        ListNode preHead = cur;
        while(head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if(head1 != null) cur.next = head1;
        if(head2 != null) cur.next = head2;
        return preHead.next;
    }
}
// merge sort