


// Runtime: 200 ms, faster than 5.80% of Java online submissions for Convert Sorted List to Binary Search Tree.
// Memory Usage: 44.5 MB, less than 5.26% of Java online submissions for Convert Sorted List to Binary Search Tree.

class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (Objects.isNull(head)) {
     return null;
    }
    int length = getLength(head);
      return subtree(head, 0, length - 1);
    }

    private TreeNode subtree(ListNode head, int start, int end) {
      TreeNode root = null;
      if (start <= end) {
        int mid = (start + end) % 2 == 0 ? (start + end) / 2
               : (start + end) / 2 + 1;
        root = new TreeNode(getNode(head, mid).val);
        root.left = subtree(head, start, mid - 1);
        root.right = subtree(head, mid + 1, end);
      }
      return root;
    }

    private ListNode getNode(ListNode head, int index) {
      for (int i = 0; i < index; i++) {
        head = head.next;
      }
      return head;
    }

    private int getLength(ListNode head) {
      int count = 0;
      while (Objects.nonNull(head)) {
        head = head.next;
        count++;
      }
      return count;
    }
}


// Runtime: 2 ms, faster than 9.48% of Java online submissions for Convert Sorted List to Binary Search Tree.
// Memory Usage: 44.7 MB, less than 5.26% of Java online submissions for Convert Sorted List to Binary Search Tree.
class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (Objects.isNull(head)) {
      return null;
    }
    List<Integer> list = new ArrayList<>();
    ListNode cur = head;
    while (Objects.nonNull(cur)) {
      list.add(cur.val);
      cur = cur.next;
    }
    return subtree(list, 0, list.size() - 1);
  }

  private TreeNode subtree(List list, int start, int end) {
    TreeNode root = null;
    if (start <= end) {
      int mid = (start + end) % 2 == 0 ? (start + end) / 2
              : (start + end) / 2 + 1;
      root = new TreeNode((int)list.get(mid));
      root.left = subtree(list, start, mid - 1);
      root.right = subtree(list, mid + 1, end);
    }
    return root;
  }
}