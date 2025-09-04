// 70. Climbing Stairs

// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
 

// Constraints:

// 1 <= n <= 45

// Runtime 0 ms Beats 100.00%
// Memory 3.98 MB Beats 34.96%
func climbStairs(n int) int {
    memory := [46]int{}
    var climb func(n int) int
    climb = func(n int) int {
        if memory[n] != 0 {
            return memory[n]
        }
        if n == 1 {
            return 1
        }
        if n == 2 {
            return 2
        }
        count := climb(n - 1) + climb(n - 2)
        memory[n] = count
        return count
    }
    return climb(n)
}