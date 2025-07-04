// 32. Longest Valid Parentheses
// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
// Example 1:
//
// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".
// Example 2:
//
// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".
// Example 3:
//
// Input: s = ""
// Output: 0
//
// Constraints:
//
// 0 <= s.length <= 3 * 104
// s[i] is '(', or ')'.

// Runtime: 2 ms, faster than 68.19% of Java online submissions for Longest Valid Parentheses.
// Memory Usage: 39.2 MB, less than 36.05% of Java online submissions for Longest Valid Parentheses.
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);            
            else {
                if (stack.isEmpty()) left = i;
                else {
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max, i - left);
                    else max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}