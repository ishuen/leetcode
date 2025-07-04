// 1019. Next Greater Node In Linked List
//
// You are given the head of a linked list with n nodes.
//
// For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.
//
// Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.
//
//
//
// Example 1:
//
//
// Input: head = [2,1,5]
// Output: [5,5,0]
// Example 2:
//
//
// Input: head = [2,7,4,3,5]
// Output: [7,0,5,5,0]
//
//
// Constraints:
//
// The number of nodes in the list is n.
// 1 <= n <= 104
// 1 <= Node.val <= 109
//
// Runtime 37 ms Beats 84.14%
// Memory 47.5 MB Beats 15.85%
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
    private class NodeInfo {
        int index;
        int val;
        NodeInfo(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public int[] nextLargerNodes(ListNode head) {
        List<NodeInfo> list = new ArrayList<>();
        Stack<NodeInfo> stack = new Stack<>();
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            while (!stack.isEmpty()) {
                NodeInfo top = stack.peek();
                if (cur.val > top.val) {
                    top.val = cur.val;
                    list.add(top);
                    stack.pop();
                } else {
                    break;
                }
            }
            NodeInfo info = new NodeInfo(index, cur.val);
            stack.push(info);
            cur = cur.next;
            index++;
        }
        int[] ans = new int[list.size() + stack.size()];
        for (int i = 0; i < list.size(); i++) {
            NodeInfo info = list.get(i);
            ans[info.index] = info.val;
        }
        return ans;
    }
}