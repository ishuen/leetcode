// 392. Is Subsequence
// Given a string s and a string t, check if s is subsequence of t.
//
// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
//
// Follow up:
// If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
//
// Credits:
// Special thanks to @pbrother for adding this problem and creating all test cases.
//
//
//
// Example 1:
//
// Input: s = "abc", t = "ahbgdc"
// Output: true
// Example 2:
//
// Input: s = "axc", t = "ahbgdc"
// Output: false
//
//
// Constraints:
//
// 0 <= s.length <= 100
// 0 <= t.length <= 10^4
// Both strings consists only of lowercase characters.
//
// Runtime: 1 ms, faster than 78.03% of Java online submissions for Is Subsequence.
// Memory Usage: 37.1 MB, less than 38.83% of Java online submissions for Is Subsequence.
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.length() == 0) return true;
        int cur = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(cur) == t.charAt(i)) {
                cur++;
                if (cur == s.length()) return true;
            }
        }
        return false;
    }
}