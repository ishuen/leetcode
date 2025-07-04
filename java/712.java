// 712. Minimum ASCII Delete Sum for Two Strings
// Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
//
//
//
// Example 1:
//
// Input: s1 = "sea", s2 = "eat"
// Output: 231
// Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
// Deleting "t" from "eat" adds 116 to the sum.
// At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
// Example 2:
//
// Input: s1 = "delete", s2 = "leet"
// Output: 403
// Explanation: Deleting "dee" from "delete" to turn the string into "let",
// adds 100[d] + 101[e] + 101[e] to the sum.
// Deleting "e" from "leet" adds 101[e] to the sum.
// At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
// If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
//
//
// Constraints:
//
// 1 <= s1.length, s2.length <= 1000
// s1 and s2 consist of lowercase English letters.

// Runtime: 18 ms, faster than 72.61% of Java online submissions for Minimum ASCII Delete Sum for Two Strings.
// Memory Usage:39.6 MB, less than 48.70% of Java online submissions for Minimum ASCII Delete Sum for Two Strings.
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] sums = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            sums[i + 1][0] = sums[i][0] + s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            sums[0][i+1] = sums[0][i] + s2.charAt(i);
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    sums[i][j] = sums[i - 1][j - 1];
                } else {
                    sums[i][j] = Math.min(sums[i - 1][j] + s1.charAt(i - 1), sums[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return sums[s1.length()][s2.length()];
    }
}
