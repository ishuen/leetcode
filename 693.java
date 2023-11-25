// 693. Binary Number with Alternating Bits
//
// Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
//
//
//
// Example 1:
//
// Input: n = 5
// Output: true
// Explanation: The binary representation of 5 is: 101
// Example 2:
//
// Input: n = 7
// Output: false
// Explanation: The binary representation of 7 is: 111.
// Example 3:
//
// Input: n = 11
// Output: false
// Explanation: The binary representation of 11 is: 1011.
//
//
// Constraints:
//
// 1 <= n <= 231 - 1
//
// Runtime 0 ms Beats 100.00% of users with Java
// Memory 39.19 MB Beats 56.80% of users with Java
class Solution {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == binary.charAt(i - 1)) return false;
        }
        return true;
    }
}
