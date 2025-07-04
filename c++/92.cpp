// 92. Reverse Linked List II
// Reverse a linked list from position m to n. Do it in one-pass.
//
// Note: 1 ≤ m ≤ n ≤ length of list.
//
// Example:
//
// Input: 1->2->3->4->5->NULL, m = 2, n = 4
// Output: 1->4->3->2->5->NULL

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

// 0 ms, faster than 100.00% ?!
class Solution {
public:
  ListNode* reverseBetween(ListNode* head, int m, int n) {
    ListNode* cur = head;
    ListNode* original1 = head;
    for (int i = 1; i <= n; i++) {
      if (i == m - 1) {
        original1 = cur;
      }
      cur = cur -> next;
    }
    ListNode* revHead = original1;
    if (m > 1) revHead = revHead -> next;
    ListNode* original2 = cur;
    cur = revHead;
    ListNode* temp = cur -> next;
    while (temp != original2) {
      cur -> next = temp -> next;
      temp -> next = revHead;
      revHead = temp;
      temp = cur -> next;
    }
    if (m == 1) return revHead;
    original1 -> next = revHead;
    return head;
  }
};