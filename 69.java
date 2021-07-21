// 69. Sqrt(x)
// Given a non-negative integer x, compute and return the square root of x.
//
// Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
//
// Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
//
//
//
// Example 1:
//
// Input: x = 4
// Output: 2
// Example 2:
//
// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
//
//
// Constraints:
//
// 0 <= x <= 231 - 1
//
// Runtime: 1 ms, faster than 99.99% of Java online submissions for Sqrt(x).
// Memory Usage: 36 MB, less than 76.50% of Java online submissions for Sqrt(x).
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        long start = 0;
        long end = x;
        long mid = (start + end) / 2;
        while (start <= end) {
            long pow = mid * mid;
            if (pow < x) {
                start = mid;
            } else if (pow == x) {
                return (int) mid;
            } else {
                end = mid;
            }
            if (mid == (start + end) / 2) {
                return (int) mid;
            }
            mid = (start + end) / 2;
        }
        return (int) mid;
    }
}

