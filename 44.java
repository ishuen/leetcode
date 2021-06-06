// 44. Wildcard Matching
// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
//
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).
//
//
//
// Example 1:
//
// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".
// Example 2:
//
// Input: s = "aa", p = "*"
// Output: true
// Explanation: '*' matches any sequence.
// Example 3:
//
// Input: s = "cb", p = "?a"
// Output: false
// Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
// Example 4:
//
// Input: s = "adceb", p = "*a*b"
// Output: true
// Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
// Example 5:
//
// Input: s = "acdcb", p = "a*c?b"
// Output: false
// Constraints:
//
// 0 <= s.length, p.length <= 2000
// s contains only lowercase English letters.
// p contains only lowercase English letters, '?' or '*'.
// Runtime: 2 ms, faster than 100.00% of Java online submissions for Wildcard Matching.
// Memory Usage: 38.9 MB, less than 93.20% of Java online submissions for Wildcard Matching.
class Solution {
    public boolean isMatch(String s, String p) {
        int index = 0, patternIndex = 0, starIndex = -1, match = -1;
        while (index < s.length()) {
            if (patternIndex < p.length() && (s.charAt(index) == p.charAt(patternIndex) || p.charAt(patternIndex) == '?')) {
                index++;
                patternIndex++;
            } else if (patternIndex < p.length() && p.charAt(patternIndex) == '*') {
                starIndex = patternIndex;
                patternIndex++;
                match = index;
            } else if (starIndex > -1) {
                patternIndex = starIndex + 1;
                match++;
                index = match;
            } else {
                return false;
            }
        }
        int len = p.length();
        while (patternIndex < len && p.charAt(patternIndex) == '*') {
            patternIndex++;
        }
        return patternIndex == len;
    }
}

