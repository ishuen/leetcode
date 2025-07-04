// 233. Number of Digit One
// Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
//
// Example 1:
//
// Input: n = 13
// Output: 6
// Example 2:
//
// Input: n = 0
// Output: 0
//
//
// Constraints:
//
// 0 <= n <= 109

class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        long count = 0;
        int partial = n;
        for (int full = 1; full <= n; full *= 10) {
            long pre = n / (full * 10);
            long cur = partial % 10;
            long suf = n % full;
            count += pre * full;
            count += (1 < cur ? full : (1 == cur ? suf + 1: 0));
            partial = partial / 10;
        }
        return (int) count;
    }
}
// Basic idea: count number of combination of 1 at each digit in two cases: prefix appears or not
// Eg.3101592:
// 1) one at hundreds:      1 (< 5): [1~3101]1[0~99]. So # = 3101 * 100 + 100 (Safe since 31011XX never be greater than 31015XX)
// 2) one at thousands:     1 (= 1): [1~310]1[0~592]. So # = 310 * 1000 + (592 + 1) (Unsafe if prefix is 0, it must be <= 1592)
// 3) one at ten thousands: 1 (> 0): [1~30]1[0~9999]. So # = 30 * 10000 (If prefix is 0, no 1 digit number exist)
// 13
// full: 1 -> 10
// partial: 13 -> 1
// pre: 1 -> 0
// cur: 3 -> 1
// suf: 0 -> 3
// 1, 10, 11, 12, 13
// 1 + 4



