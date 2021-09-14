// 856. Score of Parentheses
// Given a balanced parentheses string s, return the score of the string.
//
// The score of a balanced parentheses string is based on the following rule:
//
// "()" has score 1.
// AB has score A + B, where A and B are balanced parentheses strings.
// (A) has score 2 * A, where A is a balanced parentheses string.
//
//
// Example 1:
//
// Input: s = "()"
// Output: 1
// Example 2:
//
// Input: s = "(())"
// Output: 2
// Example 3:
//
// Input: s = "()()"
// Output: 2
// Example 4:
//
// Input: s = "(()(()))"
// Output: 6
//
//
// Constraints:
//
// 2 <= s.length <= 50
// s consists of only '(' and ')'.
// s is a balanced parentheses string.
//
// Runtime: 2 ms, faster than 9.40% of Java online submissions for Score of Parentheses.
// Memory Usage: 38.4 MB, less than 19.66% of Java online submissions for Score of Parentheses.
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(count);
                count = 0;
            } else {
                count = stack.pop() + Math.max(2 * count, 1);
            }
        }
        return count;
    }
}