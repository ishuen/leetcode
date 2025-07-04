// 83. Remove Duplicates from Sorted List
// Given a sorted linked list, delete all duplicates such that each element appear only once.
//
// Example 1:
//
// Input: 1->1->2
// Output: 1->2
// Example 2:
//
// Input: 1->1->2->3->3
// Output: 1->2->3

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

// 8 ms, faster than 98.32%
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* temp = head;
        ListNode* temp2;
        if (temp != NULL) temp2 = temp->next;
        while (temp != NULL && temp2 != NULL) {
            if (temp->val == temp2->val) {
                temp2 = temp2->next;
                temp->next = temp2;
            } else {
                temp = temp2;
                temp2 = temp2->next;
            }
        }
        return head;
    }
};