// 343. Integer Break
// Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
//
// Return the maximum product you can get.
//
//
//
// Example 1:
//
// Input: n = 2
// Output: 1
// Explanation: 2 = 1 + 1, 1 × 1 = 1.
// Example 2:
//
// Input: n = 10
// Output: 36
// Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
//
//
// Constraints:
//
// 2 <= n <= 58
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Integer Break.
// Memory Usage: 35.9 MB, less than 40.26% of Java online submissions for Integer Break.
class Solution {
    public int integerBreak(int n) {
        int[] mem = new int[n + 1];
        mem[1] = 1;
        return integerBreak(n, mem, true);
    }
    
    private int integerBreak(int n, int[] mem, boolean isRoot) {
        if (n < 1) return 1;
        if (mem[n] >= 1) return mem[n];
        int max = 1;
        for (int i = n / 2; i >= 1; i--) {
            max = Math.max(max, i * integerBreak(n - i, mem, false));
        }
        if (isRoot == false) max = Math.max(max, n);
        return mem[n] = max;
    }
}

