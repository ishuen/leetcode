// 400. Nth Digit
// Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
//
//
//
// Example 1:
//
// Input: n = 3
// Output: 3
// Example 2:
//
// Input: n = 11
// Output: 0
// Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
//
//
// Constraints:
//
// 1 <= n <= 231 - 1
//
// Runtime 0 ms Beats 100%
// Memory 39.6 MB Beats 37.67%
class Solution {
    public int findNthDigit(int n) {
        long baseCount = 9;
        long start = 1;
        int digit = 1;
        while (baseCount * digit < n) {
            n = n - (int) baseCount * digit;
            baseCount = baseCount * 10;
            start = start * 10;
            digit++;
        }
        start = start + (n - 1) / digit;
        String numString = String.valueOf(start);
        return Character.getNumericValue(numString.charAt((n - 1) % digit));
    }
}