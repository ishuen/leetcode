// 639. Decode Ways II
// A message containing letters from A-Z can be encoded into numbers using the following mapping:
//
// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"
// To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
//
// "AAJF" with the grouping (1 1 10 6)
// "KJF" with the grouping (11 10 6)
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
//
// In addition to the mapping above, an encoded message may contain the '*' character, which can represent any digit from '1' to '9' ('0' is excluded). For example, the encoded message "1*" may represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19". Decoding "1*" is equivalent to decoding any of the encoded messages it can represent.
//
// Given a string s containing digits and the '*' character, return the number of ways to decode it.
//
// Since the answer may be very large, return it modulo 109 + 7.
//
//
//
// Example 1:
//
// Input: s = "*"
// Output: 9
// Explanation: The encoded message can represent any of the encoded messages "1", "2", "3", "4", "5", "6", "7", "8", or "9".
// Each of these can be decoded to the strings "A", "B", "C", "D", "E", "F", "G", "H", and "I" respectively.
// Hence, there are a total of 9 ways to decode "*".
// Example 2:
//
// Input: s = "1*"
// Output: 18
// Explanation: The encoded message can represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19".
// Each of these encoded messages have 2 ways to be decoded (e.g. "11" can be decoded to "AA" or "K").
// Hence, there are a total of 9 * 2 = 18 ways to decode "1*".
// Example 3:
//
// Input: s = "2*"
// Output: 15
// Explanation: The encoded message can represent any of the encoded messages "21", "22", "23", "24", "25", "26", "27", "28", or "29".
// "21", "22", "23", "24", "25", and "26" have 2 ways of being decoded, but "27", "28", and "29" only have 1 way.
// Hence, there are a total of (6 * 2) + (3 * 1) = 12 + 3 = 15 ways to decode "2*".
//
//
// Constraints:
//
// 1 <= s.length <= 105
// s[i] is a digit or '*'.
//
// Runtime: 60 ms, faster than 24.54% of Java online submissions for Decode Ways II.
// Memory Usage: 44.3 MB, less than 44.65% of Java online submissions for Decode Ways II.
class Solution {
    private static final int M = 1000000007;
    public int numDecodings(String s) {
        long[] counts = new long[s.length() + 1];
        counts[0] = 1;
        char prev = s.charAt(0);
        counts[1] = prev == '0' ? 0 : prev == '*' ? 9 : 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[i + 1] = (counts[i] * (c == '0' ? 0 : c == '*' ? 9 : 1)) % M;
            if (prev == '*' && c == '*') {
                counts[i + 1] += (15 * counts[i - 1]) % M;
            } else if (prev == '*') {
                counts[i + 1] += (counts[i - 1] * (Character.getNumericValue(c) <= 6 ? 2 : 1)) % M;
            } else if (c == '*') {
                counts[i + 1] += (counts[i - 1] * (prev == '1' ? 9 : (prev == '2' ? 6 : 0))) % M;
            } else {
                int num = Integer.parseInt(s.substring(i - 1, i + 1));
                counts[i + 1] += (counts[i - 1] * (num <= 26 && 10 <= num ? 1 : 0)) % M;
            }
            counts[i + 1] = counts[i + 1] % M;
            prev = c;
        }
        return (int) counts[s.length()];
    }
}


// 1* -> 0 - 9
// 2* -> 0 - 6

//    1 *  3
// [1 1 19 21]
//    11 12 13 14 15 16 17 18 19 (2, 2, 2, 2, 2, 2, 2, 2, 2)
// 1 13, 1 23 -> 2

//    2 *
// [1,1, 15]
// 21, 22, 23, 24, 25, 26
// 2 1, 2 2, 2 3, 2 4, 2 5, 2 6, 2 7, 2 8, 2 9

// * *
// single - 81
// 26 - 9 - 1 - 1 = 15
