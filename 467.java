// 467. Unique Substrings in Wraparound String
// We define the string base to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so base will look like this:
//
// "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
// Given a string s, return the number of unique non-empty substrings of s are present in base.
//
//
//
// Example 1:
//
// Input: s = "a"
// Output: 1
// Explanation: Only the substring "a" of s is in base.
// Example 2:
//
// Input: s = "cac"
// Output: 2
// Explanation: There are two substrings ("a", "c") of s in base.
// Example 3:
//
// Input: s = "zab"
// Output: 6
// Explanation: There are six substrings ("z", "a", "b", "za", "ab", and "zab") of s in base.
//
//
// Constraints:
//
// 1 <= s.length <= 105
// s consists of lowercase English letters.
//
// Runtime 8 ms Beats 78.5%
// Memory 42.7 MB Beats 38.21%
class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] count = new int[26];
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > 0 && (c - s.charAt(i - 1) == 1 || s.charAt(i - 1) - c == 25)) {
                maxLength++;
            } else {
                maxLength = 1;
            }
            count[c - 'a'] = Math.max(maxLength, count[c - 'a']);
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum = sum + count[i];
        }
        return sum;
    }
}