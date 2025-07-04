// 115. Distinct Subsequences
// Given two strings s and t, return the number of distinct subsequences of s which equals t.
//
// A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
// It is guaranteed the answer fits on a 32-bit signed integer.
//
//
//
// Example 1:
//
// Input: s = "rabbbit", t = "rabbit"
// Output: 3
// Explanation:
// As shown below, there are 3 ways you can generate "rabbit" from S.
// rabbbit
// rabbbit
// rabbbit
// Example 2:
//
// Input: s = "babgbag", t = "bag"
// Output: 5
// Explanation:
// As shown below, there are 5 ways you can generate "bag" from S.
// babgbag
// babgbag
// babgbag
// babgbag
// babgbag
//
//
// Constraints:
//
// 1 <= s.length, t.length <= 1000
// s and t consist of English letters.
//
// Runtime: 9 ms, faster than 58.01% of Java online submissions for Distinct Subsequences.
// Memory Usage: 43.1 MB, less than 37.67% of Java online submissions for Distinct Subsequences.
class Solution {
    public int numDistinct(String s, String t) {
        int[][] comb = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            comb[0][i] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    comb[i][j] = comb[i - 1][j - 1] + comb[i][j - 1];
                } else {
                    comb[i][j] = comb[i][j - 1];
                }
            }
        }
        return comb[t.length()][s.length()];
    }
}

//    [r, a, b, b, b, i, t] 
//   1 1  1  1  1  1  1  1
// r 0 1  1  1  1  1  1  1
// a 0 0  1  1  1  1  1  1
// b 0 0  0  1  2  3  3  3
// b 0 0  0  0  1  3  3  3
// i 0 0  0  0  0  0  3  3
// t 0 0  0  0  0  0  0  3