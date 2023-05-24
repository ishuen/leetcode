// 866. Prime Palindrome
//
// Given an integer n, return the smallest prime palindrome greater than or equal to n.
//
// An integer is prime if it has exactly two divisors: 1 and itself. Note that 1 is not a prime number.
//
// For example, 2, 3, 5, 7, 11, and 13 are all primes.
// An integer is a palindrome if it reads the same from left to right as it does from right to left.
//
// For example, 101 and 12321 are palindromes.
// The test cases are generated so that the answer always exists and is in the range [2, 2 * 108].
//
//
//
// Example 1:
//
// Input: n = 6
// Output: 7
// Example 2:
//
// Input: n = 8
// Output: 11
// Example 3:
//
// Input: n = 13
// Output: 101
//
//
// Constraints:
//
// 1 <= n <= 108
//
// Runtime 54 ms Beats 66.40%
// Memory 43.6 MB Beats 7.20%
class Solution {
    public int primePalindrome(int n) {
        if (n <= 2) return 2;
        if (8 <= n && n <= 11) return 11;
        for (int i = 1; i < 100000; i++) {
            String s = Integer.toString(i);
            String reversed = new StringBuilder(s).reverse().toString();
            int parlindromeNum = Integer.parseInt(s + reversed.substring(1));
            if (parlindromeNum >= n && checkPrime(parlindromeNum)) return parlindromeNum;
        }
        return n;
    }

    private boolean checkPrime(int n) {
        if (n < 2 || n % 2 == 0) return n == 2;
        for (int i = 3; i * i <= n; i = i + 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}