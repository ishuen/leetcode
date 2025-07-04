// 725. Split Linked List in Parts
// Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
//
// The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
//
// The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
//
// Return an array of the k parts.
//
//
//
// Example 1:
//
//
// Input: head = [1,2,3], k = 5
// Output: [[1],[2],[3],[],[]]
// Explanation:
// The first element output[0] has output[0].val = 1, output[0].next = null.
// The last element output[4] is null, but its string representation as a ListNode is [].
// Example 2:
//
//
// Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
// Output: [[1,2,3,4],[5,6,7],[8,9,10]]
// Explanation:
// The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
//
//
// Constraints:
//
// The number of nodes in the list is in the range [0, 1000].
// 0 <= Node.val <= 1000
// 1 <= k <= 50
//
// Runtime: 1 ms, faster than 12.89% of Java online submissions for Split Linked List in Parts.
// Memory Usage: 40.8 MB, less than 6.55% of Java online submissions for Split Linked List in Parts.
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode pointer = head;
        ListNode[] list = new ListNode[k];
        int counter = 0;
        while (pointer != null && counter < k) {
            list[counter] = pointer;
            pointer = pointer.next;
            counter++;
        }
        if (counter != k) {
            for (int i = 0; i < counter; i++) {
                list[i].next = null;
            }
            return list;
        }
        while (pointer != null) {
            counter = counter % k;
            for (int i = counter + 1; i < k; i++) {
                list[i] = list[i].next;
            }
            counter++;
            pointer = pointer.next;
        }
        pointer = head;
        counter = 1;
        while (pointer != null && counter < k) {
            if (pointer.next == list[counter]) {
                pointer.next = null;
                pointer = list[counter];
                counter++;
            } else pointer = pointer.next;
        }
        return list;
    }
}

// Runtime: 2 ms, faster than 12.89% of Java online submissions for Split Linked List in Parts.
// Memory Usage: 40.8 MB, less than 8.84% of Java online submissions for Split Linked List in Parts.
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode pointer = head;
        ListNode[] list = new ListNode[k];
        ListNode[] tails = new ListNode[k];
        int counter = 0;
        while (pointer != null && counter < k) {
            list[counter] = pointer;
            tails[counter] = pointer;
            pointer = pointer.next;
            counter++;
        }
        if (counter != k) {
            for (int i = 0; i < counter; i++) {
                list[i].next = null;
            }
            return list;
        }
        while (pointer != null) {
            counter = counter % k;
            if (tails[counter].next != null)
                tails[counter] = tails[counter].next;
            for (int i = counter + 1; i < k; i++) {
                list[i] = list[i].next;
                if (tails[i].next != null)
                    tails[i] = tails[i].next;
            }
            counter++;
            pointer = pointer.next;
        }
        for (int i = 0; i < k; i++) {
            tails[i].next = null;
        }
        return list;
    }
}

