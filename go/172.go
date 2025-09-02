// 172. Factorial Trailing Zeroes

// Given an integer n, return the number of trailing zeroes in n!.

// Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

 

// Example 1:

// Input: n = 3
// Output: 0
// Explanation: 3! = 6, no trailing zero.
// Example 2:

// Input: n = 5
// Output: 1
// Explanation: 5! = 120, one trailing zero.
// Example 3:

// Input: n = 0
// Output: 0
 

// Constraints:

// 0 <= n <= 104
 

// Follow up: Could you write a solution that works in logarithmic time complexity?

// Runtime 0 ms Beats 100.00%
// Memory 3.98 MB Beats 62.50%
func trailingZeroes(n int) int {
    if n < 5 {
        return 0
    }
    count := 0
    for ; n >= 5; {
        count = count + n / 5
        n = n / 5
    }
    return count
}
