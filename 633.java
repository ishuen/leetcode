// 633. Sum of Square Numbers
//
// Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
//
//
//
// Example 1:
//
// Input: c = 5
// Output: true
// Explanation: 1 * 1 + 2 * 2 = 5
// Example 2:
//
// Input: c = 3
// Output: false
//
//
// Constraints:
//
// 0 <= c <= 231 - 1
//
// Runtime 3ms Beats 97.47%of users with Java
// Memory 39.89MB Beats 8.65%of users with Java
class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}