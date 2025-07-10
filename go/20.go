// 20. Valid Parentheses

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"

// Output: true

// Example 2:

// Input: s = "()[]{}"

// Output: true

// Example 3:

// Input: s = "(]"

// Output: false

// Example 4:

// Input: s = "([])"

// Output: true

 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

// Runtime 0 ms Beats 100.00%
// Memory 4.11 MB Beats 64.76%
func isValid(s string) bool {
    stack := []rune{}
    for _, char := range s {
        if char == '(' || char == '[' || char == '{' {
            stack = append(stack, char)
        } else {
            if len(stack) == 0 {
                return false
            }
            top := stack[len(stack) - 1]
            if (char == ')' && top != '(') || (char == ']' && top != '[') || (char == '}' && top != '{') {
                return false
            }
            stack = stack[:len(stack) - 1]
        }
    }
    return len(stack) == 0
}
