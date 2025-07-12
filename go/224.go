// 224. Basic Calculator

// Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

// Example 1:

// Input: s = "1 + 1"
// Output: 2
// Example 2:

// Input: s = " 2-1 + 2 "
// Output: 3
// Example 3:

// Input: s = "(1+(4+5+2)-3)+(6+8)"
// Output: 23
 

// Constraints:

// 1 <= s.length <= 3 * 105
// s consists of digits, '+', '-', '(', ')', and ' '.
// s represents a valid expression.
// '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
// '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
// There will be no two consecutive operators in the input.
// Every number and running calculation will fit in a signed 32-bit integer.

// Runtime 0 ms Beats 100.00%
// Memory 4.84 MB Beats 95.88%
func calculate(s string) int {
    stack := []int{}
    num, sum, sign := 0, 0, 1
    for _, char := range s {
        if unicode.IsDigit(char) {
            num = num * 10 + int(char - '0')
        } else if char == '+' {
            sum = sum + sign * num
            sign = 1
            num = 0
        } else if char == '-' {
            sum = sum + sign * num
            sign = -1
            num = 0
        } else if char == '(' {
            stack = append(stack, sum, sign)
            sum = 0
            sign = 1
        } else if char == ')' {
            sum = sum + sign * num
            prevSign := stack[len(stack) - 1]
            prevSum := stack[len(stack) - 2]
            stack = stack[:len(stack) - 2]
            sum = prevSum + prevSign * sum
            sign = 1
            num = 0
        }
    } 
    if num == 0 {
        return sum
    }
    return sum + sign * num
}
