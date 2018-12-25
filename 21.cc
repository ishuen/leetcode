// 21. Merge Two Sorted Lists
// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//
// Example:
//
// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4

// 8 ms, faster than 89.41%

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
  ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
    if (l1 == NULL) {
    if (l2 == NULL) return NULL;
      return l2;
    } else if (l2 == NULL) {
      return l1;
    }
    ListNode* cur1 = l1;
    ListNode* cur2 = l2;
    ListNode* res;
    if (l1->val > l2->val) {
      res = l2;
      cur2 = cur2->next;
    }
    else {
      res = l1; 
      cur1 = cur1->next;
    }
    ListNode* head = res;
    while(cur1 != NULL && cur2 != NULL) {
      if (cur2->val >= cur1->val) {
        res->next = cur1;
        cur1 = cur1->next;
      } else {
        res->next = cur2;
        cur2 = cur2->next;
      }
      res = res->next;
    }
    if (cur1 != NULL) res->next = cur1;
    else if (cur2 != NULL) res->next = cur2;
    return head;
  }
};