// 459. Repeated Substring Pattern
//
// Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
//
//
//
// Example 1:
//
// Input: s = "abab"
// Output: true
// Explanation: It is the substring "ab" twice.
// Example 2:
//
// Input: s = "aba"
// Output: false
// Example 3:
//
// Input: s = "abcabcabcabc"
// Output: true
// Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
//
//
// Constraints:
//
// 1 <= s.length <= 104
// s consists of lowercase English letters.
//
// Runtime 555 ms Beats 6.82%
// Memory 44.5 MB Beats 6.5%
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String full = s + s;
        int index = 1;
        boolean completed = true;
        while (index < s.length()) {
            for(int i = 0; i < s.length(); i++) {
                if (full.charAt(index + i) != s.charAt(i)) {
                    index++;
                    completed = false;
                    break;
                }
            }
            if (completed == true) return true;
            else completed = true;
        }
        return false;
    }
}

// Runtime 121 ms Beats 28.51%
// Memory 44.5 MB Beats 6.5%
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String full = s.substring(1) + s.substring(0, s.length() - 1);
        return full.indexOf(s) >= 0;
    }
}