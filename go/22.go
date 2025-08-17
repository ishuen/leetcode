// 22. Generate Parentheses

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]
 

// Constraints:

// 1 <= n <= 8


// Runtime 0 ms Beats 100.00%
// Memory 4.76 MB Beats 41.29%
func generateParenthesis(n int) []string {
    output := []string{}
    var generate func(left, right int, cur string)
    generate = func(left, right int, cur string) {
        if left == n && right == n {
            output = append(output, cur)
            return
        }
        if left < n {
            generate(left + 1, right, cur + string('('))
        }
        if right < n && left > right {
            generate(left, right + 1, cur + string(')'))
        }
    }
    generate(0, 0, "")
    return output
}