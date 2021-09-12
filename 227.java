// 227. Basic Calculator II
// Given a string s which represents an expression, evaluate this expression and return its value.
//
// The integer division should truncate toward zero.
//
// You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
//
// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
//
//
//
// Example 1:
//
// Input: s = "3+2*2"
// Output: 7
// Example 2:
//
// Input: s = " 3/2 "
// Output: 1
// Example 3:
//
// Input: s = " 3+5 / 2 "
// Output: 5
//
//
// Constraints:
//
// 1 <= s.length <= 3 * 105
// s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
// s represents a valid expression.
// All the integers in the expression are non-negative integers in the range [0, 231 - 1].
// The answer is guaranteed to fit in a 32-bit integer.
//
// Runtime: 9 ms, faster than 68.30% of Java online submissions for Basic Calculator II.
// Memory Usage: 38.9 MB, less than 82.35% of Java online submissions for Basic Calculator II.
class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    nums.push(num);
                } else if (sign == '-') {
                    nums.push(-1 * num);
                } else if (sign == '*') {
                    int num2 = nums.pop();
                    nums.push(num2 * num);
                } else if (sign == '/') {
                    int num2 = nums.pop();
                    nums.push(num2 / num);
                }
                sign = c;
                num = 0;
            }
        }
        
        int sum = 0;
        while (!nums.isEmpty()) {
            sum += nums.pop();
        }
        return sum;
    }
}