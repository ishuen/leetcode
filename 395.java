// 395. Longest Substring with At Least K Repeating Characters
// Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
//
// Example 1:
//
// Input: s = "aaabb", k = 3
// Output: 3
// Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
// Example 2:
//
// Input: s = "ababbc", k = 2
// Output: 5
// Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
//
//
// Constraints:
//
// 1 <= s.length <= 104
// s consists of only lowercase English letters.
// 1 <= k <= 105
//
// Runtime: 68 ms, faster than 24.52% of Java online submissions for Longest Substring with At Least K Repeating Characters.
// Memory Usage: 40.2 MB, less than 12.98% of Java online submissions for Longest Substring with At Least K Repeating Characters.
class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstring(s.toCharArray(), 0, s.length() - 1, k);
    }
    public int longestSubstring(char[] arr, int start, int end, int k) {
        if (end - start + 1 < k) return 0;
        int[] counts = new int[26];
        for (int i = start; i <=end; i++) {
            counts[arr[i] - 'a']++;
        }
        for (int i = start; i <= end; i++) {
            if (counts[arr[i] - 'a'] < k) {
                return i - start + 1 > k ? Math.max(longestSubstring(arr, start, i - 1, k), longestSubstring(arr, i + 1, end, k)) : longestSubstring(arr, i + 1, end, k);
            }
        }
        return end - start + 1;
    }
}
