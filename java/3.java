// 3. Longest Substring Without Repeating Characters
//
// Given a string s, find the length of the longest
// substring
//  without repeating characters.
//
//
//
// Example 1:
//
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:
//
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:
//
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
// Constraints:
//
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
//
// Runtime 4 ms Beats 90.20% of users with Java
// Memory 44.64 MB Beats 26.81% of users with Java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer prev = map.get(c);
            if (prev == null || prev < start) {
                max = Math.max(i - start + 1, max);
            } else {
                start = prev + 1;                
            }
            map.put(c, i);
        }
        return max;
    }
}