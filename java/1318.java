// 1318. Minimum Flips to Make a OR b Equal to c
//
// Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
// Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
//
//
//
// Example 1:
//
//
//
// Input: a = 2, b = 6, c = 5
// Output: 3
// Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
// Example 2:
//
// Input: a = 4, b = 2, c = 7
// Output: 1
// Example 3:
//
// Input: a = 1, b = 2, c = 3
// Output: 0
//
//
// Constraints:
//
// 1 <= a <= 10^9
// 1 <= b <= 10^9
// 1 <= c <= 10^9
//
// Runtime 0ms Beats 100.00%of users with Java
// Memory 39.01MB Beats 56.08%of users with Java
class Solution {
    public int minFlips(int a, int b, int c) {
        int and = a & b;
        int or = a | b;
        int xor = or ^ c;
        if (xor == 0) return 0;
        int flip = 0;
        while (xor > 0) {
            if ((xor & 1) > 0) {
                if ((and & 1) > 0) {
                    flip = flip + 2;
                } else {
                    flip = flip + 1;
                }
            }
            xor = xor >> 1;
            and = and >> 1;
        }
        return flip;
    }
}