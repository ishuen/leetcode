// 2. Add Two Numbers
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// Example:
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

// 44 ms, faster than 54.27%
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
  ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    ListNode* head = new ListNode(0);
    int next = 0;
    ListNode* cur = head;
    while(l1 != NULL || l2 != NULL || next > 0) {
      int temp = next;
      if (l1 != NULL) {
        temp = temp + l1->val;
        l1 = l1->next;
      }
      if (l2 != NULL) {
        temp = temp + l2->val;
        l2 = l2->next;
      }
      if (temp < 10) {
        next = 0;
      } else {
        next = 1;
        temp = temp - 10;
      }
      cur->next = new ListNode(temp);
      cur = cur->next;
    }
    return head->next;
  }
};