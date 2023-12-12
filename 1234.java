// 1234. Replace the Substring for Balanced String
//
// You are given a string s of length n containing only four kinds of characters: 'Q', 'W', 'E', and 'R'.
//
// A string is said to be balanced if each of its characters appears n / 4 times where n is the length of the string.
//
// Return the minimum length of the substring that can be replaced with any other string of the same length to make s balanced. If s is already balanced, return 0.
//
//
//
// Example 1:
//
// Input: s = "QWER"
// Output: 0
// Explanation: s is already balanced.
// Example 2:
//
// Input: s = "QQWE"
// Output: 1
// Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
// Example 3:
//
// Input: s = "QQQW"
// Output: 2
// Explanation: We can replace the first "QQ" to "ER".
//
//
// Constraints:
//
// n == s.length
// 4 <= n <= 105
// n is a multiple of 4.
// s contains only 'Q', 'W', 'E', and 'R'.
//
// Runtime 8 ms Beats 74.81% of users with Java
// Memory 43.04 MB Beats 96.18% of users with Java
class Solution {
    public int balancedString(String s) {
        int n = s.length() / 4;
        int[] counts = new int[4]; // QWER
        Arrays.fill(counts, -1 * n);
        int exceeded = 0;
        for (char c: s.toCharArray()) {
            int index = charToIndex(c);
            counts[index]++;
            if (counts[index] == 1) exceeded++;
        }
        if (exceeded == 0) return 0;
        int left = 0;
        int right = 0;
        int minLen = s.length();
        while (right < s.length()) {
            char c = s.charAt(right);
            int index = charToIndex(c);
            counts[index]--;
            right++;
            if (counts[index] == 0) exceeded--;
            while (exceeded == 0) {
                minLen = Math.min(minLen, right - left);
                char l = s.charAt(left);
                int indexL = charToIndex(l);
                counts[indexL]++;
                left++;
                if (counts[indexL] > 0) exceeded++;
            }
        }
        return minLen;
    }

    private int charToIndex(char c) {
        if (c == 'Q') return 0;
        if (c == 'W') return 1;
        if (c == 'E') return 2;
        return 3;
    }
}