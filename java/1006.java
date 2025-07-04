// 1006. Clumsy Factorial
//
// The factorial of a positive integer n is the product of all positive integers less than or equal to n.
//
// For example, factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1.
// We make a clumsy factorial using the integers in decreasing order by swapping out the multiply operations for a fixed rotation of operations with multiply '*', divide '/', add '+', and subtract '-' in this order.
//
// For example, clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1.
// However, these operations are still applied using the usual order of operations of arithmetic. We do all multiplication and division steps before any addition or subtraction steps, and multiplication and division steps are processed left to right.
//
// Additionally, the division that we use is floor division such that 10 * 9 / 8 = 90 / 8 = 11.
//
// Given an integer n, return the clumsy factorial of n.
//
//
//
// Example 1:
//
// Input: n = 4
// Output: 7
// Explanation: 7 = 4 * 3 / 2 + 1
// Example 2:
//
// Input: n = 10
// Output: 12
// Explanation: 12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
//
//
// Constraints:
//
// 1 <= n <= 104
//
// Runtime 2 ms Beats 40.47%
// Memory 39.6 MB Beats 65.58%
class Solution {
    public int clumsy(int n) {
        int count = 0;
        int sum = 0;
        int temp = n;
        n--;
        boolean positive = true;
        while (n > 0) {
            int mod = count % 4;
            if (mod == 0) {
                temp = temp * n;
            } else if (mod == 1) {
                temp = temp / n;
            } else if (mod == 2) {
                if (positive == true) {
                    sum = sum + temp + n;
                } else {
                    sum = sum - temp + n;
                }
                temp = 0;
            } else {
                positive = false;
                temp = n;
            }
            count++;
            n--;
        }
        if (temp != 0) {
            if (positive) {
                sum = sum + temp;
            } else {
                sum = sum - temp;
            }
        }
        return sum;
    }
}

// Runtime 0 ms Beats 100%
// Memory 38.9 MB Beats 99.7%
class Solution {
    public int clumsy(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 6;
        if (n == 4) return 7;
        if (n % 4 == 0) return n + 1;
        if (n % 4 == 1 || n % 4 == 2) return n + 2;
        return n - 1;
    }
}
