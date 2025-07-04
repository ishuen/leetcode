// 61. Rotate List
// Given a linked list, rotate the list to the right by k places, where k is non-negative.
//
// Example 1:
//
// Input: 1->2->3->4->5->NULL, k = 2
// Output: 4->5->1->2->3->NULL
// Explanation:
// rotate 1 steps to the right: 5->1->2->3->4->NULL
// rotate 2 steps to the right: 4->5->1->2->3->NULL
// Example 2:
//
// Input: 0->1->2->NULL, k = 4
// Output: 2->0->1->NULL
// Explanation:
// rotate 1 steps to the right: 2->0->1->NULL
// rotate 2 steps to the right: 1->2->0->NULL
// rotate 3 steps to the right: 0->1->2->NULL
// rotate 4 steps to the right: 2->0->1->NULL

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

// 8 ms, faster than 98.19%
class Solution {
public:
  ListNode* rotateRight(ListNode* head, int k) {
    if (head == NULL || k == 0) return head;
    ListNode* tail = head;
    int count = 1;
    while (tail->next != NULL) {
      tail = tail->next;
      count++;
    }
    if (k >= count) k = k % count;
    if (k == 0) return head;
    count = count - k - 1;
    tail->next = head;
    ListNode* newHead = head;
    for (int i = 0; i < count; i++) {
      newHead = newHead -> next;
    }
    ListNode* newTail = newHead;
    newHead = newHead -> next;
    newTail -> next = NULL;
    return newHead;
  }
};