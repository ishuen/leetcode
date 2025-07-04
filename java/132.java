// 132. Palindrome Partitioning II
// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return the minimum cuts needed for a palindrome partitioning of s.
//
//
//
// Example 1:
//
// Input: s = "aab"
// Output: 1
// Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
// Example 2:
//
// Input: s = "a"
// Output: 0
// Example 3:
//
// Input: s = "ab"
// Output: 1
//
//
// Constraints:
//
// 1 <= s.length <= 2000
// s consists of lower-case English letters only.
//
// Runtime: 34 ms, faster than 48.79% of Java online submissions for Palindrome Partitioning II.
// Memory Usage: 45.2 MB, less than 27.52% of Java online submissions for Palindrome Partitioning II.
class Solution {
    public int minCut(String s) {
        boolean[][] palinedromes = new boolean[s.length()][s.length()];
        int[] cuts = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || palinedromes[i - 1][j + 1])) {
                    palinedromes[i][j] = true;
                    min = j == 0 ? 0 : Math.min(min, cuts[j - 1] + 1);
                }
            }
            cuts[i] = min;
        }
        return cuts[s.length() - 1];
    }
    
}

// abcba aa b

//   a b c b a a
// a t
// b f t
// c f f t
// b f t f t
// a t f f f t
// a f f f f t t