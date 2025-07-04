// 203. Remove Linked List Elements
// Remove all elements from a linked list of integers that have value val.
//
// Example:
//
// Input:  1->2->6->3->4->5->6, val = 6
// Output: 1->2->3->4->5

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// 20 ms, faster than 61.82%

class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* prev = head;
        while (prev != NULL && prev -> val == val) {
            prev = prev -> next;
            head = prev;
        }
        ListNode* cur = prev;
        if (prev != NULL) {
            cur = prev -> next;
        }
        while (prev != NULL && cur != NULL) {
            if (cur -> val == val) {
                prev -> next = cur -> next;
            } else {
                prev = prev -> next;
            }
            cur = cur -> next;
        }
        return head;
    }
};