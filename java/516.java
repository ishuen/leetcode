// 516. Longest Palindromic Subsequence
// Given a string s, find the longest palindromic subsequence's length in s.
//
// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
//
//
//
// Example 1:
//
// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".
// Example 2:
//
// Input: s = "cbbd"
// Output: 2
// Explanation: One possible longest palindromic subsequence is "bb".
//
//
// Constraints:
//
// 1 <= s.length <= 1000
// s consists only of lowercase English letters.
//
// Runtime: 38 ms, faster than 70.41% of Java online submissions for Longest Palindromic Subsequence.
// Memory Usage: 49.8 MB, less than 26.14% of Java online submissions for Longest Palindromic Subsequence.
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] par = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            par[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    par[i][j] = par[i + 1][j - 1] + 2;
                } else {
                    par[i][j] = Math.max(par[i + 1][j], par[i][j - 1]);
                }
            }
        } 
        return par[0][s.length() - 1];
    }
}


// b b b a b
//
//   0 1 2 3 4
// 0 1 2 3 
// 1   1 2 2
// 2     1 1 3
// 3       1 1
// 4         1

// same = left bottom + 2
// diff = max left or bottom