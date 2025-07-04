// 70. Climbing Stairs
// You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
// Example 1:
//
// Input: 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:
//
// Input: 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
//
//
// Constraints:
//
// 1 <= n <= 45
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
// Memory Usage: 35.5 MB, less than 17.63% of Java online submissions for Climbing Stairs.
class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if ( n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int prev1 = 2;
        int prev2 = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = prev1 + prev2;
            prev2 = prev1;
            prev1 = sum;
        }
        return sum;
    } 
}