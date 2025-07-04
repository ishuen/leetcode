// 264. Ugly Number II
// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
//
// Given an integer n, return the nth ugly number.
//
//
//
// Example 1:
//
// Input: n = 10
// Output: 12
// Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
// Example 2:
//
// Input: n = 1
// Output: 1
// Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
//
//
// Constraints:
//
// 1 <= n <= 1690
//
// Runtime: 2 ms, faster than 98.69% of Java online submissions for Ugly Number II.
// Memory Usage: 38.3 MB, less than 43.67% of Java online submissions for Ugly Number II.
class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 0;
        int factor2 = 2;
        int index3 = 0;
        int factor3 = 3;
        int index5 = 0;
        int factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            nums[i] = min;
            if (factor2 == min) {
                index2++;
                factor2 = 2 * nums[index2];
            }
            if (factor3 == min) {
                index3++;
                factor3 = 3 * nums[index3];
            }
            if (factor5 == min) {
                index5++;
                factor5 = 5 * nums[index5];
            }
        }
        return nums[n - 1];
    }
}

// 1 2 3 4   5 6   8   9   10  12
// 1 2 3 2*2 5 2*3 2*4 3*3 2*5 3*4