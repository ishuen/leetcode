// 326. Power of Three
//
// Given an integer n, return true if it is a power of three. Otherwise, return false.
//
// An integer n is a power of three, if there exists an integer x such that n == 3x.
//
//
//
// Example 1:
//
// Input: n = 27
// Output: true
// Explanation: 27 = 33
// Example 2:
//
// Input: n = 0
// Output: false
// Explanation: There is no x where 3x = 0.
// Example 3:
//
// Input: n = -1
// Output: false
// Explanation: There is no x where 3x = (-1).
//
//
// Constraints:
//
// -231 <= n <= 231 - 1
//
// Follow up: Could you solve it without loops/recursion?
//
// Runtime 15 ms Beats 99.89%
// Memory 43.5 MB Beats 5.2%
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n % 3 != 0 || n <= 0) return false;
        return isPowerOfThree(n / 3);
    }
}

// Runtime 15 ms Beats 99.89%
// Memory 43.5 MB Beats 5.2%
class Solution {
    public boolean isPowerOfThree(int n) {
        while (n > 0 && n % 3 == 0) {
            n = n / 3;
        }
        if (n == 1) return true;
        return false;
    }
}