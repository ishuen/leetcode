// 224. Basic Calculator
// Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
//
// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
//
//
//
// Example 1:
//
// Input: s = "1 + 1"
// Output: 2
// Example 2:
//
// Input: s = " 2-1 + 2 "
// Output: 3
// Example 3:
//
// Input: s = "(1+(4+5+2)-3)+(6+8)"
// Output: 23
// Example 4:
//
// Input: s = "+48 + -48"
// Output: 0
// Explanation: Numbers can have multiple digits and start with +/-.
//
//
// Constraints:
//
// 1 <= s.length <= 3 * 105
// s consists of digits, '+', '-', '(', ')', and ' '.
// s represents a valid expression.
// Every number and running calculation will fit in a signed 32-bit integer.
//
// Runtime: 5 ms, faster than 87.31% of Java online submissions for Basic Calculator.
// Memory Usage: 39.2 MB, less than 62.22% of Java online submissions for Basic Calculator.
class Solution {
    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        int number = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                int tempSign = stack.pop();
                int tempResult = stack.pop();
                result = tempResult + tempSign * result;
                sign = 1;
            }
            index++;
        }
        if (number != 0) result += sign * number;
        return result;
    }
}