// 392. Is Subsequence
//
// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//
// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
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
// 0 <= t.length <= 104
// s and t consist only of lowercase English letters.
//
//
// Runtime 49 ms Beats 78.00% of users with JavaScript
// Memory 42.00 MB Beats 53.24% of users with JavaScript
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
    if (s.length === 0) return true;
    let pointer1 = 0;
    let pointer2 = 0;
    while (pointer1 < t.length) {
        if (t[pointer1] == s[pointer2]) {
            pointer2++;
            if (pointer2 == s.length) return true;
        }
        pointer1++;
    }
    return false;
};