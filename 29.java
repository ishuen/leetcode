// 29. Divide Two Integers
// Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
//
// Return the quotient after dividing dividend by divisor.
//
// The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
//
// Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
//
//
//
// Example 1:
//
// Input: dividend = 10, divisor = 3
// Output: 3
// Explanation: 10/3 = truncate(3.33333..) = 3.
// Example 2:
//
// Input: dividend = 7, divisor = -3
// Output: -2
// Explanation: 7/-3 = truncate(-2.33333..) = -2.
// Example 3:
//
// Input: dividend = 0, divisor = 1
// Output: 0
// Example 4:
//
// Input: dividend = 1, divisor = 1
// Output: 1
//
//
// Constraints:
//
// -231 <= dividend, divisor <= 231 - 1
// divisor != 0
//
// Runtime: 1 ms, faster than 99.98% of Java online submissions for Divide Two Integers.
// Memory Usage: 35.7 MB, less than 92.76% of Java online submissions for Divide Two Integers.
class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNagative = dividend < 0 ^ divisor < 0;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long counter = 1;
        long ans = 0;
        long product = ldivisor;
        while (ldividend >= ldivisor) {
            while (product <= ldividend) {
                product = product << 1;
                counter = counter << 1;
            }
            ans = ans + (counter >> 1);
            ldividend = ldividend - (product >> 1);
            product = ldivisor;
            counter = 1;
        }
        return isNagative ? (int) ~ans + 1 : ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ans;
    }
}