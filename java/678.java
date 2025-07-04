// 678. Valid Parenthesis String
// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
//
// The following rules define a valid string:
//
// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
//
//
// Example 1:
//
// Input: s = "()"
// Output: true
// Example 2:
//
// Input: s = "(*)"
// Output: true
// Example 3:
//
// Input: s = "(*))"
// Output: true
//
//
// Constraints:
//
// 1 <= s.length <= 100
// s[i] is '(', ')' or '*'.
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Parenthesis String.
// Memory Usage: 37 MB, less than 50.24% of Java online submissions for Valid Parenthesis String.
class Solution {
    public boolean checkValidString(String s) {
        int minLeft = 0;
        int maxLeft = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minLeft++;
                maxLeft++;
            }
            else if (c == ')') {
                if (minLeft > 0) minLeft--;
                maxLeft--;
                if (maxLeft < 0) return false;
            } else {
                if (minLeft > 0) minLeft--;
                maxLeft++;
            }
        }
        return minLeft == 0;
    }
}

// *
// ( -> checkValidString(s, next, left + 1)
// ) -> checkValidString(s, next, left - 1)
// empty -> checkValidString(s, next, left)
// -> TLE