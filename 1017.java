// 1017. Convert to Base -2
//
// Given an integer n, return a binary string representing its representation in base -2.
//
// Note that the returned string should not have leading zeros unless the string is "0".
//
//
//
// Example 1:
//
// Input: n = 2
// Output: "110"
// Explantion: (-2)2 + (-2)1 = 2
// Example 2:
//
// Input: n = 3
// Output: "111"
// Explantion: (-2)2 + (-2)1 + (-2)0 = 3
// Example 3:
//
// Input: n = 4
// Output: "100"
// Explantion: (-2)2 = 4
//
//
// Constraints:
//
// 0 <= n <= 109
//
//
// Runtime 1 ms Beats 57.30%
// Memory 40.4 MB Beats 28.9%
class Solution {
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            if (n % 2 == 0) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            n = -(n >> 1);
        }
        return sb.length() >= 1 ? sb.reverse().toString(): "0";
    }
}

// Runtime 0 ms Beats 100%
// Memory 40.5 MB Beats 28.9%
class Solution {
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n & 1);
            n = -(n >> 1);
        }
        return sb.length() >= 1 ? sb.reverse().toString(): "0";
    }
}