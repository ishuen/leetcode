// 1249. Minimum Remove to Make Valid Parentheses
// Given a string s of '(' , ')' and lowercase English characters.
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
//
// Formally, a parentheses string is valid if and only if:
//
// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
//
//
// Example 1:
//
// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// Example 2:
//
// Input: s = "a)b(c)d"
// Output: "ab(c)d"
// Example 3:
//
// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.
// Example 4:
//
// Input: s = "(a(b(c)d)"
// Output: "a(b(c)d)"
//
//
// Constraints:
//
// 1 <= s.length <= 10^5
// s[i] is one of  '(' , ')' and lowercase English letters.
//
// Runtime: 17 ms, faster than 67.79% of Java online submissions for Minimum Remove to Make Valid Parentheses.
// Memory Usage: 39.4 MB, less than 92.51% of Java online submissions for Minimum Remove to Make Valid Parentheses.
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> leftIndex = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ')' && leftIndex.size() == 0) {
                sb.replace(i, i + 1, "");
                i--;
            }
            else if (sb.charAt(i) == ')' && leftIndex.size() > 0) leftIndex.pop();
            else if (sb.charAt(i) == '(') {
                leftIndex.push(i);
            }
        }
        while (leftIndex.size() > 0) {
            int index = leftIndex.pop();
            sb.replace(index, index + 1, "");
        }
        return sb.toString();
    }
}

// string content except for () does not matter
// if ")" when no "(" is recorded, remove
// if at the end, "(" > ")" remove left