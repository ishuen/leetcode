// 316. Remove Duplicate Letters
// Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
//
//
//
// Example 1:
//
// Input: s = "bcabc"
// Output: "abc"
// Example 2:
//
// Input: s = "cbacdcbc"
// Output: "acdb"
//
//
// Constraints:
//
// 1 <= s.length <= 104
// s consists of lowercase English letters.
//
//
// Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
//
// Runtime: 3 ms, faster than 75.82% of Java online submissions for Remove Duplicate Letters.
// Memory Usage: 39.6 MB, less than 14.01% of Java online submissions for Remove Duplicate Letters.
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 'a']--;
            if (used[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c && letters[stack.peek() - 'a'] > 0) {
                char toRemove = stack.pop();
                used[toRemove - 'a'] = false;
            }
            used[c - 'a'] = true;
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}