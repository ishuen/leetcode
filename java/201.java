// 201. Bitwise AND of Numbers Range
// Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
//
//
//
// Example 1:
//
// Input: left = 5, right = 7
// Output: 4
// Example 2:
//
// Input: left = 0, right = 0
// Output: 0
// Example 3:
//
// Input: left = 1, right = 2147483647
// Output: 0
//
//
// Constraints:
//
// 0 <= left <= right <= 231 - 1
// Runtime: 4 ms, faster than 100.00% of Java online submissions for Bitwise AND of Numbers Range.
// Memory Usage: 38.3 MB, less than 58.28% of Java online submissions for Bitwise AND of Numbers Range.
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int left = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            left <<= 1;
        }
        return m * left;
    }
}