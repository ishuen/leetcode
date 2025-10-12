// 115. Distinct Subsequences

// Given two strings s and t, return the number of distinct subsequences of s which equals t.

// The test cases are generated so that the answer fits on a 32-bit signed integer.

 

// Example 1:

// Input: s = "rabbbit", t = "rabbit"
// Output: 3
// Explanation:
// As shown below, there are 3 ways you can generate "rabbit" from s.
// rabbbit
// rabbbit
// rabbbit
// Example 2:

// Input: s = "babgbag", t = "bag"
// Output: 5
// Explanation:
// As shown below, there are 5 ways you can generate "bag" from s.
// babgbag
// babgbag
// babgbag
// babgbag
// babgbag
 

// Constraints:

// 1 <= s.length, t.length <= 1000
// s and t consist of English letters.

// Runtime 9 ms Beats 81.55%
// Memory 17.43 MB Beats 75.73%
func numDistinct(s string, t string) int {
    matrix := make([][]int, len(t) + 1)
    matrix[0] = slices.Repeat([]int{1}, len(s) + 1)
    for i := 1; i <= len(t); i++ {
        matrix[i] = slices.Repeat([]int{0}, len(s) + 1)
    }
    for i := 1; i <= len(t); i++ {
        for j := i; j <= len(s); j++ {
            if s[j - 1] == t[i - 1] {
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i][j - 1]
            } else {
                matrix[i][j] = matrix[i][j - 1]
            }
        }
    }
    return matrix[len(t)][len(s)]
}