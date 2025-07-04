// 397. Integer Replacement
// Given a positive integer n, you can apply one of the following operations:
//
// If n is even, replace n with n / 2.
// If n is odd, replace n with either n + 1 or n - 1.
// Return the minimum number of operations needed for n to become 1.
//
//
//
// Example 1:
//
// Input: n = 8
// Output: 3
// Explanation: 8 -> 4 -> 2 -> 1
// Example 2:
//
// Input: n = 7
// Output: 4
// Explanation: 7 -> 8 -> 4 -> 2 -> 1
// or 7 -> 6 -> 3 -> 2 -> 1
// Example 3:
//
// Input: n = 4
// Output: 2
//
//
// Constraints:
//
// 1 <= n <= 231 - 1
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Integer Replacement.
// Memory Usage: 38 MB, less than 8.99% of Java online submissions for Integer Replacement.
class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || ((n >>> 1) & 1) == 0) {
                n--;
            } else {
                n++;
            }
            count++;
        }
        return count;
    }
}

// even -> n /2
// odd -> n = 3 or n - 1 has fewer 1s than n + 1 -> call with n - 1
//     -> else, call with n + 1
