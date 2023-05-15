// 421. Maximum XOR of Two Numbers in an Array
// Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
//
//
//
// Example 1:
//
// Input: nums = [3,10,5,25,2,8]
// Output: 28
// Explanation: The maximum result is 5 XOR 25 = 28.
// Example 2:
//
// Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
// Output: 127
//
//
// Constraints:
//
// 1 <= nums.length <= 2 * 105
// 0 <= nums[i] <= 231 - 1
//
// Runtime 388 ms Beats 90.6%
// Memory 105.9 MB Beats 65.1%
class Solution {
    public class Trie {
        public Node root;
        public Trie() {
            root = new Node();
        }
        public void insert(int val) {
            Node cur = root;
            int bit = 30;
            while(bit >= 0) {
                int refBit = 1 << bit;
                int curBit = (refBit & val) > 0 ? 1 : 0;
                if (curBit == 1) {
                    if (cur.right == null) {
                        cur.right = new Node();
                    }
                    cur = cur.right;
                } else {
                    if (cur.left == null) {
                        cur.left = new Node();
                    }
                    cur = cur.left;
                }
                bit--;
            }
        }
        public int findSimilar(int val) {
            Node cur = root;
            int bit = 30;
            int ans = 0;
            while(bit >= 0) {
                int refBit = 1 << bit;
                int curBit = (refBit & val) > 0 ? 1 : 0;
                if (curBit == 0) {
                    if (cur.left == null) {
                        cur = cur.right;
                        ans = ans + refBit;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if (cur.right == null) {
                        cur = cur.left;
                    } else {
                        cur = cur.right;
                        ans = ans + refBit;
                    }
                }
                bit--;
            }
            return ans;
        }
    }

    public class Node {
        public Node left;
        public Node right;
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num: nums) {
            trie.insert(num);
        }
        int max = 0;
        for (int num: nums) {
            max = Math.max(max, num ^ trie.findSimilar(Integer.MAX_VALUE ^ num));
        }
        return max;
    }
}