// 387. First Unique Character in a String
// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
//
//
//
// Example 1:
//
// Input: s = "leetcode"
// Output: 0
// Example 2:
//
// Input: s = "loveleetcode"
// Output: 2
// Example 3:
//
// Input: s = "aabb"
// Output: -1
//
//
// Constraints:
//
// 1 <= s.length <= 105
// s consists of only lowercase English letters.
//
// Runtime 7 ms Beats 86.95%
// Memory 44.5 MB Beats 5.56%
class Solution {
    public int firstUniqChar(String s) {
        int[] indexes = new int[26];
        Arrays.fill(indexes, -2);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexes[c - 'a'] == -2) {
                indexes[c - 'a'] = i;
            } else {
                indexes[c - 'a'] = -1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (indexes[i] >= 0) {
                min = Math.min(min, indexes[i]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

// Runtime 8 ms Beats 80.96%
// Memory 44.3 MB Beats 5.56%
class Solution {
    public int firstUniqChar(String s) {
        int[] indexes = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            indexes[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexes[c - 'a'] == 1) return i;
        }
        return -1;
    }
}