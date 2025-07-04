// 424. Longest Repeating Character Replacement
// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
// Return the length of the longest substring containing the same letter you can get after performing the above operations.
//
//
//
// Example 1:
//
// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:
//
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achive this answer too.
//
//
// Constraints:
//
// 1 <= s.length <= 105
// s consists of only uppercase English letters.
// 0 <= k <= s.length
//
// Runtime 8 ms Beats 71.76%
// Memory 42.5 MB Beats 50.40%
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxCount = 1;
        int maxLen = 1;
        int[] counts = new int[26];
        while (right < s.length()) {
            char c = s.charAt(right);
            counts[c - 'A']++;
            maxCount = Math.max(maxCount, counts[c - 'A']);
            if (right - left + 1 > maxCount + k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}