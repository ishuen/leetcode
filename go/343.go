// 343. Integer Break

// Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

// Return the maximum product you can get.

 

// Example 1:

// Input: n = 2
// Output: 1
// Explanation: 2 = 1 + 1, 1 × 1 = 1.
// Example 2:

// Input: n = 10
// Output: 36
// Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 

// Constraints:

// 2 <= n <= 58

// Runtime 0 ms Beats 100.00%
// Memory 3.90 MB Beats 91.53%
var memory []int
func helper(n int, isRoot bool) int {
    if n < 1 {
        return 1
    }
    if memory[n] != 0 {
        return memory[n]
    }
    maxProduct := 1
    for i := 1; i <= n / 2; i++ {
        maxProduct = max(maxProduct, i * helper(n - i, false))
    }
    if isRoot == false {
        maxProduct = max(maxProduct, n)
    }
    memory[n] = maxProduct
    return maxProduct
}
func integerBreak(n int) int {
    memory = make([]int, 59)
    memory[1] = 1
    return helper(n, true)
}