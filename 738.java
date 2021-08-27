// 738. Monotone Increasing Digits
// An integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.
//
// Given an integer n, return the largest number that is less than or equal to n with monotone increasing digits.
//
//
//
// Example 1:
//
// Input: n = 10
// Output: 9
// Example 2:
//
// Input: n = 1234
// Output: 1234
// Example 3:
//
// Input: n = 332
// Output: 299
//
//
// Constraints:
//
// 0 <= n <= 109
//
// Runtime: 1 ms, faster than 93.87% of Java online submissions for Monotone Increasing Digits.
// Memory Usage: 36.1 MB, less than 38.72% of Java online submissions for Monotone Increasing Digits.
class Solution {
    public int monotoneIncreasingDigits(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int lastIncrement = sb.length();
        for (int i = sb.length() - 1; i > 0; i--) {
            if (sb.charAt(i) < sb.charAt(i - 1)) {
                lastIncrement = i;
                sb.setCharAt(i - 1, (char)(sb.charAt(i - 1) - 1));
            }
        }
        for (int i = lastIncrement; i < sb.length(); i++) {
            sb.setCharAt(i, '9');
        }
        return Integer.valueOf(sb.toString());
    }
}