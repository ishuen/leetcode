// 1016. Binary String With Substrings Representing 1 To N
//
// Given a binary string s and a positive integer n, return true if the binary representation of all the integers in the range [1, n] are substrings of s, or false otherwise.
//
// A substring is a contiguous sequence of characters within a string.
//
//
//
// Example 1:
//
// Input: s = "0110", n = 3
// Output: true
// Example 2:
//
// Input: s = "0110", n = 4
// Output: false
//
//
// Constraints:
//
// 1 <= s.length <= 1000
// s[i] is either '0' or '1'.
// 1 <= n <= 109
//
// Runtime 0 ms Beats 100%
// Memory 40.4 MB Beats 75.69%
class Solution {
    public boolean queryString(String s, int n) {
        for (int i = n; i > 0; i--) {
            String sub = Integer.toBinaryString(i);
            if (!s.contains(sub)) {
                return false;
            }
        }
        return true;
    }
}