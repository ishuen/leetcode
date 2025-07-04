// 357. Count Numbers with Unique Digits
// Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.
//
//
//
// Example 1:
//
// Input: n = 2
// Output: 91
// Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
// Example 2:
//
// Input: n = 0
// Output: 1
//
//
// Constraints:
//
// 0 <= n <= 8
//
// Runtime 0 ms Beats 100%
// Memory 40.3 MB Beats 5.51%
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n <= 0) return 1;
        int product = 1;
        int select = 9;
        int base = n - 1;
        while (base > 0) {
            product = product * select;
            select--;
            base--;
        }
        return 9 * product + countNumbersWithUniqueDigits(n - 1);
    }
}
