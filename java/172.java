// 172. Factorial Trailing Zeroes
// Given an integer n, return the number of trailing zeroes in n!.
//
// Follow up: Could you write a solution that works in logarithmic time complexity?
//
//
//
// Example 1:
//
// Input: n = 3
// Output: 0
// Explanation: 3! = 6, no trailing zero.
// Example 2:
//
// Input: n = 5
// Output: 1
// Explanation: 5! = 120, one trailing zero.
// Example 3:
//
// Input: n = 0
// Output: 0
//
//
// Constraints:
//
// 0 <= n <= 104
//
// Runtime: 32 ms, faster than 5.06% of Java online submissions for Factorial Trailing Zeroes.
// Memory Usage: 36 MB, less than 40.23% of Java online submissions for Factorial Trailing Zeroes.
class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        int two = 0;
        int five = 0;
        int k = 1;
        while (k <= n) {
            int value = k;
            while (value % 2 == 0) {
                two++;
                value = value / 2;
            }
            while (value % 5 == 0) {
                five++;
                value = value / 5;
            }
            k++;
        }
        return Math.min(two, five);
    }
}

// Runtime: 9 ms, faster than 8.48% of Java online submissions for Factorial Trailing Zeroes.
// Memory Usage: 36 MB, less than 29.80% of Java online submissions for Factorial Trailing Zeroes.
class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        int five = 0;
        int k = 1;
        while (k <= n) {
            int value = k;
            while (value % 5 == 0) {
                five++;
                value = value / 5;
            }
            k++;
        }
        return five;
    }
}

